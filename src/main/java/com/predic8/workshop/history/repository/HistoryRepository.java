package com.predic8.workshop.history.repository;

import com.predic8.workshop.history.domain.History;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface HistoryRepository extends CrudRepository<History, String> {
	List<History> findAllByCustomerId(String customerId);
}
