package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		StringBuilder question = new StringBuilder();
		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		if (!vendeurReconnu ) {
			question.append("Mais vous n'etes pas inscrit sur notre marché aujourd'hui !\n");
		}else {
			String[] donneesEtal =controlLibererEtal.libererEtal(nomVendeur);
			if("true".equals(donneesEtal[0])) {
				question.append("Vous avez vendu " +donneesEtal[4]+" sur"+donneesEtal[3]+" "+donneesEtal[2]+".\n");
				question.append("En revoir " + donneesEtal[1]+ ", passez une bonne journée. \n");
			}
		}
	}

}
