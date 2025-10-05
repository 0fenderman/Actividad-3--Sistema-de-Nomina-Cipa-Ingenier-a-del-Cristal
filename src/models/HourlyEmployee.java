package models;

import java.time.LocalDate;

/**
 * Clase para Empleado por Horas
 */
public class HourlyEmployee extends Employee {
    
    private double hourlyRate;
    private double hoursWorked;
    private boolean hasSavingsFundAccess;
    
    private static final double REGULAR_HOURS_LIMIT = 40.0;
    private static final double OVERTIME_MULTIPLIER = 1.5;
    private static final double SAVINGS_FUND_PERCENTAGE = 0.02;
    
    public HourlyEmployee(String id, String name, LocalDate hireDate, 
                         double hourlyRate, boolean hasSavingsFundAccess) {
        super(id, name, hireDate, false);
        validateHourlyRate(hourlyRate);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = 0.0;
        this.hasSavingsFundAccess = hasSavingsFundAccess;
    }
    
    private void validateHourlyRate(double rate) {
        if (rate <= 0) {
            throw new IllegalArgumentException("La tarifa por hora debe ser mayor a cero");
        }
    }
    
    private void validateHours(double hours) {
        if (hours < 0) {
            throw new IllegalArgumentException("Las horas trabajadas no pueden ser negativas");
        }
    }
    
    public void setHoursWorked(double hours) {
        validateHours(hours);
        this.hoursWorked = hours;
    }
    
    @Override
    public double calculateGrossSalary() {
        double regularPay = 0.0;
        double overtimePay = 0.0;
        
        if (hoursWorked <= REGULAR_HOURS_LIMIT) {
            regularPay = hoursWorked * hourlyRate;
        } else {
            regularPay = REGULAR_HOURS_LIMIT * hourlyRate;
            double overtimeHours = hoursWorked - REGULAR_HOURS_LIMIT;
            overtimePay = overtimeHours * hourlyRate * OVERTIME_MULTIPLIER;
        }
        
        return regularPay + overtimePay;
    }
    
    @Override
    public double calculateBonuses() {
        return 0.0;
    }
    
    public double calculateSavingsFund() {
        if (hasSavingsFundAccess && getYearsOfService() > 1) {
            return calculateGrossSalary() * SAVINGS_FUND_PERCENTAGE;
        }
        return 0.0;
    }
    
    public double getHourlyRate() {
        return hourlyRate;
    }
    
    public double getHoursWorked() {
        return hoursWorked;
    }
    
    public boolean hasSavingsFundAccess() {
        return hasSavingsFundAccess;
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format(" | Tipo: Por Horas | Tarifa: $%.2f | Horas: %.2f", 
                                                hourlyRate, hoursWorked);
    }
}
