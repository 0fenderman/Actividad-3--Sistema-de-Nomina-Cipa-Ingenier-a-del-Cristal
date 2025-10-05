package models;

import java.time.LocalDate;

/**
 * Clase para Empleado Temporal
 */
public class TemporaryEmployee extends Employee {
    
    private double monthlySalary;
    private LocalDate contractEndDate;
    
    public TemporaryEmployee(String id, String name, LocalDate hireDate, 
                            LocalDate contractEndDate, double monthlySalary) {
        super(id, name, hireDate, false);
        validateSalary(monthlySalary);
        validateContractDates(hireDate, contractEndDate);
        this.monthlySalary = monthlySalary;
        this.contractEndDate = contractEndDate;
    }
    
    private void validateSalary(double salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("El salario debe ser mayor a cero");
        }
    }
    
    private void validateContractDates(LocalDate startDate, LocalDate endDate) {
        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException(
                "La fecha de fin del contrato debe ser posterior a la fecha de inicio"
            );
        }
    }
    
    public boolean isContractActive() {
        LocalDate today = LocalDate.now();
        return today.isBefore(contractEndDate) || today.isEqual(contractEndDate);
    }
    
    @Override
    public double calculateGrossSalary() {
        return monthlySalary;
    }
    
    @Override
    public double calculateBonuses() {
        return 0.0;
    }
    
    public double getMonthlySalary() {
        return monthlySalary;
    }
    
    public LocalDate getContractEndDate() {
        return contractEndDate;
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format(" | Tipo: Temporal | Salario: $%.2f | Fin Contrato: %s | Activo: %s", 
                                                monthlySalary, contractEndDate, 
                                                isContractActive() ? "Sí" : "No");
    }
}