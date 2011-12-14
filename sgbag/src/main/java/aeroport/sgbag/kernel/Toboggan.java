package aeroport.sgbag.kernel;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public class Toboggan extends FileBagage {
	protected static String kObjName = "Toboggan";

	@Getter
	@Setter
	private int nbTicsBagagesRemains = 10;

	@Getter
	private int remainingNbTics = 10;

	@Getter
	@Setter
	private boolean autoDeleteBagages = true;

	public boolean update() {
		if (autoDeleteBagages && !this.listBagages.isEmpty()) {
			if (remainingNbTics > 0) {
				remainingNbTics--;
			}

			if (remainingNbTics == 0) {
				Bagage b = this.listBagages.get(0);
				this.listBagages.remove(b);
				this.getConnexionCircuit().getParent().getParent().getBagagesList().remove(b);
				remainingNbTics = nbTicsBagagesRemains;
			}
		} else if(autoDeleteBagages) { // Si on a pas de bagages, on remet le tic à 0
			remainingNbTics = nbTicsBagagesRemains;
		}
		return autoDeleteBagages;
	}
}