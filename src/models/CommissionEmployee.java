package models;

import java.time.LocalDate;

/**
 * Clase para Empleado por Comisión
 */
public class CommissionEmployee extends Employee {
    
    private double baseSalary;
    private double commissionPercentage;
    private double salesAmount;
    
    private static final double SALES_THRESHOLD = 20000000.0;
    private static final double EXTRA_BONUS_PERCENTAGE = 0.03;
    
    public CommissionEmployee(String id, String name, LocalDate hireDate, 
                             double baseSalary, double commissionPercentage) {
        super(id, name, hireDate, true);
        validateBaseSalary(baseSalary);
        validateCommissionPercentage(commissionPercentage);
        this.baseSalary = baseSalary;
        this.commissionPercentage = commissionPercentage;
        this.salesAmount = 0.0;
    }
    
    private void validateBaseSalary(double salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("El salario base debe ser mayor a cero");
        }
    }
    
    private void validateCommissionPercentage(double percentage) {
        if (percentage < 0 || percentage > 1) {
            throw new IllegalArgumentException("El porcentaje de comisión debe estar entre 0 y 1");
        }
    }
    
    private void validateSales(double sales) {
        if (sales < 0) {
            throw new IllegalArgumentException("Las ventas no pueden ser menores a $0");
        }
    }
    
    public void setSalesAmount(double sales) {
        validateSales(sales);
        this.salesAmount = sales;
    }
    
    @Override
    public double calculateGrossSalary() {
        double commission = salesAmount * commissionPercentage;
        return baseSalary + commission;
    }
    
    @Override
    public double calculateBonuses() {
        double bonus = 0.0;
        if (salesAmount > SALES_THRESHOLD) {
            bonus = salesAmount * EXTRA_BONUS_PERCENTAGE;
        }
        return bonus;
    }
    
    public double getBaseSalary() {
        return baseSalary;
    }
    
    public double getCommissionPercentage() {
        return commissionPercentage;
    }
    
    public double getSalesAmount() {
        return salesAmount;
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format(" | Tipo: Comisión | Base: $%.2f | Ventas: $%.2f", 
                                                baseSalary, salesAmount);
    }
}