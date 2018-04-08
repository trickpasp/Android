package frasedodia.pasp.com.frasedodia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textoNovaFrase;
    private Button botaoNovaFrase;

    private String[] frases = {"Tudo o que um sonho precisa para ser realizado é alguém que acredite que ele possa ser realizado. \"Roberto Shinyashiki\"",
            "Imagine uma nova história para sua vida e acredite nela. \"Paulo Coelho\"",
            "Ser feliz sem motivo é a mais autêntica forma de felicidade. \"Carlos Drummond de Andrade\"",
            "Não existe um caminho para a felicidade. A felicidade é o caminho.\"Thich Nhat Hanh\"",
            "Não espere por uma crise para descobrir o que é importante em sua vida. \"Platão\"",
            "A amizade desenvolve a felicidade e reduz o sofrimento, duplicando a nossa alegria e dividindo a nossa dor. \"Joseph Addison\"",
            "Nunca deixe ninguém te dizer que não pode fazer alguma coisa. Se você tem um sonho tem que correr atrás dele. As pessoas não conseguem vencer e dizem que você também não vai vencer. Se você quer uma coisa corre atrás. \"À Procura da Felicidade\"",
            "Always in my heart @harrystyles your sincerely Louis. \"Louis Tomlinson\"",
            "Saber encontrar a alegria na alegria dos outros, é o segredo da felicidade. \"Georges Bernanos\"",
            "A alegria de fazer o bem é a única felicidade verdadeira. \"Leon Tolstói\""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoNovaFrase = (TextView) findViewById(R.id.textoNovaFraseId);
        botaoNovaFrase = (Button) findViewById(R.id.botaoNovaFraseId);



        botaoNovaFrase.setOnClickListener( (View view) -> {
            Random randomico = new Random();
            int sorteio = randomico.nextInt(10);

            textoNovaFrase.setText( frases[sorteio] );
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        return (id == R.id.action_settings) || super.onOptionsItemSelected(item);
    }

}
