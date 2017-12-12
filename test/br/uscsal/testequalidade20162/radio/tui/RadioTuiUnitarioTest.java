package br.uscsal.testequalidade20162.radio.tui;

import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

@RunWith(PowerMockRunner.class)
@PrepareForTest({RadioTui.class})
public class RadioTuiUnitarioTest {
	
	private final String musica = "Crossfire";
	
	// Metodo a ser testado: private static Integer obterTexto(String mensagem)
	// Verificar o processo de entrada e saida para obtencao de um texto.
	// Obs: fazer o mock do System.in e do System.out.
	
	@Test
	public void verificarObterTexto() throws Exception {	
		
		Scanner toddynho = PowerMockito.mock(Scanner.class);		
		Whitebox.setInternalState(RadioTui.class, "sc", toddynho);
		PrintStream ps = PowerMockito.mock(PrintStream.class);		
		System.setOut(ps);
		
		PowerMockito.when(toddynho.nextLine()).thenReturn(musica);
		
		Whitebox.invokeMethod(RadioTui.class, "obterTexto", musica);
		Mockito.verify(ps).print(musica);
				
	}
}
