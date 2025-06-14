import java.util.Scanner;

public class UsunUcznia {

    public static void usun() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj ID ucznia do usunięcia: ");

        while (!scanner.hasNextInt()) {
            System.out.print("To nie jest liczba. Podaj ID ucznia: ");
            scanner.next();
        }

        int id = scanner.nextInt();
        if (!OperacjeNaPlikach.czyUczenIstnieje(id)) {
            System.out.println("Uczeń o podanym ID nie istnieje.");
            return;
        }
        OperacjeNaPlikach.usunUcznia(id);
    }
}