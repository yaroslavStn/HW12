import java.util.*;

public class Util {

    public static Map<String, List<CallLog>> groupedLog(Collection<CallLog> callLogs) {

        Map<String, List<CallLog>> output = new HashMap<>();
        for (CallLog callLog : callLogs) {
            List<CallLog> exist = output.get(callLog.getContact().getNumber());
            if (exist == null) {
                List<CallLog> group = new ArrayList<>();
                group.add(callLog);
                output.put(callLog.getContact().getNumber(), group);
            } else {
                exist.add(callLog);
            }
        }
        return output;
    }

    public static Map<Contact, List<Message>> groupedMessage(Collection<Message> messages) {

        Map<Contact, List<Message>> output = new HashMap<>();
        for (Message message : messages) {
            List<Message> exist = output.get(message.getContact());
            if (exist == null) {
                List<Message> group = new ArrayList<>();
                group.add(message);
                output.put(message.getContact(), group);
            } else {
                exist.add(message);
            }
        }
        return output;
    }

    public static List<Counter> sort(Map<Contact, List<Message>> map) {
        List<Counter> list = new ArrayList<>();
        for (Map.Entry<Contact, List<Message>> entry : map.entrySet()) {
            Integer count = entry.getValue().size();
            Contact contact = entry.getKey();
            list.add(new Counter(contact, count));
        }
        list.sort(new Comparator<Counter>() {
            @Override
            public int compare(Counter o1, Counter o2) {
                return Integer.compare(o2.count, o1.count);
            }
        });
        return list;
    }


    static class Counter {
        private Contact contact;
        private Integer count;

        public Counter(Contact contact, Integer count) {
            this.contact = contact;
            this.count = count;
        }

        public Contact getContact() {
            return contact;
        }

        public Integer getCount() {
            return count;
        }
    }
}
