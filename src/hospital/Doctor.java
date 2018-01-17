/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

/**
 *
 * @author Ashwith Gundu
 */
public class Doctor {
   private String name,officeHours,SpecialityType;

    public Doctor(String name,String officeHours,String SpecialityType) {
        this.name = name;
        this.officeHours = officeHours;   
    this.SpecialityType = SpecialityType;
    }

    public String getName() {
        return name;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public String getSpecialityType() {
        return SpecialityType;
    }
    
    
}
