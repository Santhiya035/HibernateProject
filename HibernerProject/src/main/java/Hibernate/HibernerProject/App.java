package Hibernate.HibernerProject;

import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
	
	static void toPerformOperations(Session session,Scanner scan) {
		int choice;
		do {
			choice=scan.nextInt();

			switch(choice) {
			case 1:
				// method call to add the books
				DBoperations.toAddBooks(session);
			case 2:
				// method call to update the book details
				DBoperations.toUpdateById(session);
			case 3:
				// method call to delete the books
				DBoperations.toDeleteById(session);
			case 4:
				// method call to search the books by BookId
				DBoperations.toSearchById(session);
			case 5:
				// method call to display all the books
				DBoperations.toDisplayAll(session);
			case 6: 
				// method call to logout
				DBoperations.toLogout();
			}}
		while(choice!=6);
	}

		public static void main(String[] args) {
	     
			try {
					Configuration configuration=new Configuration().configure().addAnnotatedClass(LibraryManagement.class);
					SessionFactory sessionFact=configuration.buildSessionFactory();
					Session session=sessionFact.openSession();
					DBoperations.toLogin(session);
				}
				catch(HibernateException  exceptionObj) {
					System.out.println(exceptionObj); 
				}

		}
}

