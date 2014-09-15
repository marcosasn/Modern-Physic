/**Uma classe para descrever um elemento químico. 
 * Um elemento químico está presente na tabela períodica e detém alguns atributos que
 * são únicos e específicos de sua natureza. Os elementos químicos são representados 
 * na tabela períodica pela simbologia, número atômico, classificação e linha e coluna 
 * onde está localizado.
 * 
 * @author Andreza
 * @version 1
 */
package model;

/**
 * ElementoQuimico
 */
public class ChemicalElement {
  
    private String name, symbol;
    private int line, column, atomicNumber;
    private Classification classification;
      
    /**Construtor de ElementoQuimico
     * 
     * @param name O nome do elemento
     * @param symbol O símbolo do elemento
     * @param line A linha em que o mesmo se encontra na tabela períodica
     * @param colunm A linha em que o mesmo se encontra na tabela períodica
     * @param atomicNumber O número atômico
     * @param classification A classificação
     * @throws Exception Excessão caso o nome seja null ou string vazia, caso o simbolo seja null ou a string vazia, caso a linha
     * seja menor que 1 e maior que 10, caso a coluna seja menor que 1 e maior que 18, caso o númeto atômico seja menor que 1 ou
     * maior que 118 e por fim, caso a classificação seja null
     */
    public ChemicalElement(String name, String symbol, int line, int colunm, int atomicNumber, Classification classification) throws Exception {
    	if (name == null || name.trim().equals("")) {
            throw new Exception("Nome Inválido!");
        }
    	if (symbol == null || symbol.trim().equals("")) {
            throw new Exception("Símbolo Inválido!");
        }
    	if (line < 1 || line > 10) {
            throw new Exception("Linha Inválida!");
        }
    	if (colunm < 1 || colunm > 18) {
            throw new Exception("Coluna Inválida!");
        }
    	if (atomicNumber < 1 || atomicNumber > 118) {
            throw new Exception("Número Atômico Inválido!");
        }
    	if (classification == null) {
    		throw new Exception("Classificação não pode ser nula!");
    	}
        this.name = name;
        this.symbol = symbol;
        this.line = line;
        this.column = colunm;
        this.atomicNumber = atomicNumber;
        this.classification = classification; 
    }
  
    /**Método acessador do nome do elemento químico
     * 
     * @return O nome do elemento
     */
    public String getName() {
        return name;
    }
  
    /**Método modificador do nome do elemento químico
     * 
     * @param name O novo nome
     * @throws Exception Caso o nome seja null ou a string vazia
     */
    public void setName(String name) throws Exception {
        if (name == null || name.trim().equals("")) {
            throw new Exception("Nome Inválido!");
        }
        this.name = name;
    }
  
    /**Método acessador do símbolo do elemento químico
     * 
     * @return O símbolo do elemento
     */
    public String getSymbol() {
        return symbol;
    }
  
    /**Método modificador do símbolo do elemento químico
     * 
     * @param symbol O novo símbolo
     * @throws Exception Caso o símbolo seja null ou a string vazia
     */
    public void setSymbol(String symbol) throws Exception {
        if (symbol == null || symbol.trim().equals("")) {
            throw new Exception("Símbolo Inválido!");
        }
        this.symbol = symbol;
    }
  
    /**Método acessador da linha do elemento químico na tabela períodica
     * 
     * @return A linha do elemento químico
     */
    public int getLines() {
        return line;
    }
  
    /**Método modificador da linha do elemento químico na tabela períodica
     * 
     * @param line A nova linha do elemento químico
     * @throws Exception Caso a linha seja menor que 1 ou maior que 10
     */
    public void setLine(int line) throws Exception {
        if (line < 1 || line > 10) {
            throw new Exception("Linha Inválida!");
        }
        this.line = line;
    }
  
    /**Método acessador da coluna do elemento químico na tabela períodica
     * 
     * @return A coluna do elemento químico
     */
    public int getColumn() {
        return column;
    }
  
    /**Método modificador da coluna do elemento químico na tabela períodica
     * 
     * @param column A nova coluna do elemento químico
     * @throws Exception Caso a coluna seja menor que 1 ou maior que 18
     */
    public void setColumn(int column) throws Exception {
        if (column < 1 || column > 18) {
            throw new Exception("Coluna Inválida!");
        }
        this.column = column;
    }
  
    /**Método acessador do número atômico do elemento químico
     * 
     * @return O número atômico do elemento químico
     */
    public int getAtomicNumber() {
        return atomicNumber;
    }
  
    /**Método modificador do número atômico do elemento químico
     * 
     * @param atomicNumber O novo número atômico do elemento químico
     * @throws Exception Caso o número atômico seja menor que 1 ou seja maior que 118
     */
    public void setAtomicNumber(int atomicNumber) throws Exception {
        if (atomicNumber < 1 || atomicNumber > 118) {
            throw new Exception("Número Atômico Inválido!");
        }
        this.atomicNumber = atomicNumber;
    }
  
    /**Método acessador da classificação do elemento químico
     * 
     * @return A classificação do elemento químico
     */
    public Classification getClassification() {
        return classification;
    }
  
    /**Método modificador da classificação do elemento químico
     * 
     * @param classification A nova classificação do elemento químico
     * @throws Exception Caso a classificação seja null
     */
    public void setClassification(Classification classification) throws Exception {
    	if (classification == null) {
    		throw new Exception("Classificação não pode ser nula!");
    	}
        this.classification = classification;
    }  
    
    @Override
    public String toString() {
    	String informacoes = "Nome: " + getName() + " | Símbolo: " + getSymbol() + " | Número Atômico: " + getAtomicNumber() + " | Linha: " + getLines() + " | Coluna: " + getColumn();
    	return informacoes;
    }
    
    @Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof ChemicalElement) ) {
			return false;
		}
		ChemicalElement chemical = (ChemicalElement) obj;
		return this.getAtomicNumber() == chemical.getAtomicNumber();
	}
} 