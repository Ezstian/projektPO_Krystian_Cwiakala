
import java.util.Scanner;
public class WyswietlUczniow{
    public static void menuUczniowie() {
        System.out.print("\n---------------------------------------------");
        System.out.print("\n=-=Menu wyswietlania uczniow=-=");
        System.out.print("\n1.Lista przedmiotów");
        System.out.print("\n2.Lista wszystkich uczniow");
        System.out.print("\n3.Wyswietl oceny wybranego ucznia");
        System.out.print("\n5.Powrot do glownego Menu");
        System.out.print("\n---------------------------------------------");

        System.out.print("\nWybierz opcje: ");
        Scanner scanner = new Scanner(System.in);
        int wybor = scanner.nextInt();
        switch(wybor){
            case 1:
            Przedmioty.wyswietlPrzedmioty();
            menuUczniowie();
                break;
            case 2:

                break;
            case 5:
                Menu.pokazmenu();
                break;
            default:
                break;

        }
    }



}
