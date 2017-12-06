package br.uscsal.testequalidade20162.radio.business;

import org.junit.Test;

import br.uscsal.testequalidade20162.radio.exceptions.RegistroDuplicadoException;
import br.uscsal.testequalidade20162.radio.exceptions.RegistroNaoEncontradoException;

public class RadioBOUnitarioTest {
	
	// Metodo a ser testado: public static void adicionarMusica(String tituloAlbum, String nomeMusica) throws
	// RegistroNaoEncontradoException,
	// Verificar se a inclusÃ£o de uma musica duplicada em um album retorna a exceÃ§Ã£o adequada.
	// LEMBRE-SE DE QUE ESTE TESTE DEVE SER UNITÃ�RIO!!!
	
	@Test
	public void testeUnitarioAdicionarMusica() throws RegistroNaoEncontradoException, RegistroDuplicadoException {
		
		String tituloAlbum="Odiosa Natureza Humana";
		String nomeMusica="De saco cheio e de mal humor";
		RadioBO.adicionarMusica(tituloAlbum, nomeMusica);
		
		
		
		
		
	}
}