package com.dailystatus.dailystatus.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dailystatus.dailystatus.dto.UserDto;
import com.dailystatus.dailystatus.entity.Roles;
import com.dailystatus.dailystatus.entity.User;
import com.dailystatus.dailystatus.repo.UserRepo;

@RestController
public class UserController {
	@Autowired
	UserRepo userRepo;

	@PostMapping("/users")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		userRepo.save(user);

		return ResponseEntity.accepted().body(user);

	}

	@GetMapping("/users")
	public List<UserDto> getusers() {

		List<User> users = userRepo.findAll();
		List<UserDto> userdtos = new ArrayList<>();
		for (User user : users) {

			userdtos.add(getuserDto(user));
		}
		return userdtos;

	}

	@GetMapping("/users/{id}")
	public UserDto getuser(@PathVariable String id) {

		Optional<User> uo = userRepo.findById(id);
		User u = uo.get();
		UserDto user = getuserDto(u);

		return user;

	}

	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String id) {
		Optional<User> users = userRepo.findById(id);
		if (!users.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		user.setId(id);
		userRepo.save(user);
		return ResponseEntity.noContent().build();

	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable String id) {
		userRepo.deleteById(id);
	}

	public static UserDto getuserDto(User u) {

		UserDto user = new UserDto();
		Set<String> s = new HashSet<>();
		if (u != null) {

			user.setId(u.getId());
			user.setName(u.getName());
			user.setEmail(u.getEmail());
			user.setPassword(u.getPassword());
			for (Roles r : u.getRoles()) {
				s.add(r.getName());
			}
			user.setRoles(s);
		}
		return user;
	}
}
