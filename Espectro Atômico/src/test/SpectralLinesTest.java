package test;

import static org.junit.Assert.*;
import junit.framework.Assert;
import model.ChemicalElement;
import model.Classification;
import model.SpectralLines;

import org.junit.Before;
import org.junit.Test;


public class SpectralLinesTest {
	
	ChemicalElement hydrogen;
	SpectralLines elementLines;

	@Before
	public void setUp() throws Exception {
		hydrogen = new ChemicalElement("Hidrogênio", "H", 1, 1, 1, Classification.NAO_METAIS);
		elementLines = new SpectralLines(hydrogen);
	}

	@Test
	public void testConstructorLinhasEspectrais() {
		try {
			new SpectralLines(null);
			Assert.fail("Esperava excessão.");
		} catch (Exception e) {
			assertEquals("Elemento nao pode ser nulo!", e.getMessage());
		}
	}
	
	@Test
	public void testParamGets() {
		try {
			elementLines.getEnergy(0);
			Assert.fail("Esperava excessão.");
		} catch (Exception e) {
			assertEquals("Comprimento de onda invalido!", e.getMessage());
		}
		
		try {
			elementLines.getEnergy(-1000);
			Assert.fail("Esperava excessão.");
		} catch (Exception e) {
			assertEquals("Comprimento de onda invalido!", e.getMessage());
		}
		
		try {
			elementLines.getPosition(0, 40);
			Assert.fail("Esperava excessão.");
		} catch (Exception e) {
			assertEquals("Parametro(s) invalido(s)!", e.getMessage());
		}
		
		try {
			elementLines.getPosition(-1000, 40);
			Assert.fail("Esperava excessão.");
		} catch (Exception e) {
			assertEquals("Parametro(s) invalido(s)!", e.getMessage());
		}
		
		try {
			elementLines.getPosition(40, 0);
			Assert.fail("Esperava excessão.");
		} catch (Exception e) {
			assertEquals("Parametro(s) invalido(s)!", e.getMessage());
		}
		
		try {
			elementLines.getPosition(40, -1000);
			Assert.fail("Esperava excessão.");
		} catch (Exception e) {
			assertEquals("Parametro(s) invalido(s)!", e.getMessage());
		}
	}
	
	@Test
	public void testGetsAndSets() throws Exception {
		try {
			elementLines.getEnergy(-100);
			Assert.fail("Esperava excessão.");
		} catch(Exception e) {
			assertEquals("Comprimento de onda invalido!", e.getMessage());
		}
		
		try {
			elementLines.getEnergy(0);
			Assert.fail("Esperava excessão.");
		} catch(Exception e) {
			assertEquals("Comprimento de onda invalido!", e.getMessage());
		}
		
		try {
			elementLines.getPosition(-200, -500);
			Assert.fail("Esperava excessão.");
		} catch(Exception e) {
			assertEquals("Parametro(s) invalido(s)!", e.getMessage());
		}
		
		try {
			elementLines.getPosition(-200, 500);
			Assert.fail("Esperava excessão.");
		} catch(Exception e) {
			assertEquals("Parametro(s) invalido(s)!", e.getMessage());
		}
		
		try {
			elementLines.getPosition(0, -500);
			Assert.fail("Esperava excessão.");
		} catch(Exception e) {
			assertEquals("Parametro(s) invalido(s)!", e.getMessage());
		}
		
		try {
			elementLines.getPosition(1, -500);
			Assert.fail("Esperava excessão.");
		} catch(Exception e) {
			assertEquals("Parametro(s) invalido(s)!", e.getMessage());
		}
		
		try {
			elementLines.getPosition(0, 0);
			Assert.fail("Esperava excessão.");
		} catch(Exception e) {
			assertEquals("Parametro(s) invalido(s)!", e.getMessage());
		}
		
		elementLines.setChemicalElement(new ChemicalElement("Hidrogênio", "H", 1, 1, 1, Classification.NAO_METAIS));
		assertEquals(new ChemicalElement("Hidrogênio", "H", 1, 1, 1, Classification.NAO_METAIS), elementLines.getElement());
		
		elementLines.setChemicalElement(new ChemicalElement("Ferro", "Fe", 4, 8, 26, Classification.METAIS_DE_TRANSICAO));
		assertEquals(new ChemicalElement("Ferro", "Fe", 4, 8, 26, Classification.METAIS_DE_TRANSICAO), elementLines.getElement());
		
		elementLines.setChemicalElement(new ChemicalElement("Bromo", "Br", 4, 17, 35, Classification.HALOGENIOS));
		assertEquals(new ChemicalElement("Bromo", "Br", 4, 17, 35, Classification.HALOGENIOS), elementLines.getElement());
		
		elementLines.setChemicalElement(new ChemicalElement("Elemento", "E", 1, 1, 21, Classification.LIQUIDO));
		assertEquals(new ChemicalElement("Elemento", "E", 1, 1, 21, Classification.LIQUIDO), elementLines.getElement());
	}
	
	@Test
	public void testFunctions() throws Exception {
		assertEquals(3.712982585550099E-19, elementLines.getEnergy(535E-9), 0);
		assertEquals(5.255147310236251E-19, elementLines.getEnergy(378E-9), 0);
		assertEquals(6.921413530555061E-19, elementLines.getEnergy(287E-9), 0);
		assertEquals(4.966114208173257E-19, elementLines.getEnergy(400E-9), 0);
		assertEquals(2.8377795475275755E-19, elementLines.getEnergy(700E-9), 0);	
		
		assertEquals(1.2150227305844928E-7, elementLines.getPosition(1, 2), 0);
		assertEquals(1.0251754289306658E-7, elementLines.getPosition(1, 3), 0);
		assertEquals(6.56112274515626E-7,elementLines.getPosition(2, 3), 0);
		assertEquals(1.8746064986160745E-6, elementLines.getPosition(3, 4), 0);
		assertEquals(4.651258890518761E-6, elementLines.getPosition(5, 7), 0);
	}
	
}