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
        Random random = new Random();
        List<Contact> contacts = random.createContactList();
        List<CallLog> callLogs = random.createCallLogsList(contacts);
        List<Message> messages = random.createMessagesList(contacts);
        List<?> list = find(messages, "pet");
        Map<String, List<CallLog>> outputCall = Util.groupedLog(callLogs);
        Map<Contact, List<Message>> outputMessage = Util.groupedMessage(messages);

        for (Map.Entry<String, List<CallLog>> entry : outputCall.entrySet()) {
            System.out.println("num " + entry.getKey());
            for (CallLog callLog : entry.getValue()) {
                System.out.print(callLog.getStatus() + " " + callLog.getDate().getTime());
                System.out.println(" " + callLog.getDuration().getSeconds() + " sec");
            }
        }


    /*    Set<Contact> unique = new HashSet<>(contacts);
        System.out.println(
                "str " + contacts.size()
                        + '\n'
                        +"unq " + unique.size());*/

        List<Util.Counter> sortedList = Util.sort(outputMessage);
        List<Util.Counter> finalList = new ArrayList<>();
        for (int i = 0; i < 5 && i < sortedList.size(); i++) {
            finalList.add(sortedList.get(i));
            System.out.println(finalList.get(i).getContact().getName() +
                    " " +
                    finalList.get(i).getContact().getNumber() +
                    " " +
                    finalList.get(i).getCount());
        }


    }

}
