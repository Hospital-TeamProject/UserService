package hospital.userservice.model.enums;

public enum Title {
    PHD("Ph.D."),
    SPC("spc."),
    MD("M.D.");

    String notation;

    Title(String notation) {
        this.notation = notation;
    }

    public String getNotation() {
        return notation;
    }

    public static Title ValueOfNotation(String notation) {
        for (Title t : values()) {
            if (t.notation.equals(notation)) {
                return t;
            }
        }
        return null;
    }
}
