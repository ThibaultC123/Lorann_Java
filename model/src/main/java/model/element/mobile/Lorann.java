package model.element.mobile;

import java.io.IOException;

import model.ILevel;
import model.ISprite;
import model.Permeability;
import model.element.Sprite;

public class Lorann extends Mobile implements ISprite{

	
    private static final ISprite sprite          = new Sprite('@', "lorann_ul.png");
    private static final ISprite spriteMoveLeft  = new Sprite('@', "lorann_l.png");
    private static final ISprite spriteMoveRight = new Sprite('@', "lorann_r.png");
    private static final ISprite spriteMoveUp  = new Sprite('@', "lorann_u.png");
    private static final ISprite spriteMoveDown = new Sprite('@', "lorann_b.png");
    private static final ISprite spriteMoveDownRight = new Sprite('@', "lorann_br.png");
    private static final ISprite spriteMoveDownLeft = new Sprite('@', "lorann_bl.png");
    private static final ISprite spriteMoveUpRight = new Sprite('@', "lorann_ur.png");
    private static final ISprite spriteMoveUpLeft = new Sprite('@', "lorann_ul.png");
    private static final ISprite spriteDie  = new Sprite('@', "noimage.png");
    private int counter = 1;
	private int delay = 1; // TO CHANGE THE PICTURE AFTER DELAY !
	
	/**
	 * The Lorann Constructor !
	 * @param x
	 * @param y
	 * @param level
	 * @throws IOException
	 */
	
	
	 public Lorann(final int x, final int y, final ILevel level) throws IOException {
	        super(x, y, sprite, level, Permeability.BLOCKING);
	        sprite.loadImage();
	        spriteMoveLeft.loadImage();
	        spriteMoveRight.loadImage();
	        spriteMoveUp.loadImage();
	        spriteMoveDown.loadImage();
	        spriteDie.loadImage();
	        spriteMoveDownRight.loadImage();
	        spriteMoveDownLeft.loadImage();
	        spriteMoveUpRight.loadImage();
	        spriteMoveUpLeft.loadImage();
	    }
	    
	 

	    @Override
	    public final void moveLeft() {
	        super.moveLeft();
	        this.setSprite(spriteMoveLeft);
	    }

	   
	    @Override
	    public final void moveRight() {
	        super.moveRight();
	        this.setSprite(spriteMoveRight);
	    }
	    
	    
	    @Override
	    public final void moveUp() {
	        super.moveUp();
	        this.setSprite(spriteMoveUp);
	    }

	    
	    @Override
	    public final void moveDown() {
	        super.moveDown();
	        this.setSprite(spriteMoveDown);
	    }
	    
	    @Override
	    public final void moveDownRight() {
	        super.moveDownRight();
	        this.setSprite(spriteMoveDownRight);
	    }
	    
	    @Override
	    public final void moveDownLeft() {
	        super.moveDownLeft();
	        this.setSprite(spriteMoveDownLeft);
	    }
	    
	    @Override
	    public final void moveUpRight() {
	        super.moveUpRight();
	        this.setSprite(spriteMoveUpRight);
	    }
	    
	    @Override
	    public final void moveUpLeft() {
	        super.moveUpLeft();
	        this.setSprite(spriteMoveUpLeft);
	    }

	    
	    @Override
		public final void die() {
	        super.die();
	        this.setSprite(spriteDie);
	    }
	    
	    
	    /**
	     * 
	     * THIS PART WILL MAKE LORANN CHANGE HIS FACE WHEN THE USER IS INACTIVE !
	     */
	    
	    
	    @Override
	    public final void nothing() {
	    	super.nothing();
	    	if(delay == 6) {
	    		delay=0;
		    	switch ( getCounter() ) { 
				case 1:
					this.setSprite(spriteMoveLeft); 
					setCounter(2);
					break;
				case 2:
					this.setSprite(spriteMoveUp); 
					setCounter(3);
		    		break;
				case 3:
					this.setSprite(spriteMoveRight); 
					setCounter(4);
					break;
				case 4:
					this.setSprite(spriteMoveDown); 
					setCounter(1);
		    		break;
		    	}
	    	}
		    	else{
		    		delay++;
		        }
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

		public int getCounter() {
			return counter;
		}

		public void setCounter(int counter) {
			this.counter = counter;
		}
		
	    


	    
	
}


// COMPRENDRE LA CLASSE

// LORANN MEURT LORSQUE SA POSITION EST SUR CELLE D'UN MONSTRE, LORANN EST EFACEE ET LA CONDITION EST REMPLIE !