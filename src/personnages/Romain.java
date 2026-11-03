package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;

		assert isInvariantVerified();
	}

	public String getNom() {
		return nom;
	}

	public int getForce() {
		return force;
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

	/*
	 * public void recevoirCoup(int forceCoup) { assert forceCoup > 0;
	 * 
	 * int ancienneForce = force;
	 * 
	 * force -= forceCoup;
	 * 
	 * if (force < 1) { force = 0; parler("J'abandonne !"); } else { parler("Aïe");
	 * }
	 * 
	 * assert isInvariantVerified(); assert force < ancienneForce; }
	 */

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;

		forceCoup = calculerResistanceEquipement(forceCoup);

		if (forceCoup <= 0) {
			parler("Aïe");
		} else {
			force -= forceCoup;

			if (force <= 0) {
				force = 0;
				equipementEjecte = ejecterEquipement();
				parler("J'abandonne...");
			} else {
				parler("Aïe");
			}
		}

		assert isInvariantVerified();

		return equipementEjecte;
	}

	private int calculerResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + force + ", et la force du coup est de " + forceCoup;

		int resistanceEquipement = 0;

		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				if (equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 8;
				} else {
					resistanceEquipement += 5;
				}
			}
		}

		if (resistanceEquipement > 0) {
			if (forceCoup <= resistanceEquipement) {
				texte += "\nMais heureusement, grâce à mon équipement " + "sa force a été complètement absorbée.";
			} else {
				texte += "\nMais heureusement, grâce à mon équipement " + "sa force a été diminuée de "
						+ resistanceEquipement + " !";
			}
		}

		parler(texte);

		forceCoup -= resistanceEquipement;

		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
	    Equipement[] equipementEjecte = new Equipement[nbEquipement];

	    System.out.println("L'équipement de " + nom
	            + " s'envole sous la force du coup.");

	    int nbEquipementEjecte = 0;

	    for (int i = 0; i < nbEquipement; i++) {
	        if (equipements[i] != null) {
	            equipementEjecte[nbEquipementEjecte] = equipements[i];
	            nbEquipementEjecte++;
	            equipements[i] = null;
	        }
	    }

	    nbEquipement = 0;

	    return equipementEjecte;
	}

	private boolean isInvariantVerified() {
		return force >= 0;
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 0:
			ajouterEquipement(equipement);
			break;

		case 1:
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
			} else {
				ajouterEquipement(equipement);
			}
			break;

		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		}
	}

	private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);

		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}