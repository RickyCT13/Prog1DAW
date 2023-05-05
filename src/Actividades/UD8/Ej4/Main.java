package Actividades.UD8.Ej4;

import Actividades.UD8.ActsDiapositivas.Ej1a3.Artist;
import Actividades.UD8.ActsDiapositivas.Ej1a3.Genre;
import Actividades.UD8.ActsDiapositivas.Ej1a3.MusicEvent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("objectdb:$objectdb/db/events.odb");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();



        Artist
                a1 = new Artist("Jon Bon Jovi"),
                a2 = new Artist("Kurt Cobain"),
                a3 = new Artist("Metallica"),
                a4 = new Artist("Marshmello"),
                a5 = new Artist("Avicii"),
                a6 = new Artist("Skrillex");

        List<Artist>
                artList1 = new ArrayList<>(),
                artList2 = new ArrayList<>();

        artList1.add(a1);
        artList1.add(a2);
        artList1.add(a3);

        artList2.add(a4);
        artList2.add(a5);
        artList2.add(a6);

        MusicEvent
                event1 = new MusicEvent("Festival Rock de Verano 2023", new Date(2023 - 1900, Calendar.JULY, 12), new BigDecimal("2345.32"), Genre.ROCK, artList1),
                event2 = new MusicEvent("Evento de apreciación de música electrónica 2022", new Date(2022 - 1900, Calendar.MAY, 13), new BigDecimal("5649.50"), Genre.EDM, artList2);

        manager.remove(event1);
        manager.remove(event2);
        manager.persist(event1);
        manager.persist(event2);

        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }
}
