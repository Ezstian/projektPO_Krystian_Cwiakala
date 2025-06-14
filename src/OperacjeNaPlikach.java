import java.io.*;

public class OperacjeNaPlikach {
    private static final String plik_oceny = "oceny.txt";

    // Dodaj nową ocenę do pliku
    public static void dodajOcene(int uczenId, String przedmiot, double wartosc) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(plik_oceny, true))) {
            writer.write(uczenId + ";" + przedmiot + ";" + wartosc);
            writer.newLine();
            System.out.println("Dodano ocenę.");
        } catch (IOException e) {
            System.out.println("Błąd zapisu: " + e.getMessage());
        }
    }

    // Wyświetl wszystkie oceny danego ucznia
    public static void wyswietlOcenyUcznia(int uczenId) {
        System.out.println("Oceny ucznia ID: " + uczenId);
        try (BufferedReader reader = new BufferedReader(new FileReader(plik_oceny))) {
            String linia;
            boolean znaleziono = false;
            while ((linia = reader.readLine()) != null) {
                String[] dane = linia.split(";");
                if (dane.length == 3 && Integer.parseInt(dane[0]) == uczenId) {
                    System.out.println("- " + dane[1] + ": " + dane[2]);
                    znaleziono = true;
                }
            }
            if (!znaleziono) {
                System.out.println("Brak ocen.");
            }
        } catch (IOException e) {
            System.out.println("Błąd odczytu: " + e.getMessage());
        }
    }
}