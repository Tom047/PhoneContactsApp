import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean stop = true;
        while (stop) {
            System.out.println();
            menu();
            choice = sc.nextInt();
            switch (choice) {
                case (1):
                    //
                    break;
                case (2):
                    //
                case (3):
                    //
                    break;
                case (4):
                    //
                    break;
                case (5):
                    //
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

    public static void menu() {
        System.out.println("1. Contact list");
        System.out.println("2. Add contact");
        System.out.println("3. Edit contact");
        System.out.println("4. Remove contact");
        System.out.println("5. Find contact");
        System.out.println("6. Call history");
        System.out.println("0. Exit");
    }
}