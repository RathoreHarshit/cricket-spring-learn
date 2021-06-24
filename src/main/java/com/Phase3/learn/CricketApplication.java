package com.Phase3.learn;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Phase3.learn.bean.Player;
import com.Phase3.learn.repo.PlayerDao;

@SpringBootApplication
public class CricketApplication implements CommandLineRunner{
	private PlayerDao playerDao;
	
	public CricketApplication(PlayerDao playerDao) {
		super();
		this.playerDao = playerDao;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CricketApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		playerDao.save(new Player(UUID.randomUUID().toString(), "John Doe", 80000.00));
		playerDao.save(new Player(UUID.randomUUID().toString(), "Mary Kom", 120000.00));
		playerDao.save(new Player(UUID.randomUUID().toString(), "DK", 200000.00));
	}
}
