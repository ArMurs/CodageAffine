package packageChiffre ;

import java.util.Scanner;

public class Chiffre {
	
	/*
	 * Ancien main() utilis� ppour tester les fonctions de codage et de d�codage.
	 * 
	 * public static void main(String[] args) {
		
		// Initialisation des Scanners :
		Scanner scanMessage = new Scanner(System.in) ;
		Scanner scanCleA = new Scanner(System.in) ;
		Scanner scanCleB = new Scanner(System.in) ;
		
		// Initialisation des Strings
		String message = new String() ;
		String messageCode = new String() ;
		String messageDecode = new String() ;
		
		int cleA, cleB ;
		boolean flagEgalite ;
		
		// Entree : Message � coder , cles a et b
		System.out.println("Veuillez entrer votre message : ") ;
		message = scanMessage.next() ;
		
		System.out.println("Veuillez entrer a : ") ;
		cleA = scanCleA.nextInt() ;
		
		System.out.println("Veuillez entrer b : ") ;
		cleB = scanCleB.nextInt() ;
		
		
		//codage et decodage
		messageCode = codage(message, cleA , cleB) ;
		messageDecode = decodage(messageCode, cleA, cleB) ;
		
		// Test : le message une fois d�cod� est-il le m�me que le message original ?
		flagEgalite = message.equals(messageDecode) ;
		
		// Affichage des r�sultats : 
		System.out.println("\n");
		System.out.println("Message de base : " + message);
		System.out.println("Message code    : " + messageCode);
		System.out.println("Message decode  : " + messageDecode);
		System.out.println("Messages egaux  : " + flagEgalite);
		
		// Fermeture des Scanners
		scanMessage.close() ;
		scanCleA.close() ;
		scanCleB.close();
	}
	 */

	/*
	 * La fonction de codage en tant que tel !
	 * 
	 * La fonction a en param�tres : 
	 * 		> Le message � chiffrer : Sring
	 * 		> Les cl�s de chiffrement a et b : int
	 * 
	 * Elle retourne le message cod� : String
	 */
	public static String codage(String texte, int a, int b) {
		
		// On test si a est premier avec 26 (voir ci-dessous)
		if (test(a)) {
			
		// Si a est premier avec 26 :
			
			// Initialisation du message cod� avec un StringBuilder
			StringBuilder messageCode = new StringBuilder() ;
			
			// Pour chaque caract�re c du message ...
			for (char c : texte.toCharArray()) {
				
				// ... on recupere le code ASCII de c ...
				int code = (int) c ;
				
				// ... si c est une lettre minuscule :
				if ((code >= 97) && (code <= 122)) {
					
					// On modifie la valeur de code pour l'avoir entre 0 et 25
					code -= 97 ;
					
					// On chiffre la lettre 
					code = (a*code + b) % 26 ;
					
					// On modifie la valeur pour retourner la lettre minuscule correspondante
					code += 97 ;
					
					// On ajoute le la lettre correspondante dans la table ASCII
					messageCode = messageCode.append((char) code) ;
					
				// si c est une lettre Majuscule :
				} else if ((code >= 65) && (code <= 90)) {
					
					// IDEM (voir plus haut)
					code -= 65 ;
					code = (a*code + b) % 26 ;
					code += 65 ;
					
					messageCode = messageCode.append((char) code) ;
				
				// Si c n'est pas une lettre, pas de traitement , on l'ajoute juste au message cod�
				} else {
					messageCode = messageCode.append(c) ;
				}
			}
			// On retourne le message cod�.
			return(messageCode.toString()) ;
		
		// Si a n'est pas premier avec 26 : On retourne un message indiquant une impossibilit�.
		} else {
			return("ERREUR : VALEUR NON PREMIER AVEC 26 !") ;
		}
		
		
		

	}
	/*
	 * Fonction de test : pour que le message puisse �tre d�cod�, il faut que a soit premier avec 26.
	 * Si a n'est pas permier avec 26, deux lettres peuvent �tre chiffr�es avec le m�me r�sultat :
	 * 		Ex : 	A -> 1
	 * 				1 * 13 = 13
	 * 				13 % 26 = 13
	 * 				13 -> L
	 * 
	 * 				C -> 3
	 * 				3 * 13 = 39
	 * 				39 % 26 = 13
	 * 				13 -> L
	 * 
	 * 				On a la m�me lettre � l'arriv�e, mais pas la m�me lettre au d�part.
	 */
	public static boolean test(int a) {
		return((a%2 != 0) && (a%13 != 0)) ;
	}
	
	
	/*
	 * Fonction de d�codage : il s'agit juste de calculer les cl�s c et d d�codant le message puis de repasser
	 * le message cod� dans la fonction de codage avec ces cl�s c et d.
	 */
	public static String decodage(String texte, int a, int b) {
		
		String retour = new String() ;
		
		// Recherche des cl�s c et d (voir plus bas)
		int[] cles = chercherCles(a,b) ;
		
		int c = cles[0] ;
		int d = cles[1] ;
		
		// Passage du message cod� dans la fonction de codage avec c et d
		retour = retour.concat(codage(texte, c, d)) ;
		
		// Ajout d'une ligne pour afficher les cl�s de d�codage
		retour = retour.concat("\n\nD�cod� avec : \n\tc = " + c + "\n\td = "+ d) ;
		return(retour) ;
	}
	
	/*
	 * Trouver les cl�s de d�codage c et d � partir de a et b
	 */
	public static int[] chercherCles(int a, int b) {
		// c �tant la premi�re valeur enti�re premi�re avec a.
		int c = 0 ;
		while (((a * c) % 26 != 1 ) && (c <= 26) ) {
			c++ ;
		}
	
		// d �tant obtenu par ce calcul :
		/*
		 *  NB :  le '26 +' a �t� ajout� apr�s test : les messages d�cod�s avait des caract�res de
		 *  ponctuation � la place de certaines lettres. d doit �tre compris entre 0 et 26, il ne 
		 *  peut �tre n�gatif !
		 */
		int d = 26 + ((-(c*b)) % 26) ;
		


		int[] retour = {c,d} ;
		return(retour) ;
		
	}

}
