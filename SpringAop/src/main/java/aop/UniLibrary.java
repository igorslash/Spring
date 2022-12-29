package aop;

import org.springframework.stereotype.Component;

@Component("libraryBean")
public class UniLibrary extends AbstractLibrary{
//    public void getBook(String bookName) {
//        System.out.println("take book from UniLibrary" + bookName);
//    }
    public void getBook(Book book) {
        System.out.println("take book from UniLibrary" + book.getName());
        System.out.println("-------------------------------------------------------------");
    }
    public String returnBook() {
        System.out.println("return uniLibrary");
        return "War and peace";
    }
    public void getMagazine() {
        System.out.println("get magazine from uniLibrary");
    }
    public void returnMagazine() {
        System.out.println("return magazine from uniLibrary");
    }
    public void addBook() {
        System.out.println("We add book uniLibrary");
    }
    public void addMagazine() {
        System.out.println("We add magazine");
    }

    @Override
    public void getBook() {}
}
