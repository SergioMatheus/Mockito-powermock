package br.uscsal.testequalidade20162.radio.business;

import java.text.ParseException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import br.uscsal.testequalidade20162.radio.domain.Album;
import br.uscsal.testequalidade20162.radio.domain.Musica;
import br.uscsal.testequalidade20162.radio.enums.TipoMidia;
import br.uscsal.testequalidade20162.radio.exceptions.RegistroDuplicadoException;
import br.uscsal.testequalidade20162.radio.exceptions.RegistroNaoEncontradoException;
import br.uscsal.testequalidade20162.radio.util.DateUtil;

public class RadioBOIntegradoTest {

	// M�todo a ser testado: public static void adicionarMusica(String
	// tituloAlbum, String nomeMusica) throws
	// RegistroNaoEncontradoException,
	// Verificar se a inclus�o de uma m�sica duplicada em um album retorna a
	// exce��o adequada.
	// LEMBRE-SE DE QUE ESTE TESTE DEVE SER INTEGRADO!!!

	@Before
	public void setUp() throws ParseException, RegistroNaoEncontradoException, RegistroDuplicadoException {
		RadioBO radio = new RadioBO();
		String nomedoAlbum = "JEs�s";
		String dataString = "05/07/2007";
		DateUtil dateutil = new DateUtil();
		Date date = dateutil.parse(dataString);
		Album album = new Album(nomedoAlbum, date, TipoMidia.CD);

		String nomeMusica = "Es�";
		Integer duracao = 3;
		String nomeCantor = "Baco - Exu do blues";
		Musica musica = new Musica(nomeMusica, duracao, nomeCantor);

		radio.incluirAlbum(nomedoAlbum, date, TipoMidia.CD);
		radio.incluirMusica(nomeMusica, duracao, nomeCantor);

		radio.adicionarMusica(nomedoAlbum, nomeMusica);

	}

	@Test(expected = RegistroDuplicadoException.class)
	public void testeIntegradoAdicionarMusica() throws RegistroNaoEncontradoException, RegistroDuplicadoException {
		String tituloAlbum = "JEs�s";
		String nomeMusica = "Es�";

		RadioBO.adicionarMusica(tituloAlbum, nomeMusica);

	}
}
