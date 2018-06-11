package by.itacademy.service;

import by.itacademy.entity.Client;
import by.itacademy.entity.Review;
import by.itacademy.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ReviewService {

    public final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review save(Review review){
        return reviewRepository.save(review);
    }

    public List<Review> findAll(Pageable pageable) {
        Iterable<Review> reviews = reviewRepository.findAll(pageable);
        List<Review> values = new ArrayList<>();
        reviews.forEach(values::add);
        return values;
    }

    public List<Review> findAllByClientNameLike(String name){
        return reviewRepository.findAllByClientNameLike(name);
    }
}
