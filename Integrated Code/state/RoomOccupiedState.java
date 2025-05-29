package state;

public class RoomOccupiedState implements RoomState {
    @Override
    public String getStatus() {
        return "Occupied";
    }
}
