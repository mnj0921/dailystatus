package com.dailystatus.dailystatus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dailystatus.dailystatus.entity.Status;
import com.dailystatus.dailystatus.repo.StatusRepo;

@RestController
public class StatusController {

	@Autowired
	StatusRepo strepo;

	@GetMapping("/status")
	public List<Status> getAllStatus() {
		return strepo.findAll();
	}
	
	@GetMapping("/status/{id}")
	public Optional<Status> status(@PathVariable Long id ) {
		return strepo.findById(id);
	}
	
	@PostMapping("/status")
	public ResponseEntity<Status> addStatus(@RequestBody Status status) {
		strepo.save(status);
		return ResponseEntity.accepted().body(status);

	}
	
	@PutMapping("/status/{id}")
	public ResponseEntity<Status> updateStatus(@RequestBody Status status, @PathVariable Long id) {
		Optional<Status> statuses = strepo.findById(id);
		if (!statuses.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		status.setId(id);
		strepo.save(status);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/status/{id}")
	public void deleteStatus(@PathVariable Long id) {
		strepo.deleteById(id);
	}
}
