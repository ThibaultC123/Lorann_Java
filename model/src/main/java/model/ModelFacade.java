package model;

import java.io.IOException;
import java.sql.SQLException;




/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public final class ModelFacade implements IModelFacade {
	
private ILevel level;
public ModelFacade(final int idlevel) throws IOException, SQLException {
    this.setLevel(new Level(idlevel));
}

@Override
public final ILevel getLevel() {
    return this.level;
}

private void setLevel(final ILevel level) {
    this.level = level;
}

  
}

