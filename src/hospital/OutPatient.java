/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Ashwith Gundu
 */
public class OutPatient extends AbstractHospitalInfo{
    private Patient patient;

    public OutPatient() {
    }

    public OutPatient(String hospitalName, String hospitalAddress, Patient patient) {
        super(hospitalName, hospitalAddress);
        this.patient = patient;
    }

    @Override
    public double calcBill(String billingDetails) {

        double amount = 0;

        String[] items = billingDetails.split(",");
        for (String s : items) {
            if (s != null) {
                switch (s.trim()) {
                    case "Diphtheria":
                        amount = amount + 10.25;
                        break;
                    case "Tetanus":
                        amount = amount + 12.99;
                        break;
                    case "Acellular pertussis":
                       amount = amount + 17.89;
                        break;
                    case "Haemophilus influenzae":
                        amount = amount + 7.5;
                        break;
                    case "Pneumococcal conjugate":
                        amount = amount + 9.9;
                        break;
                    default:
                        amount = amount + EMERGENCY_FEE;
                        break;

                }
            }

        }
        return BASE_CONSULTATION_FEE + amount;
    }

    @Override
    public void assignPatientsToDoctor(List<Doctor> doctorList, Patient patient) {

        for (Doctor doct : doctorList) {
            if (doct.getName().equals(patient.getDoctorToVisit())) {
                if (this.getPatientsMappedToDoctor().keySet().contains(doct)) {
                    HashSet<Patient> hsp = this.getPatientsMappedToDoctor().get(doct);
                    hsp.add(patient);
                    this.getPatientsMappedToDoctor().put(doct, hsp);

                } else {
                    HashSet<Patient> hsp = new HashSet();
                    hsp.add(patient);
                    this.getPatientsMappedToDoctor().put(doct, hsp);
                }

            }
        }

    }
  

  @Override
    public String toString(){
    
    return super.toString()+"\n"+patient.toString();
    
    }
    
    
    
    
}

