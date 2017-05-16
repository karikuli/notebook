package notebook;

/**
 * Created by karikuli on 11.05.2017.
 */
public class Reminder extends Note {

    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "note=" + getNote() +
                ", reminder=" + time +
                '}';
    }
}
