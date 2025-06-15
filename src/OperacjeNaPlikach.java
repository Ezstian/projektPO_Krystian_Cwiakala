import java.io.*;

public class OperacjeNaPlikach {
    private static final String PLIK_OCENY = "oceny.txt";
    private static final String PLIK_UCZNIOWIE = "uczniowie.txt";

    // Dodaje ocenę do pliku
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

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PLIK_OCENY, true))) {
            writer.write(uczenId + ";" + przedmiot + ";" + wartosc);
            writer.newLine();
            System.out.println("Dodano ocenę.");
        } catch (IOException e) {
            System.out.println("Błąd zapisu. " + e.getMessage());
        }
    }

    // Sprawdza, czy uczeń o danym ID istnieje
    public static boolean czyUczenIstnieje(int id) {
        try (BufferedReader reader = new BufferedReader(new FileReader(PLIK_UCZNIOWIE))) {
            String linia;
            while ((linia = reader.readLine()) != null) {
                String[] dane = linia.split(";");
                if (dane.length > 0 && Integer.parseInt(dane[0]) == id) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Błąd podczas sprawdzania ucznia. " + e.getMessage());
        }
        return false;
    }

    // Logowanie użytkownika z pliku loginy.txt
    public static Uzytkownik zaloguj(String login, String haslo) {
        try (BufferedReader reader = new BufferedReader(new FileReader("loginy.txt"))) {
            String linia;
            while ((linia = reader.readLine()) != null) {
                String[] dane = linia.split(";");
                if (dane.length >= 3 && dane[0].equals(login) && dane[1].equals(haslo)) {
                    if (dane[2].equalsIgnoreCase("Nauczyciel")) {
                        return new Nauczyciel(login);
                    } else if (dane[2].equalsIgnoreCase("Uczen") && dane.length == 4) {
                        int id = Integer.parseInt(dane[3]);
                        return new Uczen(login, id);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Błąd logowania: " + e.getMessage());
        }
        return null;
    }

    // Wyświetla oceny ucznia o danym ID
    public static void wyswietlOcenyUcznia(int id) {
        if (!czyUczenIstnieje(id)) {
            System.out.println("Uczeń o podanym ID nie istnieje.");
            return;
        }

        boolean znaleziono = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(PLIK_OCENY))) {
            String linia;
            System.out.println("\nOceny ucznia ID: " + id);
            while ((linia = reader.readLine()) != null) {
                String[] dane = linia.split(";");
                if (dane.length == 3 && Integer.parseInt(dane[0]) == id) {
                    String przedmiot = dane[1];
                    String ocena = dane[2];
                    System.out.println(przedmiot + ": " + ocena);
                    znaleziono = true;
                }
            }
            if (!znaleziono) {
                System.out.println("Brak ocen dla tego ucznia.");
            }
        } catch (IOException e) {
            System.out.println("Błąd odczytu ocen: " + e.getMessage());
        }
    }
}