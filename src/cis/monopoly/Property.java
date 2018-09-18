package cis.monopoly;

public class Property extends Space{

    private double propPrice;
    private double propRent;
    private int propGroup;
    private int propOwnerID;
    private int houseCount;
    private boolean hasHotel;


    public Property(String propName, int propID, double propPrice, double propRent, int propGroup, int propOwnerID, int houseCount, boolean hasHotel) {
        spaceName = propName;
        spaceID = propID;
        this.propPrice = propPrice;
        this.propRent = propRent;
        this.propGroup = propGroup;
        this.propOwnerID = propOwnerID;
        this.houseCount = houseCount;
        this.hasHotel = hasHotel;
    }

    public Property() {
        propPrice = 0.0;
        propRent = 0.0;
        propGroup = -1; //the reason why it's not zero for the default is because I plan on using group 0 for the first group of props
        propOwnerID = 0;
        houseCount = 0;
        hasHotel = false;
    }

    public double getPropPrice() {
        return propPrice;
    }

    public void setPropPrice(double propPrice) {
        this.propPrice = propPrice;
    }

    public double getPropRent() {
        return propRent;
    }

    public void setPropRent(double propRent) {
        this.propRent = propRent;
    }

    public int getPropOwnerID() {
        return propOwnerID;
    }

    public void setPropOwnerID(int propOwnerID) {
        this.propOwnerID = propOwnerID;
    }

    public int getPropGroup() {
        return propGroup;
    }

    public void setPropGroup(int propGroup) {
        this.propGroup = propGroup;
    }

    public int getpropOwnerID() {
        return propOwnerID;
    }

    public void setpropOwnerID(int propOwnerID) {
        this.propOwnerID = propOwnerID;
    }

    public int getHouseCount() {
        return houseCount;
    }

    public void addHouseCount(int count) {
        houseCount += count;
    }

    public void subtractHouseCount(int count) {
        houseCount -= count;
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
