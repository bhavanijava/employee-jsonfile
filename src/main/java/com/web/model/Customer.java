package com.web.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Customer {

	@Id
	private Integer id;
	private String name;
	private Integer age;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aid_fk", referencedColumnName = "aid")
	private Address address;
}
