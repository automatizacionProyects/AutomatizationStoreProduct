# AutomatizationStoreProduct
Automatization with Selenium webDriver, Screenplay, Cucumber

# Project Stack
Se automatizo la siguiente pagina web https://demoblaze.com/index.html# con las siguientes tecnologias Automatization Framework: Selenium webdriver, Design pattern: Screenplay y cucumber. Programmin lenguage: Java, IDE: Intellij IDEA

# Steps to execute the proyect:
Ejecutar la clase Java que se encuentra en src/test/java/runners/TestRunner esta clase sin el tag en la configuracion ejecutara todos nuestros features Si se desea ejecutar un feature en especifico utilizar tag "tags" que sirve para ejecutar un feature en especifico.

# Ejecutar automatización con el TAGS
@RunWith(Cucumber.class) @CucumberOptions( features = "src/test/resources/features", glue = "stepdefinitions", plugin = {"pretty", "html:target/cucumber-reports.html"}, tags="@nombredelScenario"

) public class TestRunner { }

" Ejecutar automatización sin el tag
@RunWith(Cucumber.class) @CucumberOptions( features = "src/test/resources/features", glue = "stepdefinitions", plugin = {"pretty", "html:target/cucumber-reports.html"}

) public class TestRunner { }

# Reportes Cucumber
En la carpeta target en la raiz se encuentra el archivo cucumbers-reports.html abrirlo con el navegador deseado y ver los test que se corrieron
