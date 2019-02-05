package model;

import java.awt.Image;

import showboard.ISquare;

public interface IElement extends ISquare {
	
	  ISprite getSprite();
	  Permeability getPermeability();
	  Image getImage();
	  void setPermeability(Permeability permeability);
	  void die();
	  
	  
}
