/** Uma classe para descrever a classificação de todos os elementos da tabela períodica. 
 * Essa classificação faz referência a classes de categias de um certo tipo de elemento. 
 * Todo elemento, por sua vez, esta inserido em uma dessas categorias. 
 * A classificação detém a informação em que o elemento se encaixa na tabela períodica 
 * permitindo julgar alguns comportamentos específicos do próprio como:
 * ponto de ebulição, ponto de fusão, estado em temperatura ambiente e etc.
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
