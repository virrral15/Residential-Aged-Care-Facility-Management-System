package control;

import manager.AdmissionManager;

public class BedsCommand implements Command {

    @Override
    public CommandResponse execute(AdmissionManager manager, String[] args) {
        String status = manager.getBedStatus();
        return new CommandResponse(status, true);
    }
}
