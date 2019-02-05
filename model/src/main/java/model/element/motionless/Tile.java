package model.element.motionless;

import model.ISprite;
import model.Permeability;
import model.element.Sprite;

public class Tile extends MotionlessElement {
	  
 private static final ISprite SPRITE = new Sprite(' ', "BlackTile.jpg");


 Tile() {
     super(SPRITE, Permeability.PENETRABLE);
 }
}
