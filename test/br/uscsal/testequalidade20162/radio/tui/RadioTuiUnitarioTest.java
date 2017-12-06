package br.uscsal.testequalidade20162.radio.tui;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class RadioTuiUnitarioTest {
	
	// Método a ser testado: private static Integer obterTexto(String mensagem)
	// Verificar o processo de entrada e saída para obtenção de um texto.
	// Obs: fazer o mock do System.in e do System.out.
	
	@Test
	public void verificarObterTexto() throws Exception {
		
		String s="Crossfire\nCrossFire\n";
		
		InputStream inFake = new ByteArrayInputStream(s.getBytes());
		System.setIn(inFake);
		
		OutputStream outFake = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outFake));
		RadioTui.obterTexto(s);
		String mensagemAtual= outFake.toString();
		
		Assert.assertEquals(s, mensagemAtual);


	}
}
