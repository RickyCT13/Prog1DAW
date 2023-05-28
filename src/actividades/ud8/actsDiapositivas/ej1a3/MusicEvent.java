package actividades.ud8.actsDiapositivas.ej1a3;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity(name = "EventoMusica")
public class MusicEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_seq")
    @SequenceGenerator(name = "event_seq", initialValue = 10, allocationSize = 10)
    private int id;

    @Embedded
    private int control;


    private String name;
    private Date date;
    private BigDecimal income;

    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Embedded
    private List<Artist> artistsInEvent;

    public MusicEvent() {}

    public MusicEvent(String name, Date date, BigDecimal income) {
        this.name = name;
        this.date = date;
        this.income = income;
    }

    public MusicEvent(String name, Date date, BigDecimal income, Genre genre, List<Artist> artistsInEvent) {
        this.name = name;
        this.date = date;
        this.income = income;
        this.genre = genre;
        this.artistsInEvent = artistsInEvent;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public Genre getGenre() {
        return genre;
    }

    public List<Artist> getArtistsInEvent() {
        return artistsInEvent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setArtistsInEvent(List<Artist> artistsInEvent) {
        this.artistsInEvent = artistsInEvent;
    }
}
