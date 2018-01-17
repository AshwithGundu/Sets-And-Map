/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.util.List;

/**
 *
 * @author Ashwith Gundu
 */
public interface Hospital {
    
    static double BASE_CONSULTATION_FEE=20.0;
   static double EMERGENCY_FEE=30.0;
  
   public double calcBill(String billingDetails);
   
void assignPatientsToDoctor(List<Doctor> doctorList, Patient patient);
}

