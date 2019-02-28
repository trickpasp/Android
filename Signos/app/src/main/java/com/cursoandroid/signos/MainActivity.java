package com.cursoandroid.signos;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listaSginos;
    private String [] itensSignos = {"Áries", "Touro", "Gêmeos", "Câncer", "Leão", "Virgem", "Libra", "Escorpião", "Sagitário", "Capricórnio","Aquário", "Peixes"};
    private String [] perfil = {
            "Impulsivo, o ariano não pensa muito sobre seus atos.",
            "Teimoso, o taurino é determinado e protetor.",
            "Espontâneo e um pouco instável, o geminiano é uma verdadeira caixinha de surpresas.",
            "Família é a palavra-chave para o canceriano.",
            "Este é signo que veio para brilhar.",
            "Perspicaz e inteligente, o virginiano está acostumado com o sucesso, por isso se cobra muito, assim como aos demais.",
            "O libriano gosta do que é belo e harmonioso.",
            "Determinado, o escorpiano vai até o fim para conquistar os seus objetivos.",
            "Um signo de bem com a vida, que está sempre em busca de ação e que vive rodeado de amigos.",
            "Trabalhador, tímido e educado, o capricórnio pode passar uma imagem de fechado e até mesmo antipático, mas é que ele eprecisa confiar em quem está ao seu lado para se abrir totalmente.",
            "Independente, o aquariano preza muito por sua liberdade.",
            "Este é o signo mais romântico do zodíaco."
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaSginos = (ListView) findViewById(R.id.listViewId);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itensSignos
        ){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                // Get the Item from ListView
                View view = super.getView(position, convertView, parent);

                // Initialize a TextView for ListView each Item
                TextView tv = (TextView) view.findViewById(android.R.id.text1);

                // Set the text color of TextView (ListView Item)
                tv.setTextColor(Color.WHITE);
                tv.setTextSize(18f);

                Typeface boldTypeface = Typeface.defaultFromStyle(Typeface.BOLD);

                tv.setTypeface(boldTypeface);

                // Generate ListView Item using TextView
                return view;
            }
        };

        listaSginos.setAdapter(adaptador);

        listaSginos.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(this, perfil[position], Toast.LENGTH_LONG).show();
        });
    }
}
