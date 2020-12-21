package io.barsha.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;


import java.time.Instant;


@Entity

public class Offre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "titre is mandatory")
    @Column(name = "titre")
    private String titre;



    @Column(name = "prix")
    private float prix;

    @Column(name = "image")
    private String image;

    @Column(name = "dateValidite")
    private Instant dateValidite =  Instant.now();

    public Offre() {}

    public Offre( String titre, float prix, String image, Instant dateValidite) {
        this.titre = titre;
        this.prix = prix;
        this.image = image;
        this.dateValidite = dateValidite;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Instant getDateValidite() {
        return dateValidite;
    }

    public void setDateValidite(Instant dateValidite) {
        this.dateValidite = dateValidite;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public String getImage() {
        return image;
    }








}
