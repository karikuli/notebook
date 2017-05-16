package notebook;

/**
 * Created by karikuli on 11.05.2017.
 */
public class Note extends Record {

    private String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Note{" +
                "note=" + note +
                '}';
    }
}
