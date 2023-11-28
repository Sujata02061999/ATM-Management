package com.sujata.basic.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyConnection {
   private MyConnection() {}
   private static EntityManagerFactory entityManagerFactory;
   private static EntityManager entityManager;
   
   public static EntityManager getEntityManagerObject() {
	   if(entityManager == null) 
	   {
		   entityManagerFactory=Persistence.createEntityManagerFactory("sujata");
		   entityManager= entityManagerFactory.createEntityManager();
	   }
	   return entityManager;
   }
}
