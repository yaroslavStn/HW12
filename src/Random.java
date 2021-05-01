import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Random {
    private static final String[] names = {"vasia", "petya", "jake", "masha"};
    private static final String[] numbers = {"05055551212", "05055551213", "05055551214", "05055551215", "05055551216"};
    private static final String[] messages = {"privet", "poka", "true", "false", "ok"};
    private static Calendar randomDate = new GregorianCalendar(2021, 4, 30, (int) (Math.random() * 24), (int) (Math.random() * 60), (int) (Math.random() * 60));


    public List<Contact> createContactList() {
        List<Contact> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int r = (int) (Math.random() * names.length);
            String randomName = names[r];
            r = (int) (Math.random() * numbers.length);
            String randomNums = numbers[r];
            result.add(new Contact(randomName, randomNums));
        }
        return result;
    }

    public List<CallLog> createCallLogsList(List<Contact> contacts) {
        List<CallLog> result = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int r = (int) (Math.random() * contacts.size());
            Contact randomContact = contacts.get(r);
            CallLog.Status[] status = CallLog.Status.values();
            CallLog.Status randomStatus = status[(int) (Math.random() * status.length)];
            int d = (int) (Math.random() * 600);
            Duration duration = Duration.ofSeconds(d);
            if (randomStatus == CallLog.Status.missed) duration = Duration.ZERO;
            result.add(new CallLog(randomContact, randomDate, duration, randomStatus));
            randomDate.add(Calendar.SECOND, d);
            randomDate.add(Calendar.MINUTE, (int) (Math.random() * 600));
        }

        return result;
    }

    public List<Message> createMessagesList(List<Contact> contacts) {
        List<Message> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Contact randomContact = contacts.get((int) (Math.random() * contacts.size()));
            String randomMessage = messages[(int) (Math.random() * messages.length)];
            result.add(new Message(randomContact, randomMessage, randomDate));
            randomDate.add(Calendar.MINUTE, -(int) (Math.random() * 600));
        }
        return result;
    }
}
