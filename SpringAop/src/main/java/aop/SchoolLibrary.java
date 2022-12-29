package aop;

import org.springframework.stereotype.Component;

@Component("schoolBean")
public class SchoolLibrary extends AbstractLibrary{
    @Override
    public void getBook() {
        System.out.println("take book school");
    }
}
