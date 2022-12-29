package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        UniLibrary uniLibrary = context.getBean("libraryBean", UniLibrary.class);

        SchoolLibrary schoolLibrary = context.getBean("schoolBean", SchoolLibrary.class);

       // Book book = context.getBean("bookBean", Book.class);
        uniLibrary.getBook();
        schoolLibrary.getBook();
        uniLibrary.returnBook();
        context.close();
    }
}
