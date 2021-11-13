package com.santicodev.contarhoras.business.dto;

import com.santicodev.contarhoras.data.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

public class SemanaDTO{

    private int numSemana;
    private Page<Topic> Topics;

    public int getNumSemana() {
        return numSemana;
    }

    public void setNumSemana(int numSemana) {
        this.numSemana = numSemana;
    }

    public Page<Topic> getTopics() {
        return Topics;
    }

    public void setTopics(Page<Topic> topics) {
        Topics = topics;
    }
}
