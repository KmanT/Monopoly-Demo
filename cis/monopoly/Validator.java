package cis.monopoly;
/**
 * <h1>Validator</h1>
 * This class is used for confirming or checking if 
 * an input String is valid or not. If the String is 
 * empty, an integer, double or float.
 * @author Kyle Turske
 * @version 0.5
 */
public class Validator {
    public Validator() {

    }
    /**
     * This method checks if the String is valid or not.
     * @param val. This is the input String.
     * @return true or false.
     */
    public static Boolean emptyCheck(String val) {
        return val.isEmpty();
    }

    /*public static Boolean intCheck(String val) {
        return intCheck(val);

    }

    public static Boolean intCheck(String val, int radix) {
        if(val.isEmpty()) return false;
        for(int i = 0; i < val.length(); i++) {
            if(i == 0 && val.charAt(i) == '-') {
                if (val.length() == 1) return false;
                else continue;
            }
            if (Character.digit(val.charAt(i), radix) < 0) return false;
        }
        return true;
    }*/
    /**
     * This method checks if the String is an integer.
     * @param val. This is the input String.
     * @return true if it is an integer or false if it is not.
     */
    public static Boolean intCheck(String val) {
        try {
            Integer.parseInt(val);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * This method checks if the String is an double.
     * @param val. This is the input String.
     * @return true if it is a double or false if it is not.
     */
    public static Boolean doubleCheck(String val) {
        try {
            Double.parseDouble(val);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * This method checks if the String is an float.
     * @param val. This is the input String.
     * @return true if it is a float or false if it is not.
     */
    
    public static Boolean floatCheck(String val) {
        try {
            Float.parseFloat((val));
            return true;
        } catch (Exception e) {
            return false;
        }
    }



}
