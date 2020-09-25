package com.crm.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crm.constants.Constants;
import com.crm.config.*;
import com.crm.exception.AutomationException;
import com.crm.utils.LocalTestDataManager;
import com.crm.utils.TestDataUtils;
import com.crm.utils.TestResultsUtils;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * The Class BeforeAfterStepDefinition.
 */
public class BeforeAfterStepDefinition extends TestDataUtils {

	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(BeforeAfterStepDefinition.class);
	TestResultsUtils testResultUtils = new TestResultsUtils();

	/**
	 * Beforetest.
	 *
	 * @param scenario
	 *            the scenario
	 * @throws LCBOException
	 *             the lcbo exception
	 * @throws Throwable
	 *             the throwable
	 */
	@Before
	public void beforetest(Scenario scenario) throws AutomationException, Throwable {
		try {

			TestResultsUtils.outputFolder();
			TestResultsUtils.extentReportInitialize();
			testResultUtils.logger = testResultUtils.extent.startTest(scenario.getName());
			LOG.info("In before step definition for scenario::{}", scenario.getName());
//			readTestData(scenario);

		} catch (Exception exception) {
			LOG.error("Scenario::{}-Error in execution of before testException is ::{}", scenario.getName(),
					exception.getMessage());
		}
	}

	/**
	 * Close.
	 *
	 * @throws LCBOException
	 *             the lcbo exception
	 */
	@After
	public void close() throws AutomationException {
		try {
			LOG.info("Current scenario status is::{}", LocalTestDataManager.getScenarioStatus());
			TestResultsUtils.extentReportFlush();
			tearDown();
		} catch (Exception exception) {
			LOG.error("Error in In After Block execution::{}", exception);
			throw new AutomationException(exception);
		}
	}

}