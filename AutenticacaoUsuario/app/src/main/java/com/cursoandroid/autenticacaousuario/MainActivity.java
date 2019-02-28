package com.cursoandroid.autenticacaousuario;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        //Login do usuário
        /*firebaseAuth.signInWithEmailAndPassword("patrick.cursos@gmail.com", "patrick123")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){//sucesso
                            Log.i("signIn", "Sucesso ao fazer login usuário");
                        }else {//erro
                            Log.i("signIn", "Erro ao fazer login usuário");
                        }

                    }
                });
*/
        firebaseAuth.signOut();

        if (firebaseAuth.getCurrentUser() != null){
            Log.i("getCurrentUser", "Usuário logado");
        }else {
            Log.i("getCurrentUser", "Usuário não está logado");
        }
        //cadastro
        /*firebaseAuth.createUserWithEmailAndPassword("patrick.cursos@gmail.com", "patrick123")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){//sucesso
                            Log.i("createUser", "Sucesso ao cadastrar usuário");
                        }else {//erro
                            Log.i("createUser", "Erro ao cadastrar usuário");
                        }
                    }
                });*/

    }
}
