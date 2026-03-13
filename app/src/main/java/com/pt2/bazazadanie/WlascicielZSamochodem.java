package com.pt2.bazazadanie;

import androidx.room.Embedded;
import androidx.room.Relation;

public class WlascicielZSamochodem {

    @Override
    public String toString() {
        return "\n" + wlasciciele + "\n" + samochody;
    }
    @Embedded public Wlasciciele wlasciciele;
    @Relation(
            parentColumn = "samochod_id",
            entityColumn = "id"
    )
    public Samochody samochody;
}
