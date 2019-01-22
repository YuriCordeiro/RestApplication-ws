package br.com.compasso.aplicacao.dto;

import br.com.compasso.aplicacao.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

/**
 * CityDTO it's a Data Transfer Object
 */
@Entity
@Table(name = "TB_COSTUMER")
@SequenceGenerator(name = "SEQ_COSTUMER", sequenceName = "SEQ_COSTUMER", allocationSize = 1)
public class CostumerDTO {

    @Id
    @GeneratedValue(generator = "SEQ_COSTUMER", strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("complete_name")
    @Column(nullable = false)
    private String completeName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @JsonFormat(pattern = "dd/MM/yyyy", locale = "pt_BR", timezone = "GMT-03:00")
    @JsonProperty("birth_date")
    @Column(nullable = false)
    private Date birthDate;

    @Column(nullable = false)
    private Integer age;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "city_id", unique = true, updatable = false, nullable = false)
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
    public CostumerDTO(String completeName, Gender gender, Date birthDate, Integer age, CityDTO city) {
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
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
