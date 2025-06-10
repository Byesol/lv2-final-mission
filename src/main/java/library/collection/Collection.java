package library.collection;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import library.book.Book;


//- 청구기호,	소장처/자료실,	도서상태,	반납예정일
@Entity
public class Collection {
    @Id
    private Long id;
    private String location;
    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Book getBook() {
        return book;
    }

    public Long getId() {
        return id;
    }
}
