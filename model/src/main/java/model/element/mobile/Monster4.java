package model.element.mobile;

import java.io.IOException;

import model.ILevel;
import model.ISprite;
import model.Permeability;
import model.element.Sprite;

public class Monster4 extends Mobile implements ISprite{
	
	/** The Constant SPRITE. */
    private static final ISprite sprite          = new Sprite('@', "monster_4.png");

    /** The Constant spriteDie. */
    private static final ISprite spriteDie  = new Sprite('@', "noimage.png");
    
    /**
     * Instantiates a new Monster4.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param level
     *            the level
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public Monster4(final int x, final int y, final ILevel level) throws IOException {
        super(x, y, sprite, level, Permeability.KILLING);
        sprite.loadImage();
        spriteDie.loadImage();
    }

   
    @Override
    public final void moveLeft() {
        super.moveLeft();
        this.setSprite(sprite);
    }

    
    @Override
    public final void moveRight() {
        super.moveRight();
        this.setSprite(sprite);
    }
    
    
    @Override
    public final void moveUp() {
        super.moveUp();
        this.setSprite(sprite);
    }

   
    @Override
    public final void moveDown() {
        super.moveDown();
        this.setSprite(sprite);
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

   
    @Override
	public final void die() {
        super.die();
        this.setSprite(spriteDie);
    }

   
    @Override
    public final void nothing() {
    	super.nothing();
		this.setSprite(sprite);
		

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
