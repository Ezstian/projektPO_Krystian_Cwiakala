public class Nauczyciel extends Uzytkownik {
    public Nauczyciel(String login) {
        super(login, "Nauczyciel");
    }

    @Override
    public void pokazOpcje() {
        System.out.println("1. Lista uczniów");
        System.out.println("2. Wyświetl oceny ucznia");
        System.out.println("3. Wstaw ocenę");
        System.out.println("4. Statystyki");
        System.out.println("5. Wyjście");
    }
}