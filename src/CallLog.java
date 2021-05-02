import java.time.Duration;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Objects;

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
        return "" +
                contact +
                date.getTime() +
                duration.getSeconds() +
                 status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CallLog callLog = (CallLog) o;
        return Objects.equals(contact, callLog.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contact);
    }
}
