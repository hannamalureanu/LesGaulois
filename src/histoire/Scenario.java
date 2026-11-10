package histoire;

import personnages.Gaulois;
import personnages.Romain;
import village_gaulois.Musee;
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
		druide.booster(asterix); //commanter ca pour a)
		asterix.parler("Bonjour");
		Romain minus = new Romain("Minus", 6);
		Romain milexcus = new Romain("Milexcus", 8);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		milexcus.sEquiper(Equipement.CASQUE);
		
		/*
		 * //Pour a) asterix.frapper(minus);
		 */
		
		//Pour b)
		minus.parler("UN GAU... UN GAUGAU...");

		int forceAvant;

		do {
		    forceAvant = minus.getForce();
		    asterix.frapper(minus);
		} while (minus.getForce() > 0 && minus.getForce() != forceAvant);
		
		//pour d)
		minus.parler("Alors Asterix on fait moins le malin face à mon équipement, Hi ! Hi !");
		obelix.parler("Asterix, tu veux un peu d'aide ?");
		obelix.frapper(minus);
		
		Musee musee = new Musee();

		obelix.faireUneDonnation(musee);

		System.out.println(musee.extraireInstructionsOCaml());
	}
}