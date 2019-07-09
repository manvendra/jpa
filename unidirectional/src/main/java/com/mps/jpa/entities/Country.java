package com.mps.jpa.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author manvendrasingh
 *
 */
@Entity
@Table(name = "COUNTRIES")
@NamedQueries({
		@NamedQuery(name = "Country.findCountryByName", query = "SELECT c FROM Country c WHERE c.countryName = :countryName"),
		@NamedQuery(name = "Country.findCountryByCode", query = "SELECT c FROM Country c WHERE c.countryCode = :countryCode") })
public class Country {

	@Id
	@GeneratedValue //If this annotation is not present then ManyToOne on Address was throwing Exception
	//javax.persistence.EntityExistsException: A different object with the same identifier value was already associated with the session : [com.mps.jpa.entities.Country#0]
	private int id;

	private String countryCode;
	private String countryName;
	private String currencyCode;
	private String capital;

	@ManyToOne(cascade = {CascadeType.PERSIST})
	public Continent continent;

	
	public Country setId(int id) {
		this.id = id;
		return this;
	}

	public Country setCountryCode(String countryCode) {
		this.countryCode = countryCode;
		return this;
	}

	public Country setCountryName(String countryName) {
		this.countryName = countryName;
		return this;
	}

	public Country setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
		return this;
	}

	public Country setCapital(String capital) {
		this.capital = capital;
		return this;
	}

	public Country setContinent(Continent continent) {
		this.continent = continent;
		return this;
	}

	public long getId() {
		return id;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public String getCapital() {
		return capital;
	}

	public Continent getContinent() {
		return continent;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", countryCode=" + countryCode + ", countryName=" + countryName + ", currencyCode="
				+ currencyCode + ", capital=" + capital + ", continent=" + continent + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capital == null) ? 0 : capital.hashCode());
		result = prime * result + ((continent == null) ? 0 : continent.hashCode());
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((countryName == null) ? 0 : countryName.hashCode());
		result = prime * result + ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		if (!(obj instanceof Country)) {
			return false;
		}
		Country other = (Country) obj;
		if (capital == null) {
			if (other.capital != null) {
				return false;
			}
		} else if (!capital.equals(other.capital)) {
			return false;
		}
		if (continent == null) {
			if (other.continent != null) {
				return false;
			}
		} else if (!continent.equals(other.continent)) {
			return false;
		}
		if (countryCode == null) {
			if (other.countryCode != null) {
				return false;
			}
		} else if (!countryCode.equals(other.countryCode)) {
			return false;
		}
		if (countryName == null) {
			if (other.countryName != null) {
				return false;
			}
		} else if (!countryName.equals(other.countryName)) {
			return false;
		}
		if (currencyCode == null) {
			if (other.currencyCode != null) {
				return false;
			}
		} else if (!currencyCode.equals(other.currencyCode)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		return true;
	}

}
