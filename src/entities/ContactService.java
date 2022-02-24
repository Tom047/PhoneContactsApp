package entities;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import controllers.ContactController;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ContactService {
    private final ContactController controller;
    private final Scanner scanner;

    public ContactService(ContactController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void getAllContactsMenu() {
        String response = controller.getAllContacts();
        System.out.println(response);
        System.out.println("To get information about a contact, enter the id.");
        System.out.println("Enter 0 to exit.");
        int id = scanner.nextInt();
        if(id != 0) {
            response = controller.getContact(id);
            System.out.println(response);
        }
    }

    public void addContactMenu() {
        System.out.println("Please enter name:");
        String name = scanner.nextLine();
        System.out.println("Please enter phone number (starts with +):");
        String phone = scanner.next();
        System.out.println("Please enter email (enter 0 to skip)");
        String email = scanner.next();
        if(email.equals("0")) email = "";

        String response = controller.createContact(name, phone, email);
        System.out.println(response);
    }

    public void editContactMenu() {
        System.out.println("Please chose id");
        int id = scanner.nextInt();

        System.out.println("What setting do you want to change?");
        System.out.println("1. Name");
        System.out.println("2. Phone");
        System.out.println("3. Email");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new value");

        String newValue = scanner.nextLine();
        String response;
        switch (choice) {
            case 1:
                response = controller.editContact(id, "name", newValue);
                break;
            case 2:
                PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
                try {
                    newValue = phoneUtil.format(phoneUtil.parse(newValue, "KZ"), PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);
                    response = controller.editContact(id, "phone", newValue);
                } catch (NumberParseException e) {
                    System.err.println("NumberParseException was thrown: " + e.toString());
                    response = "Contact edition was failed!";
                }
                break;
            case 3:
                response = controller.editContact(id, "email", newValue);
                break;
            default:
                response = "Invalid input!";
                break;
        }
        System.out.println(response);
    }

    public void removeContactMenu() {
        System.out.println("Please choose id");
        int id = scanner.nextInt();

        String response = controller.deleteContact(id);
        System.out.println(response);
    }

    public void findContactMenu() {
        System.out.println("Please enter name:");
        String name = scanner.next();

        String response = controller.findContact(name);
        System.out.println(response);
    }
}
