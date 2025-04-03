package personnages;

public class Humain {
	
	final int MAX_CONNAISSANCES = 30;
	private String nom;
	private String boisson;
	private int argent;
	protected int nbConnaissance = 0;
	private Humain[] connaissances = new Humain[MAX_CONNAISSANCES];
	
	public Humain(String nom, String boisson, int argent) {
		this.nom = nom;
		this.boisson = boisson;
		this.argent = argent;
	}
	
	public String getNom() {
		return nom;
	}
	public int getArgent() {
		return argent;
	}

	public Humain[] getConnaissances() {
		return connaissances;
	}
	
	public void setArgent(int argent) {
		this.argent = argent;
	}
	
	protected void parler(String texte) {
		System.out.println("("+nom+") - " + texte);
	}
	
	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + nom + " et j'aime boire du " + boisson);
	}
	
	public void boire() {
		parler("Mmmm, un bon verre de " + boisson + " ! GLOUPS !");
	}
	
	public void acheter(String bien, int prix) {
		if (argent >= prix) {
			parler("J'ai "+argent+" sous en poche. Je vais pouvoir m'offrir " + bien + " a " + prix + " sous");
			perdreArgent(prix);
		} else {
			parler("Je n'ai plus que "+argent+" sous en poche. Je ne peux meme pas m'offrir " + bien + " a " + prix + " sous");
		}
	}
	
	public void gagnerArgent(int gain) {
		argent += gain;
	}
	
	public void perdreArgent(int perte) {
		argent -= perte;
	}
	
	public void faireConnaissanceAvec(Humain autreHumain) {
		direBonjour();
		autreHumain.repondre(this);
		memoriser(autreHumain);
	}

	private void memoriser(Humain autreHumain) {
		if (nbConnaissance < MAX_CONNAISSANCES) {
			connaissances[nbConnaissance] = autreHumain;
			nbConnaissance++;
		} else {
			for (int i = 0; i < MAX_CONNAISSANCES - 1; i++) {
				connaissances[i] = connaissances[i+1];
			}
			connaissances[MAX_CONNAISSANCES-1] = autreHumain;
		}
	}

	private void repondre(Humain autreHumain) {
		direBonjour();
		memoriser(autreHumain);
	}

	public void listerConnaissances() {
		String texte;
		if (nbConnaissance > 0) {
			texte = "Je connais beaucoup de monde dont : ";
			for (int i=0; i < nbConnaissance - 1; i++) {
				texte += connaissances[i].getNom()+", ";
			}
			texte += connaissances[nbConnaissance-1].getNom();
			parler(texte);
		}
	}
	
}
