package sk.tmconsulting.jednoduchyeshop.model;

import jakarta.persistence.*;

@Entity
@Table(name="tricka")
public class Tricko {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tento riadok zabezpeci auto increment, cize id sa bude automaticky zvysovat o 1
    @Column(name="id", updatable = false, nullable = false)
    private long id; // id pre potreby identifikaciu zaznamu v databaze

    @Column(name="farba", nullable = false)
    private String farba;

    @Column(name="velkost", nullable = false)
    private String velkost;

    @Column(name="menoZakaznika", nullable = false)
    private String menoZakaznika;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFarba() {
        return farba;
    }

    public void setFarba(String farba) {
        this.farba = farba;
    }

    public String getVelkost() {
        return velkost;
    }

    public void setVelkost(String velkost) {
        this.velkost = velkost;
    }

    public String getMenoZakaznika() {
        return menoZakaznika;
    }

    public void setMenoZakaznika(String menoZakaznika) {
        this.menoZakaznika = menoZakaznika;
    }
}
