/**
 * 
 */
package aeroport.sgbag.views;

import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Transform;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import aeroport.sgbag.kernel.Bagage;

/**
 * @author Arnaud Lahache
 *
 */
@NoArgsConstructor
public class VueBagage extends VueElem {

	@Getter
	@Setter
	private Bagage bagage;
	
	public VueBagage(VueHall parent) {
		super(parent);
		this.image = new Image(parent.getDisplay(), "data/img/bagage.png");
		
		Rectangle rect = image.getBounds();
		this.width = rect.width;
		this.height = rect.height;
	}
	
	/**
	 * @see aeroport.sgbag.views.VueElem#updateView()
	 */
	@Override
	public void updateView() {
		// TODO implémentation méthode update

	}

	/**
	 * @see aeroport.sgbag.views.VueElem#draw()
	 */
	@Override
	public void draw() {
		GC gc = this.parent.getGcBuffer();

		// We get the size of the original image :
		Rectangle rect = image.getBounds();

		// We create a transform in order to rotate and translate the image :
		Transform trImage = new Transform(parent.getDisplay());
		trImage.translate(this.x, this.y);
		trImage.rotate(this.angle);
		gc.setTransform(trImage);

		// Then we just draw the image on the GC :
		gc.drawImage(this.image, 0, 0, rect.width, rect.height, -this.width / 2,
				-this.height / 2, this.width, this.height);

		// We no longer need the transform :
		gc.setTransform(null);
		trImage.dispose();
	}

}
