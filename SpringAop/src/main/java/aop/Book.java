package aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:MyApp.properties")
public class Book {
    @Value("${War and Peace}")
    private String name;
    @Value("${author.name}")
    private String author;

    @Value("${1866}")
    private int yearOfPublic;

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublic() {
        return yearOfPublic;
    }

    public String getName() {
        return name;
    }
}
