package com.pt2.bazazadanie;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

@Entity (tableName = "samochody_tabela")
public class Samochody {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String model;
    private String marka;
    private int przebieg;
    private double cena;
    @ColumnInfo(name = "Kraj pochodzenia")
    private String kraj;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public int getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(int przebieg) {
        this.przebieg = przebieg;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    public Samochody(String model, String marka, int przebieg, double cena, String kraj) {
        this.id = 0;
        this.model = model;
        this.marka = marka;
        this.przebieg = przebieg;
        this.cena = cena;
        this.kraj = kraj;
    }
}
