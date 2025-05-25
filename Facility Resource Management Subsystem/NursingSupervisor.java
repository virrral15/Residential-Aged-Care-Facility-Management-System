package facility_resource_management;

public class NursingSupervisor extends Staff {
    public NursingSupervisor(String staffID, String name) {
        super(staffID, name, "Nursing Supervisor");
    }

    @Override
    public void performDuties() {
        System.out.println("Managing rosters, approving shifts, and coordinating nursing schedules.");
    }
}
