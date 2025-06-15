import java.util.Scanner;

public class Menu {
    public static void pokazmenu(Uzytkownik uzytkownik) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            uzytkownik.pokazOpcje();
            System.out.print("Wybierz opcję: ");
            int wybor = scanner.nextInt();
            scanner.nextLine();  // czyści bufor

            if (uzytkownik instanceof Nauczyciel) {
                switch (wybor) {
                    case 1:
                        System.out.print("Podaj ID ucznia: ");
                        int id = scanner.nextInt();
                        OperacjeNaPlikach.wyswietlOcenyUcznia(id);
                        break;
                    case 2:
                        System.out.print("Podaj ID ucznia: ");
                        int idd = scanner.nextInt();
                        scanner.nextLine(); // czyści bufor
                        Przedmioty.wyswietlPrzedmioty();
                        System.out.print("Podaj przedmiot: ");
                        String przedmiot = scanner.nextLine();
                        System.out.print("Podaj ocenę: ");
                        int ocena = scanner.nextInt();
                        OperacjeNaPlikach.dodajOcene(idd, przedmiot, ocena);
                        break;
                    case 3:
                        Statystyki.generujStatystyki();
                        break;
                    case 4:
                        System.out.println("Wylogowano.");
                        return;
                    default:
                        System.out.println("Nieprawidłowa opcja.");
                }
            } else if (uzytkownik instanceof Uczen student) {
                switch (wybor) {
                    case 1:
                        OperacjeNaPlikach.wyswietlOcenyUcznia(student.getUczenId());
                        break;
                    case 2:
                        System.out.println("Wylogowano.");
                        return;
                    default:
                        System.out.println("Nieprawidłowa opcja.");
                        return;
                }
            }
        }
    }
}