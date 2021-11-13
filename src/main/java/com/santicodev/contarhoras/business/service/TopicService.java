package com.santicodev.contarhoras.business.service;

import com.santicodev.contarhoras.business.dto.SemanaDTO;
import com.santicodev.contarhoras.business.dto.TopicDTO;
import com.santicodev.contarhoras.data.entity.Topic;
import com.santicodev.contarhoras.data.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public SemanaDTO getTopicsByWeek(int numSemana, Pageable pageable){
        SemanaDTO semana = new SemanaDTO();
        semana.setNumSemana(numSemana);
        semana.setTopics(topicRepository.findBynumSemana(numSemana, pageable));
        return semana;
    }

    public Topic saveTopic(TopicDTO topicDTO){
        Topic newTopic = new Topic();
        newTopic.setTopicName(topicDTO.getTopicName());
        newTopic.setCategory(topicDTO.getCategory());
        newTopic.setDia(new Date(new java.util.Date().getTime()));
        newTopic.setType(topicDTO.getTopicType());
        newTopic.setNumSemana(topicDTO.getNumSemana());
        newTopic.setMinutos(contarMinutos(topicDTO.getHoraInicio(), topicDTO.getHoraFin()));
        newTopic.setHoras(contarHoras(topicDTO.getHoraInicio(), topicDTO.getHoraFin()));

        return topicRepository.save(newTopic);
    }

    private int contarMinutos(String horaInicio, String horaFinal){
        return contar(Integer.parseInt(horaInicio.substring(3)),
                      Integer.parseInt(horaFinal.substring(3)),60);
    }

    private int contarHoras(String horaInicio, String horaFinal){
        return contar(Integer.parseInt(horaInicio.substring(0,2)),
                      Integer.parseInt(horaFinal.substring(0,2)), 24);
    }

    private int contar(int init, int fin, int max){
        int total = 0;
        if(init > fin) { total = (max - init) + fin; }
        else { total = fin - init; }
        return total;
    }
}
