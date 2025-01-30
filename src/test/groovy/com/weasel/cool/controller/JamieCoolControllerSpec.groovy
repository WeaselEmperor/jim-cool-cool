package com.weasel.cool.controller

import com.weasel.cool.domain.CoolnessRating
import com.weasel.cool.domain.JamieCoolThing
import com.weasel.cool.service.JamieCoolService
import spock.lang.Specification
import spock.lang.Subject

@Subject(JamieCoolController)
class JamieCoolControllerSpec extends Specification {

    JamieCoolController jamieCoolController
    JamieCoolService mockJamieCoolService

    def setup() {
        mockJamieCoolService = Mock(JamieCoolService)
        jamieCoolController = new JamieCoolController(mockJamieCoolService)
    }

    def "can get a cool thing from a cool service"() {
        given: "a pre-canned cool thing"
            JamieCoolThing coolThing = new JamieCoolThing("wooooow", CoolnessRating.OH_MY_WOOORD)

        when: "the cool controller's getCoolThing() method is called"
            JamieCoolThing returnedCoolThing = jamieCoolController.getCoolThing()

        then: "a call is made to the mocked cool service, which returns a cool thing"
            1 * mockJamieCoolService.getCoolThing() >> coolThing

        and: "the returned cool thing matches the pre-canned one"
            returnedCoolThing.name == coolThing.name
            returnedCoolThing.coolnessRating == coolThing.coolnessRating
    }
}
