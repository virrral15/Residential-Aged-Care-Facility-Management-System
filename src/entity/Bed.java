package entity;
public class Bed {
    private final String bedID;
    private boolean available = true;

    public Bed(String bedID) {
        this.bedID = bedID;
    }

    public String getBedID() {
        return bedID;
    }

    public boolean isAvailable() {
        return available;
    }

    public void markOccupied() {
        available = false;
    }

    public void markAvailable() {
        available = true;
    }
}
