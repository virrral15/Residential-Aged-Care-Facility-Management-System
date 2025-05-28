package facility_resource_management;

public class MaintenanceStaff extends Staff {
    public MaintenanceStaff(String staffID, String name) {
        super(staffID, name, "Maintenance Staff");
    }

    @Override
    public void performDuties() {
        System.out.println("Inspecting rooms and equipment, marking maintenance or repair status.");
    }
}
