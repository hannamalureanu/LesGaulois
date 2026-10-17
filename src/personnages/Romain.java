package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;

		assert isInvariantVerified();
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le Romain " + nom + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
		romain.recevoirCoup(force / 3);
	}

	public void recevoirCoup(int forceCoup) {
		assert forceCoup > 0;

		int ancienneForce = force;

		force -= forceCoup;

		if (force < 1) {
			force = 0;
			parler("J'abandonne !");
		} else {
			parler("Aïe");
		}

		assert isInvariantVerified();
		assert force < ancienneForce;
	}

	private boolean isInvariantVerified() {
		return force >= 0;
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
	}
}