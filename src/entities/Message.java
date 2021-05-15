package entities;

import java.util.Calendar;
import java.util.Objects;

public class Message {
    private String name;
    private String number;
    private String message;
    private Calendar date;
    private Status status;

    public Message(String name, String number, String message, Calendar date, Status status) {
        this.name = name;
        this.number = number;
        this.message = message;
        this.date = date;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getMessage() {
        return message;
    }

    public Calendar getDate() {
        return date;
    }

    public Status getStatus() {
        return status;
    }


    @Override
    public String toString() {
        return
                 name +
                         number+
                 message +
                 date.getTime() +
                 status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message1 = (Message) o;
        return Objects.equals(name, message1.name) &&
                Objects.equals(number, message1.number) &&
                Objects.equals(message, message1.message) &&
                Objects.equals(date, message1.date) &&
                status == message1.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number, message, date, status);
    }
}