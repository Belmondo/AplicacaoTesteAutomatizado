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
        solo.assertCurrentActivity("Botão de Cadastrar não foi acionado", Cadastra.class);
        solo.enterText(0, "The Art of Software Testing");
        solo.enterText(1, "Myers");
        solo.enterText(2, "UFC");
        solo.clickOnButton(0);
        solo.assertCurrentActivity("Não retornou para a Main Activity", MainActivity.class);
        //assertTrue("Problema", true);
    }

    public void testCadastraLivroTituloEmBranco(){
        solo.clickOnButton(0);
        solo.assertCurrentActivity("Botão de Cadastrar não foi acionado", Cadastra.class);
        solo.enterText(1, "Myers");
        solo.enterText(2, "UFC");
        solo.clickOnButton(0);
        solo.assertCurrentActivity("Não permaneceu na tela quando faltou preencher o titulo", Cadastra.class);
        solo.goBack();
        solo.assertCurrentActivity("Não retornou para a Main Activity", MainActivity.class);
    }

    public void testCadastraLivroAutorEmBranco(){
        solo.clickOnButton(0);
        solo.assertCurrentActivity("Botão de Cadastrar não foi acionado", Cadastra.class);
        solo.enterText(0, "The Art of Software Testing");
        solo.enterText(2, "UFC");
        solo.clickOnButton(0);
        solo.assertCurrentActivity("Não permaneceu na tela quando faltou preencher o autor", Cadastra.class);
        solo.goBack();
        solo.assertCurrentActivity("Não retornou para a Main Activity", MainActivity.class);
    }

}
