package service.impl;

import entities.Applicant;
import entities.Staff;
import enums.Role;
import service.ManagerService;

import java.util.UUID;

public class ManagerServiceImpl implements ManagerService {

    public String hire(Staff manager, Applicant applicant){
        if(manager.getRole()==Role.MANAGER){
            if(applicant.getRole()== Role.CASHIER) {
                Staff cashier=new Staff(applicant.getName(), applicant.getGender(), UUID.randomUUID().toString(), Role.CASHIER,applicant.getQualification());
                return cashier.getName()+" is now a cashier";
            }
        }
        return applicant.getName() + "is not qualified";
    }
}
