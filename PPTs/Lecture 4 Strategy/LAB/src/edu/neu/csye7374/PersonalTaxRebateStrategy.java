package edu.neu.csye7374;

public class PersonalTaxRebateStrategy
        implements TaxStrategyAPI {
    public static final double
            K_PERSONAL_TAX_REBATE_RATE = 0.2;

    @Override
    public double calculateTax(double income) {

        double tax = income *
                K_PERSONAL_TAX_REBATE_RATE;
        System.out.print("PersonalTax: \t\t\t $ "+tax);
        return tax;
    }
}
