package state;

public class RoomAvailableState implements RoomState {
    @Override
    public String getStatus() {
        return "Available";
    }
}
