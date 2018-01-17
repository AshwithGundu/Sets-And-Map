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
public interface Insurance {
    static double BASE_PREMIUM_AMOUNT = 600.00;
    
    public double calcAmountPayableToHospital(double PremiumPaid, double billGenerated) throws NegativeAmountException;;
    
    String checkHealthInsurancePlan() throws InvalidInsuranceIDException;
  
}
