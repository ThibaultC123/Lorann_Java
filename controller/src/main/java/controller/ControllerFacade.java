package controller;

import java.io.IOException;

// import java.util.ArrayList;
import model.IElement;
import model.IMobile;

import model.IModelFacade;
import model.Permeability;
import model.element.mobile.Energy;
import view.IViewFacade;


/*
 * Ce ControllerFacade va tout simplement instancier Lorann et les elements ainsi que les mouvements et l'animation monstres/energies.
 * 
 * 
 */
public class ControllerFacade implements IControllerFacade, IOrderPerformer {

    
    private static final int speed = 50;

  
    
    private IViewFacade view;

 
    private IModelFacade model;

   
    private UserOrder stackOrder;
    
    
    private IMobile monster1;
    
   
    private IMobile monster2;

	
    private IMobile monster3;
    
    
    private IMobile monster4;
    
    
  //  private ArrayList monsters;
    
    
	private int monsterDelay = 1;
    
   
    private IMobile lorann;
    
   
    private IElement gate;
    
    
    private IElement crystal;
    
  //  private IElement Purse;
   
    public IMobile power;
    
  
    private UserOrder lastLorannOrder;
    
   
    private UserOrder powerOrder;
    
   
    private boolean ammo = true;
    
    private int powerDelay = 5;

   
    private boolean win;
	
	
	private int mobSpeed = 15;
	
	
    private int powerSpeed = 5;

	
  
	public ControllerFacade(final IViewFacade view, final IModelFacade model) {
		this.setView(view);
	    this.setModel(model);
	    this.clearForStart(); 
	}


	@Override
	public void play() throws InterruptedException, IOException {
		
		
		
		
		/**
		 * 
		 * 
		 * PARTIE TRES IMPORTANTE ! 
		 * 
		 * 
		 * 
		 */
		
		
		lorann = getModel().getLevel().getLorann();
		lorann.alive();
		
		
		gate = getModel().getLevel().getGate();
		crystal = getModel().getLevel().getCrystal();
		
		
		if(getModel().getLevel().getMonster1instance() != false) { 
			monster1 = getModel().getLevel().getMonster1();
			monster1.alive();
			monster1.nothing();
			}
        if(getModel().getLevel().getMonster2instance() != false) {
        	monster2 = getModel().getLevel().getMonster2();
        	monster2.alive();
        	monster2.nothing();
        	}
        if(getModel().getLevel().getMonster3instance() != false) {
        	monster3 = getModel().getLevel().getMonster3();
        	monster3.alive();
        	monster3.nothing();
        	}
        if(getModel().getLevel().getMonster4instance() != false) {
        	monster4 = getModel().getLevel().getMonster4();
        	monster4.alive();
        	monster4.nothing();
        	}
        
       
        
        
      
        if(getModel().getLevel().getCrystal() == null) {
        	getModel().getLevel().getGate().setPermeability(Permeability.OPENGATE);
        	getView().OpenGateUpdate();
        	}
		
     
        
        
        /**
         * 
         * 
         * BOUCLE DU JEU !
         */
		while (lorann.isAlive() && win == false) { 
            
			Thread.sleep(speed); 
			
			
			if(lorann.isOnCrystal()) {
				
				gate.setPermeability(Permeability.OPENGATE);
	        	crystal.setPermeability(Permeability.PENETRABLE);
				getView().OpenGateUpdate();
			}
			
		
			/**if (lorann.isOnPurse()) {
			//  Purse.setPermeability(Permeability.PENETRABLE);
			 // Purse.die();
			 
			  
			  score+=1;
			
				
			} */
			if(lorann.isOnOpenGate()) win = true;
			
			
			if(lorann.isKilled()) lorann.die();
			
			
			switch (this.gerOrderFromUser()) { 
                case RIGHT:
                    this.lorann.moveRight();
                    lastLorannOrder=UserOrder.RIGHT;
                    break;
                case LEFT:
                    this.lorann.moveLeft();
                    lastLorannOrder=UserOrder.LEFT;
                    break;
                case UP:
                    this.lorann.moveUp();
                    lastLorannOrder=UserOrder.UP;
                    break;
                case DOWN:
                    this.lorann.moveDown();
                    lastLorannOrder=UserOrder.DOWN;
                    break;
                case DOWNRIGHT:
                    this.lorann.moveDownRight();
                    lastLorannOrder=UserOrder.DOWNRIGHT;
                    break;
                case UPRIGHT:
                    this.lorann.moveUpRight();
                    lastLorannOrder=UserOrder.UPRIGHT;
                    break;
                case DOWNLEFT:
                    this.lorann.moveDownLeft();
                    lastLorannOrder=UserOrder.DOWNLEFT;
                    break;
                case UPLEFT:
                    this.lorann.moveUpLeft();
                    lastLorannOrder=UserOrder.UPLEFT;
                    break;
                case SHOOT:
                	if(ammo) {power = new Energy(lorann.getX(), lorann.getY(), getModel().getLevel());
                	getView().PowerSpawn(power);
                	powerOrder=lastLorannOrder;
                	ammo = false;
                	}
                case NOTHING:
                default:
                	this.lorann.nothing();
                	break;
			}
			
			if(power!=null)PowerMechanism();
			

			if(monster1!=null && monster1.isAlive()) MonsterIA(monster1);
			if(monster2!=null && monster2.isAlive()) MonsterIA(monster2);
			if(monster3!=null && monster3.isAlive()) MonsterIA(monster3);
			if(monster4!=null && monster4.isAlive()) MonsterIA(monster4);

            
            this.clearForStart(); 
        }
		if (win != true) {
		lorann.die();
		
        this.getView().displayMessage("You loose"); 	
        
		}
		else {
		// faire le changement de niveau ici, menu
		this.getView().displayMessage("You win");
	//	this.getView().displayMessage("Your score is "+ score);
	//	score = 0;
		this.getView().displayMessage("Next Level ?");
		
		}
	}
	
