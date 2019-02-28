package com.cursoandroid.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listaItens;

    private String [] itens = {
            "Banabuiú", "Boa Viagem", "Canindé",
            "Choró", "Ibaretama", "Itatira",
            "Madalena", "Milhã", "Pedra Branca",
            "Quixadá", "Quixeramobim", "Senador Pompeu", "Solonópole"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaItens = (ListView) findViewById(R.id.listView);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens
        );

        listaItens.setAdapter(adaptador);

        listaItens.setOnItemClickListener((parente, view, position, id) ->{
            String valorClicado = listaItens.getItemAtPosition(position).toString();
            Toast.makeText(getApplicationContext(), valorClicado, Toast.LENGTH_SHORT).show();
        });
    }
}
