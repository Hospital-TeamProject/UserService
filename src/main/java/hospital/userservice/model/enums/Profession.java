package hospital.userservice.model.enums;

public enum Profession {

    NURSE("Nurse"),
    BIOCHEMIST("Biochemist"),
    GASTROENTEROLOGIST("Gastroenterologist"),
    GYNECOLOGIST("Gynecologist"),
    ENDOCRINOLOGIST("Endocrinologist"),
    CARDIOLOGIST("Cardiologist"),
    NEUROLOGIST("Neurologist"),
    NEPHROLOGIST("Nephrologist"),
    PSYCHIATRIST("Psychiatrist"),
    PULMONOLOGIST("pulmonologist"),
    UROLOGIST("Urologist"),
    HEMATOLOGIST("Hematologist"),
    SURGEON("Surgeon");

    private String notation;
    Profession(String notation) {
        this.notation = notation;
    }

    public String getNotation() {
        return notation;
    }

    public static Profession ValueOfNotation(String notation) {
        for (Profession t : values()) {
            if (t.notation.equals(notation)) {
                return t;
            }
        }
        return null;
    }
}
