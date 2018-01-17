/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Ashwith Gundu
 */
public class HospitalDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        //1. Declare and initialize a scan object "sc" to read from the file "input.txt"
        //2.Declare variables of type String.
        // Create an object for AbstarctHospitalInfo with variable name as hospitalInfo and initialize it with OutPatient class.
        Scanner scan = new Scanner(new File("input.txt"));

        String docname, specialityType, officeHours, hospitalName;
        String hospitalAddress;

        AbstractHospitalInfo hospitalInfo = new OutPatient();

        // Read the first and second line and store the data into "hospitalName" and "hospitalAddress"
        hospitalName = scan.nextLine();
        hospitalAddress = scan.nextLine();

        String a = "Patient Details\n";
        //3. while input.txt has more data(While loop starts here) {
        while (scan.hasNext()) {

            //  If the Passed type is "Doctor" then, Read in the data, and store them to the respective variables such as,   
            //  docname, specialityType, officeHours. Initlaize the multiple argument contructor of Doctor class with the mentioned variables.
            String str = scan.next();

            if (str.toLowerCase().equals("doctor")) {

                scan.nextLine();

                docname = scan.nextLine();

                specialityType = scan.nextLine();

                officeHours = scan.nextLine();

                Doctor doctor = new Doctor(docname, officeHours, specialityType);

                try {
                    hospitalInfo.addDoctors(doctor);
                } catch (InvalidDoctorSizeException exe) {
                    System.out.println(exe);
                }
            } else {

                System.out.println("****************************************\n" + a
                        + "****************************************");

                a = "";

                String genderString = str;

                char gender = genderString.charAt(0);

                scan.nextLine();

                int age = Integer.parseInt(scan.nextLine());

                String firstName = scan.nextLine();
                String lastName = scan.nextLine();

                int insuranceID = Integer.parseInt(scan.nextLine());
                String doctorToVisit = scan.nextLine();

                Patient patient = new Patient(firstName, lastName, insuranceID, age, gender, doctorToVisit);
                OutPatient outpatient = new OutPatient(hospitalName, hospitalAddress, patient);

                System.out.println(outpatient);
                hospitalInfo.assignPatientsToDoctor(hospitalInfo.getAvailableDoctorsList(), patient);

                //    Create a variable billingDetails of type String and scan the data, also create a variable billGenerated of type double and invoke the calculate bill method
                
                //InsuranceCoverage of type double and parse the data
                String billingDetails = scan.nextLine();

                double billGenerated = outpatient.calcBill(billingDetails);
                System.out.println("Bill Amount Generated before Insurance deduction:" + billGenerated);

                String insuranceCompany = scan.nextLine();
                double insuranceCoverage;
                insuranceCoverage = Double.parseDouble(scan.nextLine());

                // if the age is less than 16
                if (age < 16) {
                    // create an object for ChildInsurance of variable name childInsurance and invoke multiple argument contructor of childInsurance class.
                    ChildInsurance childInsurance = new ChildInsurance(insuranceCompany, insuranceCoverage, firstName, lastName, insuranceID, age, gender, doctorToVisit);

                    System.out.println(childInsurance);

//         Test the toString method of child insurance class. Using try catch block invoke the chekcHealthInsurancePlan in childinsurance class and store the returned value in
                    //         inusrancePlanName variable of type String,create a variable premiumPaid of type double and scan the data. Now using one more try catch block
                    try {
                        String insurancePlanName = childInsurance.checkHealthInsurancePlan();
                        System.out.println("Insurance Plan Name: " + insurancePlanName);
                    } catch (InvalidInsuranceIDException e) {
                        System.out.println(e);
                    }

                    double premiumPaid;
                    premiumPaid = Double.parseDouble(scan.nextLine());

//         invoke the calcAmountPayableToHospital method of child insurance class and store the returned value in amountPayable variable of type double and print it.
                    try {
                        double amountPayable = childInsurance.calcAmountPayableToHospital(premiumPaid, billGenerated);
                        System.out.println("Amount to be paid by after insurance deduction: " + amountPayable);
                    } catch (NegativeAmountException e) {
                        System.out.println(e);
                    }

                    // else 
                    // create an object for AdultInsurance of variable name adultInsurance and invoke multiple argument contructor of AdultInsurance class.
                } else {
                    AdultInsurance adultInsurance = new AdultInsurance(insuranceCompany, insuranceCoverage, firstName, lastName, insuranceID, age, gender, doctorToVisit);
                    System.out.println(adultInsurance);
                    //         Test the toString method of adult insurance class. Using try catch block invoke the chekcHealthInsurancePlan in adultinsurance class and store the returned value in
                    //         inusrancePlanName variable of type String,create a variable premiumPaid of type double and scan the data. 
                    try {
                        String insurancePlanName;
                        insurancePlanName = adultInsurance.checkHealthInsurancePlan();
                        System.out.println("Insurance Plan Name: " + insurancePlanName);
                    } catch (InvalidInsuranceIDException exe) {
                        System.out.println(exe);
                    }
                    double premiumPaid = Double.parseDouble(scan.nextLine());

                    //Now using one more try catch block
                    //         invoke the calcAmountPayableToHospital method of Adult insurance class and store the returned value in amountPayable variable of type double and print it.
                 //        // print all the Patients assigned to doctor "Lisa DiStefano".

                    try {
                        double amountPayable;
                        amountPayable=adultInsurance.calcAmountPayableToHospital(premiumPaid, billGenerated);
                        System.out.println("Amount to be paid by after insurance deduction: " + amountPayable);
                    } catch (NegativeAmountException ep) {
                        System.out.println(ep);
                    }
                }
            }
        }
        System.out.println("\n****************************************\n" + "Patients "
                + "assigned to doctor \"Lisa DiStefano\": \n"
                + "****************************************");


        for (Doctor dt : hospitalInfo.getPatientsMappedToDoctor().keySet()) {
            if (dt.getName().equals("Lisa DiStefano")) {
                System.out.println(hospitalInfo.getPatientsMappedToDoctor().get(dt));
            }
        }

    }
}
