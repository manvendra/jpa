/**
 * 
 */
package com.mps.jpa.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.IntStream;

import javax.persistence.EntityManager;

import com.github.javafaker.Faker;
import com.mps.jpa.entities.Address;
import com.mps.jpa.entities.Continent;
import com.mps.jpa.entities.Country;
import com.mps.jpa.entities.Person;
import com.mps.jpa.entities.PhoneNumber;

/**
 * @author manvendrapsingh
 *
 */
public class FakeFactory {
	static final int maxNumberOfAddress=2;
	static final int maxNumberOfPersonAtAnAddress=3;

	// Mimicking the object graph by taking data from javafaker API
	public static List<Person> getPersonList(EntityManager entityManager) {
		List<Person> personList = new ArrayList<>();
		Faker faker = new Faker(Locale.US);
		
		int numberOfFakeAddress = new Random().nextInt(maxNumberOfAddress) + 1;
	
		IntStream.rangeClosed(1, numberOfFakeAddress).forEach(i -> {

			Address address = getAddressObject(faker);
			int numberOfFakePeople = new Random().nextInt(maxNumberOfPersonAtAnAddress) + 1;
			System.out.println("#" + i + "|  Address creared for " + numberOfFakePeople + " People. " + address);

			IntStream.rangeClosed(1, numberOfFakePeople).forEach(j -> {
				Person person = getPersonObject(faker, address);
				System.out.println("\t#" + j + " - " + person);
				personList.add(person);
			});

		});
		return personList;

	}

	public static Address getAddressObject(Faker faker) {

		return new Address()
				.setStreet(faker.address().streetAddress())
				.setCity(faker.address().city())
				.setState(faker.address().state())
				.setZip(faker.address().zipCode())
				.setCountry(getCountryObject());
	}

	public static Person getPersonObject(Faker faker, Address address) {

		return new Person()
				.setFirstName(faker.name().firstName())
				.setLastName(faker.name().lastName())
				.setPhoneNumber(new PhoneNumber(faker.phoneNumber().cellPhone()))
				.setPermanentAddress(address);
	}

	public static Country getCountryObject() {

		return new Country()// .setId(1)
				.setCountryCode("USA")
				.setCountryName("United States Of America")
				.setCapital("Washington DC")
				.setCurrencyCode("USD")
				.setContinent(new Continent()
						// .setId(1)
						.setContinent("NA")
						.setContinentName("North America"));
	}

}
