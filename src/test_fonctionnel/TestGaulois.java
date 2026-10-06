package test_fonctionnel;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class TestGaulois {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gaulois asterix = new Gaulois("Asterix", 8);
		Gaulois obelix = new Gaulois("Obelix", 16);

		asterix.parler("Bonjour Obelix.");
		obelix.parler("Bonjour Asterix. Ca te dirais d'aller chasser des sangliers ?");
		asterix.parler("Oui tres bonne idee");

		Romain minus = new Romain("Minus", 6);

		System.out.println(
				"Dans la foret " + asterix + " et " + obelix + " tombent nez a nez sur le romain " + minus.getNom());

		for (int i = 0; i < 3; i++) {
			asterix.frapper(minus);
		}

		Romain brutus = new Romain("Brutus", 14);
		Druide panoramix = new Druide("Panoramix", 2);
		panoramix.fabriquerPotion(4, 3);
		panoramix.booster(obelix);
		panoramix.booster(asterix);
		for (int i = 0; i < 3; i++) {
			asterix.frapper(brutus);
		}
	}

}
