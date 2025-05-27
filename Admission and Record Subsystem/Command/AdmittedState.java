package admission.states;

public class AdmittedState implements ResidentState {
    @Override public String getStatus() { return "Admitted"; }
}