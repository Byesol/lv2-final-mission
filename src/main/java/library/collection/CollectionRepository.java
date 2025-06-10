package library.collection;

import java.util.List;
import java.util.Optional;

public interface CollectionRepository {

    List<Collection> findByBookId(Long bookId);

    Optional<Collection> findById(Long id);

}
