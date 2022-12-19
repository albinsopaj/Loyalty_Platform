package it.unicam.cs.ids.loyaltyPlatform;

public class ProgrammaFedelta {
    private String nome;
    private int id;
    private it.unicam.cs.ids.loyaltyPlatform.Tipologia tipologia;

    public ProgrammaFedelta(String nome, int id, it.unicam.cs.ids.loyaltyPlatform.Tipologia tipologia) {
        this.nome = nome;
        this.id = id;
        this.tipologia = tipologia;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public it.unicam.cs.ids.loyaltyPlatform.Tipologia getTipologia() {
        return tipologia;
    }
}
