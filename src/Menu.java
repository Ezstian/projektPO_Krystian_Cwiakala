import java.util.Scanner;

public class Menu {
    public static void uruchom(Uzytkownik uzytkownik) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            uzytkownik.pokazOpcje();
            System.out.print("Wybierz opcję: ");
            int wybor = scanner.nextInt();
            scanner.nextLine();

            if (uzytkownik instanceof Nauczyciel) {
                switch (wybor) {
                    case 1 :
                        OperacjeNaPlikach.wyswietlWszystkichUczniow();
                        break;
                    case 2 :
                        System.out.print("Podaj ID ucznia: ");
                        int id = scanner.nextInt();
                        OperacjeNaPlikach.wyswietlOcenyUcznia(id);
                        break;
                    case 3 :
                        System.out.print("Podaj ID ucznia: ");
                        int id = scanner.nextInt();
                        System.out.print("Podaj przedmiot: ");
                        String przedmiot = scanner.next();
                        System.out.print("Podaj ocenę: ");
                        double ocena = scanner.nextDouble();
                        OperacjeNaPlikach.dodajOcene(id, przedmiot, ocena);
                    break;
                    case 4:
                        Statystyki.generujStatystyki();
                        break;
                    case 5:
                     System.exit(0);
                     default -> System.out.println("Błąd opcji.");
                        break;
                }
            } else if (uzytkownik instanceof Student student) {
                switch (wybor) {
                    case 1 -> OperacjeNaPlikach.wyswietlOcenyUcznia(student.getUczenId());
                    case 2 -> System.exit(0);
                    default -> System.out.println("Błąd opcji.");
                }
            }
        }
    }
}