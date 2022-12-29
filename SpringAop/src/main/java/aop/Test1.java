package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        UniLibrary uniLibrary = context.getBean("libraryBean", UniLibrary.class);
        uniLibrary.getBook();
        uniLibrary.getMagazine();
        uniLibrary.addBook();
//        uniLibrary.addBook();
//        uniLibrary.returnBook();
//        uniLibrary.addMagazine();
//        uniLibrary.returnMagazine();

        context.close();
    }
}
