import entities.CallLog;
import entities.Contact;
import entities.Message;
import utils.Random;
import utils.Util;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();

    }

    private static List<?> find(List<?> list, String request) {
        List<Object> result = new ArrayList<>();
        for (Object o : list) {
            if (o.toString().contains(request)) result.add(o);
        }
        return result;

    }

    private void run() {
        utils.Random random = new Random();
        List<Contact> contacts = random.createContactList();
        List<CallLog> callLogs = random.createCallLogsList(contacts);
        List<Message> messages = random.createMessagesList(contacts);
        List<?> list = find(messages, "pet");
        Map<Contact, List<CallLog>> outputCall = Util.groupedLog(callLogs);
        Map<Contact, List<Message>> outputMessage = Util.groupedMessage(messages);

        for (Map.Entry<Contact, List<CallLog>> entry : outputCall.entrySet()) {
            System.out.println("num " + entry.getKey());
            for (CallLog callLog : entry.getValue()) {
                System.out.print(callLog.getStatus() + " " + callLog.getDate().getTime());
                System.out.println(" " + callLog.getDuration().getSeconds() + " sec");
            }
        }
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
            Contact contact = (Contact) finalList.get(i).getObject();
            System.out.println(contact.getName() +
                    " " +
                    contact.getNumber() +
                    " " +
                    finalList.get(i).getCount());
        }
    }

}
