package com.cursoandroid.preferenciasdeusuario;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Constraints;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

    private RadioGroup radioGroup;
    private RadioButton rbSelecionado;
    private Button botaoSalvar;
    private ConstraintLayout layout;
    private static final String ARQUIVO_PREFERENCIA = "ArqPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupId);
        botaoSalvar = (Button) findViewById(R.id.btSalvarId);
        layout = (ConstraintLayout) findViewById(R.id.layoutId);

        botaoSalvar.setOnClickListener((view) ->{
            int idRBEscolhido = radioGroup.getCheckedRadioButtonId();

            if (idRBEscolhido > 0){
                rbSelecionado = (RadioButton) findViewById(idRBEscolhido);
                SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                String corEscolhida = rbSelecionado.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("corEscolhida", rbSelecionado.getText().toString());
                editor.commit();

                setBackground(corEscolhida);
            }

        });

        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        if (sharedPreferences.contains("corEscolhida")){
            String corRecuperada = sharedPreferences.getString("corEscolhida","Azul");
            setBackground(corRecuperada);
        }
    }

    private void setBackground(String cor){
        if (cor.equals("Azul")){
            layout.setBackgroundColor(Color.parseColor("#495b7c"));
        }else if (cor.equals("Laranja")){
            layout.setBackgroundColor(Color.parseColor("#ffce26"));
        }else if (cor.equals("Verde")){
            layout.setBackgroundColor(Color.parseColor("#009670"));
        }
    }
}
