package Actividades.UD8.ActsDiapositivas.ConexionDB;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("objectdb:$objectdb/db/cars.odb");
        EntityManager eManager = emFactory.createEntityManager();

        eManager.getTransaction().begin();

        Car car1 = new Car("Honda", "Civic","1999", "Championship White");
        Car car2 = new Car("Opel", "Corsa", "2002", "Blue");

        eManager.persist(car1);
        eManager.persist(car2);

        eManager.getTransaction().commit();

        eManager.close();
        emFactory.close();
    }
}
