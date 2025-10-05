package models;

import java.time.LocalDate;

/**
 * Clase para Empleado Asalariado
 * Reglas de negocio:
 * - Salario fijo mensual
 * - Bono del 10% si tiene más de 5 años en la empresa
 */
public class SalariedEmployee extends Employee {
    
    private double monthlySalary;
    private static final double SENIORITY_BONUS_PERCENTAGE = 0.10;
    private static final int YEARS_FOR_BONUS = 5;
    
    public SalariedEmployee(String id, String name, LocalDate hireDate, double monthlySalary) {
        super(id, name, hireDate, true);
        validateSalary(monthlySalary);
        this.monthlySalary = monthlySalary;
    }
    
    private void validateSalary(double salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("El salario debe ser mayor a cero");
        }
    }
    
    @Override
    public double calculateGrossSalary() {
        return monthlySalary;
    }
    
    @Override
    public double calculateBonuses() {
        double bonus = 0.0;
        if (getYearsOfService() > YEARS_FOR_BONUS) {
            bonus = monthlySalary * SENIORITY_BONUS_PERCENTAGE;
        }
        return bonus;
    }
    
    public double getMonthlySalary() {
        return monthlySalary;
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format(" | Tipo: Asalariado | Salario: $%.2f", monthlySalary);
    }
}
