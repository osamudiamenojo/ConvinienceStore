package entities;
import enums.Gender;
import enums.Qualification;
import enums.Role;

public class Staff extends Person{
private String staffID;
private Role role;
private Qualification qualification;

    public Staff(Role role) {
        this.role = role;
    }

    public Staff(String name, Gender gender, String staffID, Role role, Qualification qualification) {
        super(name, gender);
        this.staffID = staffID;
        this.role = role;
        this.qualification = qualification;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }


}
