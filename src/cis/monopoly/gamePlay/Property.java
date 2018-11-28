package cis.monopoly.gamePlay;

import cis.monopoly.guiElements.AlertBox;

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
    /**This confirms if a property has a hotel or not.*/
    private boolean hasHotel;
    /**Determines the price of the house for a property.*/
    private int housePrice;
    

    /**
     * This is a constructor of a Property.
     * @param propName This is the name of the property.
     * @param propID This is the ID of the property.
     * @param propPrice This is the price of the property.
     * @param propRent This is the rent of a the property.
     * @param propGroup This is the group associated to a property.
     * @param propOwnerID This is the owner of the property.
     * @param houseCount This the number of houses on the property.
     * @param hasHotel This confirms if the property has a hotel.
     * @param housePrice This is the price of a house for a property
     */
    public Property(final String propName, final int propID, 
    			final int propPrice, final int propRent, final int propGroup,
    			final int propOwnerID, final int houseCount,
    			final boolean hasHotel, final int housePrice) {
        super(propName, propID);
        this.propPrice = propPrice;
        this.propRent = propRent;
        this.propGroup = propGroup;
        this.propOwnerID = propOwnerID;
        this.houseCount = houseCount;
        this.hasHotel = hasHotel;
        this.housePrice = housePrice;
    }

    /**
     * This is a constructor of a Property.
     * @param propName This is the name of the property.
     * @param propID This is the ID of the property.
     * @param propPrice This is the price of the property.
     * @param propRent This is the rent of a the property.
     * @param propGroup This is the group associated to a property.
     */
    public Property(final String propName, final int propID,
    		final int propPrice, final int propRent, final int propGroup) {
        super(propName, propID);
        this.propPrice = propPrice;
        this.propRent = propRent;
        this.propGroup = propGroup;
        propOwnerID = 0;
        houseCount = 0;
        hasHotel = false;
    }

    /**
     * This is a constructor of a Property.
     * @param propName This is the name of the property.
     * @param propID This is the ID of the property.
     * @param propPrice This is the price of the property.
     * @param propRent This is the rent of a the property.
     * @param propGroup This is the group associated to a property.
     * @param propOwnerID This is the owner of the property.
     */
    public Property(final String propName, final int propID,
    			final int propPrice, final int propRent,
    			final int propGroup, final int propOwnerID) {
        super(propName, propID);
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
        super("", 0);
    	propPrice = 0;
        propRent = 0;
        propGroup = -1; 
        propOwnerID = 0;
        houseCount = 0;
        hasHotel = false;
        housePrice = 0;
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
     * @param propPrice The price to be set.
     */
    public void setPropPrice(final int propPrice) {
        this.propPrice = propPrice;
    }
    /**
     * This is a getter method for the rent of a property.
     * @return propRent The rent of the property.
     */
    public int getPropRent() {
        return propRent;
    }

    /**
     * This is a setter method for the rent of a property.
     * @param propRent The rent to be set.
     */
    public void setPropRent(final int propRent) {
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
     * @param propOwnerID The OwnerID to be set.
     */
    public void setPropOwnerID(final int propOwnerID) {
        this.propOwnerID = propOwnerID;
    }

    /**
     * This is a getter method for the Group of a property.
     * @return propGroup The Group of the property.
     */
    public int getPropGroup() {
        return propGroup;
    }
    
    /**
     * This is a setter method for the Group of a property.
     * @param propGroup The Group to be set.
     */
    public void setPropGroup(final int propGroup) {
        this.propGroup = propGroup;
    }
    
    /**
     * This gets the ID of the owner of the property.
     * @return The owner's ID
     */
    public int getpropOwnerID() {
        return propOwnerID;
    }

    /**
     * Changes the property's owner ID.
     * @param propOwnerID The ID of the new owner.
     */
    public void setpropOwnerID(final int propOwnerID) {
    	this.propOwnerID = propOwnerID;
    }
    
    /**
     * This is a getter method for the number of houses on the property.
     * @return houseCount. The number of houses on the property.
     */
    public int getHouseCount() {
        return houseCount;
    }
    
    /**
     * Gets the price to purchase a house.
     * @return The price of a house
     */
    public int getHousePrice() {
		return housePrice;
	}
    
    /**
     * Automatically sets the house price based on the property group
     */
    public void setHousePrice() {
    	if (propGroup == 1 || propGroup == 2) {
    		housePrice = 50;
    	} else if (propGroup == 3 || propGroup == 4) {
    		housePrice = 100;
    	} else if (propGroup == 5|| propGroup == 6) {
    		housePrice = 150;
    	} else if (propGroup == 7 || propGroup == 8) {
    		housePrice = 200;
    	} else {
    		housePrice = 0;
    	}
    }

    /**
     * Manually sets the price for a house.
     * @param housePrice The amount a player needs to purchase the house
     */
	public void setHousePrice(final int housePrice) {
		this.housePrice = housePrice;
	}

	/**
     * This is a method that increases the number of houses on a property, only
     * if the number of houses is less than four and there isn't a hotel
     * present.
     */
    public void addHouseCount() {
        if (houseCount < 4 && !hasHotel) {
        	houseCount++;
        } else if (houseCount >= 4) {
        	AlertBox.display("Property has max houses.", "The maximum number of"
        			+ "houses has already been met. You cannot buy more for"
        			+ "this property.");
        } else if (hasHotel) {
        	AlertBox.display("Property has hotel.", "You cannot add a house"
        			+ "to a property that has a hotel.");
        }
    	
    }
    
    /**
     * This is a method that reduces the number of house on a property.
     * @param count The number the houses should be decreased by.
     */
    public void subtractHouseCount(final int count) {
        houseCount -= count;
    }

    /**
     * This is a setter method for the number of houses on a property.
     * @param houseCount The number to be set to.
     */
    public void setHouseCount(final int houseCount) {
        this.houseCount = houseCount;
    }
    
    /**
     * This is a method that checks if a property has a hotel.
     * @return hasHotel This is either true or false.
     */
    public boolean isHasHotel() {
        return hasHotel;
    }
    
    /**
     * Removes all of the houses from a property and gives the property a hotel.
     */
    public void setHasHotel() {
    	if (!hasHotel && houseCount >= 3) {
    		houseCount = 0;
    		hasHotel = true;
    	} else if (houseCount < 4) {
    		AlertBox.display("Need four houses on property", "You need to"
    				+ " purchase more houses for this property in order to"
    				+ " purchase a hotel. You need a total of four houses.");
    	}
    }
}
