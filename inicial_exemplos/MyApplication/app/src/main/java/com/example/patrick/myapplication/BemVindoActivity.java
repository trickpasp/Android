package com.example.patrick.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class BemVindoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bem_vindo);
        //Receber o nome enviado por parâmetro
        Bundle args = getIntent().getExtras();
        String nome = args.getString("nome");
        //atualizar o texto no TextView com mensagem bem-vendo
        TextView text = (TextView) findViewById(R.id.text);
        text.setText(nome + ", seja bem-vindo.");
        //Adicionando botão "up navigation"
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == android.R.id.home){
            //O método finish() vai encerrar essa activity
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
