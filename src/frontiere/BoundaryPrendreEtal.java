package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		StringBuilder question = new StringBuilder();
		if( ! controlPrendreEtal.verifierIdentite(nomVendeur)) {
		    question.append("Je suis désolée" +nomVendeur+ "mais il faut etre un habitant de notre village pour commencer ici. \n" );}
		else {
			question.append("Bonjour "+ nomVendeur+" , je vais regarder si je peux vous trouver un étal\n");
			if(!controlPrendreEtal.resteEtals()) {
				question.append("Désolée" + nomVendeur+" je n'ai plus d'étal qui ne soit pas déjà pccupé. \n");
			}else {
				installerVendeur(nomVendeur);
			}
		}
		
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder question = new StringBuilder();
		question.append("C'est parfait, il me reste un étal pour vous ! \n");
		question.append("Il me faudrait quelques renseignements. \n");
		question.append("Quel produit souhaitez-vous vendre ?  \n");
		String produit = Clavier.entrerChaine(question.toString());
		question.append("Combien souhaitez-vous en vendre ? ");
		int nbProduit = Clavier.entrerEntier(question.toString());

		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numeroEtal != -1) {
			question.append("Le vendeur "+nomVendeur+ "s'est installé à l'étal n°" +numeroEtal+ "\n");
		}
	}
}
