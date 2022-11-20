package edu.neu.csye7374;

public class PersonalTaxStrategy implements TaxStrategyAPI {

    public static final double K_PERSONAL_TAX_RATE = 0.3;

    @Override
    public double calculateTax(double income) {
//        System.out.print("PersonalTax: \t\t\t $ ");
        double tax = income * K_PERSONAL_TAX_RATE;
        System.out.print("PersonalTax: \t\t\t $ "+tax);
        return tax;
    }

}
