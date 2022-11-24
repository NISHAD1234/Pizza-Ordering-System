package com.db;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.dao.Student;


public class HibernateDatabaseConnection {
	private static StandardServiceRegistry registry;
	  private static SessionFactory sessionFactory;

	  public static SessionFactory getSessionFactory() {
	    if (sessionFactory == null) {
//	      try {
	        StandardServiceRegistryBuilder registryBuilder = 
	            new StandardServiceRegistryBuilder();

	        Map settings = new HashMap<>();
	      //  settings.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	        settings.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
	        settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/crudapp");
	        settings.put("hibernate.connection.pool_size","100");
	        settings.put("hibernate.connection.username", "root");
	        settings.put("hibernate.connection.password", "");
	        settings.put("hibernate.show_sql", "true");
	        settings.put("hibernate.hbm2ddl.auto", "update");

	        registryBuilder.applySettings(settings);

	        registry = registryBuilder.build();

	        MetadataSources sources = new MetadataSources(registry);
	          
//	          .addAnnotatedClass(Creditcard.class);
	          

	        Metadata metadata = sources
	        .addAnnotatedClass(Student.class)
	        .getMetadataBuilder().build();
	        System.out.println(metadata);
	        sessionFactory = metadata.getSessionFactoryBuilder().build();
	        System.out.println(sessionFactory);
//	      } catch (Exception e) {
//	        System.out.println("SessionFactory creation failed "+e);
//	        if (registry != null) {
//	          //StandardServiceRegistryBuilder.destroy(registry);
//	        }
//	      }
//		//return sessionFactory;
	    }
	    return sessionFactory;
	  }

	  public static void shutdown() {
	    if (registry != null) {
	      StandardServiceRegistryBuilder.destroy(registry);
	    }
	  }
}
