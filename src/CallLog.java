import java.time.Duration;
import java.time.LocalDate;
import java.util.Calendar;

public class CallLog {
    private Contact contact;
    private Calendar date;
    private Duration duration;
    private Status status;

    public Status getStatus() {
        return status;
    }

    public CallLog(Contact contact, Calendar date, Duration duration, Status status) {
        this.contact = contact;
        this.date = date;
        this.duration = duration;
        this.status = status;
    }

    public Contact getContact() {
        return contact;
    }

    public Calendar getDate() {
        return date;
    }

    public Duration getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "CallLog{" +
                "contact=" + contact +
                ", date=" + date.getTime() +
                ", duration=" + duration.getSeconds() +
                ", status=" + status +
                '}';
    }
}
