package br.disciplina.es.aplicacaotesteautomatizado;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.disciplina.es.aplicacaotesteautomatizado.database.BancoController;
import br.disciplina.es.aplicacaotesteautomatizado.database.CriaBanco;

/**
 * Created by belmondorodrigues on 19/06/2017.
 */
public class Alterar extends Activity {
    EditText livro;
    EditText autor;
    EditText editora;
    Button alterar;
    Button deletar;
    Cursor cursor;
    BancoController crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.altera);

//        final TextView textAvisoTitulo = (TextView) findViewById(R.id.textViewAvisoTitulo2);
//        final TextView textAvisoAutor = (TextView) findViewById(R.id.textViewAvisoAutor2);

        codigo = this.getIntent().getStringExtra("codigo");

        crud = new BancoController(getBaseContext());

        livro = (EditText)findViewById(R.id.editText4);
        autor = (EditText)findViewById(R.id.editText5);
        editora = (EditText)findViewById(R.id.editText6);

        alterar = (Button)findViewById(R.id.button2);

//        final String tituloString = livro.getText().toString();
//        final String autorString = autor.getText().toString();
//        final String editoraString = editora.getText().toString();

        cursor = crud.carregaDadoById(Integer.parseInt(codigo));
        livro.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.TITULO)));
        autor.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.AUTOR)));
        editora.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.EDITORA)));

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                    crud.alteraRegistro(Integer.parseInt(codigo), livro.getText().toString(), autor.getText().toString(),
                            editora.getText().toString());
                    Intent intent = new Intent(Alterar.this, Consulta.class);
                    startActivity(intent);
                    finish();

            }

        });


        deletar = (Button)findViewById(R.id.button3);
        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.deletaRegistro(Integer.parseInt(codigo));
                Intent intent = new Intent(Alterar.this,Consulta.class);
                startActivity(intent);
                finish();
            }
        });

    }
}