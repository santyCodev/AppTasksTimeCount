package com.santicodev.contarhoras.data.repository;

import com.santicodev.contarhoras.data.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
}
