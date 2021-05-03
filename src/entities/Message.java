package entities;

import java.util.Calendar;
import java.util.Objects;

public class Message {
    private Contact contact;
    private String message;
    private Calendar date;
    private Status status;

    public Message(Contact contact, String message, Calendar date, Status status) {
        this.contact = contact;
        this.message = message;
        this.date = date;
        this.status = status;
    }

    public Contact getContact() {
        return contact;
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
                 contact +
                 message +
                 date.getTime() +
                 status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(contact, message.contact) &&
                Objects.equals(date, message.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contact, date);
    }
}