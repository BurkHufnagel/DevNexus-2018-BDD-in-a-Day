package com.bddinaday.echo;

import org.openqa.selenium.By

import geb.spock.GebSpec
import spock.lang.Narrative
import spock.lang.PendingFeature
import spock.lang.Title


@Title("Echo service")
@Narrative('''As a computer simulation fan
I want my input echoed back softer
so that it emulates a real echo.''')

class EchoFunctionalSpec extends GebSpec {
    def "When a user supplies text with capital letters then it should be echoed back to them as lower case"() {
        given: "we're on the 'Echo' page"
			gotoEchoPage()

        when: "the user enters a sound with capital letters"
            $(By.id("inputSound")) << "ECHO"
            $(By.id("echoButton")).click()

        then: "it should be echoed back with lower case letters."
			waitFor() { // Defaults to waiting for up to 5 seconds, checking every half second.
				$(By.id("echoSound")).text() == "ECHO... echo..."
            }
    }

	@PendingFeature
    def "When the user submits text with no capital letters then ther should be no echo"() {
        given: "we're on the 'Echo' page"
			gotoEchoPage()

        when: "the user supplies a number"
            $(By.id("inputSound")) << "echo"
        		$(By.id("echoButton")).click()

		then: "it should be echoed back."
			waitFor(3, 0.1) { // Wait up to 3 seconds, checking every tenth of a second.
				$(By.id("echoMessage")).text() == "echo..."
        	}
    }

	def gotoEchoPage() {
		go "http://localhost:8080"
		title == "BDD in a Day: Echo"
	}


}
