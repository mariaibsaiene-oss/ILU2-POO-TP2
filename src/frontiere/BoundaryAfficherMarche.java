package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		StringBuilder phrase = new StringBuilder();
		int i=0;
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if(infosMarche.length == 0) {
			phrase.append("Le marché est vide, revenez plus tard.\n");
		}else {
			phrase.append(nomAcheteur+", vous trouverez au marché. \n");
			while(infosMarche != null) {
				phrase.append("-"+ infosMarche[i+1]+ "qui vend "+ infosMarche[i+2]+" "+ infosMarche[i+3]);
			}
		}
	}
}
