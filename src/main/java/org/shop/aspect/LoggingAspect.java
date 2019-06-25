package org.shop.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
public class LoggingAspect {
    private static final Logger logger = LogManager.getLogger(LoggingAspect.class.getName());

    @Pointcut("execution(* org.shop.repository.map.*.*(..))")
    public void businessService() {
    }

    @Before("businessService()")
    public void beforeCall(JoinPoint joinPoint) {
        logger.info("Method: " + joinPoint.getSignature().toShortString() +
                " | args => " + Arrays.asList(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "businessService()", returning = "retVal")
    public void afterCall(JoinPoint joinPoint, Object retVal) {
        logger.info("Method: " + joinPoint.getSignature().toShortString() +
                " | returns => " + retVal);
    }
}
