package notebook;

import asg.cliche.Command;
import asg.cliche.Shell;
import asg.cliche.ShellDependent;
import asg.cliche.ShellFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by karikuli on 09.05.2017.
 */
public class Notebook implements ShellDependent {
    ArrayList<Record> records = new ArrayList<>();
    private Shell parentShell;

    @Command
    public ArrayList<Record> List() {
        return records;
    }

    @Command
    public Record createPerson(String firstName, String lastName, String email, String address, String note, String... phones) {
        Person result = new Person();
        //records.size();
        result.setFirstName(firstName);
        result.setLastName(lastName);
        result.setPhone(new ArrayList<>(Arrays.asList(phones)));
        result.setEmail(email);
        result.setAddress(address);
        result.setNote(note);
        records.add(result);
        return result;
    }

    @Command
    public Note createNote(String note) {
        Note result = new Note();
        result.setNote(note);
        records.add(result);
        return result;
    }

    @Command
    public Reminder createReminder(String note, String reminder) {
        Reminder result = new Reminder();
        result.setTime(reminder);
        result.setNote(note);
        records.add(result);
        return result;
    }

    @Command
    public Alarm createAlarm(String note, String alarm) {
        Alarm result = new Alarm();
        result.setTime(alarm);
        result.setNote(note);
        records.add(result);
        return result;
    }

    @Command
    public Record edit(int id) throws IOException {
        Record r = find(id);
        if (r != null) {
            Shell shell = ShellFactory.createSubshell("#" + id, parentShell, "Editing record #" + id, r);
            shell.commandLoop();
        }
        return r;
    }

    private Record find(int id) {
        for (Record r : records) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    @Override
    public void cliSetShell(Shell theShell) {
        this.parentShell = theShell;
    }

    @Command
    public List<Record> find(String str) {
        ArrayList<Record> result = new ArrayList<>();
        for (Record r : records) {
            if (r.contains(str)) {
                result.add(r);
            }
        }
        return result;
    }

    @Command
    public List<Record> listExpired() {
        ArrayList<Record> result = new ArrayList<>();
        for (Record r : records) {
            if (r instanceof Expirable) {
                Expirable e = (Expirable) r;
                if (e.isExpired()) {
                    result.add(r);
                }
            }
        }
        return result;
    }

    @Command
    public void dismiss(int id) {
        Record r = find(id);
        if (r instanceof Expirable) {
            Expirable e = (Expirable) r;
            e.dismiss();
        } else {
            System.out.println("this is not an expirable");
        }
    }

//    @Command
//    public Person addPhone(int id, String phone){
//        for (Person r : records) {
//            if (r.getId()==id){
//                r.addPhone(phone);
//                return r;
//            }
//        }
//        return null;
//    }

//    @Command
//    public Record remove(int id){
//      for (Record r : records) {
//            if (r.getId()==id){
//        r.addPhone(phone);
//        return r;
//    }
//}
//        return null;
//  }
}
