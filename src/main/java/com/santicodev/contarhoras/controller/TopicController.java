package com.santicodev.contarhoras.controller;

import com.santicodev.contarhoras.business.dto.SemanaDTO;
import com.santicodev.contarhoras.business.dto.TopicDTO;
import com.santicodev.contarhoras.business.service.TopicService;
import com.santicodev.contarhoras.data.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping(path = "/week/{numSemana}")
    public SemanaDTO getTopicsByWeek(@PathVariable(value = "numSemana") int numSemana, Pageable pageable){
        return topicService.getTopicsByWeek(numSemana, pageable);
    }

    @PostMapping
    public Topic saveTopics(@RequestBody @Validated TopicDTO topicDto) {
        return new ResponseEntity();
    }
}
