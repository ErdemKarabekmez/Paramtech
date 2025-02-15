package com.param.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                  "html:target/cucumber-report.html",
                   "rerun:target/rerun.txt"},

        features = "src/test/resources",
        glue  = "com/param/step_definitions",
        dryRun = false,
        tags = "@scenario3"
)
public class CukeRunner {
}
