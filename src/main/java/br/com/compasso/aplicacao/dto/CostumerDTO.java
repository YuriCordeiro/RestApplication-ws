package br.com.compasso.aplicacao.dto;

import br.com.compasso.aplicacao.enums.Sexo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_COSTUMER")
@SequenceGenerator(name = "SEQ_COSTUMER", sequenceName = "SEQ_COSTUMER", allocationSize = 1)
public class CostumerDTO {

    @Id
    @GeneratedValue(generator = "SEQ_COSTUMER", strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("complete_name")
    private String completeName;

    @Enumerated(EnumType.STRING)
    private Sexo gender;

    @JsonFormat(pattern = "dd/MM/yyyy", locale = "pt_BR", timezone = "GMT-03:00")
    @JsonProperty("birth_date")
    private Date birthDate;

    private Integer age;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "city_id", unique = true, updatable = false)
    @JsonProperty("city")
    private CityDTO city;

    /**
     * Default Constructor
     */
    public CostumerDTO() {
    }

    /**
     * Constructor with fields
     *
     * @param completeName completeName
     * @param gender       costumers's gender
     * @param birthDate    costumers's birthDate
     * @param age          costumers's age
     * @param city         costumers's city
     */
    public CostumerDTO(String completeName, Sexo gender, Date birthDate, Integer age, CityDTO city) {
        this.completeName = completeName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.age = age;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompleteName() {
        return completeName;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }

    public Sexo getGender() {
        return gender;
    }

    public void setGender(Sexo gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }
}
