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
public class ChildInsurance extends AbstractInsurance {

    public ChildInsurance(String InsuranceCompanyName, double InsuranceCoverage, String fName, String lName, int insuranceID, int age,
            char gender, String doctorToVisit) {
        super(InsuranceCompanyName, InsuranceCoverage, fName, lName, insuranceID, age, gender, doctorToVisit);
    }

    @Override
    public double calcAmountPayableToHospital(double PremiumPaidByCustomer,
            double billGenerated) throws NegativeAmountException {
        if (PremiumPaidByCustomer < 0) {
            throw new NegativeAmountException();
        } else if (PremiumPaidByCustomer > BASE_PREMIUM_AMOUNT) {
            return 0.8 * billGenerated;
        } else if (PremiumPaidByCustomer <= BASE_PREMIUM_AMOUNT && PremiumPaidByCustomer > 0.5 * BASE_PREMIUM_AMOUNT) {
            return 0.5 * billGenerated;
        } else {
            return 0.2 * billGenerated;
        }
    }

    @Override
    public String toString() {
        return "Insurance Company Name: " + this.getInsuranceCompanyName() + ", "
                + "Insurance Coverage: " + this.getInsuranceCoverage();
    }

}
