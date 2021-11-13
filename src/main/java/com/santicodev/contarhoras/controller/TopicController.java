package com.santicodev.contarhoras.controller;

import com.santicodev.contarhoras.business.dto.SemanaDTO;
import com.santicodev.contarhoras.business.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping(path = "/week/{numSemana}")
    public SemanaDTO getTopicsByWeek(@PathVariable(value = "numSemana") int numSemana, Pageable pageable){
        return topicService.getTopicsByWeek(numSemana, pageable);
    }
}
