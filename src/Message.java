import java.util.Calendar;

public class Message {
    private Contact contact;
    private String message;
    private Calendar date;

    public Contact getContact() {
        return contact;
    }

    public String getMessage() {
        return message;
    }

    public Calendar getDate() {
        return date;
    }

    public Message(Contact contact, String message, Calendar date) {
        this.contact = contact;
        this.message = message;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "contact=" + contact +
                ", message='" + message + '\'' +
                ", date=" + date.getTime() +
                '}';
    }
}
