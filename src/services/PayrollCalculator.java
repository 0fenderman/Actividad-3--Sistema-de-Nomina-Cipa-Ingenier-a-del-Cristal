package services;

import interfaces.IPayrollCalculator;
import models.Employee;

/**
 * Implementación principal del calculador de nómina
 */
public class PayrollCalculator implements IPayrollCalculator {
    
    private DeductionCalculator deductionCalculator;
    private BenefitCalculator benefitCalculator;
    
    public PayrollCalculator() {
        this.deductionCalculator = new DeductionCalculator();
        this.benefitCalculator = new BenefitCalculator();
    }
    
    public PayrollCalculator(DeductionCalculator deductionCalculator, 
                            BenefitCalculator benefitCalculator) {
        this.deductionCalculator = deductionCalculator;
        this.benefitCalculator = benefitCalculator;
    }
    
    @Override
    public double calculateNetSalary(Employee employee) {
        double grossSalary = employee.calculateGrossSalary();
        double bonuses = employee.calculateBonuses();
        double benefits = calculateBenefits(employee);
        double deductions = calculateDeductions(employee);
        
        double netSalary = (grossSalary + bonuses + benefits) - deductions;
        
        if (netSalary < 0) {
            throw new IllegalStateException(
                String.format("Error: El salario neto del empleado %s no puede ser negativo. " +
                             "Salario neto calculado: $%.2f", 
                             employee.getName(), netSalary)
            );
        }
        
        return netSalary;
    }
    
    @Override
    public double calculateDeductions(Employee employee) {
        double grossSalary = employee.calculateGrossSalary();
        double bonuses = employee.calculateBonuses();
        double baseForDeductions = grossSalary + bonuses;
        return deductionCalculator.calculateTotalDeductions(baseForDeductions);
    }
    
    @Override
    public double calculateBenefits(Employee employee) {
        return benefitCalculator.calculateTotalBenefits(employee);
    }
    
    /**
     * Genera un reporte detallado de la nómina
     */
    public PayrollReport generatePayrollReport(Employee employee) {
        double grossSalary = employee.calculateGrossSalary();
        double bonuses = employee.calculateBonuses();
        double benefits = calculateBenefits(employee);
        double deductions = calculateDeductions(employee);
        double netSalary = calculateNetSalary(employee);
        
        return new PayrollReport(
            employee,
            grossSalary,
            bonuses,
            benefits,
            deductions,
            netSalary
        );
    }
}
