package model;

import java.awt.Image;
import java.io.IOException;

public interface ISprite {

	Image getImage();

	void loadImage() throws IOException;

	char getConsoleImage();

}

