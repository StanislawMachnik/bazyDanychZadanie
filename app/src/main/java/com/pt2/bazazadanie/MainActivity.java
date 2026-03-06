package com.pt2.bazazadanie;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import java.util.List;

public class MainActivity extends AppCompatActivity {
    SamochodyBazaDanych samochodyBazaDanych;
    private ListView lista;
    private EditText model;
    private EditText marka;
    private EditText przebieg;
    private EditText cena;
    private EditText kraj;
    private Button dodaj;
    private Button edytuj;
    private String model_text;
    private String marka_text;
    private String kraj_text;
    private int przebieg_text;
    private double cena_text;
    private int id_wybor;

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
        kraj = findViewById(R.id.kraj);

        samochodyBazaDanych = SamochodyBazaDanych.zwrocInstancjeBazyDanych(MainActivity.this);

        List<Samochody> wszystkieSamochodyList = samochodyBazaDanych.zwrocSamochodyDao().zwrocWszystkieSamochody();
        ArrayAdapter<Samochody> arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, wszystkieSamochodyList);
        lista.setAdapter(arrayAdapter);

        dodaj.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        model_text = String.valueOf(model.getText());
                        marka_text = String.valueOf(marka.getText());
                        kraj_text = String.valueOf(kraj.getText());
                        przebieg_text = Integer.parseInt(String.valueOf(przebieg.getText()));
                        cena_text = Double.parseDouble(String.valueOf(cena.getText()));

                        samochodyBazaDanych.zwrocSamochodyDao().wstawSamochody(new Samochody(model_text, marka_text, przebieg_text, cena_text, kraj_text));
                        arrayAdapter.notifyDataSetChanged();
                    }
                }
        );
        lista.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                        samochodyBazaDanych.zwrocSamochodyDao().usun(wszystkieSamochodyList.get(i));
                        wszystkieSamochodyList.remove(i);
                        arrayAdapter.notifyDataSetChanged();

                        return false;
                    }
                }
        );
        /*lista.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        id_wybor = wszystkieSamochodyList.get(i).getId();
                    }
                }
        );
        edytuj.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        model_text = String.valueOf(model.getText());
                        marka_text = String.valueOf(marka.getText());
                        kraj_text = String.valueOf(kraj.getText());
                        przebieg_text = Integer.parseInt(String.valueOf(przebieg.getText()));
                        cena_text = Double.parseDouble(String.valueOf(cena.getText()));

                        samochodyBazaDanych.zwrocSamochodyDao().zaktualizuj();
                    }
                }
        );*/
    }
}