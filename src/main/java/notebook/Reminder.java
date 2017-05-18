package notebook;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by karikuli on 11.05.2017.
 */
public class Reminder extends Note implements Expirable {
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd HH mm");

    private LocalDateTime time;
    private boolean dismissed;

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setTime(String strTime) {
        this.time = LocalDateTime.parse(strTime, formatter);

    }

    @Override
    public String toString() {
        return "Reminder{" +
                "note=" + getNote() +
                ", reminder=" + time.format(formatter) +
                '}';
    }

    @Override
    public boolean isExpired() {
        if (dismissed) {
            return false;
        }
        LocalDateTime currentDate = LocalDateTime.now();
        return time.isBefore(currentDate);
    }

    @Override
    public void dismiss() {
        dismissed = true;
    }
}
