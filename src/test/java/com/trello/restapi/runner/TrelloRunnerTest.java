package com.trello.restapi.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"json:target/cucumber-report/cucumber.json"},
                features = "classpath:features",
                glue = "com.trello.restapi.steps",
                monochrome = true,
                dryRun = false)
public class TrelloRunnerTest {

}
