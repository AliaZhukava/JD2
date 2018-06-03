package by.itacademy.repository;

import by.itacademy.config.TestConfig;
import by.itacademy.entity.Review;
import by.itacademy.util.DatabaseHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@Transactional
public class ReviewRepositoryTest {

    @Autowired
    private DatabaseHelper databaseHelper;

    @Autowired
    private ReviewRepository reviewRepository;

    @Before
    public void init() {
        databaseHelper.cleanDatabase();
        databaseHelper.prepareData();
    }

    @Test
    public void checkSave(){
        Review savedReview = reviewRepository.save(new Review(LocalDate.now(), "pass1", user5));
        assertThat(savedReview.getText(). equalTo("pass1"));
    }

    @Test
    public void checkFindAll(){
        Iterable<Review> reviews = reviewRepository.findAll(PageRequest.of(0, 2));
        List<Object> values = new ArrayList<>();
        reviews.forEach(values::add);
        final int expectedSize = 4;
        assertThat(values, hasSize(expectedSize));
    }

    @Test
    public void checkFindAllByClientNameLike(){
        Iterable<Review> reviews = reviewRepository.findAllByClientNameLike("user%");
        List<Object> values = new ArrayList<>();
        reviews.forEach(values::add);
        final int expectedSize = 4;
        assertThat(values, hasSize(expectedSize));
    }

    @Test
    public void checkDelete(){
        reviewRepository.delete(review1);
        Iterable<Review> reviews = reviewRepository.findAll();
        List<Object> values = new ArrayList<>();
        reviews.forEach(values::add);
        final int expectedSize = 3;
        assertThat(values, hasSize(expectedSize));
    }
}
