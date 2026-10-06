package personnages;

public class Gaulois {
    private String nom;
    private int force;

    public Gaulois(String nom, int force) {
        this.nom = nom;
        this.force = force;
    }

    public String getNom() {
        return nom;
    }

    public void parler(String texte) {
        System.out.println(prendreParole() + "\"" + texte + "\"");
    }

    private String prendreParole() {
        return "Le Gaulois " + nom + " : ";
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gaulois asterix= new Gaulois("Asterix", 8);
		System.out.println(asterix);
	}

	@Override
	public String toString() {
		return nom ;
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
		romain.recevoirCoup(force / 3);
	}
    
}

