package com.mps.jpa;

import java.util.List;
import java.util.stream.IntStream;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import com.mps.jpa.entities.Person;
import com.mps.jpa.utils.FakeFactory;

public class App {

	public static void main(String[] args) {
		System.out.println("Program started");

		try {
			saveFakePersonsToDB();
			
			EntityManager entityManager = PersistenceManager.getEntityManagerFactory().createEntityManager();
			List<Person> personList = getAllPersonsFromDB(entityManager);
			printPersonList(personList);
			
			
		//	checkDetachWorking();
			//checkFlushWorking();
			//metaModelTest();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			PersistenceManager.closeFactory();
		}

	}

	/**
	 * Flush does not confirm the changes to DB, so until commit is done the changes are not available in other persistence context.
	 *  But current persistence context already had the changes available.
	 *  Then what is the use of flush (without commit) ??
	 */
	static void checkFlushWorking() {
		System.out.println("\n\n*********************************************");
		System.out.println(" !! Testing Flush functioality  !!");
		System.out.println("*********************************************\n");
		
		EntityManager entityManager1 = PersistenceManager.getEntityManagerFactory().createEntityManager();
		entityManager1.getTransaction().begin();
		List<Person> personList = getAllPersonsFromDB(entityManager1);
		printPersonList(personList);
		personList.forEach(person -> person.setFirstName("I am Changed"));
		System.out.println("\n*********** Fetching objects by same Entity Manger after change before flush ************\n");
		printPersonList(getAllPersonsFromDB(entityManager1));
		
		entityManager1.flush();
		//entityManager.getTransaction().commit();
		System.out.println("\n*********** Fetching objects by same Entity Manger after change after flush************\n");
		printPersonList(getAllPersonsFromDB(entityManager1));
		entityManager1.close();
		
		
		System.out.println("\n*********** Fetching objects again by another Entity Manger  ************\n");
		EntityManager entityManager2 = PersistenceManager.getEntityManagerFactory().createEntityManager();
		printPersonList(getAllPersonsFromDB(entityManager2));
		entityManager2.close();
		
		entityManager1.getTransaction().commit();
		
		System.out.println("\n*********** Fetching objects again by another Entity Manger  ************\n");
		EntityManager entityManager3 = PersistenceManager.getEntityManagerFactory().createEntityManager();
		printPersonList(getAllPersonsFromDB(entityManager3));
		entityManager3.close();
		
		
		
	}

	
	static void checkDetachWorking() {
		System.out.println("\n\n*********************************************");
		System.out.println(" !! Testing Detach functioality  !!");
		System.out.println("*********************************************\n");
		
		EntityManager entityManager = PersistenceManager.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		List<Person> personList = getAllPersonsFromDB(entityManager);
		printPersonList(personList);
		personList.forEach(entityManager::detach);
		personList.forEach(person -> person.setFirstName("I am Changed"));
		entityManager.flush();
		entityManager.close();
		entityManager.getTransaction().commit();
		
		System.out.println("\n*********** Fetching objects again by another Entity Manger  ************\n");
		entityManager = PersistenceManager.getEntityManagerFactory().createEntityManager();
		printPersonList(getAllPersonsFromDB(entityManager));
		entityManager.close();
		
	}

	

	private static void saveFakePersonsToDB() {
		EntityManager entityManager = PersistenceManager.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		List<Person> personList = FakeFactory.getPersonList(entityManager);
		personList.forEach(p -> entityManager.persist(p));

		entityManager.getTransaction().commit();
		entityManager.close();

		System.out.println("\n   !!! Saved " + personList.size() + " person in DataBase !!!");
	}

	private static void metaModelTest() {
		EntityManager entityManager = PersistenceManager.getEntityManagerFactory().createEntityManager();
		
		Metamodel metamodel = entityManager.getMetamodel();
		EntityType entityType=  metamodel.entity(Person.class);
	}
	
	private static List<Person> getAllPersonsFromDB(EntityManager entityManager) {
		 List<Person> personList =entityManager.createQuery("SELECT p FROM Person p", Person.class).getResultList();
		 return personList;
	}
	
	private static void printPersonList(List<Person> personList) {
		IntStream.rangeClosed(0, (personList.size() - 1)).forEach(i -> System.out.println("#" + (i + 1) + " " + personList.get(i)));
	}
}
