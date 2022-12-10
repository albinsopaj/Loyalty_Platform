package app.src.main.java.it.unicam.cs.ids.loyaltyPlatform;

import java.util.Date;

public class Campagna {
    private String nome;
    private int id;
    private Date inizio;
    private Date fine;

    public Campagna(String nome, int id, Date inizio, Date fine) {
        this.nome = nome;
        this.id = id;
        this.inizio = inizio;
        this.fine = fine;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public Date getInizio() {
        return inizio;
    }

    public Date getFine() {
        return fine;
    }
}
