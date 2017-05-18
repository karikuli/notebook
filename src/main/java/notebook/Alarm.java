package notebook;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by karikuli on 18.05.2017.
 */
public class Alarm extends Note {

    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH mm");

    private LocalTime time;

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
}
