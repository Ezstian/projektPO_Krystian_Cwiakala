public class Uczen extends Uzytkownik {
    private int uczenId;

    public Uczen(String login, int uczenId) {
        super(login, "Uczen");
        this.uczenId = uczenId;
    }

    public int getUczenId() {
        return uczenId;
    }

    @Override
    public void pokazOpcje() {
        System.out.println("\n =-=Menu ucznia=-=");
        System.out.println("1. Wyświetl swoje oceny");
        System.out.println("2. Wyloguj");
    }
}