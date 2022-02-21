import java.util.Scanner;
import java.util.Vector;

public class Contact {
    public static Scanner in = new Scanner(System.in);
    private String name;
    private String phone;
    private String email;
    private static Vector < Contact > user = new Vector < Contact > ();

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        addContact(this);

    private void addContact() {
        user.add(Contact);
    }
        
    String getName() {
        return name;
    }

    String getPhone() {
        return phone;
    }

    String getEmail() {
        return email;
    }
}
