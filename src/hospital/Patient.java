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
public class Patient {
     private int age;
    private String doctorToVisit;
    private String fName;
    private char gender;
    private int insuranceID;
    private String lName;

   
    public Patient() {
    }
    
     public Patient(String fName, String lName,int insuranceID, int age, char gender, 
             String doctorToVisit) {
      
        this.age = age;
        this.doctorToVisit = doctorToVisit;
        this.fName = fName;
        this.gender = gender;
        this.insuranceID = insuranceID;
        this.lName = lName;
    
     }
    
    public int getAge() {
        return age;
    }

    public String getDoctorToVisit() {
        return doctorToVisit;
    }

    public String getfName() {
        return fName;
    }

    public char getGender() {
        return gender;
    }

    public int getInsuranceID() {
        return insuranceID;
    }

    public String getlName() {
        return lName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setInsuranceID(int insuranceID) {
        this.insuranceID = insuranceID;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Override
    public String toString(){
    return "First Name: "+this.getfName()+"\nLast Name: "+this.getlName()+"\nInsurance ID: "+
            this.getInsuranceID()+"\nAge: "+this.getAge()+"\nGender: "+this.getGender();
    
    }
    
    
}
