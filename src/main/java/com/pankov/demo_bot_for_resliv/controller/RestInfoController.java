package com.pankov.demo_bot_for_resliv.controller;

import com.pankov.demo_bot_for_resliv.model.dto.InfoDto;
import com.pankov.demo_bot_for_resliv.model.entity.Info;
import com.pankov.demo_bot_for_resliv.service.impl.InfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestInfoController {

    private final InfoService infoService;

    @GetMapping(value = "/cities", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Info> getCities() {
        return infoService.findAll();
    }

    @GetMapping(value = "/city/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Info getCity(@PathVariable("name") String name) {
        return infoService.findByCityName(name);
    }

    @PostMapping(value = "/city", produces = MediaType.APPLICATION_JSON_VALUE)
    public void addInfo(@RequestBody InfoDto info) {
        infoService.save(info);
    }

    @PutMapping(value = "/city", produces = MediaType.APPLICATION_JSON_VALUE)
    public void changeInfo(@RequestBody InfoDto info) {
        infoService.update(info);
    }

    @DeleteMapping(value = "/city/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCity(@PathVariable("name") String name) {
        infoService.deleteByCityName(name);
    }
}
