package main;

import java.io.IOException;
import java.sql.SQLException;

import controller.ControllerFacade;
import controller.IControllerFacade;
import model.IModelFacade;
import model.ModelFacade;
import view.IViewFacade;
import view.ViewFacade;

public class Main {
	   
	
	public static void main(final String[] args) throws IOException, InterruptedException, SQLException {
	
		final IModelFacade model = new ModelFacade(2); 									
        final IViewFacade view = new ViewFacade(model.getLevel()); 						
        final IControllerFacade controller = new ControllerFacade(view, model); 		
        view.setOrderPerformer(controller.getOrderPeformer()); 							

        controller.play(); 																
    }
}

    

