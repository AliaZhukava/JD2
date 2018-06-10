package by.itacademy.repository;

import by.itacademy.entity.Review;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

    List<Review> findAll(Pageable pageable);

    List<Review> findAllByClientNameLike(String name);
}
