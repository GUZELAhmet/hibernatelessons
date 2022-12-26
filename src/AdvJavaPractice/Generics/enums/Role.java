package AdvJavaPractice.Generics.enums;

public enum Role {
    ROLE_ADMIN("adimn"),
    ROLE_TEACHER("teacher"),
    ROLE_STUDENT("student");

    String name;
    Role(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
