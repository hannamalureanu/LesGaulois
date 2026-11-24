package personnages;

import objets.Equipement;
import village_gaulois.Village;
import village_gaulois.Musee;

public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	private Village village;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());

		Equipement[] tropheesBataille = romain.recevoirCoup((force / 2) * effetPotion);

		effetPotion--;

		if (effetPotion < 1) {
			effetPotion = 1;
		}

		if (tropheesBataille != null) {
			for (int i = 0; i < tropheesBataille.length; i++) {
				if (tropheesBataille[i] != null && nbTrophees < trophees.length) {
					trophees[nbTrophees] = tropheesBataille[i];
					nbTrophees++;
				}
			}
		}
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}

	public void sePresenter() {
		StringBuilder sb = new StringBuilder("Bonjour, je m'appelle ").append(nom).append(". ");

		if (village == null) {
			sb.append("Je voyage de villages en villages.");
		} else if (village.getChef() == this) {
			sb.append("Je suis le chef le village : ").append(village.getNom()).append(".");
		} else {
			sb.append("J'habite le village : ").append(village.getNom()).append(".");
		}

		parler(sb.toString());
	}

	public void faireUneDonnation(Musee musee) {
		if (nbTrophees != 0) {

			parler("Je donne au musee tous mes trophees :");

			for (int i = 0; i < nbTrophees; i++) {
				if (trophees[i] != null) {
					System.out.println(new StringBuilder("- ").append(trophees[i].toString().toLowerCase()).toString());
					musee.donnerTrophees(this, trophees[i]);
					trophees[i] = null;
				}
			}

			nbTrophees = 0;
		}
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix);
	}
}
