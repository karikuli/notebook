package notebook;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by karikuli on 18.05.2017.
 */
public class Alarm extends Note implements Expirable {

    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH mm");

    private LocalTime time;
    private LocalDate dismissedDate;

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setTime(String strTime) {
        this.time = LocalTime.parse(strTime, formatter);

    }

    @Override
    public String toString() {
        return "Alarm{" +
                "note=" + getNote() +
                ", alarm=" + time.format(formatter) +
                '}';
    }

    @Override
    public boolean isExpired() {
        LocalDate currentDate = LocalDate.now();
        if (dismissedDate == null || !currentDate.isEqual(currentDate)) {
            return false;
        }
        LocalTime currentTime = LocalTime.now();
        return time.isBefore(currentTime);
    }

    @Override
    public void dismiss() {
        dismissedDate = LocalDate.now();
    }
}
