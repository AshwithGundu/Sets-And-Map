/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Ashwith Gundu
 */
public abstract class AbstractHospitalInfo implements Hospital{

  
    private List<Doctor> availableDoctorsList;
    private String hospitalAddress;
    private String hospitalName;
    private HashMap<Doctor, HashSet<Patient>> patientsMappedToDoctor;

    public AbstractHospitalInfo() {
        this.availableDoctorsList = new ArrayList<>();
        this.patientsMappedToDoctor = new HashMap();
    }

    public AbstractHospitalInfo(String hospitalName, String hospitalAddress) {
        this.hospitalAddress = hospitalAddress;
        this.hospitalName = hospitalName;
        this.availableDoctorsList = new ArrayList<>();
        this.patientsMappedToDoctor = new HashMap();
    }

    public List<Doctor> getAvailableDoctorsList() {
        return availableDoctorsList;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public HashMap<Doctor, HashSet<Patient>> getPatientsMappedToDoctor() {
        return patientsMappedToDoctor;
    }

    public static double getBASE_CONSULTATION_FEE() {
        return BASE_CONSULTATION_FEE;
    }

    public static double getEMERGENCY_FEE() {
        return EMERGENCY_FEE;
    }

    public void setPatientsMappedToDoctor(HashMap<Doctor, HashSet<Patient>> patientsMappedToDoctor) {
        this.patientsMappedToDoctor = patientsMappedToDoctor;
    }

    
    public abstract double calcBill(String billingDetails);

    @Override
    public abstract void assignPatientsToDoctor(List<Doctor> doctorList, Patient patient);

    public void addDoctors(Doctor doctor) throws InvalidDoctorSizeException {
        if (this.availableDoctorsList.size() < 0) {
            throw new InvalidDoctorSizeException();
        } else {
            this.availableDoctorsList.add(doctor);
        }
    }

    @Override
    public String toString() {
        return "HospitalName: " + this.getHospitalName() + " ,\n" + "HospitalAddress: " 
                + this.getHospitalAddress();
    }

}
