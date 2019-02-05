package model.element.mobile;

import java.io.IOException;

import model.ILevel;
import model.ISprite;
import model.Permeability;
import model.element.Sprite;

public class Energy extends Mobile implements ISprite {
	
	  private static final ISprite sprite1  = new Sprite('!', "fireball_1.png");
	    private static final ISprite sprite2  = new Sprite('!', "fireball_2.png");
	    private static final ISprite sprite3  = new Sprite('!', "fireball_3.png");
	    private static final ISprite sprite4  = new Sprite('!', "fireball_4.png");
	    private static final ISprite sprite5  = new Sprite('!', "fireball_5.png");
	    private static final ISprite nosprite  = new Sprite('!', "noimage.png");
		// private int delay = 1;
		private int counter = 1;
	    
	    public int getCounter() {
			return counter;
		}

		public void setCounter(int counter) {
			this.counter = counter;
		}
		
		  public Energy(final int x, final int y, final ILevel level) throws IOException {
		        super(x, y, sprite1, level, Permeability.POWER);
		        sprite1.loadImage();
		        sprite2.loadImage();
		        sprite3.loadImage();
		        sprite4.loadImage();
		        sprite5.loadImage();
		        nosprite.loadImage();
		    }
		    
		  private void SpriteChanger() {
		    	switch ( getCounter() ) { //this switch is used to change the player picture when he didn't move
				case 1:
					this.setSprite(sprite1); //first picture load, next time we do the while the second will be load
					setCounter(2);
					break;
				case 2:
					this.setSprite(sprite2); //third picture load, next time we do the while the fourth will be load
					setCounter(3);
		    		break;
				case 3:
					this.setSprite(sprite3); //first picture load, next time we do the while the second will be load
					setCounter(4);
					break;
				case 4:
					this.setSprite(sprite4); //third picture load, next time we do the while the fourth will be load
					setCounter(5);
		    		break;
				case 5:
					this.setSprite(sprite5); //third picture load, next time we do the while the fourth will be load
					setCounter(1);
		    		break;
		    	}
	  	
	    }
		  
		  /*
		     * (non-Javadoc)
		     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveLeft()
		     */
		    @Override
		    public final void moveLeft() {
		        this.SpriteChanger();
		        super.moveLeft();
		    }

		    /*
		     * (non-Javadoc)
		     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveRight()
		     */
		    @Override
		    public final void moveRight() {
		        this.SpriteChanger();
		    	super.moveRight();
		    }
		    
		    /*
		     * (non-Javadoc)
		     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveLeft()
		     */
		    @Override
		    public final void moveUp() {
		        this.SpriteChanger();
		        super.moveUp();
		    }

		    /*
		     * (non-Javadoc)
		     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveRight()
		     */
		    @Override
		    public final void moveDown() {
		        this.SpriteChanger();
		    	super.moveDown();
		    }
		    
		    @Override
		    public final void moveDownRight() {
		    }
		    
		    @Override
		    public final void moveDownLeft() {
		    }
		    
		    @Override
		    public final void moveUpRight() {
		    }
		    
		    @Override
		    public final void moveUpLeft() {
		    }

		    /*
		     * (non-Javadoc)
		     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#die()
		     */
		    @Override
			public final void die() {
		        super.die();
		        this.setSprite(nosprite);
		    }

		    /*
		     * (non-Javadoc)
		     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#doNothing()
		     */
		    @Override
		    public final void nothing() {
		    	this.SpriteChanger();
		    	super.nothing();

		    }

			@Override
			public void loadImage() throws IOException {
				// TODO Auto-generated method stub
				
			}

			@Override
			public char getConsoleImage() {
				// TODO Auto-generated method stub
				return 0;
			}
			
		


}
