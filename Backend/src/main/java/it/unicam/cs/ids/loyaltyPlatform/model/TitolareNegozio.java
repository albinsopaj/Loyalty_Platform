package it.unicam.cs.ids.loyaltyPlatform.model;

public class TitolareNegozio implements UtenteAutenticato {
    private String nome;
    private String cognome;
    private String email;
    private String numeroCellulare;
    private char sesso;
    private String username;
    private String password;

    public TitolareNegozio(String nome, String cognome, String email, String numeroCellulare, char sesso, String username, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.numeroCellulare = numeroCellulare;
        this.sesso = sesso;
        this.username = username;
        this.password = password;
    }

    public void creaCampagna(FidelityProgram fidelityProgram) {

    }

    public void creaProgrammaFedelta() {

    }

    public void creaRuoloStaff() {

    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public String getNumeroCellulare() {
        return numeroCellulare;
    }

    public char getSesso() {
        return sesso;
    }

    public String getUsername() {
        return username;
    }
}
