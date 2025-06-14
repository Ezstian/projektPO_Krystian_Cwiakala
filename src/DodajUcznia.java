import java.util.Scanner;

public class DodajUcznia {
    public static void dodawanie() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj imię ucznia: ");
        String imie = scanner.nextLine();

        System.out.print("Podaj nazwisko ucznia: ");
        String nazwisko = scanner.nextLine();

        int noweId = OperacjeNaPlikach.pobierzNoweIdUcznia();
        Uczen nowyUczen = new Uczen(noweId, imie, nazwisko);

        OperacjeNaPlikach.zapiszUczniaDoPliku(nowyUczen);
        System.out.println("Dodano ucznia: " + nowyUczen);
    }
}