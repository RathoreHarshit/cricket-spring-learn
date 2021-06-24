package com.Phase3.learn.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Phase3.learn.bean.Player;

@Repository
public interface PlayerDao extends JpaRepository<Player, String>{
	public Optional<Player> findByName(String name);
	public Iterable<Player> deleteByName(String name);
	
}