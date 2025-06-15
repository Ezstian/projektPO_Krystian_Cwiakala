import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Witaj w Elektronicznym Systemie Oceniania");
        System.out.print("Podaj login: ");
        String login = scanner.nextLine();
        System.out.print("Podaj hasło: ");
        String haslo = scanner.nextLine();

        Uzytkownik uzytkownik = OperacjeNaPlikach.zaloguj(login, haslo);

        if (uzytkownik == null) {
            System.out.println("Błędny login lub hasło.");
            return;
        }

        System.out.println("Zalogowano jako: " + uzytkownik.getRola());
        Menu.uruchom(uzytkownik);
    }
}