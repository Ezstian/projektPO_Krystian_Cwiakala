import java.io.*;

public class OperacjeNaPlikach {
    private static final String plik_oceny = "oceny.txt";

    // Dodaj nową ocenę do pliku
    public static void dodajOcene(int uczenId, String przedmiot, double wartosc) {
       if(uczenId<0){
           System.out.print("Nie istnieje uczen o ujemnym ID");
           return;
       }
        if (!Przedmioty.lista.contains(przedmiot)) {
            System.out.println("Podano niepoprawny przedmiot");
            return;
        }
        if (wartosc < 1|| wartosc>6) {
            System.out.print("Ocena musi miescic sie w przedziale 1-6");
            return;
        }

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
        if(uczenId<0){
            System.out.print("Nie istnieje uczen o ujemnym ID");
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(plik_oceny))) {
            String wiersz;
            boolean znaleziono = false;
            while ((wiersz = reader.readLine()) != null) {
                String[] dane = wiersz.split(";");
                if (dane.length == 3 && Integer.parseInt(dane[0]) == uczenId) {
                    System.out.println("- " + dane[1] + ": " + dane[2]);
                    znaleziono = true;
                }
            }
            if (!znaleziono) {
                System.out.println("Nie istnieje uczen o takim ID.");
            }
        } catch (IOException e) {
            System.out.println("Błąd odczytu: " + e.getMessage());
        }
    }
}