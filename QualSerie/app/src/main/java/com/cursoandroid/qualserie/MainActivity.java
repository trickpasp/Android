package com.cursoandroid.qualserie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private ImageView imageExibicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBarId);
        imageExibicao = (ImageView) findViewById(R.id.imageExibicaoId);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int valorProgresso = progress;

                if (valorProgresso == 0){
                    imageExibicao.setImageResource(R.drawable.pouco);
                } else if (valorProgresso == 1){
                    imageExibicao.setImageResource(R.drawable.medio);
                }else if (valorProgresso == 2){
                    imageExibicao.setImageResource(R.drawable.muito);
                }else if (valorProgresso == 3){
                    imageExibicao.setImageResource(R.drawable.susto);

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
