package histoire;

import personnages.Gaulois;
import personnages.Romain;
import personnages.Druide;
import objets.Equipement;

//import village_gaulois.Musee;

public class Scenario {

	public static void main(String[] args) {
		Druide druide = new Druide("Panoramix", 5);
		druide.parler("Je vais aller préparer une petite potion...");
		druide.fabriquerPotion(5, 3);
		Gaulois obelix = new Gaulois("Obélix", 25);
		Gaulois asterix = new Gaulois("Astérix", 8);
		druide.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		druide.booster(asterix);
		asterix.parler("Bonjour");
		Romain minus = new Romain("Minus", 6);
		Romain milexcus = new Romain("Milexcus", 8);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		milexcus.sEquiper(Equipement.CASQUE);

		// PARTIE 4 - a

		/*
		 * minus.parler("UN GAU... UN GAUGAU...");
		 * 
		 * asterix.frapper(minus); asterix.frapper(minus); asterix.frapper(minus);
		 */

		// PARTIE 4 - b

		/*
		 * minus.parler("UN GAU... UN GAUGAU...");
		 * 
		 * int forceAvant;
		 * 
		 * do { forceAvant = minus.getForce(); asterix.frapper(minus);
		 * 
		 * } while (minus.getForce() > 0 && minus.getForce() != forceAvant);
		 */

		// PARTIE 4 - c

		/*
		 * minus.parler("UN GAU... UN GAUGAU...");
		 * 
		 * asterix.frapper(minus);
		 */

		// PARTIE 4 - d
		
		/*
		 * minus.parler("UN GAU... UN GAUGAU...");
		 * 
		 * asterix.frapper(minus);
		 * 
		 * minus.parler(
		 * "Alors Asterix on fait moins le malin face à mon équipement, Hi ! Hi !" );
		 * 
		 * obelix.parler("Asterix, tu veux un peu d'aide ?");
		 * 
		 * obelix.frapper(minus);
		 */

		// PARTIE 4 - e

		/*
		 * minus.parler("UN GAU... UN GAUGAU...");
		 * 
		 * asterix.frapper(minus); asterix.frapper(minus);
		 * 
		 * minus.parler(
		 * "Alors Asterix on fait moins le malin face à mon équipement, Hi ! Hi !" );
		 * 
		 * obelix.parler("Asterix, tu veux un peu d'aide ?");
		 * 
		 * obelix.frapper(minus);
		 */

		// PARTIE 5 - Musée

		/*
		 * milexcus.parler("UN GAU... UN GAUGAU...");
		 * 
		 * do { obelix.frapper(milexcus);
		 * 
		 * } while (milexcus.getForce() > 0);
		 * 
		 * Musee musee = new Musee();
		 * 
		 * obelix.faireUneDonnation(musee);
		 * 
		 * // ========================================== // PARTIE 6 - Export OCaml //
		 * ==========================================
		 * 
		 * System.out.println(musee.extraireInstructionsOCaml());
		 */

	}

}