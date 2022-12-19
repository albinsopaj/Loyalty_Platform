package it.unicam.cs.ids.loyaltyPlatform;

import java.util.Date;

public class Cliente {

    private String nome;
    private String cognome;
    private Date dataNascita;
    private String email;
    private String numeroCellulare;
    private String domicilio;
    private char sesso;

    public Cliente(String nome, String cognome, Date dataNascita, String email, String numeroCellulare, String domicilio, char sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.email = email;
        this.numeroCellulare = numeroCellulare;
        this.domicilio = domicilio;
        this.sesso = sesso;
    }

    public it.unicam.cs.ids.loyaltyPlatform.TesseraDigitale visualizzaTesseraDigitale() {

    }

    public void scaricaTesseraDigitale() {

    }

    public void compilaFormularioRegistrazione() {

    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public String getEmail() {
        return email;
    }

    public String getNumeroCellulare() {
        return numeroCellulare;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public char getSesso() {
        return sesso;
    }
}