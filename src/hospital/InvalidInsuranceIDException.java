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
public class InvalidInsuranceIDException extends Exception  {

    public InvalidInsuranceIDException() {
    }
     public InvalidInsuranceIDException(String msg) {
        super(msg);
    }
    
}
