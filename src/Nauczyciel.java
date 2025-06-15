public class Nauczyciel extends Uzytkownik {
    public Nauczyciel(String login) {
        super(login, "Nauczyciel");
    }

    @Override
    public void pokazOpcje() {
        System.out.println("\n =-= Menu nauczyciela =-=");
        System.out.println("1. Wyświetl oceny ucznia");
        System.out.println("2. Dodaj ocenę");
        System.out.println("3. Generuj statystyki");
        System.out.println("4. Wyloguj");
    }
}