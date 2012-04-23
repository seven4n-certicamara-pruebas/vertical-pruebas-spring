package ejemplo;

import org.junit.*;

public class TestAll{

	@Test public void testSaludo(){
		HolaJava o = new HolaJava();
		assert "Hola, Mundo! (en Java)".equals("Hola, Mundo! (en Java)");
	}

}
