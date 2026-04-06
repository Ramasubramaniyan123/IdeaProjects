
package com.example.suggestionbox.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.suggestionbox.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
  List<Feedback> findByEmail(String email);
}
