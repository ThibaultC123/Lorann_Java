package model;

import java.awt.Point;

import showboard.IPawn;

public interface IMobile extends IPawn, IElement{


    void moveUp();

   
    void moveLeft();

   
    void moveDown();

    
    void moveRight();

    
	void moveUpLeft();
	
	 
	void moveDownLeft();
	
	 
	void moveUpRight();
	
	
	void moveDownRight();
	
	
	void nothing();
	
    @Override
    int getX();

    
    @Override
    int getY();

   
    Boolean isAlive();
    
   
	void die();
    
    
	void alive();
    
    Boolean isCrashed();
	Boolean isKilled();
	Boolean isOnCrystal();
	Boolean isOnOpenGate();
	Boolean isOnPurse();

   @Override
    Point getPosition();


}
