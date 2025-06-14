import java.util.Scanner;

public class Menu {

    public static void pokazmenu() {

        Scanner scanner = new Scanner(System.in);
        int wybor;
        System.out.println("\n---------------------------------------------");
        System.out.println("\nElektroniczny system oceniania Zarządzanie wstawianiem i wyświetlaniem ocen cząstkowych z różnych przedmiotów");

        // Wyświetlenie opcji menu
        System.out.println("1.Lista wszystkich uczniow");
        System.out.println("2.Dodaj ucznia");
        System.out.println("3.Wyswietl oceny wybranego ucznia");
        System.out.println("4.Wstaw ocene wybranemu uczniowi");
        System.out.println("5.Zakończ");
        System.out.println("\n---------------------------------------------");
        System.out.println("\nWybierz opcję: ");

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
                OperacjeNaPlikach.wyswietlWszystkichUczniow();
                pokazmenu();
                break;
            case 2:
                DodajUcznia.dodawanie();
                pokazmenu();
                break;
            case 3:
                System.out.print("Podaj id ucznia: ");
                int id = scanner.nextInt();
                OperacjeNaPlikach.wyswietlOcenyUcznia(id);
                pokazmenu();
                break;
            case 4:
                System.out.print("Podaj id ucznia: ");
                int numer = scanner.nextInt();
                System.out.print("Podaj przedmiot z listy: ");
                Przedmioty.wyswietlPrzedmioty();
                String przedmiot = scanner.next();
                System.out.print("Podaj ocene: ");
                double ocena = scanner.nextDouble();
                OperacjeNaPlikach.dodajOcene(numer,przedmiot,ocena);
                pokazmenu();
                break;
            case 5:
                System.out.print("Zakonczono dzialanie programu.");
                break;
            default:
                System.out.print("Podano nieprawidlowa wartosc.");
                pokazmenu();
                break;
        }
    }
}