package com.finapps.management.finans.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Users {
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String password;
	private int isActive;
	private Long role;
}
