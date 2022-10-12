package service.impl;

import entities.Applicant;
import entities.Staff;
import enums.Role;
import exceptions.ServiceException;
import service.ManagerService;

import java.util.UUID;

public class ManagerServiceImpl implements ManagerService {
    public String hireACashier(Staff manager, Applicant applicant) {
        if (manager==null || applicant==null) throw new NullPointerException("Manager or cashier cannot be null");

        if (!Role.MANAGER.equals(manager.getRole())){
            throw new ServiceException("You must be a manager to perform this function");
        }
        if(Role.CASHIER.equals(applicant.getRole())) {
            Staff cashier = new Staff(applicant.getName(), applicant.getGender(),
                    UUID.randomUUID().toString(), Role.CASHIER, applicant.getQualification());
        }
        String hireMessage = String.format("%s is now a cashier", applicant.getName());
        return hireMessage;
    }
}
