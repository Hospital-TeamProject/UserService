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


}
