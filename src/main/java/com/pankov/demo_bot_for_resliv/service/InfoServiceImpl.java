package com.pankov.demo_bot_for_resliv.service;

import com.pankov.demo_bot_for_resliv.exception.ResourceNotFoundException;
import com.pankov.demo_bot_for_resliv.model.dto.InfoDto;
import com.pankov.demo_bot_for_resliv.model.entity.Info;
import com.pankov.demo_bot_for_resliv.repository.InfoRepository;
import com.pankov.demo_bot_for_resliv.service.impl.InfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InfoServiceImpl implements InfoService {

    private final InfoRepository infoRepository;

    @Override
    public void save(InfoDto info) {
        Info savedInfo = Info.builder()
                .cityName(info.getCityName())
                .description(info.getDescription())
                .build();
        infoRepository.save(savedInfo);
    }

    @Override
    public void update(InfoDto info) {
        Optional<Info> updatedInfo = Optional.of(infoRepository.findByCityName(info.getCityName()));
        if (updatedInfo.isPresent()){
            updatedInfo.get().setDescription(info.getDescription());
            infoRepository.save(updatedInfo.get());
        }
    }

    @Transactional
    @Override
    public void deleteByCityName(String name) {
        infoRepository.deleteInfoByCityName(name);
    }

    @Override
    public Info findByCityName(String name) throws ResourceNotFoundException {
        return Optional.of(name)
                .map(infoRepository::findByCityName)
                .orElseThrow(() -> new ResourceNotFoundException("Город не найден!"));
    }

    @Override
    public List<Info> findAll() {
        Optional<List<Info>> list = Optional.of(infoRepository.findAll());
        return list.orElse(Collections.emptyList());
    }
}
