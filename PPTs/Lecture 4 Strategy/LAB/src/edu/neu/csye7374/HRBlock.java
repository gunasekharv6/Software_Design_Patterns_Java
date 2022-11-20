package edu.neu.csye7374;

public class HRBlock {
    private double income;
    private TaxStrategyAPI taxRate;

    public HRBlock(double income) {
        this.income = income;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public TaxStrategyAPI getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(TaxStrategyAPI rate) {
        this.taxRate = rate;
    }


    private void run() {
        taxRate.calculateTax(getIncome());
        System.out.println();
//        double tax = taxRate.calculateTax(getIncome());
//        System.out.println(tax);
    }

    public static void demo() {
        final double annualIncome = 169480.75;
        HRBlock obj = new HRBlock(annualIncome);

        System.out.println();
        System.out.println("Calculating Personal Tax Strategy");
        obj.setTaxRate( new PersonalTaxStrategy() );
        obj.run();	// calculate taxes


        System.out.println();
        System.out.println("Calculating Personal Tax Penalty Strategy");
        obj.setTaxRate( new PersonalTaxPenaltyStrategy() );
        obj.run();	// calculate taxes

        System.out.println();
        System.out.println("Calculating Personal TaxRebate Strategy");
        obj.setTaxRate( new PersonalTaxRebateStrategy() );
        obj.run();	// calculate taxes
    }
}
