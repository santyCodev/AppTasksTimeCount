package com.santicodev.contarhoras.data.repository;

import com.santicodev.contarhoras.data.TopicRepository;
import com.santicodev.contarhoras.data.entity.Topic;
import com.santicodev.contarhoras.data.enums.Category;
import com.santicodev.contarhoras.data.enums.TopicType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

@SpringBootTest
public class TopicRepositoryTest {

    int numTopicType;

    @Autowired
    private TopicRepository topicRepository;

    @Test
    public void saveTopicsTest(){
        Topic topic;
        numTopicType = 0;
        for (int i=0; i<11; i++){
            topicRepository.save(new Topic("Topic "+i, topicTypeByNum(), categoryByNum(i), i+2, i+2));
        }
    }
    
    private TopicType topicTypeByNum(){
        TopicType topic = null;
        if(numTopicType == 0) {
            numTopicType = 1;
            topic = TopicType.THEORY;
        }
        else if(numTopicType == 1){
            numTopicType = 0;
            topic = TopicType.PROJECT;
        }
        return topic;
    }

    private Category categoryByNum(int index){
        Category cat = null;
        if(index == 0 || index == 1){ cat = Category.MUSIC; }
        else if(index == 0 || index == 1){ cat = Category.DRAWING; }
        else if(index == 0 || index == 1){ cat = Category.DEV_OTHER; }
        else if(index == 0 || index == 1){ cat = Category.ENGLISH; }
        else if(index == 0 || index == 1){ cat = Category.WEB_DEV; }
        return cat;
    }
}
