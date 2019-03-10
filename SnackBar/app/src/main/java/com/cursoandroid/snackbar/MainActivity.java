package com.cursoandroid.snackbar;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonAbrir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAbrir = findViewById(R.id.buttonAbrir);

        buttonAbrir.setOnClickListener(v -> Snackbar.make(v, "Botão pressionando", Snackbar.LENGTH_LONG)
                .setAction("Confirmar",(view)-> {
                        buttonAbrir.setText("Botão alterado");
                    })
                .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                .show());
    }
}
