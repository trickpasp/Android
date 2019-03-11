package com.cursoandroid.atmconsultoria.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cursoandroid.atmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;

public class SobreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sobre);

        View sobre = new AboutPage(this)
                .setImage(R.drawable.logo)
                .addGroup("Fale conosco")
                .addEmail("atmconsultoria@gmail.com")
                .addWebsite("https://www.google.com/", "Acesse nosso site")
                .addGroup("Rede Sociais")
                .addFacebook("google", "Facebook")

                .addTwitter("google", "Twitter")
                .addYoutube("google", "Youtube")
                .addPlayStore("com.google.android.apps.plus", "PlayStore")
                .addGitHub("google", "GitHub")
                .addInstagram("google", "Instagram")
                .create();
        setContentView(sobre);
    }
}
