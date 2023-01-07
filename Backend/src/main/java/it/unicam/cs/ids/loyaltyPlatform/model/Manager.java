package it.unicam.cs.ids.loyaltyPlatform.model;

public class Manager implements UtenteAutenticato {
    private String nome;
    private String cognome;
    private char sesso;
    private String email;
    private int id;
    private String numeroCellulare;
    private String username;
    private String password;

    public Manager(String nome, String cognome, char sesso, String email, int id, String numeroCellulare, String username, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.sesso = sesso;
        this.email = email;
        this.id = id;
        this.numeroCellulare = numeroCellulare;
        this.username = username;
        this.password = password;
    }

    public void aggiornaPuntiManualmente(Cliente cliente, int punteggio) {
        cliente.visualizzaTesseraDigitale().setPunti(punteggio);
    }

    public void inviaComunicazioni() {

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

    public int getId() {
        return id;
    }

    public String getNumeroCellulare() {
        return numeroCellulare;
    }

    public String getUsername() {
        return username;
    }
}
