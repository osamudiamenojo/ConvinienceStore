package entities;

import enums.Gender;
import enums.Qualification;
import enums.Role;
import lombok.*;


@Getter
@Setter
@ToString
@EqualsAndHashCode


public class Applicant extends Person{
    private Role role= Role.UNDETERMINED;
    private Qualification qualification;
    public Applicant(String name, Gender gender, Qualification qualification) {
        super(name, gender);
        this.qualification = qualification;
    }

    public String apply(){
        setRole(Role.CASHIER);
        return this.getName()+" has applied to be a cashier";
    }
}
