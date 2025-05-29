package control;

import manager.ResidentRegistry;

public class ListResidentsCommand implements Command {
    @Override
    public void execute() {
        System.out.println("--- List of Admitted Residents ---");
        ResidentRegistry.getInstance().getAdmittedResidents()
            .forEach(r -> System.out.println(r + "\n------------------------------"));
    }
}
