package com.mps.jpa.entities;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

/**
 * @author manvendrasingh
 *
 */
@Embeddable
public class PhoneNumber {
	
	
	private String completePhoneNumber;

	@Transient
	private String countryCode = "+1"; //optional to pass default is US number
	@Transient
	private String area;       //3 digits before prefix
	@Transient
	private String prefix;     //3 digits before line number
	@Transient
	private String lineNumber; //Last 4 digit

	public PhoneNumber() {
		// TODO Auto-generated constructor stub
	}
	public PhoneNumber(String completePhoneNumber) {
		this.completePhoneNumber = completePhoneNumber;
		setupPhoneNumberParts(completePhoneNumber);
	}

	public void setupPhoneNumberParts(String completePhoneNumber) {
		if(completePhoneNumber ==null || completePhoneNumber.length()<10) {
			return;
		}
		lineNumber = completePhoneNumber.substring(completePhoneNumber.length()-4);
		prefix = completePhoneNumber.substring(completePhoneNumber.length()-7,completePhoneNumber.length()-4);
		area = completePhoneNumber.substring(completePhoneNumber.length()-10,completePhoneNumber.length()-7);
	    if(completePhoneNumber.length()>10) {
	    	countryCode=completePhoneNumber.substring(0,completePhoneNumber.length()-10);
	    }
	}
	
	
	@Override
	public int hashCode() {
		final int prime  = 31;
		int       result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((completePhoneNumber == null) ? 0 : completePhoneNumber.hashCode());
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((lineNumber == null) ? 0 : lineNumber.hashCode());
		result = prime * result + ((prefix == null) ? 0 : prefix.hashCode());
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
		if (!(obj instanceof PhoneNumber)) {
			return false;
		}
		PhoneNumber other = (PhoneNumber) obj;
		if (area == null) {
			if (other.area != null) {
				return false;
			}
		} else if (!area.equals(other.area)) {
			return false;
		}
		if (completePhoneNumber == null) {
			if (other.completePhoneNumber != null) {
				return false;
			}
		} else if (!completePhoneNumber.equals(other.completePhoneNumber)) {
			return false;
		}
		if (countryCode == null) {
			if (other.countryCode != null) {
				return false;
			}
		} else if (!countryCode.equals(other.countryCode)) {
			return false;
		}
		if (lineNumber == null) {
			if (other.lineNumber != null) {
				return false;
			}
		} else if (!lineNumber.equals(other.lineNumber)) {
			return false;
		}
		if (prefix == null) {
			if (other.prefix != null) {
				return false;
			}
		} else if (!prefix.equals(other.prefix)) {
			return false;
		}
		return true;
	}

	

	@Override
	public String toString() {
		return "PhoneNumber [completePhoneNumber=" + completePhoneNumber + ", countryCode=" + countryCode + ", area=" + area + ", prefix=" + prefix + ", lineNumber=" + lineNumber + "]";
	}

	/**
	 * @return the completePhoneNumber
	 */
	public String getcompletePhoneNumber() {
		return completePhoneNumber;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * @return the lineNumber
	 */
	public String getLineNumber() {
		return lineNumber;
	}

}