import java.util.Scanner;

public class Menu {

    public static void pokazmenu() {

        Scanner scanner = new Scanner(System.in);
        int wybor;
        System.out.print("\n---------------------------------------------");
        System.out.println("\nElektroniczny system oceniania Zarządzanie wstawianiem i wyświetlaniem ocen cząstkowych z różnych przedmiotów");

        // Wyświetlenie opcji menu
        System.out.println("1.Lista wszystkich uczniow");
        System.out.println("2.Wyswietl oceny wybranego ucznia");
        System.out.print("3.Wstaw ocene wybranemu uczniowi");
        System.out.println("4.Zakończ");
        System.out.print("\n---------------------------------------------");
        System.out.print("\nWybierz opcję: ");

        // Walidacja wejścia użytkownika
        while (!scanner.hasNextInt()) {
            System.out.print("\nTo nie jest liczba. Spróbuj jeszcze raz: ");
            scanner.next();
        }
        wybor = scanner.nextInt();
        scanner.nextLine();
        // Obsługa wybranej opcji
        switch (wybor) {
            case 1:
                System.out.print("Lista wszystkich uczniów: ");
                pokazmenu();
                break;
            case 2:
                System.out.print("Podaj id ucznia: ");
                int idd = scanner.nextInt();
                OperacjeNaPlikach.wyswietlOcenyUcznia(idd);
                pokazmenu();
                break;
            case 3:
                System.out.print("Podaj id ucznia: ");
                int id = scanner.nextInt();
                System.out.print("Podaj przedmiot z listy: ");
                Przedmioty.wyswietlPrzedmioty();
                String przedmiot = scanner.next();
                System.out.print("Podaj ocene: ");
                double ocena = scanner.nextDouble();
                OperacjeNaPlikach.dodajOcene(id,przedmiot,ocena);
                pokazmenu();
                break;
            case 4:
                System.out.print("Zakonczono dzialanie programu.");
                break;
            default:
                System.out.print("Podano nieprawidlowa wartosc.");
                pokazmenu();
                break;
        }
    }
}