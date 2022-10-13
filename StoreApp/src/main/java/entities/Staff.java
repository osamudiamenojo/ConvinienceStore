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

    public Staff(String name, Gender gender, String toString, Role cashier, Qualification qualification) {

    }
}
