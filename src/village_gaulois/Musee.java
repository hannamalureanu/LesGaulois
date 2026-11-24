package village_gaulois;

import objets.Equipement;
import objets.Trophee;
import personnages.Gaulois;

public class Musee {

	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee = 0;

	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		if (nbTrophee < trophees.length) {
			trophees[nbTrophee] = new Trophee(gaulois, equipement);
			nbTrophee++;
		}
	}

	public String extraireInstructionsOCaml() {
		StringBuilder sb = new StringBuilder("let musee = [\n");

		for (int i = 0; i < nbTrophee; i++) {
			sb.append("\"").append(trophees[i].donnerNom()).append("\", \"")
					.append(trophees[i].getEquipement().toString().toLowerCase()).append("\"");

			if (i < nbTrophee - 1) {
				sb.append(";");
			}
			sb.append("\n");
		}

		sb.append("]");
		return sb.toString();
	}
}
