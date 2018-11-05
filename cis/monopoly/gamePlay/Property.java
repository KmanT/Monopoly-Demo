package cis.monopoly.gamePlay;

/**
 * <h1>Property</h1>
 * This class is used in identifying the properties
 * on the spaces on the board.
 * @author Kyle Turske
 * @version 0.5
 */
public class Property extends Space {
	/**This defines the price of a property.*/
    private int propPrice;
    /**This defines the Rent of a property.*/
    private int propRent;
    /**This defines the Groups of a property.*/
    private int propGroup;
    /**This defines the ownerID of a property.*/
    private int propOwnerID;
    /**This defines the number of houses on a property.*/
    private int houseCount;
    /**This confirms if a propery has a hotel or not.*/
    private boolean hasHotel;

    /**
     * This is a constructor of a Property.
     * @param propName. This is the name of the property.
     * @param propID. This is the ID of the property.
     * @param propPrice. This is the price of the property.
     * @param propRent. This is the rent of a the property.
     * @param propGroup. This is the group associated to a property.
     * @param propOwnerID. This is the owner of the property.
     * @param houseCount. This the number of houses on the property.
     * @param hasHotel. This confirms if the property has a hotel.
     */
    public Property(String propName, int propID, int propPrice, int propRent,
                    int propGroup, int propOwnerID, int houseCount, boolean hasHotel) {
        spaceName = propName;
        spaceID = propID;
        this.propPrice = propPrice;
        this.propRent = propRent;
        this.propGroup = propGroup;
        this.propOwnerID = propOwnerID;
        this.houseCount = houseCount;
        this.hasHotel = hasHotel;
    }

    /**
     * This is a constructor of a Property.
     * @param propName. This is the name of the property.
     * @param propID. This is the ID of the property.
     * @param propPrice. This is the price of the property.
     * @param propRent. This is the rent of a the property.
     * @param propGroup. This is the group associated to a property.
     */
    public Property(String propName, int propID, int propPrice, int propRent, int propGroup) {
        spaceName = propName;
        spaceID = propID;
        this.propPrice = propPrice;
        this.propRent = propRent;
        this.propGroup = propGroup;
        propOwnerID = 0;
        houseCount = 0;
        hasHotel = false;
    }

    /**
     * This is a constructor of a Property.
     * @param propName. This is the name of the property.
     * @param propID. This is the ID of the property.
     * @param propPrice. This is the price of the property.
     * @param propRent. This is the rent of a the property.
     * @param propGroup. This is the group associated to a property.
     * @param propOwnerID. This is the owner of the property.
     */
    public Property(String propName, int propID, int propPrice, int propRent,
                    int propGroup, int propOwnerID) {
        spaceName = propName;
        spaceID = propID;
        this.propPrice = propPrice;
        this.propRent = propRent;
        this.propGroup = propGroup;
        this.propOwnerID = propOwnerID;
        houseCount = 0;
        hasHotel = false;
    }
    /**
     * This is a default constructor of a Property that
     * sets everything to 0 or false except propGroup. propGroup
     * is set to -1 because we plan to start at 0.
     */
    
    public Property() {
        propPrice = 0;
        propRent = 0;
        propGroup = -1; //the reason why it's not zero for the default is
        propOwnerID = 0;//because I plan on using group 0 for the first group of props
        houseCount = 0;
        hasHotel = false;
    }

    /**
     * This is a getter method for the price of a property.
     * @return propPrice. The price of the property.
     */
    public int getPropPrice() {
        return propPrice;
    }


    /**
     * This is a setter method for the price of a property.
     * @param propPrice. The price to be set.
     */
    public void setPropPrice(int propPrice) {
        this.propPrice = propPrice;
    }
    /**
     * This is a getter method for the rent of a property.
     * @return propRent. The rent of the property.
     */
    public int getPropRent() {
        return propRent;
    }

    /**
     * This is a setter method for the rent of a property.
     * @param propRent. The rent to be set.
     */
    public void setPropRent(int propRent) {
        this.propRent = propRent;
    }
    
    /**
     * This is a getter method for the OwnerID of a property.
     * @return propOwnerID. The OwnerID of the property.
     */
    public int getPropOwnerID() {
        return propOwnerID;
    }

    /**
     * This is a setter method for the rent of a property.
     * @param propOwnerID. The OwnerID to be set.
     */
    public void setPropOwnerID(int propOwnerID) {
        this.propOwnerID = propOwnerID;
    }

    /**
     * This is a getter method for the Group of a property.
     * @return propGroup. The Group of the property.
     */
    public int getPropGroup() {
        return propGroup;
    }
    
    /**
     * This is a setter method for the Group of a property.
     * @param propGroup. The Group to be set.
     */
    public void setPropGroup(int propGroup) {
        this.propGroup = propGroup;
    }
    
//    public int getpropOwnerID() {
//        return propOwnerID;
//    }
//
//    public void setpropOwnerID(int propOwnerID) {
//        this.propOwnerID = propOwnerID;
//    }
    
    /**
     * This is a getter method for the number
     * of houses on the property.
     * @return houseCount. The no.of houses on the property.
     */
    
    public int getHouseCount() {
        return houseCount;
    }

    /**
     * This is a method that increases the number of
     * house on a property.
     * @param count. The number the houses should be 
     * increased by.
     */
    public void addHouseCount(int count) {
        houseCount += count;
    }
    
    /**
     * This is a method that reduces the number of
     * house on a property.
     * @param count. The number the houses should be 
     * decreased by.
     */
    public void subtractHouseCount(int count) {
        houseCount -= count;
    }

    /**
     * This is a setter method for the number of houses
     * on a property.
     * @param houseCount. The number to be set to.
     */
    public void setHouseCount(int houseCount) {
        this.houseCount = houseCount;
    }
    /**
     * This is a method that checks if a property has a 
     * hotel.
     * @return hasHotel. This is either true or false.
     */
    public boolean isHasHotel() {
        return hasHotel;
    }
    
    /**
     * This is a setter method to set the property to have
     * a hotel.
     * @param hasHotel. The is either true or false to be set.
     */
    public void setHasHotel(boolean hasHotel) {
        this.hasHotel = hasHotel;
    }
}
