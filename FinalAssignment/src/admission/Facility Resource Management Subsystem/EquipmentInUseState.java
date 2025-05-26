package facility_resource_management;

public class EquipmentInUseState implements EquipmentState {
    @Override
    public String getStatus() {
        return "In Use";
    }
}
