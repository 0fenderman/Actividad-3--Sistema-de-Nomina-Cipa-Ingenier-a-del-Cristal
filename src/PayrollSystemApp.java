import models.*;
import services.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal del Sistema de Nómina
 */
public class PayrollSystemApp {
    
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║         SISTEMA DE NÓMINA - GESTIÓN DE EMPLEADOS         ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝\n");
        
        PayrollCalculator payrollCalculator = new PayrollCalculator();
        List<Employee> employees = new ArrayList<>();
        
        try {
            // EMPLEADO ASALARIADO
            System.out.println("Creando Empleado Asalariado...");
            SalariedEmployee emp1 = new SalariedEmployee(
                "001",
                "María González",
                LocalDate.of(2018, 3, 15),
                5000000.0
            );
            employees.add(emp1);
            
            // EMPLEADO POR HORAS
            System.out.println("Creando Empleado por Horas...");
            HourlyEmployee emp2 = new HourlyEmployee(
                "002",
                "Carlos Ramírez",
                LocalDate.of(2022, 8, 1),
                30000.0,
                true
            );
            emp2.setHoursWorked(50.0);
            employees.add(emp2);
            
            // EMPLEADO POR COMISIÓN
            System.out.println("Creando Empleado por Comisión...");
            CommissionEmployee emp3 = new CommissionEmployee(
                "003",
                "Ana Martínez",
                LocalDate.of(2020, 1, 10),
                3000000.0,
                0.05
            );
            emp3.setSalesAmount(25000000.0);
            employees.add(emp3);
            
            // EMPLEADO TEMPORAL
            System.out.println("Creando Empleado Temporal...");
            TemporaryEmployee emp4 = new TemporaryEmployee(
                "004",
                "Luis Fernández",
                LocalDate.of(2024, 6, 1),
                LocalDate.of(2025, 12, 31),
                2500000.0
            );
            employees.add(emp4);
            
            System.out.println("\n✓ Todos los empleados creados exitosamente\n");
            
            // GENERAR REPORTES
            System.out.println("Generando reportes de nómina...\n");
            
            for (Employee employee : employees) {
                PayrollReport report = payrollCalculator.generatePayrollReport(employee);
                System.out.println(report.generateDetailedReport());
            }
            
            // RESUMEN GENERAL
            generateSummary(employees, payrollCalculator);
            
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.err.println("Error en el sistema: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void generateSummary(List<Employee> employees, PayrollCalculator calculator) {
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                    RESUMEN GENERAL                       ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        
        double totalGross = 0.0;
        double totalNet = 0.0;
        double totalDeductions = 0.0;
        
        for (Employee emp : employees) {
            totalGross += emp.calculateGrossSalary() + emp.calculateBonuses();
            totalNet += calculator.calculateNetSalary(emp);
            totalDeductions += calculator.calculateDeductions(emp);
        }
        
        System.out.println(String.format("\nTotal Empleados:              %d", employees.size()));
        System.out.println(String.format("Total Salarios Brutos:        $%,.2f", totalGross));
        System.out.println(String.format("Total Deducciones:            $%,.2f", totalDeductions));
        System.out.println(String.format("Total Salarios Netos:         $%,.2f", totalNet));
        System.out.println("\n════════════════════════════════════════════════════════════\n");
    }
}