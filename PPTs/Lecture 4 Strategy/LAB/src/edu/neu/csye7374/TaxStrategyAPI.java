package edu.neu.csye7374;

@FunctionalInterface
public interface TaxStrategyAPI {
    double calculateTax(double income);
}
