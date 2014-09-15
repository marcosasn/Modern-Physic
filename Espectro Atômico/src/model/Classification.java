/** Uma classe para descrever a classifica��o de todos os elementos da tabela per�odica. 
 * Essa classifica��o faz refer�ncia a classes de categias de um certo tipo de elemento. 
 * Todo elemento, por sua vez, esta inserido em uma dessas categorias. 
 * A classifica��o det�m a informa��o em que o elemento se encaixa na tabela per�odica 
 * permitindo julgar alguns comportamentos espec�ficos do pr�prio como:
 * ponto de ebuli��o, ponto de fus�o, estado em temperatura ambiente e etc.
 * 
 * @author Andreza
 * @version 1
 * 
 */

package model;

/**Classification
 * 
 * @author Marcos Nascimento
 * @version 1
 *
 */
public enum Classification {

	METAIS_ALCALINOS, 
	METAIS_ALCALINOS_TERROSOS, 
	METAIS_DE_TRANSICAO, 
	LANTANIDEOS, 
	ACTINIDEOS, 
	METAIS_REPRESENTATIVOS, 
	SEMI_METAIS, 
	NAO_METAIS, 
	HALOGENIOS, 
	GASES_NOBRES, 
	SOLIDO, 
	LIQUIDO, 
	GASOSO, 
	DESCONHECIDO;

}
