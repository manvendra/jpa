/**
 * 
 */
package com.mps.jpa.entities;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author manvendrasingh
 *
 */
@Entity
public class Person {
	@Id
	@GeneratedValue
	private long id;
	
	private String firstName;
	private String lastName;
	
 
		
	@ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
	private Address permanentAddress;
	
	@Embedded
	private PhoneNumber phoneNumber;
	
	
	
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName +  ", permanentAddress=" + permanentAddress + ", phoneNumber="
				+ phoneNumber + "]";
	}

	@Override
	public int hashCode() {
		final int prime  = 31;
		int       result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((permanentAddress == null) ? 0 : permanentAddress.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Person)) {
			return false;
		}
		Person other = (Person) obj;
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		
		if (permanentAddress == null) {
			if (other.permanentAddress != null) {
				return false;
			}
		} else if (!permanentAddress.equals(other.permanentAddress)) {
			return false;
		}
		if (phoneNumber == null) {
			if (other.phoneNumber != null) {
				return false;
			}
		} else if (!phoneNumber.equals(other.phoneNumber)) {
			return false;
		}
		return true;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * @return the permanentAddress
	 */
	public Address getPermanentAddress() {
		return permanentAddress;
	}

	/**
	 * @return the phoneNumber
	 */
	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param id the id to set
	 */
	public Person setId(long id) {
		this.id = id;
		return this;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public Person setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public Person setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	/**
	 * @param permanentAddress the permanentAddress to set
	 */
	public Person setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
		return this;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public Person setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	
	

}
