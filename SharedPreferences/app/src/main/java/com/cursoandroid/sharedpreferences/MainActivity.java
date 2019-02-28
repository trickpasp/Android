package com.cursoandroid.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText textoNome;
    private Button salvar;
    private TextView textoExibicao;

    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoNome = (EditText) findViewById(R.id.nomeId);
        textoExibicao = (TextView) findViewById(R.id.tvExibirId);
        salvar = (Button) findViewById(R.id.btSavarId);

        salvar.setOnClickListener((view) -> {
            SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            if (textoNome.getText().toString().equals("")){
                Toast.makeText(this, "Por favor, preencher o nome!", Toast.LENGTH_SHORT).show();
            }else {
                editor.putString("nome", textoNome.getText().toString());
                editor.commit();
                textoExibicao.setText("Olá, " + textoNome.getText().toString());
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        if (sharedPreferences.contains("nome")){
            String nomeUsuario = sharedPreferences.getString("nome", "Usuário não definido");
            textoExibicao.setText(nomeUsuario);
        }else {
            textoExibicao.setText("Olá, usuário não definido.");
        }
    }
}
