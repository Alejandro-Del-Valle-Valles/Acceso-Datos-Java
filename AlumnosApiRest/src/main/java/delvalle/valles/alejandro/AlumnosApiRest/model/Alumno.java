package delvalle.valles.alejandro.AlumnosApiRest.model;

import java.time.LocalDate;
import java.util.Objects;

public class Alumno {

    private int nia;
    private String name;
    private String surname;
    private LocalDate bornDate;
    private LocalDate registrationDate;

    public Alumno(int nia, String name, String surname, LocalDate bornDate, LocalDate registrationDate) {
        this.nia = nia;
        this.name = name;
        this.surname = surname;
        this.bornDate = bornDate;
        this.registrationDate = registrationDate;
    }

    public int getNia() {
        return nia;
    }

    public void setNia(int nia) {
        this.nia = nia;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    public void setBornDate(LocalDate bornDate) {
        this.bornDate = bornDate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return getNia() == alumno.getNia();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getNia());
    }
}
