package com.example.patrick.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends DebugActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btLogin = (Button) findViewById(R.id.btLogin);
        btLogin.setOnClickListener(onClickLogin());
    }

    private View.OnClickListener onClickLogin(){
        return (View view) ->{
            TextView tLogin = (TextView) findViewById(R.id.tLogin);
            TextView tSenha = (TextView) findViewById(R.id.tSenha);

            String login = tLogin.getText().toString();
            String senha = tSenha.getText().toString();

            if("patrick".equals(login) && "123".equals(senha)) {
                //Navega para próxima página
                Intent intent = new Intent(getContext(), BemVindoActivity.class);
                intent.putExtra("nome", "Patrick");
                startActivity(intent);
            } else
                alert("Login e/ou senha incorretos");

        };
    }

    private Context getContext(){
        return this;
    }

    private void alert(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
