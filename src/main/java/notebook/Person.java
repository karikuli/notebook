package notebook;

import java.util.ArrayList;

/**
 * Created by karikuli on 11.05.2017.
 */
public class Person extends Note {

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private ArrayList<String> phones;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<String> getPhone() {
        return phones;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(ArrayList<String> phones) {
        this.phones = phones;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + getId() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", note='" + getNote() + '\'' +
                ", phone=" + phones +
                '}';
    }

    public void addPhone(String phone) {
        phones.add(phone);
    }
}
