package entities;

import enums.Gender;
import enums.Qualification;
import enums.Role;
import lombok.Data;

import java.util.UUID;

@Data
public class Staff extends Person{
    private String staffID;
    private Role role;
    private Qualification qualification;

    public Staff(String name, Gender gender, String staffID, Role role, Qualification qualification) {
        super(name, gender);
        this.staffID = staffID;
        this.role = role;
        this.qualification = qualification;
    }
}
