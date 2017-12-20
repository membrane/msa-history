package com.predic8.workshop.history.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.predic8.workshop.history.bo.Article;
import com.predic8.workshop.history.bo.Basket;
import com.predic8.workshop.history.domain.History;
import com.predic8.workshop.history.repository.HistoryRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Service
public class BasketListener {
	private final ObjectMapper mapper;
	private final HistoryRepository historyRepository;

	public BasketListener(ObjectMapper mapper, HistoryRepository historyRepository) {
		this.mapper = mapper;
		this.historyRepository = historyRepository;
	}

	@KafkaListener(topics = "shop")
	public void listen(Operation op) throws IOException {
		if (!op.getBo().equals("basket")) {
			return;
		}

		if (!op.getAction().equals("create")) {
			return;
		}

		op.logReceive();

		Basket basket = mapper.convertValue(op.getObject(), Basket.class);

		List<String> articleIds = basket
			.getItems()
			.stream()
			.map(Article::getArticle).collect(toList());

		historyRepository.save(new History(basket.getCustomer(), articleIds));
	}
}