
package com.employee;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.employee.EmployeeService.*(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {

        String methodName = joinPoint.getSignature().getName();

        switch (methodName) {
            case "addEmployee":
                System.out.println("Logging: Adding employee");
                break;

            case "displayEmployee":
                System.out.println("Logging: Displaying employee");
                break;

            case "calculateSalary":
                System.out.println("Logging: Calculating salary");
                break;

            default:
                System.out.println("Logging: Employee service method executing");
        }
    }
}
