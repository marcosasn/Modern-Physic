/**Classe que faz a representacao de um numero em potencia de 10 (dez). 
 * 
 */

package model;

/**Scientific Notation
 * 
 * @author Marcos Nascimento
 * @version 1
 */
public class ScientificNotation {

	private double mantissa, originalValue;
	private int exponent;
	
	/**Construtor da classe
	 * 
	 * @param value O valor que deseja obter representacao.
	 */
	public ScientificNotation(double value) {
		this.originalValue = value;
		normalize();
	}
	
	/**Metodo que faz a normalizacao do valor.
	 * 
	 */
	private void normalize() {
		double value = originalValue;
		while (Math.abs(value) < 100 && value != 0) {
			value *= 10;
			exponent--;
		}
		while (Math.abs(value) >= 1000) {
			value /= 10;
			exponent++;
		}
		mantissa = value;
	}
	
	/**Metodo acessador do expoente.
	 * 
	 * @return O expoente.
	 */
	public int getExponent() { 
		return exponent;
	}
	
	/**Metodo acessador de mantissa.
	 * 
	 * @return A mantissa.
	 */
	public double getMantissa() { 
		return mantissa;
	}
	
	@Override
	public String toString() { 
		return String.format("%d", (int)mantissa) + (exponent != 0 ? "E" + exponent : "");
	}
}
