public class Oceny {
    private String przedmiot;
    private double wartosc;
    private double waga;
    private String typ; // np. Sprawdzian, Kartkówka

    public Oceny(String przedmiot, double wartosc, double waga, String typ) {
        this.przedmiot = przedmiot;
        this.wartosc = wartosc;
        this.waga = waga;
        this.typ = typ;
    }

    public String getPrzedmiot() {
        return przedmiot;
    }

    public double getWartosc() {
        return wartosc;
    }

    public double getWaga() {
        return waga;
    }

    public String getTyp() {
        return typ;
    }

    @Override
    public String toString() {
        return "Oceny{" +
                "przedmiot='" + przedmiot + '\'' +
                ", wartosc=" + wartosc +
                ", waga=" + waga +
                ", typ='" + typ + '\'' +
                '}';
    }
}