package com.santicodev.contarhoras;

import com.santicodev.contarhoras.data.repository.TopicRepository;
import com.santicodev.contarhoras.data.entity.Topic;
import com.santicodev.contarhoras.data.entity.enums.Category;
import com.santicodev.contarhoras.data.entity.enums.TopicType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;

@SpringBootApplication
public class ContarhorasApplication {

	@Autowired
	TopicRepository topicRepository;

	int numTopicType;

	@Bean
	public CommandLineRunner run (){
		return args -> {
			Topic topic;
			numTopicType = 0;
			for (int i=0; i<10; i++){
				topicRepository.save(new Topic("Topic "+i, topicTypeByNum(),
									categoryByNum(i), i+2, i+2,
									new Date(new java.util.Date().getTime()),1));
			}
		};
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
		else if(index == 2 || index == 3){ cat = Category.DRAWING; }
		else if(index == 4 || index == 5){ cat = Category.DEV_OTHER; }
		else if(index == 6 || index == 7){ cat = Category.ENGLISH; }
		else if(index == 8 || index == 9){ cat = Category.WEB_DEV; }
		return cat;
	}

	public static void main(String[] args) {
		SpringApplication.run(ContarhorasApplication.class, args);
	}
}
