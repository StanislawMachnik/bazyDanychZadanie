package com.pt2.bazazadanie;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

@Entity (tableName = "wlasciciele_tabela")
public class Wlasciciele {
    @PrimaryKey(autoGenerate = true)
    private int id_wlasciciel;

    private String imie;
    private String nazwisko;
    private int pesel;
    private int samochod_id;

    public int getId_wlasciciel() {
        return id_wlasciciel;
    }

    public void setId_wlasciciel(int id_wlasciciel) {
        this.id_wlasciciel = id_wlasciciel;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getPesel() {
        return pesel;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }

    public int getSamochod_id() {
        return samochod_id;
    }

    public void setSamochod_id(int samochod_id) {
        this.samochod_id = samochod_id;
    }



    public Wlasciciele(String imie, String nazwisko, int pesel, int samochod_id) {
        this.id_wlasciciel = 0;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.samochod_id = samochod_id;
    }

    @Override
    public String toString() {
        return "ID właściciela: " + id_wlasciciel +
                "\nImię: " + imie +
                "\nNazwisko: " + nazwisko +
                "\nPesel:" + pesel +
                "\nID samochodu: " + samochod_id;
    }
}
