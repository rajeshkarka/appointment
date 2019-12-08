package com.intuit.demo.boot.appointment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Pet {

	private @Id @GeneratedValue Long petId;
	private String petName;
	private Float age;
	private String breed;
	private String gender;
	
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
