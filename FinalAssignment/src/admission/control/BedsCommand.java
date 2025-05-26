package admission.control;

import admission.manager.AdmissionManager;

public class BedsCommand implements Command {
    @Override
    public CommandResponse execute() {
        return new CommandResponse(true, AdmissionManager.getInstance().getBedStatus());
    }
} 