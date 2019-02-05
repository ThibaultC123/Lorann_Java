package model.element.motionless;

import model.ISprite;
import model.Permeability;
import model.element.Sprite;

public class VerticalBone extends MotionlessElement {
	  
private static final ISprite SPRITE = new Sprite('|', "vertical_bone.png");

	 
	 VerticalBone() {
	     super(SPRITE, Permeability.BLOCKING);
	 }
}