	/**
	 * This function is a kind of IA for monster to go on Lorann
	 */
	private void MonsterIA(IMobile monster) {
	
		if(monsterDelay == mobSpeed) { 
    		monsterDelay=0;
    		
			if(lorann.getX() > monster.getX()) {
	            monster.moveRight();
			}
			if(lorann.getX() < monster.getX()) {
	            monster.moveLeft();
			}
			if(lorann.getY() < monster.getY()) {
	            monster.moveUp();
			}
			if(lorann.getY() > monster.getY()) {
	            monster.moveDown();
			}
    		
	   	}
	
	  else monsterDelay++;
	   	
	
		MobKillChecker(monster); // WILL CHECK IF A MONSTER KILLED LORANN

		if(power!=null)PowerKillChecker(monster);
	}

	public void MobKillChecker(IMobile monster) {
		if(lorann.getX()==monster.getX() && lorann.getY()==monster.getY()) {lorann.die();}
	}
	
	public void PowerMechanism() {
		
		if(powerDelay == powerSpeed) { 
			powerDelay=0;
			switch (this.powerOrder) {
	        case LEFT:
	            this.power.moveRight();
	            break;
	        case RIGHT:
	            this.power.moveLeft();
	            break;
	        case DOWN:
	            this.power.moveUp();
	            break;
	        case UP:
	            this.power.moveDown();
	            break;
			default:
				break;
			}
		}
	   	
	   	else powerDelay++;
	   	
		
		if(lorann.getX()==power.getX() && lorann.getY()==power.getY()) {
			power.die();
			ammo = true;
			power = null;
			powerDelay = 5;
		}
	}
	
	
	
	public void PowerKillChecker(IMobile monster) {
		
		if(power.getX()==monster.getX() && power.getY()==monster.getY()) {
			monster.die();
			monster=null;
			power.die();
			ammo = true;
			power = null;
			powerDelay = 5;
	}}
	
    
	@Override
	public void orderPerform(UserOrder userOrder) throws IOException {
		this.setStackOrder(userOrder);
	}
	
    /**
     * Gets the view.
     *
     * @return the view
     */
    IViewFacade getView() {
        return this.view;
    }
    
    /**
     * Sets the view.
     *
     * @param view
     *            the view to set
     */
    private void setView(final IViewFacade view) {
        this.view = view;
    }
    
    /**
     * Gets the model.
     *
     * @return the model
     */
    private IModelFacade getModel() {
        return this.model;
    }
    
    /**
     * Sets the model.
     *
     * @param model
     *            the model to set
     */
    private void setModel(final IModelFacade model) {
        this.model = model;
    }
    
    /**
     * Gets the stack order.
     *
     * @return the stack order
     */
    private UserOrder gerOrderFromUser() {
        return this.stackOrder;
    }

    /**
     * Sets the stack order.
     *
     * @param stackOrder
     *            the new stack order
     */
    private void setStackOrder(final UserOrder stackOrder) {
        this.stackOrder = stackOrder;
    }

    /**
     * Clear stack order.
     */
    private void clearForStart() {
        this.stackOrder = UserOrder.NOTHING;
    }

   /**
    * Get the order to perform
    */
    @Override
    public IOrderPerformer getOrderPeformer() {
        return this;
    }

}