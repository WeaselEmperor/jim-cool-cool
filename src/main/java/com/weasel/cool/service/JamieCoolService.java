package com.weasel.cool.service;

import com.weasel.cool.domain.CoolnessRating;
import com.weasel.cool.domain.JamieCoolThing;
import org.springframework.stereotype.Service;

@Service
public class JamieCoolService {

    public JamieCoolThing getCoolThing() {
        return new JamieCoolThing("cool thing", CoolnessRating.WOW_THE_COOLEST);
    }
}
