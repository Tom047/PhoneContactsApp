package entities;

import controllers.ContactController;

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
