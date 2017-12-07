package br.uscsal.testequalidade20162.radio.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.*;
import org.powermock.modules.junit4.PowerMockRunner;

import br.uscsal.testequalidade20162.radio.exceptions.RegistroDuplicadoException;
import br.uscsal.testequalidade20162.radio.exceptions.RegistroNaoEncontradoException;

@RunWith(PowerMockRunner.class)
@PrepareForTest({AlbumDao.class, MusicaDao.class, Musica.class, Album.class})
public class RadioBOIntegradoTest {

	// M�todo a ser testado: public static void adicionarMusica(String tituloAlbum, String nomeMusica) throws
	// RegistroNaoEncontradoException,
	// Verificar se a inclus�o de uma m�sica duplicada em um album retorna a exce��o adequada.
	// LEMBRE-SE DE QUE ESTE TESTE DEVE SER INTEGRADO!!!
	
	RadioBO radio = Mockito.mock(RadioBO.class);
	
	@Mock
	AlbumDao albumDaoMock;
	MusicaDao musicaDaoMock;
	
	@Before
	public void setUp() throws ParseException, RegistroNaoEncontradoException, RegistroDuplicadoException {
		RadioBo radio = new RadioBO();
		String nomedoAlbum = "JEs�s";
		DateUtil date = null;
		Album album = new Album(nomeAlbum, date, TipoMidia.CD);
		
		String nomeMusica = "Es�";
		Integer duracao = 3;
		String nomeCantor = "Baco - Exu do blues";
		Musica musica = new Musica(nomeMusica, duracao, nomeCantor);
		
		PowerMockito.mockStatic(albumDaoMock.getClass());
		PowerMockito.mockStatic(musicaDaoMock.getClass());
		
		PowerMockito.doNothing().when(albumDaoMock).incluir(album);
		PowerMockito.doNothing().when(musicaDaoMock).incluir(musica);
		
		PowerMockito.doNothing().when(albumDaoMock).buscarPorTitulo(nomeAlbum);
		PowerMockito.doNothing().when(musicaDaoMock).buscarPorNome(nomeMusica);
		
		radio.incluirAlbum(nomeAlbum, dataLancamento, TipoMidia.CD);
		radio.incluirMusica(nomeMusica, duracao, nomeInterprete);
		
		radio.adicionarMusica(nomeAlbum, nomeMusica);

	}
	
	@Test
	public void testeIntegradoAdicionarMusica() throws RegistroNaoEncontradoException, RegistroDuplicadoException {
		String tituloAlbum = "Es�";
		String nomeMusica = "Es�";
		
		RadioBo.adicionarMusica(tituloAlbum, nomeMusica);
		
	}	
}

