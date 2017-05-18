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

    @Override
    public boolean contains(String str) {
        if (super.contains(str)) {
            return true;
        }
        String low = str.toLowerCase();
        String ln = note.toLowerCase();
        return ln.contains(low);
    }
}
