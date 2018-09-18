package cis.monopoly;

public class Space {

    protected String spaceName;
    protected int spaceID;


    public Space (String spaceName, int spaceID) {
        this.spaceName = spaceName;
        this.spaceID = spaceID;
    }

    public Space () {
        spaceName = "";
        spaceID = 0;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public int getSpaceID() {
        return spaceID;
    }

    public void setSpaceID(int spaceID) {
        this.spaceID = spaceID;
    }
}


