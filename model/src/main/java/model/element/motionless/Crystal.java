package model.element.motionless;

import model.ISprite;

import model.Permeability;
import model.element.Sprite;

public class Crystal extends MotionlessElement {
	   
private static final ISprite SPRITE = new Sprite('X', "crystal_ball.png");




Crystal() {
  super(SPRITE, Permeability.OPENNING);
}
}

