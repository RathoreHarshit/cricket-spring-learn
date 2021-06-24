package com.Phase3.learn.services;

import java.util.Optional;

import com.Phase3.learn.bean.Player;

public interface PlayerService {
	public Iterable<Player> getAllPlayer();

	public Optional<Player> findPlayerById(String id);

	public Optional<Player> findPlayerByName(String name);
	
	public void createPlayer(Player player);
	public void deletePlayerById(String id);

	public void deletePlayerByName(String name);

	
}
