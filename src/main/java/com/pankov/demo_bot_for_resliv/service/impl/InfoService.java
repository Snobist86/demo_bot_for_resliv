package com.pankov.demo_bot_for_resliv.service.impl;

import com.pankov.demo_bot_for_resliv.model.dto.InfoDto;
import com.pankov.demo_bot_for_resliv.model.entity.Info;

import java.util.List;

public interface InfoService {

    void save(InfoDto info);

    void update(InfoDto info);

    void deleteByCityName(String name);

    Info findByCityName(String name);

    List<Info> findAll();
}
