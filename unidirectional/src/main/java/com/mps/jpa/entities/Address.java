package com.mps.jpa.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.LockModeType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
/**
 * @author manvendrasingh
 *
 */
@Entity 
@Table(name = "ADDRESS")
@NamedQueries({
	@NamedQuery(name = "Address.findAddressByZip",query = "SELECT c FROM Address c WHERE c.zip = :zip order by c.street",lockMode = LockModeType.READ),
	@NamedQuery(name = "Address.findAddressByStreet",query = "SELECT c FROM Address c WHERE c.street = :street order by c.city,c.addressLine1",lockMode = LockModeType.READ)		
})
public class Address {

	@Id
	@GeneratedValue
	private long id;
	
	private String addressLine1;
	private String street;
	private String city;
	private String state;
	private String zip;
	
	@ManyToOne(optional = false,cascade = {CascadeType.PERSIST})
	@JoinColumn(name="COUNTRY_ID")
	private Country country;
	

	
	
	@Override
	public int hashCode() {
		final int prime  = 31;
		int       result = 1;
		result = prime * result + ((addressLine1 == null) ? 0 : addressLine1.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
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
		if (!(obj instanceof Address)) {
			return false;
		}
		Address other = (Address) obj;
		if (addressLine1 == null) {
			if (other.addressLine1 != null) {
				return false;
			}
		} else if (!addressLine1.equals(other.addressLine1)) {
			return false;
		}
		if (city == null) {
			if (other.city != null) {
				return false;
			}
		} else if (!city.equals(other.city)) {
			return false;
		}
		if (country == null) {
			if (other.country != null) {
				return false;
			}
		} else if (!country.equals(other.country)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (state == null) {
			if (other.state != null) {
				return false;
			}
		} else if (!state.equals(other.state)) {
			return false;
		}
		if (street == null) {
			if (other.street != null) {
				return false;
			}
		} else if (!street.equals(other.street)) {
			return false;
		}
		if (zip == null) {
			if (other.zip != null) {
				return false;
			}
		} else if (!zip.equals(other.zip)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", addressLine1=" + addressLine1+ ", street=" + street  + ", city=" + city + ", state=" + state + ", zip=" + zip + ", country=" + country + "]";
	}

	public long getId() {
		return id;
	}

	public String getStreet() {
		return street;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}

	public Country getCountry() {
		return country;
	}

	
	
	
	public Address setId(long id) {
		this.id = id;
		return this;
	}

	public Address setStreet(String street) {
		this.street = street;
		return this;
	}

	public Address setAddressLine2(String addressLine2) {
		this.addressLine1 = addressLine2;
		return this;
	}

	public Address setCity(String city) {
		this.city = city;
		return this;
	}

	public Address setState(String state) {
		this.state = state;
		return this;
	}

	public Address setZip(String zip) {
		this.zip = zip;
		return this;
	}

	public Address setCountry(Country country) {
		this.country = country;
		return this;
	}
	

}

