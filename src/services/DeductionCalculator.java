package services;

/**
 * Clase responsable de calcular todas las deducciones obligatorias
 */
public class DeductionCalculator {
    
    private static final double SOCIAL_SECURITY_PERCENTAGE = 0.04;
    private static final double ARL_PERCENTAGE = 0.00522;
    
    /**
     * Calcula el total de deducciones para un empleado
     */
    public double calculateTotalDeductions(double grossSalary) {
        double socialSecurity = calculateSocialSecurity(grossSalary);
        double arl = calculateARL(grossSalary);
        return socialSecurity + arl;
    }
    
    /**
     * Calcula la deducción de seguro social y pensión (4%)
     */
    public double calculateSocialSecurity(double grossSalary) {
        return grossSalary * SOCIAL_SECURITY_PERCENTAGE;
    }
    
    /**
     * Calcula la deducción de ARL (0.522%)
     */
    public double calculateARL(double grossSalary) {
        return grossSalary * ARL_PERCENTAGE;
    }
    
    /**
     * Obtiene el porcentaje total de deducciones
     */
    public double getTotalDeductionPercentage() {
        return SOCIAL_SECURITY_PERCENTAGE + ARL_PERCENTAGE;
    }
}