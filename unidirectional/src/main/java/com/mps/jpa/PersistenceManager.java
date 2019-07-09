/**
 * 
 */
package com.mps.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author manvendrasingh
 *
 */
public class PersistenceManager {

	public static EntityManagerFactory getEntityManagerFactory() {
		return SingletonClassHolder.ENTITY_MANAGER_FACTORY;
	}

	public static void closeFactory() {
		SingletonClassHolder.ENTITY_MANAGER_FACTORY.close();
	}

	private static class SingletonClassHolder {

		private static EntityManagerFactory ENTITY_MANAGER_FACTORY;

		static {
			try {

				ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("mpspu");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
