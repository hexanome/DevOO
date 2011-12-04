package aeroport.sgbag.kernel;

import java.util.LinkedList;

import lombok.Getter;

public abstract class ElementCircuit {

	@Getter
	private LinkedList<Chariot> listeChariot;

	public abstract Boolean update();

	public Boolean registerChariot(Chariot chariot) {
		int oldSize = listeChariot.size();
		
		listeChariot.addFirst(chariot);
		
		return (listeChariot.size() == oldSize + 1);
	}

	public Boolean unregisterChariot() {
		int oldSize = listeChariot.size();
		
		listeChariot.removeLast();
		
		return (listeChariot.size() == oldSize - 1);
	}

	public Boolean hasChariot() {
		return (listeChariot.size() > 0);
	}

}