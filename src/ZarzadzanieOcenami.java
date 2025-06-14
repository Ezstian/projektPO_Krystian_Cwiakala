import java.util.Scanner;
public class ZarzadzanieOcenami {
    public static void menuZarzadzaniaOcenami() {
        System.out.print("\n---------------------------------------------");
        System.out.print("\n=-=Menu zarzadzania ocenami=-=");
        System.out.print("\n1.Wstaw ocene wybranemu uczniowi");
        System.out.print("\n2.Pokaz oceny wybranego ucznia");
        System.out.print("\n3.Powrot do glownego Menu");
        System.out.print("\n---------------------------------------------");

        System.out.print("\nWybierz opcje: ");
        Scanner scanner = new Scanner(System.in);
        int wybor = scanner.nextInt();
        switch (wybor) {
            case 1:
                System.out.print("Podaj id ucznia: ");
                int id = scanner.nextInt();
                System.out.print("Podaj przedmiot z listy: ");
                Przedmioty.wyswietlPrzedmioty();
                String przedmiot = scanner.next();
                System.out.print("Podaj ocene: ");
                double ocena = scanner.nextDouble();
                OperacjeNaPlikach.dodajOcene(id,przedmiot,ocena);
                menuZarzadzaniaOcenami();
                break;
            case 2:
                System.out.print("Podaj id ucznia: ");
                int idd = scanner.nextInt();
                OperacjeNaPlikach.wyswietlOcenyUcznia(idd);
                menuZarzadzaniaOcenami();
                break;
            case 3:
                Menu.pokazmenu();
                break;
            default:
                System.out.print("Podano niepoprawna wartosc.");
                menuZarzadzaniaOcenami();
                break;
        }
    }
}
