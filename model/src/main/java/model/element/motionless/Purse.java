package model.element.motionless;

import model.ISprite;
import model.Permeability;
import model.element.Sprite;

public class Purse extends MotionlessElement {
	   
private static final ISprite SPRITE = new Sprite('$', "purse.png");

	 
	 Purse() {
	     super(SPRITE, Permeability.PENETRABLE);
	 }
}
