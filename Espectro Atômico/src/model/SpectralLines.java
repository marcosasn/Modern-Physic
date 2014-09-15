/**Uma classe que descreve as linhas espectrais, objeto de estudo da fisica moderna.
 * 
 * @author Andreza
 * @version 1
 */
package model;

/**LinhasEspectrais
 *
 */
public class SpectralLines {

	private ChemicalElement element;
	private static final double RYDBERG = 10973731.6;
	private static final double LIGHT_SPEED = 299792458;
	private static final double PLANCK_CONSTANT = 6.62606957E-34;
	
	/**Construtor de linhas espectrais
	 * 
	 * @param element O elemento
	 * @throws Exception Caso o elemento seja null
	 */
	public SpectralLines(ChemicalElement element) throws Exception {
		if (element == null) {
			throw new Exception("Elemento nao pode ser nulo!");
		}
		this.element = element;
	}
	
	/**Metodo acessador do elemento quimico
	 * 
	 * @return O elemento quimico
	 */
	public ChemicalElement getElement() {
		return element;
	}
	
	/**Metodo acessador da energia de um certo comprimento de onda
	 * 
	 * @param waveLength O comprimento de onda
	 * @return O valor da energia
	 * @throws Exception Caso o comprimento de onda for menor ou igual a 0
	 */
	public double getEnergy(double waveLength) throws Exception{
		if (waveLength <= 0) {
			throw new Exception("Comprimento de onda invalido!");
		}
		return (PLANCK_CONSTANT * LIGHT_SPEED) / waveLength;
	}
	
	/**Metodo acessador da posicao da linha espectral
	 * 
	 * @param firstLevel O nivel inicial de energia
	 * @param lastLevel O nivel final de energia
	 * @return A posicao da linha espectral
	 * @throws Exception Caso o nivel inicial for menor que 1 e o nivel final for menor que o nivel inicial
	 */
	public double getPosition(int firstLevel, int lastLevel) throws Exception{
		if (firstLevel < 1 || lastLevel < firstLevel) {
			throw new Exception("Parametro(s) invalido(s)!");
		}
		double squaredAtomicNumber = Math.pow(element.getAtomicNumber(), 2);
		double squaredFirstLevel = Math.pow(firstLevel, 2);
		double squaredLastLevel = Math.pow(lastLevel, 2);
		
		double waveNumber = RYDBERG * squaredAtomicNumber * ((1/squaredFirstLevel) - (1/squaredLastLevel)); 
		return 1/waveNumber;
	}
	
	/**Metodo modificador de elemento quimico
	 * 
	 * @param element O novo elemento quimico
	 */
	public void setChemicalElement(ChemicalElement element) {
		this.element = element;
	}
}
