package com.cursoandroid.radiobutton;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

    private RadioGroup radioGroup;
    private RadioButton radioButtonEscolhido;
    private Button botaoEscolher;
    private TextView textoExibicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupId);
        botaoEscolher = (Button) findViewById(R.id.btEscolherId);
        textoExibicao = (TextView) findViewById(R.id.tvExibirId);

        botaoEscolher.setOnClickListener((view) -> {
            int idRBEscolhido = radioGroup.getCheckedRadioButtonId();
            if (idRBEscolhido > 0){
                radioButtonEscolhido = (RadioButton) findViewById(idRBEscolhido);
                textoExibicao.setText(radioButtonEscolhido.getText());
            }
        });
    }
}
