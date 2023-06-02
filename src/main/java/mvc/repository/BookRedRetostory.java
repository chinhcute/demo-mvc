package mvc.repository;

import mvc.entity.BookRedEntity;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@Repository
public class BookRedRetostory {
    private List<BookRedEntity> bookRedEntities = new ArrayList<>();
    @PostConstruct
    public void init(){
        bookRedEntities.add(new BookRedEntity(1, 100.00,"chinh", "Roger"));
        bookRedEntities.add(new BookRedEntity(2, 100.00,"vien", "Roger ok"));
    }
    public List<BookRedEntity> findAll(){
        return bookRedEntities;
    }
}
