package com.intuit.demo.boot.appointment.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="pets")
public class Pet {

	@Id 
	@GeneratedValue
	@Column(name="pet_id")
	private  Long petId;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name = "pet_name")
	private String petName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "age")
	private Float age;
	
	@Column(name = "breed")
	private String breed;
	
	@Column(name = "gender")
	private String gender;
	
	
	public Pet() {
		
	}
	
	

	public Long getPetId() {
		return petId;
	}




	public void setPetId(Long petId) {
		this.petId = petId;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public String getPetName() {
		return petName;
	}




	public void setPetName(String petName) {
		this.petName = petName;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public Float getAge() {
		return age;
	}




	public void setAge(Float age) {
		this.age = age;
	}




	public String getBreed() {
		return breed;
	}




	public void setBreed(String breed) {
		this.breed = breed;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public Pet(Long petId, Long userId,String description, String petName, Float age, String breed, String gender) {
		super();
		this.petId = petId;
		User user=new User();
		
		this.user=user;
		this.description=description;
		this.petName = petName;
		this.age = age;
		this.breed = breed;
		this.gender = gender;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((breed == null) ? 0 : breed.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((petId == null) ? 0 : petId.hashCode());
		result = prime * result + ((petName == null) ? 0 : petName.hashCode());
		return result;
	}
	
	
	@Override
	public String toString() {
		return "Pet [petId=" + petId + ", petName=" + petName + ", age=" + age + ", breed=" + breed + ", gender="
				+ gender + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pet other = (Pet) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (breed == null) {
			if (other.breed != null)
				return false;
		} else if (!breed.equals(other.breed))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (petId == null) {
			if (other.petId != null)
				return false;
		} else if (!petId.equals(other.petId))
			return false;
		if (petName == null) {
			if (other.petName != null)
				return false;
		} else if (!petName.equals(other.petName))
			return false;
		return true;
	}
	
	
}
