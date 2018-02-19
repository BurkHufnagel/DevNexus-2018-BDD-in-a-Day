/*
	This is the Geb configuration file.
	See: http://www.gebish.org/manual/current/#configuration
*/


import org.openqa.selenium.chrome.ChromeDriver
import io.github.bonigarcia.wdm.ChromeDriverManager


waiting {
    timeout = 2
}

environments {
    ChromeDriverManager.getInstance().setup()
    driver = { new ChromeDriver() }
}
