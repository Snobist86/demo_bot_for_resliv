package com.pankov.demo_bot_for_resliv.repository;

import com.pankov.demo_bot_for_resliv.model.entity.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfoRepository extends JpaRepository<Info, Long> {

    Info findByCityName(String name);

//    List<Info> findAll();

    void deleteInfoByCityName(String name);

}
