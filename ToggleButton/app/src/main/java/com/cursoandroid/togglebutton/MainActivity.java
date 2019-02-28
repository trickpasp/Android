package com.cursoandroid.togglebutton;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

    private ToggleButton toggleButton;

    private TextView tvExibir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = (ToggleButton) findViewById(R.id.tbId);
        tvExibir = (TextView) findViewById(R.id.tvExibirId);

        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            tvExibir.setText("");
            if(isChecked){
                tvExibir.setText("Mostrar...");
            }
        });


    }
}
