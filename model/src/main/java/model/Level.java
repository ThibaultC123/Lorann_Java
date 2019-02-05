package model;

import java.io.IOException;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;

import model.dao.ProceduresWithDAO;
import model.element.mobile.Lorann;
import model.element.mobile.Monster1;
import model.element.mobile.Monster2;
import model.element.mobile.Monster3;
import model.element.mobile.Monster4;
import model.element.motionless.MotionlesElementFactory;



public class Level extends Observable implements ILevel{
	 public static int          width = 28;
	 public static int 		 height= 12;
	 
	 private IElement[][] onTheLevel;
	 private IMobile lorann;
	 
	 private IMobile monster1;
	 private boolean monster1instance;
	 private IMobile monster2;
	 private boolean monster2instance;
	 private IMobile monster3;
	 private boolean monster3instance;
	 private IMobile monster4;
	 private boolean monster4instance;
	
	 
	 private IElement gate;
	 private IElement crystal;
	 
	 public Level(final int idlevel) throws IOException, SQLException {       
	    	super();
	        this.loadLevel(idlevel);
	    }
	 
	 
	 private void loadLevel(final int idlevel) throws IOException, SQLException {

	        this.onTheLevel = new IElement[this.getWidth()][this.getHeight()]; 
	        
	    	for (int n=0; n<height; n++) 
	    	{
	    		for (int i=0; i < width;i++)
	    		{
	    			this.setOnTheLevelXY(MotionlesElementFactory.getFromFileSymbol(' '), i, n);
	    		}
	    	}
	    	
	    	
	    	 ResultSet result = ProceduresWithDAO.getLevelCompById(idlevel); //
	     	
	         while(result.next()) { 
	         	
	         	switch (result.getString(ProceduresWithDAO.getColumnSprite()).charAt(0)) {
	         	
	         	case '@':
	         		setLorann(new Lorann(result.getInt(ProceduresWithDAO.getColumnX()), result.getInt(ProceduresWithDAO.getColumnY()), this));
	         		break;
	         	case '1':
	             	setMonster1(new Monster1(result.getInt(ProceduresWithDAO.getColumnX()), result.getInt(ProceduresWithDAO.getColumnY()), this));
	             	setMonster1instance(true);
	             	break;
	         	case '2':
	             	setMonster2(new Monster2(result.getInt(ProceduresWithDAO.getColumnX()), result.getInt(ProceduresWithDAO.getColumnY()), this));
	             	setMonster2instance(true);
	             	break;
	         	case '3':
	             	setMonster3(new Monster3(result.getInt(ProceduresWithDAO.getColumnX()), result.getInt(ProceduresWithDAO.getColumnY()), this));
	             	setMonster3instance(true);
	             	break;
	         	case '4':
	             	setMonster4(new Monster4(result.getInt(ProceduresWithDAO.getColumnX()), result.getInt(ProceduresWithDAO.getColumnY()), this));
	             	setMonster4instance(true);
	             	break;
	         	case 'H':
	         		this.setOnTheLevelXY(MotionlesElementFactory.getFromFileSymbol(
	                 		result.getString(ProceduresWithDAO.getColumnSprite()).charAt(0)),result.getInt(ProceduresWithDAO.getColumnX()),result.getInt(ProceduresWithDAO.getColumnY()));
	         		setGate(this.getOnTheLevelXY(result.getInt(ProceduresWithDAO.getColumnX()),result.getInt(ProceduresWithDAO.getColumnY())));
	             	break; 
	         	case 'X':
	         		this.setOnTheLevelXY(MotionlesElementFactory.getFromFileSymbol(
	                 		result.getString(ProceduresWithDAO.getColumnSprite()).charAt(0)),result.getInt(ProceduresWithDAO.getColumnX()),result.getInt(ProceduresWithDAO.getColumnY()));
	         		setCrystal(this.getOnTheLevelXY(result.getInt(ProceduresWithDAO.getColumnX()),result.getInt(ProceduresWithDAO.getColumnY())));
	             	break;
	             default:
	         	this.setOnTheLevelXY(MotionlesElementFactory.getFromFileSymbol(
	             		result.getString(ProceduresWithDAO.getColumnSprite()).charAt(0)),result.getInt(ProceduresWithDAO.getColumnX()),result.getInt(ProceduresWithDAO.getColumnY()));
	             break;
	             }
	         }
	         result.close();
	     }


	
	 
	  /**
	     * get the width
	     */
	    @Override
	    public final int getWidth() {
	        return this.width;
	    }

	    /**
	     * get the height
	     */
	    @Override
	    public final int getHeight() {
	        return this.height;
	    }

	    /**
	     * get element by XY
	     */
	    @Override
	    public final IElement getOnTheLevelXY(final int x, final int y) {
	        return this.onTheLevel[x][y];
	    }

	    /**
	     * Sets the on the level XY.
	     *
	     * @param element
	     *            the element
	     * @param x
	     *            the x
	     * @param y
	     *            the y
	     */
	    private void setOnTheLevelXY(final IElement element, final int x, final int y) {
	        this.onTheLevel[x][y] = element;
	    }

	    /**
	     * Notify view of change
	     */
	    @Override
	    public final void setMobileHasChanged() { // Implementation of DP observer
	        this.setChanged();
	        this.notifyObservers();
	    }

	    /**
	     * Get the observable
	     */
	    @Override
	    public Observable getObservable() {
	        return this;
	    }

	    
	    /**
	     * All getters and setter for element of the map that need to be update during the game
	     */
		public IMobile getLorann() {
			return lorann;
		}

		public void setLorann(IMobile lorann) {
			this.lorann = lorann;
		}

		public IMobile getMonster1() {
			return monster1;
		}

		public void setMonster1(IMobile monster1) {
			this.monster1 = monster1;
		}
		
	    public IMobile getMonster2() {
			return monster2;
		}

		public void setMonster2(IMobile monster2) {
			this.monster2 = monster2;
		}

		public IMobile getMonster3() {
			return monster3;
		}

		public void setMonster3(IMobile monster3) {
			this.monster3 = monster3;
		}

		public IMobile getMonster4() {
			return monster4;
		}
		
		public void setMonster4(IMobile monster4) {
			this.monster4 = monster4;
		}

		public boolean getMonster1instance() {
			return monster1instance;
		}

		public void setMonster1instance(boolean monster1instance) {
			this.monster1instance = monster1instance;
		}

		public boolean getMonster2instance() {
			return monster2instance;
		}

		public void setMonster2instance(boolean monster2instance) {
			this.monster2instance = monster2instance;
		}

		public boolean getMonster3instance() {
			return monster3instance;
		}

		public void setMonster3instance(boolean monster3instance) {
			this.monster3instance = monster3instance;
		}

		public boolean getMonster4instance() {
			return monster4instance;
		}

		public void setMonster4instance(boolean monster4instance) {
			this.monster4instance = monster4instance;
		}

		public IElement getGate() {
			return gate;
		}

		public void setGate(IElement gate) {
			this.gate = gate;
		}

		public IElement getCrystal() {
			return crystal;
		}

		public void setCrystal(IElement crystal) {
			this.crystal = crystal;
		}
	 
	 
	 
		// CLASSE TERMINEE
		
// METTRE EN PLACE LES ELEMENTS MOTIONLESS ET MOBILE
	 
	 
}






	 



