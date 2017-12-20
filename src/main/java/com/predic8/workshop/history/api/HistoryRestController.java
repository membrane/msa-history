package com.predic8.workshop.history.api;

import com.predic8.workshop.history.domain.History;
import com.predic8.workshop.history.repository.HistoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/histories")
@RestController
public class HistoryRestController {
	private final HistoryRepository historyRepository;

	public HistoryRestController(HistoryRepository historyRepository) {
		this.historyRepository = historyRepository;
	}

	@GetMapping("/{id}")
	public List<History> show(@PathVariable String id) {
		return historyRepository.findAllByCustomerId(id);
	}
}