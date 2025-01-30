package com.weasel.cool.service

import com.weasel.cool.domain.CoolnessRating
import com.weasel.cool.domain.JamieCoolThing
import com.weasel.cool.service.JamieCoolService
import spock.lang.Specification
import spock.lang.Subject

@Subject(JamieCoolService)
class JamieCoolServiceSpec extends Specification {

    JamieCoolService jamieCoolService

    def setup() {
        jamieCoolService = new JamieCoolService()
    }

    def "can return a cool jamie thing"() {
        given: " a jamie cool service"
            assert jamieCoolService != null

        when: "its getCoolThing() method is called"
            JamieCoolThing coolThing = jamieCoolService.getCoolThing()

        then: "a cool thing is returned"
            coolThing != null
            coolThing.getCoolnessRating() == CoolnessRating.WOW_THE_COOLEST
    }
}
