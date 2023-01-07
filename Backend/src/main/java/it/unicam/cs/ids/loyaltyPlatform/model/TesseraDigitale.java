package it.unicam.cs.ids.loyaltyPlatform.model;

public class TesseraDigitale {
    private int id;
    private int punti;
    public TesseraDigitale(int id) {
        this.id = id;
    }

    public void setPunti(int punteggio){
        this.punti = punteggio;
    }
    public int getId() {
        return id;
    }


}
