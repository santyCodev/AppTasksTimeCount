package com.santicodev.contarhoras.business.service;

import com.santicodev.contarhoras.business.dto.SemanaDTO;
import com.santicodev.contarhoras.data.entity.Topic;
import com.santicodev.contarhoras.data.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
}
