package aop.aspects;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
public class JoinPoint {//Join Point это точка выполнения соединения метода с бизнес-логикой и
    //метода со служебным функционалом
    @Before("aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint;
        System.out.println("methodSignature" + methodSignature.getName());
        if (methodSignature.getMethod().equals("addBook")) {
            //Object[] args = joinPoint.getArgs();
        }
    }
}
