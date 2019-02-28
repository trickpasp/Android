package com.cursoandroid.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox cbCao;
    private CheckBox cbGato;
    private CheckBox cbPapagaio;

    private Button btMostrar;
    private TextView tvMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbCao = (CheckBox) findViewById(R.id.cbCaoId);
        cbGato = (CheckBox) findViewById(R.id.cbGatoId);
        cbPapagaio = (CheckBox) findViewById(R.id.cbPapagaioId);

        btMostrar = (Button) findViewById(R.id.btMostraId);

        tvMostrar = (TextView) findViewById(R.id.tvExibirId);

        btMostrar.setOnClickListener((view) ->{
            String itemSelecionado = "Item: " + cbCao.getText() + "\tStatus: " + cbCao.isChecked() + "\n";
            itemSelecionado += "Item: " + cbGato.getText() + "\tStatus: " + cbGato.isChecked() + "\n";
            itemSelecionado += "Item: " + cbPapagaio.getText() + "\tStatus: " + cbPapagaio.isChecked();

            tvMostrar.setText(itemSelecionado);
        });

    }
}
