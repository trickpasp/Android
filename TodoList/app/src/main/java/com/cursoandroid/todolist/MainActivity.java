package com.cursoandroid.todolist;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private EditText textoTarefa;
    private Button botaoAdicionar;
    private ListView listaTarefas;
    private SQLiteDatabase bancoDados;
    private ArrayAdapter<String> itensAdaptador;
    private ArrayList<String> itens;
    private ArrayList<Integer> ids;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            textoTarefa = (EditText) findViewById(R.id.textoId);
            botaoAdicionar = (Button) findViewById(R.id.btAdicionarId);
            listaTarefas = (ListView) findViewById(R.id.listViewId);

            bancoDados = openOrCreateDatabase("appTarefas", MODE_PRIVATE, null);
//            bancoDados.execSQL("DROP TABLE tarefas");
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS tarefas(id INTEGER PRIMARY KEY AUTOINCREMENT, tarefa VARCHAR)");

            botaoAdicionar.setOnClickListener((view) -> {
                String textoDigitado = textoTarefa.getText().toString();
                salvarTarefa(textoDigitado);
            });
            listaTarefas.setLongClickable(true);
            listaTarefas.setOnItemLongClickListener((parent, view, position, id) -> {
                Log.i("Item", position + " / " + ids.get(position));
                removertarefa(ids.get(position));
                return true;
            });

//            listaTarefas.setOnItemClickListener((parent, view, position, id) -> {
//                Log.i("Item", position + " / " + ids.get(position));
//                removertarefa(ids.get(position));
//            });
            recuperarTarefas();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void salvarTarefa(String texto){
        try{
            if (!texto.equals("")){
                bancoDados.execSQL("INSERT INTO tarefas (tarefa) values('" + texto + "')");
                Toast.makeText(this, "Tarefa salva com sucesso!", Toast.LENGTH_SHORT).show();
                recuperarTarefas();
                textoTarefa.setText("");
            }else {
                Toast.makeText(this, "Digite uma tarefa", Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void recuperarTarefas(){
        try{
            Cursor cursor = bancoDados.rawQuery("SELECT * FROM tarefas ORDER BY id DESC", null);

            int indiceColunaId = cursor.getColumnIndex("id");
            int indiceColunaTarefa = cursor.getColumnIndex("tarefa");

//            Criar adaptador
            itens = new ArrayList<String>();
            ids = new ArrayList<Integer>();
            itensAdaptador = new ArrayAdapter<String>(getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    itens);
            listaTarefas.setAdapter(itensAdaptador);

            cursor.moveToFirst();
            while (cursor != null) {

                Log.i("Resultado - ", "Id: " + cursor.getString(indiceColunaId) + " Tarefa: " + cursor.getString(indiceColunaTarefa));
                itens.add(cursor.getString(indiceColunaTarefa));
                ids.add(Integer.parseInt(cursor.getString(indiceColunaId)));
                cursor.moveToNext();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void removertarefa(Integer id){
        try {
            bancoDados.execSQL("DELETE FROM tarefas WHERE id="+ id);
            recuperarTarefas();
            Toast.makeText(this, "Tarefa removida com sucesso!", Toast.LENGTH_SHORT).show();
        }catch (Exception e){

        }
    }
}
