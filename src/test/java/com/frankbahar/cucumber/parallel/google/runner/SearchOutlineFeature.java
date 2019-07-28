package com.frankbahar.cucumber.parallel.google.runner;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(features = "src/test/resources/com/frankbahar/cucumber/parallel/google/features/search-outline.feature", glue = "com.frankbahar.cucumber.parallel.google")

public class SearchOutlineFeature {
	@Test
	public void runCukes() {
		new TestNGCucumberRunner(getClass()).runCukes();

	}

}
