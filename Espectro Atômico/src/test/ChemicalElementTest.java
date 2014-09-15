package test;

import static org.junit.Assert.assertEquals;
import junit.framework.Assert;
import model.ChemicalElement;
import model.Classification;

import org.junit.Before;
import org.junit.Test;


public class ChemicalElementTest {
	
	ChemicalElement elemen1;
	ChemicalElement elemen2;
	ChemicalElement elemen3;
	ChemicalElement elemen4;

	@Before
	public void setUp() throws Exception {
		elemen1 = new ChemicalElement("Hidrog�nio", "H", 1, 1, 1, Classification.NAO_METAIS);
		elemen2 = new ChemicalElement("Ferro", "Fe", 4, 8, 26, Classification.METAIS_DE_TRANSICAO);
		elemen3 = new ChemicalElement("Bromo", "Br", 4, 17, 35, Classification.HALOGENIOS);
		elemen4 = new ChemicalElement("Elemento", "E", 1, 1, 21, Classification.LIQUIDO);	
	}
	
	@Test
	public void testConstructorChemicalElement() {
		try {
			new ChemicalElement(" ", "H", 1, 1, 1, Classification.NAO_METAIS);
			Assert.fail("Esperava excess�o.");
		} catch(Exception e) {
			assertEquals("Nome Inv�lido!", e.getMessage());
		}
		
		try {
			new ChemicalElement(null, "H", 1, 1, 1, Classification.NAO_METAIS);
			Assert.fail("Esperava excess�o.");
		} catch(Exception e) {
			assertEquals("Nome Inv�lido!", e.getMessage());
		}
		
		try {
			new ChemicalElement("Hidrog�nio", " ", 1, 1, 1, Classification.NAO_METAIS);
			Assert.fail("Esperava excess�o.");
		} catch(Exception e) {
			assertEquals("S�mbolo Inv�lido!", e.getMessage());
		}
		
		try {
			new ChemicalElement("Hidrog�nio", null, 1, 1, 1, Classification.NAO_METAIS);
			Assert.fail("Esperava excess�o.");
		} catch(Exception e) {
			assertEquals("S�mbolo Inv�lido!", e.getMessage());
		}
		
		try {
			new ChemicalElement("Hidrog�nio", "H", -300, 1, 1, Classification.NAO_METAIS);
			Assert.fail("Esperava excess�o.");
		} catch(Exception e) {
			assertEquals("Linha Inv�lida!", e.getMessage());
		}
		
		try {
			new ChemicalElement("Hidrog�nio", "H", 300, 1, 1, Classification.NAO_METAIS);
			Assert.fail("Esperava excess�o.");
		} catch(Exception e) {
			assertEquals("Linha Inv�lida!", e.getMessage());
		}
		
		try {
			new ChemicalElement("Hidrog�nio", "H", 0, 1, 1, Classification.NAO_METAIS);
			Assert.fail("Esperava excess�o.");
		} catch(Exception e) {
			assertEquals("Linha Inv�lida!", e.getMessage());
		}
		
		try {
			new ChemicalElement("Hidrog�nio", "H", 1, -500, 1, Classification.NAO_METAIS);
			Assert.fail("Esperava excess�o.");
		} catch(Exception e) {
			assertEquals("Coluna Inv�lida!", e.getMessage());
		}
		
		try {
			new ChemicalElement("Hidrog�nio", "H", 1, 500, 1, Classification.NAO_METAIS);
			Assert.fail("Esperava excess�o.");
		} catch(Exception e) {
			assertEquals("Coluna Inv�lida!", e.getMessage());
		}
		
		try {
			new ChemicalElement("Hidrog�nio", "H", 1, 0, 1, Classification.NAO_METAIS);
			Assert.fail("Esperava excess�o.");
		} catch(Exception e) {
			assertEquals("Coluna Inv�lida!", e.getMessage());
		}
		
		try {
			new ChemicalElement("Hidrog�nio", "H", 1, 1, -1000, Classification.NAO_METAIS);
			Assert.fail("Esperava excess�o.");
		} catch(Exception e) {
			assertEquals("N�mero At�mico Inv�lido!", e.getMessage());
		}
		
		try {
			new ChemicalElement("Hidrog�nio", "H", 1, 1, 1000, Classification.NAO_METAIS);
			Assert.fail("Esperava excess�o.");
		} catch(Exception e) {
			assertEquals("N�mero At�mico Inv�lido!", e.getMessage());
		}
		
		try {
			new ChemicalElement("Hidrog�nio", "H", 1, 1, 0, Classification.NAO_METAIS);
			Assert.fail("Esperava excess�o.");
		} catch(Exception e) {
			assertEquals("N�mero At�mico Inv�lido!", e.getMessage());
		}
		
		try {
			new ChemicalElement("Hidrog�nio", "H", 1, 1, 1, null);
			Assert.fail("Esperava excess�o.");
		} catch(Exception e) {
			assertEquals("Classifica��o n�o pode ser nula!", e.getMessage());
		}
	}

