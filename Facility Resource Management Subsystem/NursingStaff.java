package FRMS;

public class NursingStaff extends Staff {
    public NursingStaff(String staffID, String name) {
        super(staffID, name, "Nursing Staff");
    }

    @Override
    public void performDuties() {
        System.out.println("Providing care, assigning and releasing equipment, updating patient records.");
    }
}
