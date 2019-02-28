package com.cursoandroid.mediaplayer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button btTocar;

    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btTocar = (Button) findViewById(R.id.btTocarId);
        mediaPlayer = MediaPlayer.create(this, R.raw.musica);

        btTocar.setOnClickListener((view) -> {
            if (mediaPlayer.isPlaying()){
                pausarMusica();

            } else {
                tocarMusica();
            }
        });

    }

    private void tocarMusica() {
        if (mediaPlayer != null){
            mediaPlayer.start();
            btTocar.setText("Pausar");
        }
    }

    private void pausarMusica() {
        if (mediaPlayer != null){
            mediaPlayer.pause();
            btTocar.setText("Tocar");
        }
    }

    @Override
    protected void onDestroy() {
        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
            this.finish();
        }
        super.onDestroy();
    }

}
