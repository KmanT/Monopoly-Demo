package srcpackage;

public class Property extends Space{

    private int propGroup;
    private int spaceOwnerID;
    private int houseCount;
    private boolean hasHotel;


    public Property(String propName, double propPrice, double propRent, int propGroup, int spaceOwnerID, int houseCount, boolean hasHotel) {
        spaceName = propName;
        spacePrice = propPrice;
        spaceRent = propRent;
        this.propGroup = propGroup;
        this.spaceOwnerID = spaceOwnerID;
        this.houseCount = houseCount;
        this.hasHotel = hasHotel;
    }

    public Property() {
        propGroup = -1; //the reason why it's not zero for the default is because I plan on using group 0 for the first group of spaces
        spaceOwnerID = 0;
        houseCount = 0;
        hasHotel = false;
    }

    public int getSpaceOwnerID() {
        return spaceOwnerID;
    }

    public void setSpaceOwnerID(int spaceOwnerID) {
        this.spaceOwnerID = spaceOwnerID;
    }

    public int getHouseCount() {
        return houseCount;
    }

    public void setHouseCount(int houseCount) {
        this.houseCount = houseCount;
    }

    public boolean isHasHotel() {
        return hasHotel;
    }

    public void setHasHotel(boolean hasHotel) {
        this.hasHotel = hasHotel;
    }
}
