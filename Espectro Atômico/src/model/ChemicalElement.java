/**Uma classe para descrever um elemento qu�mico. 
 * Um elemento qu�mico est� presente na tabela per�odica e det�m alguns atributos que
 * s�o �nicos e espec�ficos de sua natureza. Os elementos qu�micos s�o representados 
 * na tabela per�odica pela simbologia, n�mero at�mico, classifica��o e linha e coluna 
 * onde est� localizado.
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
     * @param symbol O s�mbolo do elemento
     * @param line A linha em que o mesmo se encontra na tabela per�odica
     * @param colunm A linha em que o mesmo se encontra na tabela per�odica
     * @param atomicNumber O n�mero at�mico
     * @param classification A classifica��o
     * @throws Exception Excess�o caso o nome seja null ou string vazia, caso o simbolo seja null ou a string vazia, caso a linha
     * seja menor que 1 e maior que 10, caso a coluna seja menor que 1 e maior que 18, caso o n�meto at�mico seja menor que 1 ou
     * maior que 118 e por fim, caso a classifica��o seja null
     */
    public ChemicalElement(String name, String symbol, int line, int colunm, int atomicNumber, Classification classification) throws Exception {
    	if (name == null || name.trim().equals("")) {
            throw new Exception("Nome Inv�lido!");
        }
    	if (symbol == null || symbol.trim().equals("")) {
            throw new Exception("S�mbolo Inv�lido!");
        }
    	if (line < 1 || line > 10) {
            throw new Exception("Linha Inv�lida!");
        }
    	if (colunm < 1 || colunm > 18) {
            throw new Exception("Coluna Inv�lida!");
        }
    	if (atomicNumber < 1 || atomicNumber > 118) {
            throw new Exception("N�mero At�mico Inv�lido!");
        }
    	if (classification == null) {
    		throw new Exception("Classifica��o n�o pode ser nula!");
    	}
        this.name = name;
        this.symbol = symbol;
        this.line = line;
        this.column = colunm;
        this.atomicNumber = atomicNumber;
        this.classification = classification; 
    }
  
    /**M�todo acessador do nome do elemento qu�mico
     * 
     * @return O nome do elemento
     */
    public String getName() {
        return name;
    }
  
    /**M�todo modificador do nome do elemento qu�mico
     * 
     * @param name O novo nome
     * @throws Exception Caso o nome seja null ou a string vazia
     */
    public void setName(String name) throws Exception {
        if (name == null || name.trim().equals("")) {
            throw new Exception("Nome Inv�lido!");
        }
        this.name = name;
    }
  
    /**M�todo acessador do s�mbolo do elemento qu�mico
     * 
     * @return O s�mbolo do elemento
     */
    public String getSymbol() {
        return symbol;
    }
  
    /**M�todo modificador do s�mbolo do elemento qu�mico
     * 
     * @param symbol O novo s�mbolo
     * @throws Exception Caso o s�mbolo seja null ou a string vazia
     */
    public void setSymbol(String symbol) throws Exception {
        if (symbol == null || symbol.trim().equals("")) {
            throw new Exception("S�mbolo Inv�lido!");
        }
        this.symbol = symbol;
    }
  
    /**M�todo acessador da linha do elemento qu�mico na tabela per�odica
     * 
     * @return A linha do elemento qu�mico
     */
    public int getLines() {
        return line;
    }
  
    /**M�todo modificador da linha do elemento qu�mico na tabela per�odica
     * 
     * @param line A nova linha do elemento qu�mico
     * @throws Exception Caso a linha seja menor que 1 ou maior que 10
     */
    public void setLine(int line) throws Exception {
        if (line < 1 || line > 10) {
            throw new Exception("Linha Inv�lida!");
        }
        this.line = line;
    }
  
    /**M�todo acessador da coluna do elemento qu�mico na tabela per�odica
     * 
     * @return A coluna do elemento qu�mico
     */
    public int getColumn() {
        return column;
    }
  
    /**M�todo modificador da coluna do elemento qu�mico na tabela per�odica
     * 
     * @param column A nova coluna do elemento qu�mico
     * @throws Exception Caso a coluna seja menor que 1 ou maior que 18
     */
    public void setColumn(int column) throws Exception {
        if (column < 1 || column > 18) {
            throw new Exception("Coluna Inv�lida!");
        }
        this.column = column;
    }
  
    /**M�todo acessador do n�mero at�mico do elemento qu�mico
     * 
     * @return O n�mero at�mico do elemento qu�mico
     */
    public int getAtomicNumber() {
        return atomicNumber;
    }
  
    /**M�todo modificador do n�mero at�mico do elemento qu�mico
     * 
     * @param atomicNumber O novo n�mero at�mico do elemento qu�mico
     * @throws Exception Caso o n�mero at�mico seja menor que 1 ou seja maior que 118
     */
    public void setAtomicNumber(int atomicNumber) throws Exception {
        if (atomicNumber < 1 || atomicNumber > 118) {
            throw new Exception("N�mero At�mico Inv�lido!");
        }
        this.atomicNumber = atomicNumber;
    }
  
    /**M�todo acessador da classifica��o do elemento qu�mico
     * 
     * @return A classifica��o do elemento qu�mico
     */
    public Classification getClassification() {
        return classification;
    }
  
    /**M�todo modificador da classifica��o do elemento qu�mico
     * 
     * @param classification A nova classifica��o do elemento qu�mico
     * @throws Exception Caso a classifica��o seja null
     */
    public void setClassification(Classification classification) throws Exception {
    	if (classification == null) {
    		throw new Exception("Classifica��o n�o pode ser nula!");
    	}
        this.classification = classification;
    }  
    
    @Override
    public String toString() {
    	String informacoes = "Nome: " + getName() + " | S�mbolo: " + getSymbol() + " | N�mero At�mico: " + getAtomicNumber() + " | Linha: " + getLines() + " | Coluna: " + getColumn();
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