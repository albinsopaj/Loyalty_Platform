package it.unicam.cs.ids.loyaltyPlatform;

import java.util.ArrayList;

public class LoyaltyPlatform {
    private String nome;
    private it.unicam.cs.ids.loyaltyPlatform.ProgrammaFedelta[] programmiFedelta;
    private ArrayList<it.unicam.cs.ids.loyaltyPlatform.Cliente> clienti;
    private ArrayList<it.unicam.cs.ids.loyaltyPlatform.Campagna> campagne;

    public LoyaltyPlatform(String nome, it.unicam.cs.ids.loyaltyPlatform.ProgrammaFedelta[] programmiFedelta, ArrayList<it.unicam.cs.ids.loyaltyPlatform.Cliente> clienti, ArrayList<it.unicam.cs.ids.loyaltyPlatform.Campagna> campagne) {
        this.nome = nome;
        this.programmiFedelta = programmiFedelta;
        this.clienti = clienti;
        this.campagne = campagne;
    }

    public String getNome() {
        return nome;
    }

    public it.unicam.cs.ids.loyaltyPlatform.ProgrammaFedelta[] getProgrammiFedelta() {
        return programmiFedelta;
    }

    public ArrayList<it.unicam.cs.ids.loyaltyPlatform.Cliente> getClienti() {
        return clienti;
    }

    public ArrayList<it.unicam.cs.ids.loyaltyPlatform.Campagna> getCampagne() {
        return campagne;
    }
}
