package it.unicam.cs.ids.loyaltyPlatform.model;

import java.util.ArrayList;

public class LoyaltyPlatform {
    private String nome;
    private ProgrammaFedelta[] programmiFedelta;
    private ArrayList<Cliente> clienti;
    private ArrayList<Campagna> campagne;

    public LoyaltyPlatform(String nome, ProgrammaFedelta[] programmiFedelta, ArrayList<Cliente> clienti, ArrayList<Campagna> campagne) {
        this.nome = nome;
        this.programmiFedelta = programmiFedelta;
        this.clienti = clienti;
        this.campagne = campagne;
    }

    public String getNome() {
        return nome;
    }

    public ProgrammaFedelta[] getProgrammiFedelta() {
        return programmiFedelta;
    }

    public ArrayList<Cliente> getClienti() {
        return clienti;
    }

    public ArrayList<Campagna> getCampagne() {
        return campagne;
    }
}
