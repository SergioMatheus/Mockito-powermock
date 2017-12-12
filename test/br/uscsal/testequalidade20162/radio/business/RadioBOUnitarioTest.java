package br.uscsal.testequalidade20162.radio.business;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.reflection.Whitebox;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import br.uscsal.testequalidade20162.radio.domain.Album;
import br.uscsal.testequalidade20162.radio.domain.Musica;
import br.uscsal.testequalidade20162.radio.enums.TipoMidia;
import br.uscsal.testequalidade20162.radio.exceptions.RegistroDuplicadoException;
import br.uscsal.testequalidade20162.radio.exceptions.RegistroNaoEncontradoException;
import br.uscsal.testequalidade20162.radio.persistence.AlbumDao;
import br.uscsal.testequalidade20162.radio.persistence.MusicaDao;
import br.uscsal.testequalidade20162.radio.util.DateUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ AlbumDao.class, MusicaDao.class })
public class RadioBOUnitarioTest {

	// Metodo a ser testado: public static void adicionarMusica(String
	// tituloAlbum, String nomeMusica) throws
	// RegistroNaoEncontradoException,
	// Verificar se a inclusÃ£o de uma musica duplicada em um album retorna a
	// exceÃ§Ã£o adequada.
	// LEMBRE-SE DE QUE ESTE TESTE DEVE SER UNITÃ�RIO!!!

	@Before
	public void setup() {

		PowerMockito.mockStatic(AlbumDao.class);
		PowerMockito.mockStatic(MusicaDao.class);
		
		String datas = "05/06/2007";
		DateUtil dateutil = new DateUtil();
		Date data = dateutil.parse(datas);
		
		Whitebox.setInternalState(AlbumDao.class, "incluirAlbum", "Musica 1",data, TipoMidia.CD );
		
	}

	@Test(expected = RegistroDuplicadoException.class)
	public void testeUnitarioAdicionarMusicaRegistroDuplicado()
			throws RegistroNaoEncontradoException, RegistroDuplicadoException {
		
		
		
	}
}