package utils;

import entities.CallLog;
import entities.Contact;
import entities.Message;
import entities.Status;

import java.time.Duration;
import java.util.*;

public class Random {
    private static final String[] names = {"vasia", "petya", "jake", "masha"};
    private static final String[] numbers = {"+111", "+222", "+333", "+444", "+555", "+666", "+000"};
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
    public Calendar randomDate (){
        return new GregorianCalendar(2021,
                Calendar.APRIL,
                (int) (Math.random() * 30),
                (int) (Math.random() * 24),
                (int) (Math.random() * 60),
                (int) (Math.random() * 60));
    }

    public List<CallLog> createCallLogsList(List<Contact> contacts) {
        List<CallLog> result = new ArrayList<>();

        for (int i = 0; i < 25; i++) {
            int r = (int) (Math.random() * names.length);
            String randomName = names[r];
            r = (int) (Math.random() * numbers.length);
            String randomNumber = numbers[r];
            Status randomStatus = status[(int) (Math.random() * status.length)];
            r = (int) (Math.random() * 600);
            Duration duration = Duration.ofSeconds(r);
            if (randomStatus == Status.missed) duration = Duration.ZERO;
            Calendar randomDate = new GregorianCalendar(2021,
                    Calendar.APRIL,
                    (int) (Math.random() * 30),
                    (int) (Math.random() * 24),
                    (int) (Math.random() * 60),
                    (int) (Math.random() * 60));

            result.add(new CallLog(
                    randomName,
                    randomNumber,
                    randomDate,
                    duration,
                    randomStatus));
        }

        return result;
    }

    public List<Message> createMessagesList(List<Contact> contacts) {
        List<Message> result = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            Calendar randomDate = new GregorianCalendar(2021,
                    Calendar.APRIL,
                    (int) (Math.random() * 30),
                    (int) (Math.random() * 24),
                    (int) (Math.random() * 60),
                    (int) (Math.random() * 60));
            int r = (int) (Math.random() * names.length);
            String randomName = names[r];
            r = (int) (Math.random() * numbers.length);
            String randomNumber = numbers[r];
            String randomMessage = messages[(int) (Math.random() * messages.length)];
            Status randomStatus = status[(int) (Math.random() * status.length)];
            result.add(new Message(randomName,
                    randomNumber,
                    randomMessage,
                    randomDate,
                    randomStatus));

        }
        return result;
    }

    public String randomPhone() {
      int  r = (int) (Math.random() * numbers.length);
    return numbers[r];
    }
}
