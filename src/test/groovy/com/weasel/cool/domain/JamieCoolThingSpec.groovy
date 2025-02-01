package com.weasel.cool.domain

import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Subject

@Narrative("""Really just adding this to test out 'instance-controlled' static factory method (see Effective Java item 1, 'advantage 2')
so one method will return a new instance each time, the other method will return the same instance each time (like singleton pattern)""")
@Subject(JamieCoolThing)
class JamieCoolThingSpec extends Specification {

    def "can have a coolest jamie statically created, returning the same instance each time"() {
        expect: "a static-factory-method-created coolestJamie to equal another"
            JamieCoolThing.singleCoolestJamie() == JamieCoolThing.singleCoolestJamie()
    }

    def "can have a coolest jamie dynamically created, returning a new instance each time"() {
        expect: "a static-factory-method-created coolestJamie to equal another"
            JamieCoolThing.coolestJamie() != JamieCoolThing.coolestJamie()
    }
}
