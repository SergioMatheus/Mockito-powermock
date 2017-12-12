package br.uscsal.testequalidade20162.radio.domain;

import java.text.ParseException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import br.uscsal.testequalidade20162.radio.enums.TipoMidia;
import br.uscsal.testequalidade20162.radio.exceptions.RegistroDuplicadoException;
import br.uscsal.testequalidade20162.radio.util.DateUtil;


@RunWith(PowerMockRunner.class)
@PrepareForTest({Musica.class})
public class AlbumUnitarioTest {

	// Metodo a ser testado: private void validarMusica(Musica musica) throws RegistroDuplicadoException {
	// Verificar que se levantada a excecao adequada quando uma musica já existente em um album é validada.

	private static final String COMP = "Hozier";
	private static final String NOME_MUSICA = "Take Me To Church";
	private Album alb;
	
	@Before
	public void setUp() throws ParseException {
		String dataString = "05/07/2007";
		DateUtil dateutil = new DateUtil();
		Date date = dateutil.parse(dataString);
		alb = new Album("Qualquer coisa", date, TipoMidia.CD);
		Musica musica = new Musica(NOME_MUSICA, 4, COMP);
		
		alb.getMusicas().add(musica);
				
	}
	
	@Test(expected = RegistroDuplicadoException.class)
	public void validarMusicaTeste() throws Exception {
		
		Musica musica = new Musica(NOME_MUSICA, 4, COMP);		
		Whitebox.invokeMethod(alb, "validarMusica", musica);
	}
	
}