package com.example.mateus.listviewexemplo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TextWatcher {
    EditText nomeBusca;
    ListView nomesLV;
    String nomeAdd;
    List<String> nomes;
    ArrayAdapter<String> adapter;
    Button adicionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adicionar = (Button) findViewById(R.id.btAddNome);
        nomeBusca = (EditText) findViewById(R.id.busca);
        nomesLV = (ListView) findViewById(R.id.LV);
        nomes = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomes);

        nomesLV.setAdapter(adapter);

        nomes.add("Mateus de Lima");
        nomes.add("Eliane Tamara");
        nomes.add("Gernamotaa ALice");

        nomeBusca.addTextChangedListener(this);
    }

    public void adicionar (View view){
        nomeAdd = nomeBusca.getText().toString();
        nomes.add(nomeAdd);

    }

    public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {
    }

    public void onTextChanged(CharSequence s, int i, int i1, int i2) {
        adapter.getFilter().filter(s);

    }

    public void afterTextChanged(Editable editable) {
    }

    public void sair(View v) {
        finish();
    }
}
