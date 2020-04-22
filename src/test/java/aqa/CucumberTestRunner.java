package aqa;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "steps")
// , tags = {"not @Ignore"} not - игнорировать тесты с указаннме тегом
// без not - выполнять только тест с указанным тегом
// >mvn clean install - почитать

public class CucumberTestRunner {

}
