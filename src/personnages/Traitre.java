package personnages;

import java.util.Random;

public class Traitre extends Samourai {
	private int niveauTraitrise = 0;
	
	public Traitre(String seigneur, String nom, String boisson, int argent) {
		super(seigneur, nom, boisson, argent);
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mais je suis un traître et mon niveau de tra�trise est : "+niveauTraitrise+". Chut !");
	}
	
	public void ranconner(Commercant commercant) {
		if (niveauTraitrise<3) {
			int argentCommercant = commercant.getArgent();
			int argentRanconne = argentCommercant * 2/10;
			
			commercant.perdreArgent(argentRanconne);
			gagnerArgent(argentRanconne);
			niveauTraitrise ++;
			parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne moi "+argentRanconne+" sous ou gare a toi !");
			commercant.parler("Tout de suite grand "+getNom()+".");
		}else {
			parler("Mince je ne peux plus ranconner personne sinon un samourai risque de me demasquer !");
		}
	}
	
	public void faireLeGentil() {
		Random random = new Random();
		if (nbConnaissance < 1) {
			parler("Je ne peux faire ami ami avec personne car je ne connais personne ! Snif.");
		}else {
			Humain ami = getConnaissances()[random.nextInt(nbConnaissance)];
			int don = getArgent() * 1/20;
			String nomAmi = ami.getNom();
			
			parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec "+nomAmi+".");
			parler("Bonjour l'ami ! Je voudrais vous aider en vous donnant "+don+" sous.");
			ami.gagnerArgent(don);
			perdreArgent(don);
			String nom = getNom();
			ami.parler("Merci "+nom+". Vous �tes quelqu'un de bien.");
			if (niveauTraitrise>1) {
				niveauTraitrise --;
			}
		}
	}
}