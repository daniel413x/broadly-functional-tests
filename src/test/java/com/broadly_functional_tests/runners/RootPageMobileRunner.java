package com.broadly_functional_tests.runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com/features/root-page-mobile")
@ConfigurationParameter(
  key = PLUGIN_PROPERTY_NAME,
  value = "pretty, html:target/extent-report/root-page-report.html, junit:target/extent-report/root-page-report.xml, com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:")
  // order matters; base_steps comes second for the mobile overload to function
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.broadly_functional_tests.steps.root_page_mobile_steps, com.broadly_functional_tests.steps.base_steps")
public class RootPageMobileRunner {
}
