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
            System.out.println("Błąd zapisu: " + e.getMessage());
        }
    }

    // Zwraca nowe unikalne ID na podstawie największego ID w pliku uczniowie.txt
    public static int pobierzNoweIdUcznia() {
        int maxId = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(plik_uczniowie))) {
            String linia;
            while ((linia = reader.readLine()) != null) {
                String[] dane = linia.split(";");
                if (dane.length >= 1) {
                    int id = Integer.parseInt(dane[0]);
                    if (id > maxId) {
                        maxId = id;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Błąd podczas odczytu ID uczniów: " + e.getMessage());
        }
        return maxId + 1;
    }

    // Wyświetla wszystkie oceny danego ucznia na podstawie jego ID
    public static void wyswietlOcenyUcznia(int uczenId) {
        System.out.println("Oceny ucznia ID: " + uczenId);
        if (!czyUczenIstnieje(uczenId)) {
            System.out.println("Uczeń o podanym ID nie istnieje.");
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
                System.out.println("Brak ocen dla podanego ID ucznia.");
            }
        } catch (IOException e) {
            System.out.println("Błąd odczytu: " + e.getMessage());
        }
    }

    // Zapisuje nowego ucznia do pliku uczniowie.txt
    public static void zapiszUczniaDoPliku(Uczen uczen) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(plik_uczniowie, true))) {
            writer.write(uczen.getId() + ";" + uczen.getImie() + ";" + uczen.getNazwisko());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Błąd zapisu ucznia: " + e.getMessage());
        }
    }

    // Wyświetla wszystkich uczniów wczytanych z pliku uczniowie.txt
    public static void wyswietlWszystkichUczniow() {
        List<Uczen> uczniowie = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(plik_uczniowie))) {
            String linia;
            while ((linia = reader.readLine()) != null) {
                String[] dane = linia.split(";");
                if (dane.length == 3) {
                    int id = Integer.parseInt(dane[0]);
                    String imie = dane[1];
                    String nazwisko = dane[2];
                    uczniowie.add(new Uczen(id, imie, nazwisko));
                }
            }
        } catch (IOException e) {
            System.out.println("Błąd odczytu uczniów: " + e.getMessage());
            return;
        }

        System.out.println("Lista uczniów:");
        for (Uczen uczen : uczniowie) {
            System.out.println(uczen);
        }
    }
    // Sprawdza, czy uczeń o danym ID istnieje w pliku
    public static boolean czyUczenIstnieje(int uczenId) {
        try (BufferedReader reader = new BufferedReader(new FileReader(plik_uczniowie))) {
            String linia;
            while ((linia = reader.readLine()) != null) {
                String[] dane = linia.split(";");
                if (dane.length == 3 && Integer.parseInt(dane[0]) == uczenId) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Błąd przy sprawdzaniu istnienia ucznia: " + e.getMessage());
        }
        return false;
    }
}
