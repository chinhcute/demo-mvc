package mvc.controller;

import mvc.entity.BookEntity;
import mvc.entity.CategoryEntity;
import mvc.repository.BookRedRetostory;
import mvc.repository.BookRepository;
import mvc.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/postman")
public class PostMan {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookRedRetostory bookRedRetostory;
    @Autowired
    CategoryRepository categoryRepository;
    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public Object getBook() {
        return (List<BookEntity>) bookRepository.findAll();
    }
    @RequestMapping("/hello")
    public String greeting(@RequestParam(name = "name") String name,
                           @RequestParam(name = "country", required = false, defaultValue = "viet nam")String country){
        return "hello"+name +"from" + country;
    }
    @RequestMapping(value = "/bookPost", method = RequestMethod.GET)
    public Object getAllBook(){
        List<BookRedEntity> bookEntityList = (List<BookRedEntity>) bookRedRetostory.findAll();
        return bookEntityList;
    }


    @RequestMapping(value = "/bookCategory", method = RequestMethod.GET)
    public Object getCategor(){
        List<CategoryEntity>  bookEntityList = (List<CategoryEntity>) categoryRepository.findAll();
        return bookEntityList;
    }
}
