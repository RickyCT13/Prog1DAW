package actividades.ud8.actsDiapositivas.ej5;

import actividades.ud8.actsDiapositivas.ej1a3.MusicEvent;

import javax.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("objectdb:$objectdb/db/events.odb");
        EntityManager eManager = emFactory.createEntityManager();

        eManager.getTransaction().begin();

        TypedQuery<MusicEvent> query1 = eManager.createQuery("SELECT * FROM EventoMusica WHERE id = 20", MusicEvent.class);
        MusicEvent myEvent = query1.getSingleResult();
        System.out.println(myEvent);



        eManager.getTransaction().commit();

        eManager.close();
        emFactory.close();
    }
}
