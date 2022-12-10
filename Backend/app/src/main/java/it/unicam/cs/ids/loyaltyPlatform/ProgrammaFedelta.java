package app.src.main.java.it.unicam.cs.ids.loyaltyPlatform;

public class ProgrammaFedelta {
    private String nome;
    private int id;
    private Tipologia tipologia;

    public ProgrammaFedelta(String nome, int id, Tipologia tipologia) {
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

    public Tipologia getTipologia() {
        return tipologia;
    }
}
