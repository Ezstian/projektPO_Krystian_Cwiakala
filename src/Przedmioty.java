import java.util.Arrays;
import java.util.List;

public class Przedmioty {
    public static final List<String> lista = Arrays.asList(
            "Matematyka",
            "Język polski",
            "Fizyka",
            "Historia",
            "Informatyka"
    );

    public static void wyswietlPrzedmioty() {
        System.out.println("\nDostępne przedmioty:");
        int i = 1;
        for (String przedmiot : lista) {
            System.out.println(i + ". " + przedmiot);
            i++;
        }
    }
}