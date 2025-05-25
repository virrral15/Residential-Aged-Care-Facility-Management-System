package facility_resource_management;

public class RoomUnderMaintenanceState implements RoomState {
    @Override
    public String getStatus() {
        return "Under Maintenance";
    }
}
