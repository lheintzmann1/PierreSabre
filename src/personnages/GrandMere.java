package personnages;

public class GrandMere extends Humain {

    public GrandMere(String nom, String boisson, int argent) {
        super(nom, boisson, argent);
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
    
}
