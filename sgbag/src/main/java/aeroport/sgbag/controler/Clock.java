package aeroport.sgbag.controler;

import org.eclipse.swt.SWTException;

import lombok.*;
import aeroport.sgbag.kernel.Hall;
import aeroport.sgbag.views.VueHall;

@AllArgsConstructor
public class Clock implements Runnable {

	@Getter
	@Setter
	private int interval;

	@Getter
	@Setter
	private Hall hall;

	@Getter
	@Setter
	private VueHall vueHall;

	private boolean isPaused = true;

	public void init() {
		vueHall.getDisplay().timerExec(interval, this);
	}

	public void run() {
		try {
			if(hall != null && !isPaused){
				hall.update();
			}		
			vueHall.updateView();
			vueHall.draw();

			vueHall.getDisplay().timerExec(interval, this);
		} catch(SWTException e) {
			// Exception lancé à la sortie de l'application
			// Elle n'est pas importante, elle est donc juste catchée
		}
	}

	public void pause() {
		isPaused = true;
	}
	public void unpause() {
		isPaused = false;
		
	}

}
