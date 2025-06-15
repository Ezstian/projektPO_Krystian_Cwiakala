public class Student extends Uzytkownik {
    private int uczenId;

    public Student(String login, int uczenId) {
        super(login, "Uczen");
        this.uczenId = uczenId;
    }

    public int getUczenId() {
        return uczenId;
    }

    @Override
    public void pokazOpcje() {
        System.out.println("1. Moje oceny");
        System.out.println("2. Wyjście");
    }
}