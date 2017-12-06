package br.uscsal.testequalidade20162.radio.domain;

import org.junit.Test;

import br.uscsal.testequalidade20162.radio.enums.TipoMidia;
import br.uscsal.testequalidade20162.radio.exceptions.RegistroDuplicadoException;


public class AlbumUnitarioTest {

	// Metodo a ser testado: private void validarMusica(Musica musica) throws RegistroDuplicadoException {
	// Verificar que se levantada a excecao adequada quando uma musica já existente em um album é validada.
	@Test(expected = RegistroDuplicadoException.class)
	public void validarMusicaTeste() throws RegistroDuplicadoException {
		Album album= new Album("O Glorioso retorno de quem nunca foi", null, TipoMidia.DIGITAL);
		Musica musica = new Musica("Take Me To Church", 4, "Hozier");
		album.adicionarMusica(musica);
		album.adicionarMusica(musica);
	}
}