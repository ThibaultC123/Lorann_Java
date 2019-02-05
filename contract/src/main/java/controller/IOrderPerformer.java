package controller;

import java.io.IOException;

public interface IOrderPerformer {

	void orderPerform(UserOrder userOrder) throws IOException;
	
}


// CETTE INTERFACE REPREND L'ENUM USERORDER POUR LES ENTREEES UTILISATEURS