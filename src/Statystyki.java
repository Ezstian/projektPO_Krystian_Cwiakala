import java.io.*;
import java.util.*;

public class Statystyki {

    // Generuje i wyświetla statystyki ocen
    public static void generujStatystyki() {
        Map<Integer, List<Double>> ocenyMap = new HashMap<>();
        int liczbaOcen = 0;
        double sumaOcen = 0.0;

        try (BufferedReader reader = new BufferedReader(new FileReader("oceny.txt"))) {
            String linia;
            while ((linia = reader.readLine()) != null) {
                String[] dane = linia.split(";");
                if (dane.length == 3) {
                    int uczenId = Integer.parseInt(dane[0]);
                    double ocena = Double.parseDouble(dane[2]);

                    ocenyMap.putIfAbsent(uczenId, new ArrayList<>());
                    ocenyMap.get(uczenId).add(ocena);

                    sumaOcen += ocena;
                    liczbaOcen++;
                }
            }
        } catch (IOException e) {
            System.out.println("Błąd podczas odczytu pliku z ocenami: " + e.getMessage());
            return;
        }

        if (liczbaOcen == 0) {
            System.out.println("Brak ocen do wygenerowania statystyk.");
            return;
        }

        System.out.println("\n Stzatystyki ucniów:");
        for (Map.Entry<Integer, List<Double>> entry : ocenyMap.entrySet()) {
            int uczenId = entry.getKey();
            List<Double> oceny = entry.getValue();
            double srednia = oceny.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

            System.out.printf("Uczeń ID: "+uczenId+"  Średnia ocen: "+srednia+" Liczba ocen: "+oceny.size()+"\n");
        }
    }
}