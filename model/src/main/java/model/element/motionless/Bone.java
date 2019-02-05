package model.element.motionless;

import model.ISprite;
import model.Permeability;
import model.element.Sprite;

public class Bone extends MotionlessElement {
	   
private static final ISprite SPRITE = new Sprite('O', "bone.png");

	 
	 Bone() {
	     super(SPRITE, Permeability.BLOCKING);
	 }
}

