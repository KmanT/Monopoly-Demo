package srcpackage;

public class Space {

    protected String spaceName;
    protected double spacePrice;
    protected double spaceRent;

    public Space (String spaceName, double spacePrice, double spaceRent) {
        this.spaceName = spaceName;
        this.spacePrice = spacePrice;
        this.spaceRent = spaceRent;
    }

    public Space () {
        spaceName = "";
        spacePrice = 0.00;
        spaceRent = 0.00;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public double getSpacePrice() {
        return spacePrice;
    }

    public void setSpacePrice(double spacePrice) {
        this.spacePrice = spacePrice;
    }

    public double getSpaceRent() {
        return spaceRent;
    }

    public void setSpaceRent(double spaceRent) {
        this.spaceRent = spaceRent;
    }
}
