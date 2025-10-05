## 👥 Autores

**CIPA - Grupo [4]**

- Jose Daniel Argel Duarte 
- Juan Camilo Castilla Lopez
- Juan Camilo Sierra Vega 
- Carlos David Villab Paez 

**Universidad:** [Universidad De Cartagena ]
**Materia:** [Ingenieria En Software]
**Fecha:** Octubre 2025

# 💼 Sistema de Nómina - Gestión de Empleados

Sistema completo de gestión de nómina desarrollado en Java utilizando Programación Orientada a Objetos (POO), implementando principios SOLID, código limpio y buenas prácticas de desarrollo.

## 📋 Descripción

Sistema de nómina empresarial que permite gestionar diferentes tipos de empleados (Asalariados, Por Horas, Por Comisión y Temporales), calculando automáticamente salarios, bonos, beneficios y deducciones según las reglas de negocio establecidas.

## ✨ Características

- ✅ Gestión de 4 tipos diferentes de empleados
- ✅ Cálculo automático de salarios brutos y netos
- ✅ Manejo de bonos según antigüedad y desempeño
- ✅ Gestión de beneficios (alimentación, fondo de ahorro)
- ✅ Cálculo de deducciones obligatorias (Seguro Social, Pensión, ARL)
- ✅ Validaciones de negocio robustas
- ✅ Generación de reportes detallados de nómina

## 🛠️ Tecnologías Utilizadas

- **Lenguaje:** Java 11+
- **Entorno de Desarrollo:** Visual Studio Code
- **Paradigma:** Programación Orientada a Objetos (POO)

## 📁 Estructura del Proyecto
payroll-system/
│
├── src/
│   ├── models/                      # Modelos de dominio
│   │   ├── Employee.java           # Clase abstracta base
│   │   ├── SalariedEmployee.java   # Empleado asalariado
│   │   ├── HourlyEmployee.java     # Empleado por horas
│   │   ├── CommissionEmployee.java # Empleado por comisión
│   │   └── TemporaryEmployee.java  # Empleado temporal
│   │
│   ├── services/                    # Lógica de negocio
│   │   ├── PayrollCalculator.java  # Calculadora principal
│   │   ├── DeductionCalculator.java # Cálculo de deducciones
│   │   ├── BenefitCalculator.java  # Cálculo de beneficios
│   │   └── PayrollReport.java      # Generador de reportes
│   │
│   ├── interfaces/                  # Contratos
│   │   └── IPayrollCalculator.java # Interface principal
│   │
│   └── PayrollSystemApp.java       # Aplicación principal
│
└── README.md                        # Documentación

## 🎯 Principios SOLID Implementados

### 1. Single Responsibility Principle (SRP)
Cada clase tiene una única responsabilidad:
- `Employee`: Representar datos básicos de empleados
- `DeductionCalculator`: Calcular deducciones
- `BenefitCalculator`: Calcular beneficios

### 2. Open/Closed Principle (OCP)
Nuevos tipos de empleados pueden agregarse sin modificar código existente

### 3. Liskov Substitution Principle (LSP)
Cualquier tipo de empleado puede sustituir a la clase base `Employee`

### 4. Interface Segregation Principle (ISP)
Interface `IPayrollCalculator` con métodos específicos y cohesivos

### 5. Dependency Inversion Principle (DIP)
`PayrollCalculator` depende de abstracciones, no implementaciones concretas

## 📜 Reglas de Negocio

### Tipos de Empleados

#### 🏢 Empleado Asalariado
- Salario fijo mensual
- **Bono:** 10% del salario si tiene más de 5 años en la empresa

#### ⏰ Empleado por Horas
- Pago por horas trabajadas (tarifa base por hora)
- **Horas extras:** Más de 40 horas se pagan a 1.5x la tarifa normal
- **Fondo de ahorro:** 2% si tiene más de 1 año y acepta el beneficio

#### 💰 Empleado por Comisión
- Salario base + porcentaje de comisión sobre ventas
- **Bono adicional:** 3% sobre ventas si superan $20.000.000

#### 📅 Empleado Temporal
- Salario fijo mensual
- Contrato por tiempo definido
- **No aplican** bonos ni beneficios adicionales

### Deducciones Obligatorias

- **Seguro Social y Pensión:** 4% del salario bruto
- **ARL:** 0.522% del salario bruto
- **Total deducciones:** 4.522%

### Beneficios Adicionales

- **Bono de Alimentación:** $1.000.000/mes para empleados permanentes
- **Fondo de Ahorro:** 2% para empleados por horas con más de 1 año (opcional)

## 🚀 Instalación y Ejecución

### Compilar el proyecto
```bash
javac -d bin src/models/*.java src/interfaces/*.java src/services/*.java src/PayrollSystemApp.java