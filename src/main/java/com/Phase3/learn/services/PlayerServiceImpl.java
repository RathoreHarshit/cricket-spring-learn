package com.Phase3.learn.services;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Phase3.learn.bean.Player;
import com.Phase3.learn.repo.PlayerDao;



@Service
public class PlayerServiceImpl implements PlayerService{
	private PlayerDao playerDao;

	public PlayerServiceImpl(PlayerDao playerDao) {

		this.playerDao = playerDao;
	}

	@Override
	@Transactional
	public Iterable<Player> getAllPlayer() {
		// TODO Auto-generated method stub
		return playerDao.findAll();
	}

	@Override
	@Transactional
	public Optional<Player> findPlayerById(String id) {
		// TODO Auto-generated method stub
		return playerDao.findById(id);
	}

	@Override
	@Transactional
	public Optional<Player> findPlayerByName(String name) {
		// TODO Auto-generated method stub
		return playerDao.findByName(name);
	}

	@Override
	@Transactional
	public void createPlayer(Player player) {
		// TODO Auto-generated method stub
		playerDao.save(player);
		
	}

	@Override
	@Transactional
	public void deletePlayerById(String id) {
		// TODO Auto-generated method stub
		playerDao.deleteById(id);
		
	}

	@Override
	@Transactional
	public void deletePlayerByName(String name) {
		// TODO Auto-generated method stub
		playerDao.deleteByName(name);
	}

	
	

	}

