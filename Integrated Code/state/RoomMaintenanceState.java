package state;

public class RoomMaintenanceState implements RoomState {
    @Override
    public String getStatus() {
        return "Under Maintenance";
    }
}
