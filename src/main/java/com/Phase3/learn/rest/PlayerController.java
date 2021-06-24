package com.Phase3.learn.rest;


import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Phase3.learn.bean.Player;
import com.Phase3.learn.services.PlayerService;
@RestController
@RequestMapping("/api")
public class PlayerController {
	
		private PlayerService playerService;

		public PlayerController(PlayerService playerService) {
			this.playerService = playerService;
		}

		@GetMapping("/players")
		public ResponseEntity<Iterable<Player>> getAllPlayers() {
			return ResponseEntity.ok(playerService.getAllPlayer());
		}

		@GetMapping("/players/id/{player_id}")
		public ResponseEntity<Optional<Player>> findPlayerById(@PathVariable("player_id") String id) {
			Optional<Player> ply=playerService.findPlayerById(id);

				if(ply.isPresent())
				return ResponseEntity.status(HttpStatus.FOUND).body(ply);
				else
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ply);
		}

		@GetMapping("/players/name/{player_name}")
		public ResponseEntity<Optional<Player>> findPlayerByName(@PathVariable("player_name") String name) {
			Optional<Player> ply=playerService.findPlayerByName(name);
			if(ply.isPresent())
			return new ResponseEntity<Optional<Player>>(ply, HttpStatus.FOUND);
			else
				return new ResponseEntity<Optional<Player>>(ply, HttpStatus.NOT_FOUND);
		}
		
		@PostMapping("/players")
		public ResponseEntity<HttpStatus> createPlayer(@RequestBody Player player) {
			try {
				playerService.createPlayer(player);
				return new ResponseEntity<>(HttpStatus.CREATED);
			}
			catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@DeleteMapping("/players/id/{id}")
		public ResponseEntity<HttpStatus> deletePlayerById(@PathVariable String id) {
			try {
				playerService.deletePlayerById(id);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@DeleteMapping("/players/name/{name}")
		public ResponseEntity<HttpStatus> deletePlayerByName(@PathVariable String name) {
			try {
				playerService.deletePlayerByName(name);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}


		
	}	

