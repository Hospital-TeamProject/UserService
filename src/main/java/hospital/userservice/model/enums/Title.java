package hospital.userservice.model.enums;

public enum Title {
    PHD("Ph.D."),
    SPC("spc."),
    MD("M.D.");

    String notation;

    Title(String notation) {
        this.notation = notation;
    }
}
