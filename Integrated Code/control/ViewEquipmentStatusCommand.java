package control;

import manager.EquipmentManager;

public class ViewEquipmentStatusCommand implements Command {
    @Override
    public void execute() {
        System.out.println("--- View Equipment Status ---");
        EquipmentManager.getInstance().displayEquipmentStatus();
    }
}
