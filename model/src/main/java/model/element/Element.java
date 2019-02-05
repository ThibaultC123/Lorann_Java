package model.element;

import java.awt.Image;

import model.IElement;
import model.ISprite;
import model.Permeability;

public class Element implements IElement {

	
	 private ISprite       sprite;
	 private Permeability permeability;
	 
	 public Element(final ISprite sprite, final Permeability permeability) {
	        this.setSprite(sprite);
	        this.setPermeability(permeability);
	    }
	 
	 protected final void setSprite(final ISprite sprite2) {
	        this.sprite = sprite2;
	    }
	 
	 @Override
	    public final ISprite getSprite() {
	        return this.sprite;
	    }
	 
	 @Override
	    public final Permeability getPermeability() {
	        return this.permeability;
	    }
	 
	  public void setPermeability(final Permeability permeability) {
	        this.permeability = permeability;
	    }
	  
	  @Override
	    public final Image getImage() {
	        return this.getSprite().getImage();
	    }

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

	

	
	  
}
