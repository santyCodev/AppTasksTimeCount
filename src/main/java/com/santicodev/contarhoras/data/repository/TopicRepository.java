package com.santicodev.contarhoras.data.repository;

import com.santicodev.contarhoras.data.entity.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

    Page<Topic> findBynumSemana(int numSemana, Pageable pageable);
}
