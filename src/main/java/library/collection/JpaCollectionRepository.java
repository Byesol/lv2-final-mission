package library.collection;

import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaCollectionRepository extends CollectionRepository, JpaRepository<Collection, Long> {


}
