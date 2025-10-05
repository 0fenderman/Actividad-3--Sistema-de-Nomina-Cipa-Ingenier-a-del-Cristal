package services;

import models.Employee;
import models.HourlyEmployee;

/**
 * Clase responsable de calcular todos los beneficios adicionales
 */
public class BenefitCalculator {
    
    private static final double FOOD_ALLOWANCE = 1000000.0;
    
    /**
     * Calcula el total de beneficios para un empleado
     */
    public double calculateTotalBenefits(Employee employee) {
        double foodAllowance = calculateFoodAllowance(employee);
        double savingsFund = calculateSavingsFund(employee);
        return foodAllowance + savingsFund;
    }
    
    /**
     * Calcula el bono de alimentación
     * Solo aplica para empleados permanentes
     */
    public double calculateFoodAllowance(Employee employee) {
        if (employee.isPermanent()) {
            return FOOD_ALLOWANCE;
        }
        return 0.0;
    }
    
    /**
     * Calcula el aporte al fondo de ahorro
     * Solo aplica para empleados por hora con más de 1 año
     */
    public double calculateSavingsFund(Employee employee) {
        if (employee instanceof HourlyEmployee) {
            HourlyEmployee hourlyEmp = (HourlyEmployee) employee;
            return hourlyEmp.calculateSavingsFund();
        }
        return 0.0;
    }
    
    public double getFoodAllowanceAmount() {
        return FOOD_ALLOWANCE;
    }
}