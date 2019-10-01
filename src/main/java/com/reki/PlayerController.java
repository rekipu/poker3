package com.reki;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.reki.repositories.PlayerRepository;

@RestController
public class PlayerController {

	private final PlayerRepository repository;

	PlayerController(PlayerRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/players")
	List<Player> all() {
		return (List<Player>) repository.findAll();
	}

	@PostMapping("/players")
	Player newPlayer(@RequestBody Player player) {
		return repository.save(player);
	}

	// Single item

	@GetMapping("/players/{id}")
	Optional<Player> one(@PathVariable Long id) {
		return repository.findById(id);
	}

	/*
	 * @PutMapping("/players/{id}") Player replaceEmployee(@RequestBody Player
	 * newPlayer, @PathVariable Long id) { return repository.findById(id)
	 * .map(player -> { player.setName(newPlayer.getName());
	 * player.setDate(newPlayer.getDate()); return repository.save(player); })
	 * .orElseGet(() -> { newPlayer.setId(id); return repository.save(newPlayer);
	 * }); }
	 */

	@DeleteMapping("/players/{id}")
	void deletePlayer(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
