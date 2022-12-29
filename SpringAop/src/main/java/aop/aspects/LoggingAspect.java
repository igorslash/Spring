package aop.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
@Order(1)//вызывает очередь вызовов классов
public class LoggingAspect {
    @Before("execution(public void get*(String))")//aop.UniLibrary.getBook = только класс UniLibrary
    // * = все пеараметры и геты;
    // *(*) = любой  1 тип параметров
    // *(..) = любоe  kolichestvo типoв параметров
    public void beforeAddAdvice() {
        System.out.println("before get book");
    }
    @Before("execution(public void getBook(aop.Book))")//(aop.Book, ..) может идти 0 или больше
    // параметров любого типа
    //(**(..) любого типа типoв параметров
    public void getBook() {
        System.out.println("get book UniLibrary");
    }
    //    @Before("execution(* returnBook())")
//    public void returnBook() {
//        System.out.println("return book");
//    }
    @After("execution(* returnBook())")// *,
    // * *() любой тип данных
    public void afterGetAdvice() {
        System.out.println("after get book");
    }
}
