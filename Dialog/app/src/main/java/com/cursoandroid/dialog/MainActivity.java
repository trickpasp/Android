package com.cursoandroid.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button botao;
    private AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = (Button) findViewById(R.id.button);

        botao.setOnClickListener((view) -> {
            dialog = new AlertDialog.Builder(this);

            dialog.setTitle("Título do dialog");
            dialog.setMessage("Mensagem do Dialog");
            dialog.setCancelable(false);
            dialog.setIcon(android.R.drawable.ic_delete);
            dialog.setNegativeButton("Não", (dialog, which) -> {
                Toast.makeText(this, "Pressionado botão não", Toast.LENGTH_SHORT).show();
            });
            dialog.setPositiveButton("Sim", (dialog, which) ->{
                Toast.makeText(this, "Pressionado botão sim", Toast.LENGTH_SHORT).show();
            });

            dialog.create();
            dialog.show();
        });
    }
}
