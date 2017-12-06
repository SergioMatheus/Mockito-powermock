package br.uscsal.testequalidade20162.radio.business;

import org.junit.Test;
//import org.junit.runner.RunWith;
import org.mockito.Mockito;
//import org.powermock.*;


import br.uscsal.testequalidade20162.radio.exceptions.RegistroDuplicadoException;
import br.uscsal.testequalidade20162.radio.exceptions.RegistroNaoEncontradoException;

//@RunWith(PowerMockRunner.class)
//@PrepareForTest(XxxService.class)
public class RadioBOIntegradoTest {

	// Método a ser testado: public static void adicionarMusica(String tituloAlbum, String nomeMusica) throws
	// RegistroNaoEncontradoException,
	// Verificar se a inclusão de uma música duplicada em um album retorna a exceção adequada.
	// LEMBRE-SE DE QUE ESTE TESTE DEVE SER INTEGRADO!!!
	
	RadioBO radio = Mockito.mock(RadioBO.class);
	
	@Test
	public void testeIntegradoAdicionarMusica() throws RegistroNaoEncontradoException, RegistroDuplicadoException {
		String tituloAlbum = "Esú";
		String nomeMusica = "Esú";
		Mockito.doNothing().when(radio).adicionarMusicaInstancia(tituloAlbum, nomeMusica);
		radio.adicionarMusicaInstancia(tituloAlbum, nomeMusica);
		Mockito.verify(radio).adicionarMusicaInstancia(tituloAlbum, nomeMusica);
		
	}	
}

