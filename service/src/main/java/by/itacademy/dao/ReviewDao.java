package by.itacademy.dao;

import by.itacademy.entity.Review;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ReviewDao extends BaseDao implements DaoInterface<Review, Long>{

    public final static ReviewDao INSTANCE = new ReviewDao();

    public static ReviewDao getInstance() {
        return INSTANCE;
    }

    @Override
    public Long save(Review entity) {
        return (Long)getCurrentSession().save(entity);
    }

    @Override
    public void update(Review entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Review findById(Long id) {
        Review review = getCurrentSession().get(Review.class, id);
        return review;

    }

    @Override
    public void delete(Review entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<Review> findAll() {
        List<Review> reviews = getCurrentSession().createQuery("from Review").list();
        return reviews;
    }
}
