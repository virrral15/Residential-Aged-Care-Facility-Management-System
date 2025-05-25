package facility_resource_management;

public class AdminStaff extends Staff {
    public AdminStaff(String staffID, String name) {
        super(staffID, name, "Admin Staff");
    }

    @Override
    public void performDuties() {
        System.out.println("Performing admin tasks: room allocation, equipment monitoring, reporting.");
    }
}
