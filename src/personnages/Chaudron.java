package personnages;

public class Chaudron {

	private int quantitePotion=0;
	private int forcePotion=0;

	public void remplirChaudron(int quantite, int forcePotion) {
		this.quantitePotion = quantite;
		this.forcePotion = forcePotion;
	}

	public boolean resterPotion() {
		return quantitePotion > 0;
	}

	public int prendreLouche() {
		int potion = forcePotion;
		quantitePotion--;

		return potion;
	}
}