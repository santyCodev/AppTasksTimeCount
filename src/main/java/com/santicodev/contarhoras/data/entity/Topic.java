package com.santicodev.contarhoras.data.entity;

import com.santicodev.contarhoras.data.entity.enums.Category;
import com.santicodev.contarhoras.data.entity.enums.TopicType;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "TOPIC")
public class Topic {

    @Id
    @SequenceGenerator(
            name = "topic_sequence",
            sequenceName = "topic_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "topic_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private long id;

    @Column(name = "topic_name")
    private String topicName;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TopicType type;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "horas")
    private int horas;

    @Column(name = "minutos")
    private int minutos;

    @Column(name = "dia")
    private Date dia;

    @Column(name = "num_semana")
    private int numSemana;

    public Topic(String topicName, TopicType type, Category category, int horas, int minutos, Date dia, int numSemana) {
        this.topicName = topicName;
        this.type = type;
        this.category = category;
        this.horas = horas;
        this.minutos = minutos;
        this.dia = dia;
        this.numSemana = numSemana;
    }

    public Topic() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public TopicType getType() {
        return type;
    }

    public void setType(TopicType type) {
        this.type = type;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public int getNumSemana() {
        return numSemana;
    }

    public void setNumSemana(int numSemana) {
        this.numSemana = numSemana;
    }
}
