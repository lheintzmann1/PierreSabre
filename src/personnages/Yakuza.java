package personnages;

public class Yakuza extends Humain{
	private String clan;
	private int reputation = 0;
	
	public Yakuza(String nom, String boisson, int argent, String clan) {
		super(nom, boisson, argent);
		this.clan = clan;
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mon clan est celui de " + clan);
	}
	
	public void extorquer(Commercant victime) {
		int argentVictime = victime.getArgent();
		
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par la ?");
		parler(victime.getNom()+", si tu tiens a la vie donne moi ta bourse !");
		setArgent(getArgent()+argentVictime);
		victime.seFaireExtorquer();
		reputation ++;
		parler("J'ai piqué les "+ argentVictime +" sous de "+ victime.getNom() +", ce qui me fait "+ getArgent() +" sous dans ma poche. Hi ! Hi !");
	}

	public int getReputation() {
		return reputation;
	}
}