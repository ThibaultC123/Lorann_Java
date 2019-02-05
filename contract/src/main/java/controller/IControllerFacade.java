package controller;

import java.io.IOException;

public interface IControllerFacade {
	 void play() throws InterruptedException, IOException;
	 IOrderPerformer getOrderPeformer();
}



// Le controller prend le UserOrder et la view le set. 