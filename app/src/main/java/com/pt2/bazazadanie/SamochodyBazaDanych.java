package com.pt2.bazazadanie;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Samochody.class}, version = 1)
public abstract class SamochodyBazaDanych extends RoomDatabase{
    public abstract SamochodyDao zwrocSamochodyDao();
    private static SamochodyBazaDanych instancja;
    public static SamochodyBazaDanych zwrocInstancjeBazyDanych(Context context){
        if(instancja == null){
            instancja = Room.databaseBuilder(context, SamochodyBazaDanych.class, "samochody_db").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return instancja;
    }

}
