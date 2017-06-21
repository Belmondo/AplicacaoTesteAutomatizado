package br.disciplina.es.aplicacaotesteautomatizado;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.disciplina.es.aplicacaotesteautomatizado.database.BancoController;

/**
 * Created by belmondorodrigues on 19/06/2017.
 */
public class Cadastra extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastra);

        final TextView textAvisoTitulo = (TextView) findViewById(R.id.textViewAvisoTitulo);
        final TextView textAvisoAutor = (TextView) findViewById(R.id.textViewAviso);


        Button botao = (Button) findViewById(R.id.button);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textAvisoAutor.setText("");
                textAvisoTitulo.setText("");
                BancoController crud = new BancoController(getBaseContext());
                EditText titulo = (EditText)findViewById(R.id.editText);
                EditText autor = (EditText)findViewById((R.id.editText2));
                EditText editora = (EditText)findViewById(R.id.editText3);
                String tituloString = titulo.getText().toString();
                String autorString = autor.getText().toString();
                String editoraString = editora.getText().toString();
                String resultado;


                if (null == tituloString || tituloString.isEmpty() || tituloString.length() < 4){
                    textAvisoTitulo.setText("Preencha o titulo");
                    textAvisoTitulo.setTextColor(Color.RED);
                } else if(null == autorString || autorString.isEmpty() || autorString.length() < 4){

                    textAvisoAutor.setText("Preencha o autor");
                    textAvisoAutor.setTextColor(Color.RED);

                } else {
                    resultado = crud.insereDado(tituloString, autorString, editoraString);
                    Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                    Intent voltaTela = new Intent().setClass(getApplicationContext(),MainActivity.class);
                    startActivity(voltaTela);
                }

            }
        });


    }

}
