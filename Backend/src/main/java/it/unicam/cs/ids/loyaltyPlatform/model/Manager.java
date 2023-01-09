package it.unicam.cs.ids.loyaltyPlatform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Manager implements UtenteAutenticato {
    private String nome;
    private String cognome;
    private char sesso;
    private String email;
    private int id;
    private String numeroCellulare;
    private String username;
    private String password;

    public void aggiornaPuntiManualmente(Cliente cliente, int punteggio) {
        cliente.visualizzaTesseraDigitale().setPunti(punteggio);
    }

    public void inviaComunicazioni() {

    }

}
