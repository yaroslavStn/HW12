package utils;

import entities.CallLog;
import entities.Message;

import java.util.*;


public class Util {

    public static Map<String, List<CallLog>> groupedLog(Collection<CallLog> callLogs) {

        Map<String, List<CallLog>> output = new HashMap<>();
        for (CallLog callLog : callLogs) {
            List<CallLog> exist = output.get(callLog.getNumber());
            if (exist == null) {
                List<CallLog> group = new ArrayList<>();
                group.add(callLog);
                output.put(callLog.getNumber(), group);
            } else {
                exist.add(callLog);
            }
        }
        return output;
    }

    public static Map<String, List<Message>> groupedMessage(Collection<Message> messages) {

        Map<String, List<Message>> output = new HashMap<>();
        for (Message message : messages) {
            List<Message> exist = output.get(message.getNumber());
            if (exist == null) {
                List<Message> group = new ArrayList<>();
                group.add(message);
                output.put(message.getNumber(), group);
            } else {
                exist.add(message);
            }
        }
        return output;
    }

    public static List<Counter> sortedMessages(Map<String, List<Message>> map) {
        List<Counter> list = new ArrayList<>();
        for (Map.Entry<String, List<Message>> entry : map.entrySet()) {
            Integer count = entry.getValue().size();
            String number = entry.getKey();
            list.add(new Counter(number, count));
        }
        list.sort(new Comparator<Counter>() {
            @Override
            public int compare(Counter o1, Counter o2) {
                return Integer.compare(o2.count, o1.count);
            }
        });
        return list;
    }

    public static List<Counter> sortedCallLog(Map<String, List<CallLog>> map) {
        List<Counter> list = new ArrayList<>();
        for (Map.Entry<String, List<CallLog>> entry : map.entrySet()) {
            Integer count = entry.getValue().size();
            String number = entry.getKey();
            list.add(new Counter(number, count));
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
        private String number;
        private Integer count;

        public String getNumber() {
            return number;
        }

        public Integer getCount() {
            return count;
        }

        public Counter(String number, Integer count) {
            this.number = number;
            this.count = count;
        }
    }
}
