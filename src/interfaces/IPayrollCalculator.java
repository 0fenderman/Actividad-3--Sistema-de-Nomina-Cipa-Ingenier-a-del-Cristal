package interfaces;

import models.Employee;

/**
 * Interface para cálculo de nómina
 * Implementa el principio SOLID: Interface Segregation Principle (ISP)
 */
public interface IPayrollCalculator {
    
    /**
     * Calcula el salario neto del empleado
     */
    double calculateNetSalary(Employee employee);
    
    /**
     * Calcula las deducciones totales
     */
    double calculateDeductions(Employee employee);
    
    /**
     * Calcula los beneficios totales
     */
    double calculateBenefits(Employee employee);
}
