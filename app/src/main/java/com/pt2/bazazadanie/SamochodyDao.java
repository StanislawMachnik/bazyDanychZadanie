package com.pt2.bazazadanie;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SamochodyDao {
    @Insert
    public void wstawSamochody(Samochody samochody);

    @Delete
    public void usun(Samochody samochody);

    @Update
    public void zaktualizuj(Samochody samochody);

    @Query("Select * from samochody_tabela")
    List<Samochody> zwrocWszystkieSamochody();

    @Transaction
    @Query("Select * from wlasciciele_tabela")
    List<WlascicielZSamochodem> zwrocWlascicielaISamochod();

    @Insert
    public void wstawWlasciciela(Wlasciciele wlasciciele);
}
