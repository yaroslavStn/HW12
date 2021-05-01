import java.util.ArrayList;
import java.util.List;

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
        List<?> list = find(messages, "050555");
    }
}
