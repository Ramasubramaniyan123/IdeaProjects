
package com.example.suggestionbox.controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.suggestionbox.service.FeedbackService;
import com.example.suggestionbox.entity.Feedback;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin
public class FeedbackController {
  private final FeedbackService service;
  public FeedbackController(FeedbackService service) { this.service = service; }

  @PostMapping
  public Feedback submit(@RequestBody Feedback f) {
    return service.save(f);
  }

  @GetMapping
  public List<Feedback> all() {
    return service.getAll();
  }

  @GetMapping("/user/{email}")
  public List<Feedback> byUser(@PathVariable String email) {
    return service.getByEmail(email);
  }

  @PutMapping("/{id}/status")
  public Feedback update(@PathVariable Long id, @RequestParam String status) {
    return service.updateStatus(id, status);
  }
}
