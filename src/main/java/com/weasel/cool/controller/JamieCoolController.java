package com.weasel.cool.controller;

import com.weasel.cool.domain.JamieCoolThing;
import com.weasel.cool.service.JamieCoolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class JamieCoolController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final JamieCoolService jamieCoolService;

    @Autowired
    public JamieCoolController(final JamieCoolService jamieCoolService) {
        this.jamieCoolService = jamieCoolService;
    }

    @GetMapping(path = "/wow-so-cool", produces = MediaType.APPLICATION_JSON_VALUE)
    public JamieCoolThing getCoolThing() {
        logger.info("Getting such a cool thing, wow how could it be so cool?");
        return jamieCoolService.getCoolThing();
    }
}
