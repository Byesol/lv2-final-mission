package library.collection;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import library.book.Book;
import library.borrow.Borrow;
import library.reservation.domain.CollectionStatus;
import library.reservation.domain.Reservation;


//- 청구기호,	소장처/자료실,	도서상태,	반납예정일
@Entity
public class Collection {
    @Id
    private Long id;
    private String location;
    private LocalDate dueDate;
    @Enumerated(EnumType.STRING)
    private CollectionStatus collectionStatus;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @OneToMany(mappedBy = "collection")
    private List<Reservation> reservations = new ArrayList<>();

    @OneToOne(mappedBy = "collection")
    private Borrow borrow;

    public Book getBook() {
        return book;
    }

    public Long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public CollectionStatus getCollectionStatus() {
        return collectionStatus;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public Borrow getBorrow() {
        return borrow;
    }
}
