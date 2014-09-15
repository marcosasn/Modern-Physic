/**Classe para armazenar os dados de cada elemento da tabela periodica.
 * 
 */

package model;

/**Periodic Table
 * 
 * @author Marcos Nascimento
 * @version 1
 *
 */
public class PeriodicTable {
	
	public static ChemicalElement[] tabela = new ChemicalElement[118];
	static {
		try {
			tabela[0] = new ChemicalElement("Hidrogênio", "H", 1, 1, 1, Classification.NAO_METAIS);
			tabela[1] = new ChemicalElement("Lítio", "Li", 2, 1, 3, Classification.METAIS_ALCALINOS);
			tabela[2] = new ChemicalElement("Sódio", "Na", 3, 1, 11, Classification.METAIS_ALCALINOS);
			tabela[3] = new ChemicalElement("Potássio", "K", 4, 1, 19, Classification.METAIS_ALCALINOS);
			tabela[4] = new ChemicalElement("Rubídio", "Rb", 5, 1, 37, Classification.METAIS_ALCALINOS);
			tabela[5] = new ChemicalElement("Césio", "Cs", 6, 1, 55, Classification.METAIS_ALCALINOS);
			tabela[6] = new ChemicalElement("Frâncio", "Fr", 7, 1, 87, Classification.METAIS_ALCALINOS);
			tabela[7] = new ChemicalElement("Berílio", "Be", 2, 2, 4, Classification.METAIS_ALCALINOS_TERROSOS);
			tabela[8] = new ChemicalElement("Magnésio", "Mg", 3, 2, 12, Classification.METAIS_ALCALINOS_TERROSOS);
			tabela[9] = new ChemicalElement("Cálcio", "Ca", 4, 2, 20, Classification.METAIS_ALCALINOS_TERROSOS);
			tabela[10] = new ChemicalElement("Estrôncio", "Sr", 5, 2, 38, Classification.METAIS_ALCALINOS_TERROSOS);
			tabela[11] = new ChemicalElement("Bário", "Ba", 6,2, 56, Classification.METAIS_ALCALINOS_TERROSOS);
			tabela[12] = new ChemicalElement("Rádio", "Ra", 7, 2, 88, Classification.METAIS_ALCALINOS_TERROSOS);
			tabela[13] = new ChemicalElement("Escândio", "Sc", 4, 3, 21, Classification.METAIS_DE_TRANSICAO);
			tabela[14] = new ChemicalElement("Ítrio", "Y", 5, 3, 39, Classification.METAIS_DE_TRANSICAO);
			tabela[15] = new ChemicalElement("TitÂnio", "Ti", 4, 4, 22, Classification.METAIS_DE_TRANSICAO);
			tabela[16] = new ChemicalElement("Zircônio", "Zr", 5, 4, 40, Classification.METAIS_DE_TRANSICAO);
			tabela[17] = new ChemicalElement("Háfnio", "Hf", 6, 4, 72, Classification.METAIS_DE_TRANSICAO);
			tabela[18] = new ChemicalElement("Rutherfórdio", "Rf", 7, 4, 104, Classification.METAIS_DE_TRANSICAO);
			tabela[19] = new ChemicalElement("Vanádio", "V", 4, 5, 23, Classification.METAIS_DE_TRANSICAO);
			tabela[20] = new ChemicalElement("Nióbio", "Nb", 5, 5, 41, Classification.METAIS_DE_TRANSICAO);
			tabela[21] = new ChemicalElement("Tântalo", "Ta", 6, 5, 73, Classification.METAIS_DE_TRANSICAO);
			tabela[22] = new ChemicalElement("Dúbnio", "Db", 7, 5, 105, Classification.METAIS_DE_TRANSICAO);
			tabela[23] = new ChemicalElement("Cromo", "Cr", 4, 6,  24, Classification.METAIS_DE_TRANSICAO);
			tabela[24] = new ChemicalElement("Molibdênio", "Mo", 5, 6, 42, Classification.METAIS_DE_TRANSICAO);
			tabela[25] = new ChemicalElement("Tungstênio", "W", 6, 6, 74, Classification.METAIS_DE_TRANSICAO);
			tabela[26] = new ChemicalElement("Seabórgio", "Sg", 7, 6, 106, Classification.METAIS_DE_TRANSICAO);
			tabela[27] = new ChemicalElement("Manganês", "Mn", 4, 7, 25, Classification.METAIS_DE_TRANSICAO);
			tabela[28] = new ChemicalElement("Tecnécio", "Tc", 5, 7, 43, Classification.METAIS_DE_TRANSICAO);
			tabela[29] = new ChemicalElement("Rênio", "Re", 6, 7, 75, Classification.METAIS_DE_TRANSICAO);
			tabela[30] = new ChemicalElement("Bóhrio", "Bh", 7, 7, 107, Classification.METAIS_DE_TRANSICAO);
			tabela[31] = new ChemicalElement("Ferro", "Fe", 4, 8, 26, Classification.METAIS_DE_TRANSICAO);
			tabela[32] = new ChemicalElement("Rutênio", "Ru", 5, 8, 44, Classification.METAIS_DE_TRANSICAO);
			tabela[33] = new ChemicalElement("Ósmio", "Os", 6, 8, 76, Classification.METAIS_DE_TRANSICAO);
			tabela[34] = new ChemicalElement("Hássio", "Hs", 7, 8, 108, Classification.METAIS_DE_TRANSICAO);
			tabela[35] = new ChemicalElement("Cobalto", "Co", 4, 9, 27, Classification.METAIS_DE_TRANSICAO);
			tabela[36] = new ChemicalElement("Ródio", "Rh", 5, 9, 45, Classification.METAIS_DE_TRANSICAO);
			tabela[37] = new ChemicalElement("Irídio", "Ir", 6, 9, 77, Classification.METAIS_DE_TRANSICAO);
			tabela[38] = new ChemicalElement("Meitnério", "Mt", 7, 9, 109, Classification.METAIS_DE_TRANSICAO);
			tabela[39] = new ChemicalElement("Níquel", "Ni", 4, 10, 28, Classification.METAIS_DE_TRANSICAO);
			tabela[40] = new ChemicalElement("Poládio", "Pd", 5, 10, 46, Classification.METAIS_DE_TRANSICAO);
			tabela[41] = new ChemicalElement("Platina", "Pt", 6, 10, 78, Classification.METAIS_DE_TRANSICAO);
			tabela[42] = new ChemicalElement("Darmstádio", "Ds", 7, 10, 110, Classification.METAIS_DE_TRANSICAO);
			tabela[43] = new ChemicalElement("Cobre", "Cu", 4, 11, 29, Classification.METAIS_DE_TRANSICAO);
			tabela[44] = new ChemicalElement("Prata", "Ag", 5, 11, 47, Classification.METAIS_DE_TRANSICAO);
			tabela[45] = new ChemicalElement("Ouro", "Au", 6, 11, 79, Classification.METAIS_DE_TRANSICAO);
			tabela[46] = new ChemicalElement("Roentgênio", "Rg", 7, 11, 111, Classification.METAIS_DE_TRANSICAO);
			tabela[47] = new ChemicalElement("Zinco", "Zn", 4, 12, 30, Classification.METAIS_DE_TRANSICAO);
			tabela[48] = new ChemicalElement("Cadmio", "Cd", 5, 12, 48, Classification.METAIS_DE_TRANSICAO);
			tabela[49] = new ChemicalElement("Mercúrio", "Hg", 6, 12, 80, Classification.METAIS_DE_TRANSICAO);
			tabela[50] = new ChemicalElement("Copérnico", "Cn", 7, 12, 112, Classification.METAIS_DE_TRANSICAO);
			tabela[51] = new ChemicalElement("Boro", "B", 2, 13, 5, Classification.SEMI_METAIS);
			tabela[52] = new ChemicalElement("Alumínio", "Al", 3, 13, 13, Classification.METAIS_REPRESENTATIVOS);
			tabela[53] = new ChemicalElement("Gálio", "Ga", 4, 13, 31, Classification.METAIS_REPRESENTATIVOS);
			tabela[54] = new ChemicalElement("Índio", "In", 5, 13, 49, Classification.METAIS_REPRESENTATIVOS);
			tabela[55] = new ChemicalElement("Tálio", "Tl", 6, 13, 81, Classification.METAIS_REPRESENTATIVOS);
			tabela[56] = new ChemicalElement("Ununtrio", "Uut", 7, 13, 113, Classification.METAIS_REPRESENTATIVOS);
			tabela[57] = new ChemicalElement("Carbono", "C", 2, 14, 6, Classification.NAO_METAIS);
			tabela[58] = new ChemicalElement("Silício", "Si", 3, 14, 14, Classification.SEMI_METAIS);//OLHAR z DEPOIS
			tabela[59] = new ChemicalElement("Germânio", "Ge", 4, 14, 32, Classification.SEMI_METAIS);
			tabela[60] = new ChemicalElement("Estanho", "Sn", 5, 14, 50, Classification.METAIS_REPRESENTATIVOS);
			tabela[61] = new ChemicalElement("Chumbo", "Pb", 6, 14, 82, Classification.METAIS_REPRESENTATIVOS);
			tabela[62] = new ChemicalElement("Ununquádio", "Uuq", 7, 14, 114, Classification.METAIS_REPRESENTATIVOS);
			tabela[63] = new ChemicalElement("Nitrigênio", "N", 2, 15, 7, Classification.NAO_METAIS);
			tabela[64] = new ChemicalElement("Fosfóro", "P", 3, 15, 15, Classification.NAO_METAIS);
			tabela[65] = new ChemicalElement("Arsênio", "As", 4, 15, 33, Classification.NAO_METAIS);
			tabela[66] = new ChemicalElement("Antimônio","Sb", 5, 15, 51, Classification.SEMI_METAIS);
			tabela[67] = new ChemicalElement("Bismuto", "Bi", 6, 15, 83, Classification.METAIS_REPRESENTATIVOS);
			tabela[68] = new ChemicalElement("Ununpentio", "Uup", 7, 15, 115, Classification.METAIS_REPRESENTATIVOS);
			tabela[69] = new ChemicalElement("Oxigênio", "O", 2, 16, 8, Classification.NAO_METAIS);
			tabela[70] = new ChemicalElement("Enxofre", "S", 3, 16, 16, Classification.NAO_METAIS);
			tabela[71] = new ChemicalElement("Selênio", "Se", 4, 16, 34, Classification.NAO_METAIS);
			tabela[72] = new ChemicalElement("Telúrio", "Te", 5, 16, 52, Classification.SEMI_METAIS);
			tabela[73] = new ChemicalElement("Polônio", "Po", 6, 16, 84, Classification.NAO_METAIS);
			tabela[74] = new ChemicalElement("Ununhéxio", "Uuh", 7, 16, 116, Classification.METAIS_REPRESENTATIVOS);
			tabela[75] = new ChemicalElement("Flúor", "F", 2, 17, 9, Classification.HALOGENIOS);
			tabela[76] = new ChemicalElement("Cloro", "Cl", 3, 17, 17, Classification.HALOGENIOS);
			tabela[77] = new ChemicalElement("Bromo", "Br", 4, 17, 35, Classification.HALOGENIOS);
			tabela[78] = new ChemicalElement("Iodo", "I", 5, 17, 53, Classification.HALOGENIOS);
			tabela[79] = new ChemicalElement("Astato", "At", 6, 17, 85, Classification.HALOGENIOS);
			tabela[80] = new ChemicalElement("Ununséptio", "Uus", 7, 17, 117, Classification.HALOGENIOS);
			tabela[81] = new ChemicalElement("Hélio", "He", 1, 18, 2, Classification.GASES_NOBRES);
			tabela[82] = new ChemicalElement("Neônio", "Ne", 2, 18, 10, Classification.GASES_NOBRES);
			tabela[83] = new ChemicalElement("Argônio", "Ar", 3, 18, 18, Classification.GASES_NOBRES);
			tabela[84] = new ChemicalElement("Criptônio", "Kr", 4, 18, 36, Classification.GASES_NOBRES);
			tabela[85] = new ChemicalElement("Xenônio", "Xe", 5, 18, 54, Classification.GASES_NOBRES);
			tabela[86] = new ChemicalElement("Radônio", "Rn", 6, 18, 86, Classification.GASES_NOBRES);
			tabela[87] = new ChemicalElement("Ununóctio", "Uuo", 7, 18, 118, Classification.GASES_NOBRES);
			tabela[88] = new ChemicalElement("Lantânio", "La", 9, 4, 57, Classification.LANTANIDEOS);
			tabela[89] = new ChemicalElement("Cério", "Ce", 9, 5, 58, Classification.LANTANIDEOS);
			tabela[90] = new ChemicalElement("Praseodímio", "Pr", 9, 6, 59, Classification.LANTANIDEOS);
			tabela[91] = new ChemicalElement("Neodímio", "Nd", 9, 7, 60, Classification.LANTANIDEOS);
			tabela[92] = new ChemicalElement("Promécio", "Pm", 9, 8, 61, Classification.LANTANIDEOS);
			tabela[93] = new ChemicalElement("Samário", "Sm", 9, 9, 62, Classification.LANTANIDEOS);
			tabela[94] = new ChemicalElement("Európio", "Eu", 9, 10, 63, Classification.LANTANIDEOS);
			tabela[95] = new ChemicalElement("Gadolínio", "Gd", 9, 11, 64, Classification.LANTANIDEOS);
			tabela[96] = new ChemicalElement("Térbio", "Tb", 9, 12, 65, Classification.LANTANIDEOS);
			tabela[97] = new ChemicalElement("Disprósio", "Dy", 9, 13, 66, Classification.LANTANIDEOS);
			tabela[98] = new ChemicalElement("Hólmio", "Ho", 9, 14, 67, Classification.LANTANIDEOS);
			tabela[99] = new ChemicalElement("Érbio", "Er", 9, 15, 68, Classification.LANTANIDEOS);
			tabela[100] = new ChemicalElement("Túlio", "Tm", 9, 16, 69, Classification.LANTANIDEOS);
			tabela[101] = new ChemicalElement("Itérbio", "Yb", 9, 17, 70, Classification.LANTANIDEOS);
			tabela[102] = new ChemicalElement("Lutécio", "Lu", 9, 18, 71, Classification.LANTANIDEOS);
			tabela[103] = new ChemicalElement("Actínio", "Ac", 10, 4, 89, Classification.ACTINIDEOS);
			tabela[104] = new ChemicalElement("Tório", "Th", 10, 5, 90, Classification.ACTINIDEOS);
			tabela[105] = new ChemicalElement("Protactínio", "Pa", 10, 6, 91, Classification.ACTINIDEOS);
			tabela[106] = new ChemicalElement("Urânio", "U", 10, 7, 92, Classification.ACTINIDEOS);
			tabela[107] = new ChemicalElement("Neptúnio", "Np", 10, 8, 93, Classification.ACTINIDEOS);
			tabela[108] = new ChemicalElement("Plutônio", "Pu", 10, 9, 94, Classification.ACTINIDEOS);
			tabela[109] = new ChemicalElement("Amerício", "Am", 10, 10, 95, Classification.ACTINIDEOS);
			tabela[110] = new ChemicalElement("Cúrio", "Cm", 10, 11, 96, Classification.ACTINIDEOS);
			tabela[111] = new ChemicalElement("Berquélio", "Bk", 10, 12, 97, Classification.ACTINIDEOS);
			tabela[112] = new ChemicalElement("Califórnio", "Cf", 10, 13, 98, Classification.ACTINIDEOS);
			tabela[113] = new ChemicalElement("Einstênio", "Es", 10, 14, 99, Classification.ACTINIDEOS);
			tabela[114] = new ChemicalElement("Férmio", "Fm", 10, 15, 100, Classification.ACTINIDEOS);
			tabela[115] = new ChemicalElement("Mendelévio", "Md", 10, 16, 101, Classification.ACTINIDEOS);
			tabela[116] = new ChemicalElement("Nobélio", "No", 10, 17, 102, Classification.ACTINIDEOS);
			tabela[117] = new ChemicalElement("Laurêncio", "Lr", 10, 18, 103, Classification.ACTINIDEOS);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}