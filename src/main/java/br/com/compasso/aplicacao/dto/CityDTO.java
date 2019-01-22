package br.com.compasso.aplicacao.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "TB_CITY")
@SequenceGenerator(name = "SEQ_CITY", sequenceName = "SEQ_CITY", allocationSize = 1)
public class CityDTO {

    @Id
    @GeneratedValue(generator = "SEQ_CITY", strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String province;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "city", optional = false)
    private CostumerDTO costumer;

    /**
     * Default Constructor
     */
    public CityDTO() {
    }

    /**
     * Constructor using fields without id
     *
     * @param name     city's name
     * @param province city's province
     */
    public CityDTO(String name, String province) {
        this.name = name;
        this.province = province;
    }

    /**
     * Constructor using fields
     *
     * @param id       city's id
     * @param name     city's name
     * @param province city's province
     */
    public CityDTO(Integer id, String name, String province) {
        this.id = id;
        this.name = name;
        this.province = province;
    }


    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * should set city's id
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * should set city's name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * should set city's province
     *
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    public CostumerDTO getCostumer() {
        return costumer;
    }
}
