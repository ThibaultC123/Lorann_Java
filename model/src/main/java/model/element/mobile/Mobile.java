package model.element.mobile;

import java.awt.Point;

import model.ILevel;
import model.IMobile;
import model.ISprite;
import model.Permeability;
import model.element.Element;
import showboard.IBoard;

public abstract class Mobile extends Element implements IMobile{

	private Point   position;
	protected Boolean alive;
	private ILevel  level;
	private IBoard  board;

	Mobile(final ISprite sprite, final ILevel level, final Permeability permeability) {
        super(sprite, permeability);
        this.setLevel(level);
        this.position = new Point();
    }
	
	Mobile(final int x, final int y, final ISprite sprite, final ILevel level, final Permeability permeability) {
        this(sprite, level, permeability);
        this.setX(x);
        this.setY(y);
    }
	
	@Override
    public void moveUp() {
        this.setY(this.getY() - 1);
       
      
        if (this.isCrashed()) {
            this.setY(this.getY() + 1);
        }
        this.setHasMoved();
    }

    @Override
    public void moveLeft() {
        this.setX(this.getX() - 1);
       
      
        if (this.isCrashed()) {
            this.setX(this.getX() + 1);
        }
        this.setHasMoved();
    }

    @Override
    public void moveDown() {
        this.setY(this.getY() + 1);
        
        if (this.isCrashed()) {
            this.setY(this.getY() - 1);
        }
        this.setHasMoved();
    }

    @Override
    public void moveRight() {
        this.setX(this.getX() + 1);
       
        if (this.isCrashed()) {
            this.setX(this.getX() - 1);
        }
        this.setHasMoved();
    }
    
    @Override
    public void moveDownRight() {
        this.setX(this.getX() + 1);
        this.setY(this.getY() + 1);
        if (this.isCrashed()) {
            this.setX(this.getX() - 1);
            this.setY(this.getY() - 1);
        }
        this.setHasMoved();
    }
    
    @Override
    public void moveDownLeft() {
        this.setX(this.getX() - 1);
        this.setY(this.getY() + 1);
        if (this.isCrashed()) {
            this.setX(this.getX() + 1);
            this.setY(this.getY() - 1);
        }
        this.setHasMoved();
    }
    
    @Override
    public void moveUpRight() {
        this.setX(this.getX() + 1);
        this.setY(this.getY() - 1);
        if (this.isCrashed()) {
            this.setX(this.getX() - 1);
            this.setY(this.getY() + 1);
        }
        this.setHasMoved();
    }
    
    @Override
    public void moveUpLeft() {
        this.setX(this.getX() - 1);
        this.setY(this.getY() - 1);
        if (this.isCrashed()) {
            this.setX(this.getX() + 1);
            this.setY(this.getY() + 1);
        }
        this.setHasMoved();
    }

    @Override
    public void nothing() {
        this.setHasMoved();
    }
	
   
    protected void setHasMoved() {
        this.getLevel().setMobileHasChanged();
    }

    /**
     * Getter for Mobile position X
     */
    @Override
    public final int getX() {
        return this.getPosition().x;
    }

    /**
     * Setter for Mobile position X
     * 
     * @param x
     * 	the x position
     */
    public final void setX(final int x) {
        this.getPosition().x = x;
    }

    /**
     * Getter for Mobile position Y
     */
    @Override
    public final int getY() {
        return this.getPosition().y;
    }

    /**
     * Setter for Mobile position Y
     * 
     * @param y
     * 		the y position
     */
    public final void setY(final int y) {
        this.getPosition().y = y;
    }

    /**
     * Gets the level.
     *
     * @return the level
     */
    public ILevel getLevel() {
        return this.level;
    }

    /**
     * Sets the level.
     *
     * @param level
     *            the new level
     */
    private void setLevel(final ILevel level) {
        this.level = level;
    }

    /**
     * Return the state of mobile element
     */
    @Override
    public Boolean isAlive() {
        return this.alive;
    }

    /**
     * Alive.
     */
    public void alive() {
    	this.alive = true;
    }
    /**
     * Dies.
     */
    public void die() {
        this.alive = false;
        this.setHasMoved();
    }

    /**
     * get if mobile element his in a collision
     */
    @Override
    public Boolean isCrashed() {
        return this.getLevel().getOnTheLevelXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING;
    }
    
    /**
     * get if mobile element his killed
     */
    @Override
    public Boolean isKilled() {
        return this.getLevel().getOnTheLevelXY(this.getX(), this.getY()).getPermeability() == Permeability.KILLING;
    }
    
    /**
     * get if mobile element his in a crystal
     */    
    @Override
    public Boolean isOnCrystal() {
        return this.getLevel().getOnTheLevelXY(this.getX(), this.getY()).getPermeability() == Permeability.OPENNING;
    }
    
    /**
     * get if mobile element his on a gate
     */
    @Override
    public Boolean isOnOpenGate() {
        return this.getLevel().getOnTheLevelXY(this.getX(), this.getY()).getPermeability() == Permeability.OPENGATE;
    }
    
    public Boolean isOnPurse() {
    
    	return this.getLevel().getOnTheLevelXY(this.getX(), this.getY()).getPermeability() == Permeability.PENETRABLE;
    }

    /**
     * Get the position
     */
    @Override
    public Point getPosition() {
        return this.position;
    }

    /**
     * Sets the position.
     *
     * @param position
     *            the position to set
     */
    public void setPosition(final Point position) {
        this.position = position;
    }

    /**
     * Gets the board.
     *
     * @return the board
     */
    protected IBoard getBoard() {
        return this.board;
    }

}

    
    
    
// BIEN COMPRENDRE CETTE PARTIE !!!