public class Uczen extends Osoba {
    private int id;

    public Uczen(int id, String imie, String nazwisko) {
        super(imie, nazwisko);
        this.id = id;
    }

    public Uczen(String imie, String nazwisko, int id) {
        super(imie, nazwisko);
        this.id = 0;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Uczen: id=" + id +
                ", imie=" + getImie() +
                ", nazwisko=" + getNazwisko();
    }

}
