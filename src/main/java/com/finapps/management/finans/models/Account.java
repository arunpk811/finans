package com.finapps.management.finans.models;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Account {
	@Id
	@GeneratedValue
	private Long id;
	private Long accountNumber;
	private Banks bank;
	private Double balance;
	private AccountType type;
	private Integer isActive;

	@ManyToOne
	@Getter(AccessLevel.NONE)
	private Users user;

}
