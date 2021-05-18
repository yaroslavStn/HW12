import entities.CallLog;
import entities.Contact;
import entities.Message;
import utils.Random;
import utils.Util;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();

    }

    private List<Message> findImMessages(List<Message> list,  Predicate <Message> predicate) {
        List<Message> result = new ArrayList<>();
        for (Message o : list) {
            if (predicate.test(o)){
                result.add(o);
            };
        }
        return result;

    }

    private void run() {
        utils.Random random = new Random();
        List<Contact> contacts = random.createContactList();
        List<CallLog> callLogs = random.createCallLogsList(contacts);
        List<Message> messages = random.createMessagesList(contacts);


        List<Message> list = findImMessages(messages, (Message message) -> {
            return message.getMessage().contains("pet");
        });
        Map<String, List<CallLog>> outputCall = Util.groupedLog(callLogs);
        Map<String, List<Message>> outputMessage = Util.groupedMessage(messages);
        Calendar randomDate= random.randomDate();
        String randomPhone = random.randomPhone();


        Collection<CallLog> filteredCallLog = Util.callLogFilter(callLogs, new Predicate<CallLog>() {
            @Override
            public boolean test(CallLog callLog) {
                return callLog.equalsByDate(randomDate);
            }
        });

        Collection <Message> filteredMessage = Util.messageFilter(messages, new Predicate<Message>() {
            @Override
            public boolean test(Message message) {
                return message.containsPhoneOfMessage(randomPhone);
            }
        });



        for (Map.Entry<String, List<CallLog>> entry : outputCall.entrySet()) {
            System.out.println("num " + entry.getKey());
            for (CallLog callLog : entry.getValue()) {
                System.out.print(callLog.getStatus() + " " + callLog.getDate().getTime());
                System.out.println(" " + callLog.getDuration().getSeconds() + " sec");
            }
        }

        Contact[] contacts1 = contacts.toArray(new  Contact[0]);
        CallLog[] callLogs1 = callLogs.toArray(new CallLog[callLogs.size()]);
        Message [] temp = new Message[messages.size()];
        Message [] messages1= messages.toArray(temp);

        Set<Contact> uniqueC = new HashSet<>(contacts);
        Set<Message> uniqueM =  new HashSet<>(messages);
        Set<CallLog> uniqueL =  new HashSet<>(callLogs);
        List<Util.Counter> sortedList = Util.sortedMessages(outputMessage);
        List<Util.Counter> finalList = new ArrayList<>();
        printer(sortedList, finalList);
        sortedList.clear();
        sortedList = Util.sortedCallLog(outputCall);
        finalList.clear();
        printer(sortedList, finalList);
    }

    private void printer(List<Util.Counter> sortedList, List<Util.Counter> finalList) {
        for (int i = 0; i < 5 && i < sortedList.size(); i++) {
            finalList.add(sortedList.get(i));
            String contact =  finalList.get(i).getNumber();
            System.out.println(
                    " " +
                    contact +
                    " " +
                    finalList.get(i).getCount());
        }
    }

}
