package com.cursoandroid.sqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {

            SQLiteDatabase bancoDeDados = openOrCreateDatabase("app", MODE_PRIVATE, null);
            //tabela
            bancoDeDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(id INTEGER PRIMARY KEY AUTOINCREMENT,nome VARCHAR, idade INT(3))");
//            bancoDeDados.execSQL("DROP TABLE pessoas");
            //Inserir dados
//            bancoDeDados.execSQL("INSERT INTO pessoas(nome, idade) values ('Patrick', 22)");
//            bancoDeDados.execSQL("INSERT INTO pessoas(nome, idade) values ('Lindemberg', 22)");
//            bancoDeDados.execSQL("INSERT INTO pessoas(nome, idade) values ('Jefté', 22)");
//            bancoDeDados.execSQL("INSERT INTO pessoas(nome, idade) values ('Reaias', 21)");
//            bancoDeDados.execSQL("INSERT INTO pessoas(nome, idade) values ('Claudioniso', 22)");
//            bancoDeDados.execSQL("INSERT INTO pessoas(nome, idade) values ('Jogerliano', 22)");
//            bancoDeDados.execSQL("INSERT INTO pessoas(nome, idade) values ('Caio Anderson', 21)");

            Cursor cursor = bancoDeDados.rawQuery("SELECT nome, idade FROM pessoas ", null);

            int indiceColunaNome = cursor.getColumnIndex("nome");
            int indiceColunaIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();

            while (cursor != null) {
                Log.i("Resultado - nome: ", cursor.getString(indiceColunaNome));
                Log.i("Resultado - idade: ", cursor.getString(indiceColunaIdade));

                cursor.moveToNext();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
