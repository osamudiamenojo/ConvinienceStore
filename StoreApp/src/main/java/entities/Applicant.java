package entities;

import enums.Qualification;
import enums.Role;
import lombok.Data;

@Data

public class Applicant extends Person{
    private Role role= Role.UNDETERMINED;
    private Qualification qualification;



    public String apply(){
        setRole(Role.CASHIER);
        return this.getName()+" has applied to be a cashier";
    }
}
