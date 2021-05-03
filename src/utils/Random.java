package utils;

import entities.CallLog;
import entities.Contact;
import entities.Message;
import entities.Status;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Random {
    private static final String[] names = {"vasia", "petya", "jake", "masha"};
    private static final String[] numbers = {"+111", "+222", "+333", "+444", "+555","+666","+000"};
    private static final String[] messages = {"privet", "poka", "true", "false", "ok"};
    private static Status[] status = Status.values();

    public List<Contact> createContactList() {
        List<Contact> result = new ArrayList<>();
        for (String number : numbers) {
            int r = (int) (Math.random() * names.length);
            String randomName = names[r];
            result.add(new Contact(randomName, number));
        }
        return result;
    }

    public List<CallLog> createCallLogsList(List<Contact> contacts) {
        List<CallLog> result = new ArrayList<>();
        Calendar randomDate = new GregorianCalendar();
        randomDate.set(2021, Calendar.APRIL, 30, (int) (Math.random() * 24), (int) (Math.random() * 60), (int) (Math.random() * 60));
        for (int i = 0; i < 25; i++) {
            int r = (int) (Math.random() * contacts.size());
            Contact randomContact = contacts.get(r);
            Status randomStatus = status[(int) (Math.random() * status.length)];
            int d = (int) (Math.random() * 600);
            Duration duration = Duration.ofSeconds(d);
            if (randomStatus == Status.missed) duration = Duration.ZERO;
            result.add(new CallLog(randomContact, randomDate, duration, randomStatus));
            randomDate.add(Calendar.SECOND, d);
         //   System.out.println(randomDate.getTime());;
           randomDate.add(Calendar.MINUTE, (int) (Math.random() * 600));
        }

        return result;
    }

    public List<Message> createMessagesList(List<Contact> contacts) {
        Calendar randomDate = new GregorianCalendar(2021, Calendar.APRIL, 30, (int) (Math.random() * 24), (int) (Math.random() * 60), (int) (Math.random() * 60));
        List<Message> result = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            Contact randomContact = contacts.get((int) (Math.random() * contacts.size()));
            String randomMessage = messages[(int) (Math.random() * messages.length)];
            Status randomStatus = status[(int) (Math.random() * status.length)];
            result.add(new Message(randomContact, randomMessage, randomDate,randomStatus));
           // randomDate.add(Calendar.MINUTE, -(int) (Math.random() * 600));
        }
        return result;
    }
}
