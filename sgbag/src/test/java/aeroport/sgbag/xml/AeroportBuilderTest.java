package aeroport.sgbag.xml;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import aeroport.sgbag.kernel.Chariot;
import aeroport.sgbag.kernel.Rail;

public class AeroportBuilderTest {

	@Test
	public void testGetNextKernelObject() throws SAXException, IOException,
			ParserConfigurationException {

		AeroportBuilder aBuilder = new AeroportBuilder(
				"src/test/java/aeroport/sgbag/xml/test.xml");

		Chariot c1 = (Chariot) aBuilder.getNextKernelObject();
		assertTrue(c1.getLength() == 10);
		assertTrue(c1.getMaxMoveDistance() == 20);

		Rail r = (Rail) aBuilder.getNextKernelObject();
		assertTrue(r.getLength() == 50);		
		
		Chariot c2 = (Chariot) aBuilder.getNextKernelObject();
		assertTrue("c2: " +c2.getLength(), c2.getLength() == 11);
		assertTrue("c2: " +c2.getMaxMoveDistance(), c2.getMaxMoveDistance() == 21);
		
		Chariot c3 = (Chariot) aBuilder.getNextKernelObject();
		assertTrue("c3: " +c3.getLength(), c3.getLength() == 12);
		assertTrue("c3: " +c3.getMaxMoveDistance(), c3.getMaxMoveDistance() == 22);
		
		Chariot c4 = (Chariot) aBuilder.getNextKernelObject();
		assertTrue("c4: " +c4.getLength(), c4.getLength() == 11);
		assertTrue("c4: " +c4.getMaxMoveDistance(), c4.getMaxMoveDistance() == 22);
		
		Object o = aBuilder.getNextKernelObject();
		assertTrue(o instanceof Rail);
		
		Rail r2 = (Rail) o;
		assertTrue(r2.getLength() == 53);
	}
}
