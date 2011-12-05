package aeroport.sgbag.views;

import org.eclipse.swt.widgets.*;
import java.util.*;

public class VueHall extends Canvas implements Viewable {

	private HashMap<Integer, LinkedList<VueElem>> calques;

	public VueHall(Composite parent, int style) {
		super(parent, style);
		calques = new HashMap<Integer, LinkedList<VueElem>>();
	}

	public void ajouterVue(VueElem vue, int layer) {
		LinkedList<VueElem> elementOfLayer;
		if(calques.get(layer) == null) {
			elementOfLayer = new LinkedList<VueElem>();
			calques.put(layer, elementOfLayer);
		} else {
			elementOfLayer = calques.get(layer);
		}
		elementOfLayer.add(vue);
	}

	public void retirerVue(VueElem vue) {
		boolean trouve = false;
		for (Iterator<Integer> iterator = calques.keySet().iterator(); iterator.hasNext() && !trouve;) {
			LinkedList<VueElem> vues = calques.get(iterator.next());
			for (int j = 0; j < vues.size() && !trouve; j++) {
				if(vues.get(j).equals(vue)) {
					vues.remove(j);
					trouve = true;
				}
			}
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isClicked() {
		// TODO Auto-generated method stub
		return false;
	}

}
