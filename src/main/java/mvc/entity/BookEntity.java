package mvc.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;
    @NotEmpty(message = "gggggggg")
    @Column (name = "name")
    private String name;

    @Column (name = "author")
    private String author;

    @ManyToOne
    @JoinColumn(name= "categoryId")
    private CategoryEntity category;



    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "bookDetailsId")
    @PrimaryKeyJoinColumn
    @JsonBackReference
    private BookDetailsEntity bookDetails;

    public  BookEntity(){
    }
//    @Override
//    public String toString(){
//        return "BookEntity(" +
//                "id=" + id +
//                ",name='" + name + '\'' +
//                ",author='" + author + '\'' +
//                ",category=" + category.getName() + '}';
//    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public BookDetailsEntity getBookDetails() {
        return bookDetails;
    }

    public void setBookDetails(BookDetailsEntity bookDetails) {
        this.bookDetails = bookDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}