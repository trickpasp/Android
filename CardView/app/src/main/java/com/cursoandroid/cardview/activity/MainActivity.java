package com.cursoandroid.cardview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cursoandroid.cardview.R;
import com.cursoandroid.cardview.adapter.PostagemAdapter;
import com.cursoandroid.cardview.model.Postagem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPostagem;
    private List<Postagem> postagens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPostagem = findViewById(R.id.recyclerPostagem);

        //DefinirLayout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerPostagem.setLayoutManager(layoutManager);

        //Definir adapter
        this.prepararPostagens();

        PostagemAdapter adapter = new PostagemAdapter(this.postagens);
        recyclerPostagem.setAdapter(adapter);

    }

    public void prepararPostagens() {
        Postagem p = new Postagem("Patrick Silva", "Viagem fortaleza", R.drawable.imagem1);
        this.postagens.add(p);

        p = new Postagem("Hotel JM", "Viage, aproveite nossos descontos!", R.drawable.imagem2);
        this.postagens.add(p);

        p = new Postagem("Maria Luiza", "#Paris", R.drawable.imagem3);
        this.postagens.add(p);

        p = new Postagem("Rodrigues", "Que foto sensacional", R.drawable.imagem4);
        this.postagens.add(p);
    }
}
