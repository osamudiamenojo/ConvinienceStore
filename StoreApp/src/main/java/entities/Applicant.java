package entities;

import enums.Gender;
import enums.Qualification;
import enums.Role;

public class Applicant extends Person{
    private Qualification qualification;
    private Role role=Role.UNDETERMINED;

    public Applicant(String name, Gender gender, Qualification qualification) {
        super(name, gender);
        this.qualification = qualification;
    }



    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Applicant() {
    }



    public String apply(){
        setRole(Role.CASHIER);
        return this.getName()+" has applied to be a cashier";
    }


}
