package com.cursoandroid.recyclerview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.cursoandroid.recyclerview.R;
import com.cursoandroid.recyclerview.RecyclerItemClickListener;
import com.cursoandroid.recyclerview.adapter.Adapter;
import com.cursoandroid.recyclerview.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Listagem de filmes
        this.criarFilmes();

        //Configurar o adapter
        Adapter adapter = new Adapter(listaFilmes);

        //Configurar recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //Evento de click
        recyclerView.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getApplicationContext(),
                    recyclerView,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position);
                            Toast.makeText(getApplicationContext(), "" + filme.getTitulo(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position);
                            Toast.makeText(getApplicationContext(), "" + filme.getTitulo(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        }
                    }
            )
        );

    }

    public void criarFilmes() {
        Filme filme = new Filme("Pantera Negra", "2018", "Ação");
        listaFilmes.add(filme);
        filme = new Filme("Vingadores", "2018", "Ação");
        listaFilmes.add(filme);
        filme = new Filme("Nasce Uma Estrela", "2018", "Drama/Romance");
        listaFilmes.add(filme);
        filme = new Filme("Um Lugar Silencioso", "2018", "Terror");
        listaFilmes.add(filme);
        filme = new Filme("Os Incríveis 2", "2018", "Ficção científica/Ação");
        listaFilmes.add(filme);
        filme = new Filme("Infiltrado na Klan", "2018", "Drama/Filme policial");
        listaFilmes.add(filme);
        filme = new Filme("Hereditário", "2018", "Drama/Suspense");
        listaFilmes.add(filme);
        filme = new Filme("Aquaman", "2018", "Fantasia/Ficção científica");
        listaFilmes.add(filme);
        filme = new Filme("Venom", "2018", "Suspense/Ficção científica");
        listaFilmes.add(filme);
        filme = new Filme("Jogador Nº 1", "2018", "Suspense/Ficção científica");
        listaFilmes.add(filme);
        filme = new Filme("Missão: Impossível", "2018", "Suspense/Ação");
        listaFilmes.add(filme);
        filme = new Filme("Roma", "2018", "Drama");
        listaFilmes.add(filme);

    }
}
