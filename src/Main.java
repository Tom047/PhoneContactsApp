import controllers.ContactController;
import data.PostgresDB;
import data.interfaces.IDB;
import entities.Contact;
import entities.ContactService;
import reposiitories.ContactsRepository;
import reposiitories.interfaces.IContactsRepository;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        IDB db = new PostgresDB();
        IContactsRepository repo = new ContactsRepository(db);
        ContactController controller = new ContactController(repo);
        ContactService service = new ContactService(controller);
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean stop = true;
        while (stop) {
            System.out.println();
            menu();
            choice = sc.nextInt();
            switch (choice) {
                case (1):
                    service.getAllContactsMenu();
                    break;
                case (2):
                    service.addContactMenu();
                case (3):
                    //
                    break;
                case (4):
                    service.getAllContactsMenu();
                    service.removeContactMenu();
                    break;
                case (5):
                    service.findContactMenu();
                    break;
                case (6):
                    //
                    break;
                case (0):
                    stop = false;
                    break;
            }
        }
    }

    private static void menu() {
        System.out.println("Select option:");
        System.out.println("1. Contact list");
        System.out.println("2. Add contact");
        System.out.println("3. Edit contact");
        System.out.println("4. Remove contact");
        System.out.println("5. Find contact");
        System.out.println("6. Call history");
        System.out.println("0. Exit");
    }
}