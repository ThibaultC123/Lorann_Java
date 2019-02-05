package model.element.motionless;

public abstract class MotionlesElementFactory {
	
	
    private static final Bone bone = new Bone();
    private static final HorizontalBone horizontalBone = new HorizontalBone();
    private static final VerticalBone verticalBone = new VerticalBone();
    private static final Purse purse = new Purse();
    private static final Crystal crystal = new Crystal();
    private static final Gate gate = new Gate();
    private static final Tile tile = new Tile();
	
    private static MotionlessElement[]       motionlessElements  = {
            bone,
            horizontalBone,
            verticalBone,
            purse,
            crystal,
            gate,
            tile,
            };
    
  
    public static MotionlessElement createBone() {
        return bone;
    }
    
    
    public static MotionlessElement createHorizontalBone() {
        return horizontalBone;
    }
    
   
    public static MotionlessElement createVerticalBone() {
        return verticalBone;
    }
   
    public static MotionlessElement createPurse() {
        return purse;
    }
    
    
    public static MotionlessElement createCrystal() {
        return crystal;
    }
    
   
    public static MotionlessElement createGate() {
        return gate;
    }
    
    public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
    	
        for (final MotionlessElement motionlessElement : motionlessElements) {
            if (motionlessElement.getSprite().getConsoleImage() == fileSymbol) {
                return motionlessElement;
            }
        }
        return tile;
    }
}


