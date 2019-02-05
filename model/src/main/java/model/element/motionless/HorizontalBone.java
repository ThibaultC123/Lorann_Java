package model.element.motionless;

import model.ISprite;
import model.Permeability;
import model.element.Sprite;

public class HorizontalBone extends MotionlessElement {
	  
private static final ISprite SPRITE = new Sprite('-', "horizontal_bone.png");

	
	 HorizontalBone() {
	     super(SPRITE, Permeability.BLOCKING);
	 }
}
