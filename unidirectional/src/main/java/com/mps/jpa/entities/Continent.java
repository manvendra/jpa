package com.mps.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author manvendrasingh
 *
 */
@Entity
@Table(name = "CONTINENTS")
public class Continent {

	@Id
	@GeneratedValue
	private int id;

	private String continentName;
	private String continent;

	public long getId() {
		return id;
	}

	public String getContinentName() {
		return continentName;
	}

	public String getContinent() {
		return continent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((continent == null) ? 0 : continent.hashCode());
		result = prime * result + ((continentName == null) ? 0 : continentName.hashCode());
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
		if (!(obj instanceof Continent)) {
			return false;
		}
		Continent other = (Continent) obj;
		if (continent == null) {
			if (other.continent != null) {
				return false;
			}
		} else if (!continent.equals(other.continent)) {
			return false;
		}
		if (continentName == null) {
			if (other.continentName != null) {
				return false;
			}
		} else if (!continentName.equals(other.continentName)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		return true;
	}

	public Continent setId(int id) {
		this.id = id;
		return this;
	}

	public Continent setContinentName(String continentName) {
		this.continentName = continentName;
		return this;
	}

	public Continent setContinent(String continent) {
		this.continent = continent;
		return this;
	}

	@Override
	public String toString() {
		return "Continent [id=" + id + ", continentName=" + continentName + ", continent=" + continent + "]";
	}

}
