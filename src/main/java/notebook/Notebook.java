package notebook;

import asg.cliche.Command;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by karikuli on 09.05.2017.
 */
public class Notebook {
    ArrayList<Record> records = new ArrayList<>();

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
