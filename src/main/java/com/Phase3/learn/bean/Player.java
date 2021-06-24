package com.Phase3.learn.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Player {
	@Id
	@Column(name = "player_id")
	private String id;
	@Column(name = "player_name")
	private String name;
	@Column(name = "ratings")
	private double ratings;
}
