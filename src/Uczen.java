public class Uczen {
    private int id;
    private String imie;
    private String nazwisko;

    public Uczen(int id, String imie, String nazwisko) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public int getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    @Override
    public String toString() {
        return "Uczen: " +
                "id=" + id +
                ", imie=" + imie +
                ", nazwisko=" + nazwisko;
    }
}