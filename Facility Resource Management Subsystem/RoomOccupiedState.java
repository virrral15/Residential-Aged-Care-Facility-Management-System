package facility_resource_management;

public class RoomOccupiedState implements RoomState {
    @Override
    public String getStatus() {
        return "Occupied";
    }
}
