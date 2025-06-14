import java.util.ArrayList;

public class Uczen  {
    private final ArrayList<Oceny> oceny;
    private String imie;
    private String nazwisko;
    private String idUcznia;

    public Uczen(String imie, String nazwisko, String idUcznia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.idUcznia = idUcznia;
        this.oceny = new ArrayList<>();
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getIdUcznia() {
        return idUcznia;
    }


}