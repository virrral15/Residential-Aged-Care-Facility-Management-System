package facility_resource_management;

public class RoomAvailableState implements RoomState {
    @Override
    public String getStatus() {
        return "Available";
    }
}
