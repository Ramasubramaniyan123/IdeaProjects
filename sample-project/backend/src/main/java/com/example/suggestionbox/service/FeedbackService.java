
package com.example.suggestionbox.service;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.suggestionbox.repository.FeedbackRepository;
import com.example.suggestionbox.entity.Feedback;

@Service
public class FeedbackService {
  private final FeedbackRepository repo;
  public FeedbackService(FeedbackRepository repo) { this.repo = repo; }

  public Feedback save(Feedback f) {
    f.setStatus("OPEN");
    return repo.save(f);
  }

  public List<Feedback> getAll() {
    return repo.findAll();
  }

  public List<Feedback> getByEmail(String email) {
    return repo.findByEmail(email);
  }

  public Feedback updateStatus(Long id, String status) {
    Feedback f = repo.findById(id).orElseThrow();
    f.setStatus(status);
    return repo.save(f);
  }
}
