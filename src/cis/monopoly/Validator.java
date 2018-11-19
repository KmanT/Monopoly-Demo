package cis.monopoly;
/**
 * <h1>Validator</h1>
 * This class is used for confirming or checking if an input String is valid or
 * not. If the String is empty, an integer, double or float.
 * @author Kyle Turske
 * @version 0.5
 */
public class Validator {
    
    /**
     * This method checks if the String contains anything.
     * @param val This is the input String.
     * @return true or false.
     */
    public static Boolean emptyCheck(final String val) {
        return val.isEmpty();
    }
    
    /**
     * This method checks if the String contains input.
     * @param val The string being evaluated
     * @return true if the string is not blank; false if it is.
     */
    public static Boolean hasInput(final String val) {
    	if (val.equals("")) {
    		return false;
    	} else {
    		return true;
    	}
    }
    /**
     * This method checks if the String is an integer.
     * @param val This is the input String.
     * @return true if it is an integer or false if it is not.
     */
    public static Boolean intCheck(final String val) {
        try {
            Integer.parseInt(val);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * This method checks if the String is an double.
     * @param val This is the input String.
     * @return true if it is a double or false if it is not.
     */
    public static Boolean doubleCheck(final String val) {
        try {
            Double.parseDouble(val);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * This method checks if the String is an float.
     * @param val This is the input String.
     * @return true if it is a float or false if it is not.
     */
    
    public static Boolean floatCheck(final String val) {
        try {
            Float.parseFloat((val));
            return true;
        } catch (Exception e) {
            return false;
        }
    }



}
