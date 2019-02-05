package view;

import controller.IOrderPerformer;
import model.IMobile;

public interface IViewFacade  {
	void displayMessage(String message);
	void setOrderPerformer(IOrderPerformer orderPeformer);
	void OpenGateUpdate();
	void PowerSpawn(IMobile power); // POUR CE QUI EST DE l'ENERGIE
	
}

// A FAIRE !