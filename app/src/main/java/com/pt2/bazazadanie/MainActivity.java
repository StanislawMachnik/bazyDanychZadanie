package com.pt2.bazazadanie;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import java.util.List;

public class MainActivity extends AppCompatActivity {
    SamochodyBazaDanych samochodyBazaDanych;
    ListView lista;
    EditText model;
    EditText marka;
    EditText przebieg;
    EditText cena;
    Button dodaj;
    Button edytuj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.lista);
        model = findViewById(R.id.model);
        marka = findViewById(R.id.marka);
        przebieg = findViewById(R.id.przebieg);
        cena = findViewById(R.id.cena);
        dodaj = findViewById(R.id.dodaj);
        edytuj = findViewById(R.id.edytuj);

        samochodyBazaDanych = SamochodyBazaDanych.zwrocInstancjeBazyDanych(MainActivity.this);

        List<Samochody> wszystkieSamochodyList = samochodyBazaDanych.zwrocSamochodyDao().zwrocWszystkieSamochody();
        ArrayAdapter<Samochody> arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, wszystkieSamochodyList);
        lista.setAdapter(arrayAdapter);

        arrayAdapter.notifyDataSetChanged();

    }
}