package app.src.main.java.it.unicam.cs.ids.loyaltyPlatform;

public class AddettoCassa implements UtenteAutenticato {
    private String nome;
    private String cognome;
    private char sesso;
    private String email;
    private String numeroCellulare;
    private String username;
    private String password;

    public AddettoCassa(String nome, String cognome, char sesso, String email, String numeroCellulare, String username) {
        this.nome = nome;
        this.cognome = cognome;
        this.sesso = sesso;
        this.email = email;
        this.numeroCellulare = numeroCellulare;
        this.username = username;
    }

    public void visualizzaProfiloUtente() {

    }

    public void aggiornaStatoPuntiManualmente() {

    }

    public void scansionaTesseraDigitale() {

    }

    public void notificaClienteSulleUltimePromozioni() {

    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public char getSesso() {
        return sesso;
    }

    public String getEmail() {
        return email;
    }

    public String getNumeroCellulare() {
        return numeroCellulare;
    }

    public String getUsername() {
        return username;
    }
}
