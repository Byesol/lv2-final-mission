package library.borrow;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import library.collection.Collection;

@Entity
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "collection_id")
    private Collection collection;

    private LocalDate dueDate;

    public Collection getCollection() {
        return collection;
    }

    public Long getId() {
        return id;
    }
}
