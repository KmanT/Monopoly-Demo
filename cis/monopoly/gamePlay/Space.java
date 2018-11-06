package cis.monopoly.gamePlay;

/**
 * <h1>Space</h1>
 * This class is used in identifying the spaces
 * on the board.
 * @author Kyle Turske
 * @version 0.5
 */

public abstract class Space {
	/**This defines the name of a space on the board.*/
    private String spaceName;
    /**This defines the ID of a space on the board.*/
    private int spaceID;


    /**
     * This is the constructor of a space.
     * @param spaceName This is the name of the space.
     * @param spaceID This is the ID of the space.
     */
    public Space(final String spaceName, final int spaceID) {
        this.spaceName = spaceName;
        this.spaceID = spaceID;
    }
    /**
     * This is a default constructor of space that
     * sets the name of the space to an empty string and
     * the ID of the space to 0.
     */
    public Space() {
        spaceName = "";
        spaceID = 0;
    }
    
    

    /**
     * This is a getter method for the space name.
     * @return spaceName. The name of the space.
     */
    public String getSpaceName() {
        return spaceName;
    }

    /**
     * This is a setter method for the space name.
     * @param spaceName The name of the space.
     */
    public void setSpaceName(final String spaceName) {
        this.spaceName = spaceName;
    }
    
    /**
     * This is a getter method for the space ID.
     * @return spaceID. The ID of the space.
     */
    public int getSpaceID() {
        return spaceID;
    }
    /**
     * This is a setter method for the space ID.
     * @param spaceID The ID of the space.
     */
    public void setSpaceID(final int spaceID) {
        this.spaceID = spaceID;
    }
}


