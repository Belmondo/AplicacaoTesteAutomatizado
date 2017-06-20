package br.disciplina.es.aplicacaotesteautomatizado;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

/**
 * Created by italoaraujo on 19/06/2017.
 */

public class TesteTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public TesteTest(){
        super(MainActivity.class);
    }

    private Solo solo;

    public void setUp(){
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testCadastrarLivroComTodosOsCampos(){
        solo.clickOnButton(0);
        solo.assertCurrentActivity("Deu erro", Cadastra.class);
        assertTrue("Problema", true);
    }

    public void testCadastraLivroTituloEmBranco(){
        solo.clickOnButton(0);
        solo.assertCurrentActivity("Deu erro", Cadastra.class);
        solo.enterText(1, "Belmondo");
        solo.enterText(2, "UFC");
        solo.clickOnButton(0);
        solo.assertCurrentActivity("Deu erro 2", Cadastra.class);
    }

}
