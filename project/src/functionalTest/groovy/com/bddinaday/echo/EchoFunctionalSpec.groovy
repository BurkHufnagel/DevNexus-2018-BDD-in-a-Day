package com.bddinaday.echo;

import org.openqa.selenium.By

import geb.spock.GebSpec
import spock.lang.Narrative
import spock.lang.PendingFeature
import spock.lang.Title


@Title("Welcome service")
@Narrative('''As a new user
I want to feel welcome
so that I will want to continue using the system''')

class EchoFunctionalSpec extends GebSpec {
    def "When a user supplies a sound then it should be echoed back to them"() {
        given: "we're on the 'Echo' page"
			gotoEchoPage()

        when: "the user enters a sound"
            $(By.id("inputSound")) << "Echo!"

		and: "submits their input"
            $(By.id("echoButton")).click()

        then: "it should be echoed back."
			waitFor() { // Defaults to waiting for up to 5 seconds, checking every half second.
				$(By.id("echoSound")).text() == "Echo!"
            }
    }

	@PendingFeature
    def "When the user submits a number then it should be echoed back"() {
        given: "we're on the 'Echo' page"
			gotoEchoPage()

        when: "the user supplies a number"
            $(By.id("inputSound")) << "23"
        		$(By.id("echoButton")).click()

		then: "it should be echoed back."
			waitFor(3, 0.1) { // Wait up to 3 seconds, checking every tenth of a second.
				$(By.id("echoMessage")).text() == "23"
        		}
    }

	def gotoEchoPage() {
		go "http://localhost:8080"
		title == "BDD in a Day: Echo"
	}


}
