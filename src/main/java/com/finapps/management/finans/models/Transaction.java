/**
 * 
 */
package com.finapps.management.finans.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author arunp
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Transaction {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String description;
	private Float amount;
	private String type;
	private Date transactionDate;
	@Getter(AccessLevel.NONE)
	@ManyToOne
	private Users user;
}
