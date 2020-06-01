/**
 * 
 */
package com.finapps.management.finans.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
}
