package br.uscsal.testequalidade20162.radio.tui;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.Test;

public class RadioTuiUnitarioTest {
	
	// Método a ser testado: private static Integer obterTexto(String mensagem)
	// Verificar o processo de entrada e saída para obtenção de um texto.
	// Obs: fazer o mock do System.in e do System.out.
	
	@Test(expected = Exception.class)
	public void verificarObterTexto() throws Exception {
		
		String s="Crossfire\nCrossFire";
		
		InputStream inFake = new ByteArrayInputStream(s.getBytes());
		System.setIn(inFake);


		RadioTui.adicionarMusica();


	}
}
