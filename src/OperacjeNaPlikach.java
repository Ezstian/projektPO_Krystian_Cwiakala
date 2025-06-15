import java.io.*;
import java.util.*;

public class OperacjeNaPlikach {
    private static final String plik_oceny = "oceny.txt";
    private static final String plik_uczniowie = "uczniowie.txt";

    // Dodaje ocenę do pliku oceny.txt
    public static void dodajOcene(int uczenId, String przedmiot, double wartosc) {
        if (!czyUczenIstnieje(uczenId)) {
            System.out.println("Uczeń o podanym ID nie istnieje.");
            return;
        }
        if (!Przedmioty.lista.contains(przedmiot)) {
            System.out.println("Podano niepoprawny przedmiot.");
            return;
        }
        if (wartosc < 1 || wartosc > 6) {
            System.out.println("Ocena musi mieścić się w przedziale 1–6.");
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(plik_oceny, true))) {
            writer.write(uczenId + ";" + przedmiot + ";" + wartosc);
            writer.newLine();
            System.out.println("Dodano ocenę.");
        } catch (IOException e) {
            System.out.println("Błąd zapisu. " + e.getMessage());
        }
    }
    public static Uzytkownik zaloguj(String login, String haslo) {
        // Dane użytkowników można trzymać np. w pliku loginy.txt: login;haslo;rola;id (dla uczniów)
        try (BufferedReader reader = new BufferedReader(new FileReader("loginy.txt"))) {
            String linia;
            while ((linia = reader.readLine()) != null) {
                String[] dane = linia.split(";");
                if (dane.length >= 3 && dane[0].equals(login) && dane[1].equals(haslo)) {
                    if (dane[2].equalsIgnoreCase("Nauczyciel")) {
                        return new Nauczyciel(login);
                    } else if (dane[2].equalsIgnoreCase("Uczen") && dane.length == 4) {
                        int id = Integer.parseInt(dane[3]);
                        return new Student(login, id);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Błąd logowania: " + e.getMessage());
        }
        return null;
    }


}
