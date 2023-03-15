package com.jpa.test.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue
	private int id;


	@Column(name = "name")
	private String name;



	@Column(name = "city")
	private String city;


	@Column(name = "status")
	private String status;



//	public int getId() {
//		return id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public String getCity() {
//		return city;
//	}
//
//	public String getStatus() {
//		return status;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}

//	public User(int id, String name, String city, String status) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.city = city;
//		this.status = status;
//	}

//	public User() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

//	@Override
//	public String toString() {
//		return "User [id=" + id + ", name=" + name + ", city=" + city + ", status=" + status + "]";
//	}

}
