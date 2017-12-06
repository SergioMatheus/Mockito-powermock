package br.uscsal.testequalidade20162.radio.business;

import java.util.Date;
import org.junit.Test;

import br.uscsal.testequalidade20162.radio.enums.TipoMidia;
import br.uscsal.testequalidade20162.radio.exceptions.RegistroDuplicadoException;
import br.uscsal.testequalidade20162.radio.exceptions.RegistroNaoEncontradoException;

public class RadioBOUnitarioTest {

	// Metodo a ser testado: public static void adicionarMusica(String
	// tituloAlbum, String nomeMusica) throws
	// RegistroNaoEncontradoException,
	// Verificar se a inclusÃ£o de uma musica duplicada em um album retorna a
	// exceÃ§Ã£o adequada.
	// LEMBRE-SE DE QUE ESTE TESTE DEVE SER UNITÃ�RIO!!!	

	@Test(expected = RegistroNaoEncontradoException.class)
	public void testeUnitarioAdicionarMusicaRegistroNaoEncontrado()
			throws RegistroNaoEncontradoException, RegistroDuplicadoException {
		String tituloAlbum2 = "Dark Sky Paradise";
		String nomeMusica2 = "I Know";
		RadioBO.adicionarMusica(tituloAlbum2, nomeMusica2);
	}

	@Test(expected = RegistroDuplicadoException.class)
	public void testeUnitarioAdicionarMusicaRegistroDuplicado()
			throws RegistroNaoEncontradoException, RegistroDuplicadoException {
		String tituloAlbum = "Odiosa Natureza Humana";
		String nomeMusica = "De saco cheio e de mal humor";
		Date dataLancamento = null;
		Integer duracao = 2;
		String nomeInterpretePrincipal="Matanza";
		TipoMidia tipoMidia = TipoMidia.DIGITAL;
		RadioBO.incluirAlbum(tituloAlbum, dataLancamento, tipoMidia);
		RadioBO.incluirMusica(nomeMusica, duracao, nomeInterpretePrincipal);
		RadioBO.adicionarMusica(tituloAlbum, nomeMusica);
		RadioBO.adicionarMusica(tituloAlbum, nomeMusica);
	}
}