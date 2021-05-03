package utils;

import entities.CallLog;
import entities.Contact;
import entities.Message;

import java.util.*;


public class Util {

    public static Map<Contact, List<CallLog>> groupedLog(Collection<CallLog> callLogs) {

        Map<Contact, List<CallLog>> output = new HashMap<>();
        for (CallLog callLog : callLogs) {
            List<CallLog> exist = output.get(callLog.getContact());
            if (exist == null) {
                List<CallLog> group = new ArrayList<>();
                group.add(callLog);
                output.put(callLog.getContact(), group);
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

    public static List<Counter> sortedMessages(Map<Contact, List<Message>> map) {
        List<Counter> list = new ArrayList<>();
        for (Map.Entry<Contact, List<Message>> entry : map.entrySet()) {
            Integer count = entry.getValue().size();
            Object object = entry.getKey();
            list.add(new Counter(object, count));
        }
        list.sort(new Comparator<Counter>() {
            @Override
            public int compare(Counter o1, Counter o2) {
                return Integer.compare(o2.count, o1.count);
            }
        });
        return list;
    }

    public static List<Counter> sortedCallLog(Map<Contact, List<CallLog>> map) {
        List<Counter> list = new ArrayList<>();
        for (Map.Entry<Contact, List<CallLog>> entry : map.entrySet()) {
            Integer count = entry.getValue().size();
            Object object = entry.getKey();
            list.add(new Counter(object, count));
        }
        list.sort(new Comparator<Counter>() {
            @Override
            public int compare(Counter o1, Counter o2) {
                return Integer.compare(o2.count, o1.count);
            }
        });
        return list;
    }


    public static class Counter {
        private Object object;
        private Integer count;

        Counter(Object object, Integer count) {
            this.object = object;
            this.count = count;
        }

        public Object getObject() {
            return object;
        }

        public Integer getCount() {
            return count;
        }
    }
}
