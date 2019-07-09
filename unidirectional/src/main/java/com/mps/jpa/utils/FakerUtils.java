package com.mps.jpa.utils;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import com.github.javafaker.Faker;

public class FakerUtils {

	public static Faker getFakerByISO3CountryCode(String ISO3CountryCode) {
		Locale locale = SingletonWrapperFaker.countryLocaleMap.get(ISO3CountryCode);
		Faker faker = new Faker(locale);
		return faker;
	}

	public static Faker getRandomFaker() {
		return null;

	}

	private static class SingletonWrapperFaker {

		static Map<String, Locale> countryLocaleMap = new TreeMap<>();

		static {
			Arrays.asList(Locale.getAvailableLocales()).forEach(locale -> {
				try {
					countryLocaleMap.put(locale.getISO3Country(), locale);
				} catch (Exception e) {
					//Not every locale is implemented.
				}
			});
		}

	}

}