	@Test
	public void testChemicalElement() {
		assertEquals("Hidrog�nio", elemen1.getName());
		assertEquals("H", elemen1.getSymbol());
		assertEquals(1, elemen1.getLines());
		assertEquals(1, elemen1.getColumn());
		assertEquals(1, elemen1.getAtomicNumber());
		assertEquals(Classification.NAO_METAIS, elemen1.getClassification());
		
		assertEquals("Ferro", elemen2.getName());
		assertEquals("Fe", elemen2.getSymbol());
		assertEquals(4, elemen2.getLines());
		assertEquals(8, elemen2.getColumn());
		assertEquals(26, elemen2.getAtomicNumber());
		assertEquals(Classification.METAIS_DE_TRANSICAO, elemen2.getClassification());
		
		assertEquals("Bromo", elemen3.getName());
		assertEquals("Br", elemen3.getSymbol());
		assertEquals(4, elemen3.getLines());
		assertEquals(17, elemen3.getColumn());
		assertEquals(35, elemen3.getAtomicNumber());
		assertEquals(Classification.HALOGENIOS, elemen3.getClassification());
		
		assertEquals("Elemento", elemen4.getName());
		assertEquals("E", elemen4.getSymbol());
		assertEquals(1, elemen4.getLines());
		assertEquals(1, elemen4.getColumn());
		assertEquals(21, elemen4.getAtomicNumber());
		assertEquals(Classification.LIQUIDO, elemen4.getClassification());
	}
	
	
	@Test
	public void testSetsChemicalElement() throws Exception {
		assertEquals("Hidrog�nio", elemen1.getName());
		elemen1.setName("Caramelo");
		assertEquals("Caramelo", elemen1.getName());
		
		assertEquals("H", elemen1.getSymbol());
		elemen1.setSymbol("Ca");
		assertEquals("Ca", elemen1.getSymbol());
		
		assertEquals(1, elemen1.getLines());
		elemen1.setLine(5);
		assertEquals(5, elemen1.getLines());
		
		assertEquals(1, elemen1.getColumn());
		elemen1.setColumn(10);
		assertEquals(10, elemen1.getColumn());
		
		assertEquals(1, elemen1.getAtomicNumber());
		elemen1.setAtomicNumber(20);
		assertEquals(20, elemen1.getAtomicNumber());
		
		assertEquals(Classification.NAO_METAIS, elemen1.getClassification());
		elemen1.setClassification(Classification.ACTINIDEOS);
		assertEquals(Classification.ACTINIDEOS, elemen1.getClassification());		
		
		assertEquals("Caramelo", elemen1.getName());
		assertEquals("Ca", elemen1.getSymbol());
		assertEquals(5, elemen1.getLines());
		assertEquals(10, elemen1.getColumn());
		assertEquals(20, elemen1.getAtomicNumber());
		assertEquals(Classification.ACTINIDEOS, elemen1.getClassification());		
	}
	
	@Test
	public void testToString() {
		assertEquals("Nome: Hidrog�nio | S�mbolo: H | N�mero At�mico: 1 | Linha: 1 | Couna: 1", elemen1.toString());
		assertEquals("Nome: Ferro | S�mbolo: Fe | N�mero At�mico: 26 | Linha: 4 | Couna: 8", elemen2.toString());
		assertEquals("Nome: Bromo | S�mbolo: Br | N�mero At�mico: 35 | Linha: 4 | Couna: 17", elemen3.toString());
		assertEquals("Nome: Elemento | S�mbolo: E | N�mero At�mico: 21 | Linha: 1 | Couna: 1", elemen4.toString());
	}
}