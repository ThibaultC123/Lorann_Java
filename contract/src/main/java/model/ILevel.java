package model;

import java.util.Observable;

public interface ILevel {
	int getWidth();
	int getHeight();
	
	void setMobileHasChanged();
	Observable getObservable();
	
	boolean getMonster4instance();
	boolean getMonster1instance();
	boolean getMonster2instance();
	boolean getMonster3instance();
	
    IElement getOnTheLevelXY(int x, int y); // SET WHERE TO PUT THE SPRITES.
    
    
    /**
     * 
     *   THIS PART INSTANTIATE THE MONSTERS
     *  
     *  
     *  */
    IMobile getLorann(); 
    IMobile getMonster1();
    IMobile getMonster2();
	IMobile getMonster3();
	IMobile getMonster4();
	
	
	/**
	 * THIS PART INSTANTIATE THE SPRITES THAT NEED TO BE UPDATED DURING THE LEVEL
	 * @return
	 */
	
	IElement getGate();
	IElement getCrystal();
	
	
}
