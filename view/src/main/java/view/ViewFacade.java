package view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.IOrderPerformer;
import controller.UserOrder;
import model.ILevel;
import model.IMobile;
import showboard.BoardFrame;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */

public class ViewFacade implements IViewFacade, Runnable, KeyListener {

   
    private static final int squareNumberWidth = 24;
    
  
    private static final int squareNumberHeight = 12;
    
   
    private static final int squareSize = 50; 

   
    private Rectangle        closeView;

    
    private ILevel           level;

  
    private IOrderPerformer  orderPerformer;

    BoardFrame boardFrame;
    
    Image Door;
    ImageIcon iDoor;
    
    
   
    public ViewFacade(final ILevel level) throws IOException {
        this.setLevel(level); 
       
        this.setCloseView(new Rectangle(0, 0, squareNumberWidth, squareNumberHeight));
        
        SwingUtilities.invokeLater(this);
    }

   /**
    * Display a message in a popup
    */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

  
	@Override
    public final void run() {
        boardFrame = new BoardFrame("Game");
        boardFrame.setDimension(new Dimension(squareNumberWidth, squareNumberHeight)); 
        boardFrame.setDisplayFrame(this.getCloseView()); 
        boardFrame.setSize(squareNumberWidth * squareSize, squareNumberHeight * squareSize); 
        boardFrame.addKeyListener(this); 

        for (int x = 0; x < squareNumberWidth; x++) { 
            for (int y = 0; y < squareNumberHeight; y++) {
                boardFrame.addSquare(this.level.getOnTheLevelXY(x, y), x, y);
            }
        }

        if(getLevel().getMonster1instance() != false) {boardFrame.addPawn(getLevel().getMonster1());} 
        if(getLevel().getMonster2instance() != false) {boardFrame.addPawn(getLevel().getMonster2());}
        if(getLevel().getMonster3instance() != false) {boardFrame.addPawn(getLevel().getMonster3());}
        if(getLevel().getMonster4instance() != false) {boardFrame.addPawn(getLevel().getMonster4());}
        boardFrame.addPawn(getLevel().getLorann()); 
        
        this.getLevel().getObservable().addObserver(boardFrame.getObserver());
        boardFrame.setVisible(true); 
    }
	
	
	public void OpenGateUpdate() {
		try {
			getLevel().getGate().getImage().getGraphics().drawImage(ImageIO.read(new File("/Users/serhat/Downloads/Lorann/main/sprites/gate_open.png")),0,0, null); 
			if (getLevel().getCrystal() != null) 
				getLevel().getCrystal().getImage().getGraphics().drawImage(ImageIO.read(new File("/Users/serhat/Downloads/Lorann/main/sprites/BlackTile.jpg")),0,0, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public void PowerSpawn (IMobile power) {
		boardFrame.addPawn(power);
	}
	
	
   
    static UserOrder keyCodeToUserOrder(final int keyCode) {
        UserOrder userOrder;
                
        switch (keyCode) {
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
            	userOrder = UserOrder.RIGHT;
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_Q:
                userOrder = UserOrder.LEFT;
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_Z:
                userOrder = UserOrder.UP;
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                userOrder = UserOrder.DOWN;
                break;
            case KeyEvent.VK_X:
                userOrder = UserOrder.DOWNRIGHT;
                break;
            case KeyEvent.VK_W:
                userOrder = UserOrder.DOWNLEFT;
                break;
            case KeyEvent.VK_E:
                userOrder = UserOrder.UPRIGHT;
                break;
            case KeyEvent.VK_A:
                userOrder = UserOrder.UPLEFT;
                break;
            case KeyEvent.VK_SPACE:
                userOrder = UserOrder.SHOOT;
                break;
            default:
                userOrder = UserOrder.NOTHING;
                break;
        }
        return userOrder;
    }

    /**
     * Not used
     */
    @Override
    public void keyTyped(final KeyEvent keyEvent) {
        
    }

    
    @Override
    public final void keyPressed(final KeyEvent keyEvent) {
        try { 
        	
            this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
        } catch (final IOException exception) {
            exception.printStackTrace();
        }
    }

    
    @Override
    public void keyReleased(final KeyEvent keyEvent) {
        // Not used
    }

   
    private ILevel getLevel() {
        return this.level;
    }

    
    private void setLevel(final ILevel level) throws IOException {
        this.level = level;
        for (int x = 0; x < ViewFacade.squareNumberWidth; x++) { 
            for (int y = 0; y < ViewFacade.squareNumberHeight; y++) {
                this.getLevel().getOnTheLevelXY(x, y).getSprite().loadImage(); 
            }
        }
    }


    
    private Rectangle getCloseView() {
        return this.closeView;
    }

   
    private void setCloseView(final Rectangle closeView) {
        this.closeView = closeView;
    }

    
    private IOrderPerformer getOrderPerformer() {
        return this.orderPerformer;
    }

    
    public final void setOrderPerformer(final IOrderPerformer orderPerformer) {
        this.orderPerformer = orderPerformer;
    }
}



