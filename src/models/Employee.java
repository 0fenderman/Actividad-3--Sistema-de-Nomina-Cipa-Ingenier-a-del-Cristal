package models;

import java.time.LocalDate;

/**
 * Clase abstracta base para todos los tipos de empleados.
 * Implementa el principio SOLID: Single Responsibility Principle (SRP)
 * - Responsabilidad única: Representar datos básicos de un empleado
 */
public abstract class Employee {
    
    protected String id;
    protected String name;
    protected LocalDate hireDate;
    protected boolean isPermanent;
    
    /**
     * Constructor base para todos los empleados
     */
    public Employee(String id, String name, LocalDate hireDate, boolean isPermanent) {
        this.id = id;
        this.name = name;
        this.hireDate = hireDate;
        this.isPermanent = isPermanent;
    }
    
    // Getters
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public LocalDate getHireDate() {
        return hireDate;
    }
    
    public boolean isPermanent() {
        return isPermanent;
    }
    
    /**
     * Calcula los años de antigüedad del empleado
     */
    public int getYearsOfService() {
        return LocalDate.now().getYear() - hireDate.getYear();
    }
    
    /**
     * Método abstracto para calcular el salario bruto
     */
    public abstract double calculateGrossSalary();
    
    /**
     * Método abstracto para calcular bonos
     */
    public abstract double calculateBonuses();
    
    @Override
    public String toString() {
        return String.format("ID: %s | Nombre: %s | Fecha Contratación: %s | Permanente: %s",
                id, name, hireDate, isPermanent ? "Sí" : "No");
    }
}