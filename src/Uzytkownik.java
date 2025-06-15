public abstract class Uzytkownik {
    protected String login;
    protected String rola;

    public Uzytkownik(String login, String rola) {
        this.login = login;
        this.rola = rola;
    }
    public String getRola() {
        return rola;
    }

    public abstract void pokazOpcje();
}