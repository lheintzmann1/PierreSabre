package personnages;

public class Ronin extends Humain{
	private int honneur = 1;
	
	public Ronin(String nom, String boisson, int argent) {
		super(nom, boisson, argent);
	}
	
	public void donner(Commercant beneficiaire) {
		int don = Math.round(0.1f*getArgent());
		
		parler(beneficiaire.getNom()+" prend ces "+ don +" sous.");
		perdreArgent(don);
		beneficiaire.recevoir(don);
	}
	
}