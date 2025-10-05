package services;

import models.Employee;
import java.time.LocalDate;

/**
 * Clase que representa un reporte completo de nómina
 */
public class PayrollReport {
    
    private Employee employee;
    private double grossSalary;
    private double bonuses;
    private double benefits;
    private double deductions;
    private double netSalary;
    private LocalDate reportDate;
    
    public PayrollReport(Employee employee, double grossSalary, double bonuses, 
                        double benefits, double deductions, double netSalary) {
        this.employee = employee;
        this.grossSalary = grossSalary;
        this.bonuses = bonuses;
        this.benefits = benefits;
        this.deductions = deductions;
        this.netSalary = netSalary;
        this.reportDate = LocalDate.now();
    }
    
    public Employee getEmployee() {
        return employee;
    }
    
    public double getGrossSalary() {
        return grossSalary;
    }
    
    public double getBonuses() {
        return bonuses;
    }
    
    public double getBenefits() {
        return benefits;
    }
    
    public double getDeductions() {
        return deductions;
    }
    
    public double getNetSalary() {
        return netSalary;
    }
    
    public LocalDate getReportDate() {
        return reportDate;
    }
    
    /**
     * Genera un reporte detallado en formato de texto
     */
    public String generateDetailedReport() {
        StringBuilder report = new StringBuilder();
        report.append("\n════════════════════════════════════════════════════════════\n");
        report.append("                    REPORTE DE NÓMINA\n");
        report.append("════════════════════════════════════════════════════════════\n");
        report.append(String.format("Fecha del Reporte: %s\n", reportDate));
        report.append("────────────────────────────────────────────────────────────\n");
        report.append("INFORMACIÓN DEL EMPLEADO\n");
        report.append("────────────────────────────────────────────────────────────\n");
        report.append(String.format("ID: %s\n", employee.getId()));
        report.append(String.format("Nombre: %s\n", employee.getName()));
        report.append(String.format("Fecha de Contratación: %s\n", employee.getHireDate()));
        report.append(String.format("Años de Servicio: %d\n", employee.getYearsOfService()));
        report.append(String.format("Tipo: %s\n", employee.isPermanent() ? "Permanente" : "No Permanente"));
        report.append("\n────────────────────────────────────────────────────────────\n");
        report.append("DETALLES DE PAGO\n");
        report.append("────────────────────────────────────────────────────────────\n");
        report.append(String.format("Salario Bruto:           $%,15.2f\n", grossSalary));
        report.append(String.format("Bonos:                   $%,15.2f\n", bonuses));
        report.append(String.format("Beneficios:              $%,15.2f\n", benefits));
        report.append("                         ─────────────────────\n");
        report.append(String.format("Subtotal:                $%,15.2f\n", 
                                    grossSalary + bonuses + benefits));
        report.append("\n────────────────────────────────────────────────────────────\n");
        report.append("DEDUCCIONES\n");
        report.append("────────────────────────────────────────────────────────────\n");
        report.append(String.format("Total Deducciones:       $%,15.2f\n", deductions));
        report.append("\n════════════════════════════════════════════════════════════\n");
        report.append(String.format("SALARIO NETO:            $%,15.2f\n", netSalary));
        report.append("════════════════════════════════════════════════════════════\n");
        
        return report.toString();
    }
    
    @Override
    public String toString() {
        return String.format("Reporte[%s - %s] Neto: $%.2f", 
                           employee.getName(), reportDate, netSalary);
    }
}