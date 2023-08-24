package com.web.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Address {

	@Id
	private Integer aid;
	private String villageName;
	private Integer pincode;
}
