package br.disciplina.es.aplicacaotesteautomatizado.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by belmondorodrigues on 19/06/2017.
 */
public class CriaBanco extends SQLiteOpenHelper {

    //nome do banco de dados
    public static final String NOME_BANCO = "banco.db";
    //campos do banco de dados
    public static final String TABELA = "livros";
    public static final String ID = "_id";
    public static final String TITULO = "titulo";
    public static final String AUTOR = "autor";
    public static final String EDITORA = "editora";
    //versão do banco de dados
    public static final int VERSAO = 1;

    //construtor que passará para a super classe as informações do local e versão do banco.
    public CriaBanco(Context context){

        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    //chamado quando a aplicação cria o banco de dados pela primeira vez.
    // Nesse método devem ter todas as diretrizes de criação e população inicial do banco.
    public void onCreate(SQLiteDatabase db) {

        //código de criação do banco, que segue o mesmo padrão do JDBC

        String sql = "CREATE TABLE "+TABELA+"("
                + ID + " integer primary key autoincrement, "
                + TITULO + " text, "
                + AUTOR + " text, "
                + EDITORA + " text "
                +")";

        db.execSQL(sql);

    }

    @Override
    //método responsável por atualizar o banco de dados com alguma informação estrutural que
    // tenha sido alterada. Ele sempre é chamado quando uma atualização é necessária, para não
    // ter nenhum tipo de inconsistência de dados entre o banco existente no aparelho e o novo
    // que a aplicação irá utilizar.
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS" + TABELA);
        onCreate(db);

    }
}
