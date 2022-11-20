package edu.neu.csye7374;

public class PersonalTaxPenaltyStrategy
        implements TaxStrategyAPI {
    public static final double
            K_PERSONAL_TAX_WITH_PENALTY_RATE = 0.4;

    @Override
    public double calculateTax(double income) {
//        System.out.print("PersonalTax: \t\t\t $ ");
        double tax = income *
                K_PERSONAL_TAX_WITH_PENALTY_RATE;
        System.out.print("PersonalTax: \t\t\t $ "+tax);
        return tax;
    }
}

