package com.cursoandroid.pedrapapeloutesoura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view) {
        this.opcaoSelecionada("pedra");
    }

    public void selecionarPapel(View view) {
        this.opcaoSelecionada("papel");
    }

    public void selecionarTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario){

        ImageView imageResultado = (ImageView) findViewById(R.id.imageResultadoId);
        TextView textResultado = (TextView) findViewById(R.id.textResultadoId);

        //gerar número aleatório
        String [] opcoes = {"pedra", "papel", "tesoura"};
        int numero = new Random().nextInt(3);
        String escolhaApp = opcoes[numero];

        switch (escolhaApp){
            case "pedra": imageResultado.setImageResource(R.drawable.pedra);break;
            case "papel": imageResultado.setImageResource(R.drawable.papel);break;
            case "tesoura": imageResultado.setImageResource(R.drawable.tesoura);break;
        }

        if ((escolhaApp.equals("pedra") && escolhaUsuario.equals("tesoura"))
            ||(escolhaApp.equals("papel") && escolhaUsuario.equals("pedra"))
            ||(escolhaApp.equals("tesoura") && escolhaUsuario.equals("papel"))){
            textResultado.setText("App ganhador!");
        } else if ((escolhaUsuario.equals("pedra") && escolhaApp.equals("tesoura"))
                ||(escolhaUsuario.equals("papel") && escolhaApp.equals("pedra"))
                ||(escolhaUsuario.equals("tesoura") && escolhaApp.equals("papel"))){
            textResultado.setText("Você ganhau!");
        } else {
            textResultado.setText("Empate!");
        }

    }
}
