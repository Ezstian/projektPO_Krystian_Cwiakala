import java.util.Scanner;

public class Menu {

    public static void pokazmenu() {

        Scanner scanner = new Scanner(System.in);
        int wybor;

        System.out.println("=-=Elektroniczny system oceniania Zarządzanie wstawianiem i wyświetlaniem ocen cząstkowych z różnych przedmiotów=-=");

        // Wyświetlenie opcji menu
        System.out.println("1. Wyswietl");
        System.out.println("2. Usuń ucznia");
        System.out.println("3. Dodaj Ocene");
        System.out.println("4. Wyswietl Uczniów");
        System.out.println("5. Zakończ");
        System.out.print("------------------------------------------------------------------------------------------------------------------\n");
        System.out.print("Wybierz opcję: ");

        // Walidacja wejścia użytkownika
        while (!scanner.hasNextInt()) {
            System.out.print("\nTo nie jest liczba. Spróbuj jeszcze raz: ");
            scanner.next();
        }

        wybor = scanner.nextInt();
        scanner.nextLine(); // Czyszczenie bufora wejściowego

        // Obsługa wybranej opcji
        switch (wybor) {
            case 1:
                break;
            case 2:
                break;
            default:
                break;

        }
    }
}