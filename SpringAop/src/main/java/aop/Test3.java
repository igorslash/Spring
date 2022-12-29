package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3 {
    public static void main(String[]args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        UniLibrary library = context.getBean("uniLibrary", UniLibrary.class);
        String bookName = library.returnBook();
        System.out.println("return book" + bookName);
        context.close();
    }
}
