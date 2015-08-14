package com.exemple.loginexemple.Model;

import java.io.Serializable;

/**
 * Created by leolebogoss on 14/08/2015.
 */
public class Data  implements Serializable {

    private int id;
    private String nom;
    private String prenom;
    private String age;
    private String info;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Data(int id,
                String nom,
                String prenom,
                String age,
                String info){
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.age=age;
        this.info=info;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age='" + age + '\'' +
                ", info='" + info +'\'' +
                '}';
    }
}
