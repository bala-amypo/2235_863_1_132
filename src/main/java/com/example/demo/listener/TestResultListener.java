package com.example.demo.listener;

import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

public class TestResultListener extends AbstractTestExecutionListener {

    public TestResultListener() {}

    @Override
    public void beforeTestClass(TestContext testContext) {
        System.out.println("Starting Test Suite for: " + testContext.getTestClass().getName());
    }

    @Override
    public void afterTestMethod(TestContext testContext) {
        if (testContext.getTestException() != null) {
            System.err.println("TEST FAILED: " + testContext.getTestMethod().getName() 
                + " - Reason: " + testContext.getTestException().getMessage());
        } else {
            System.out.println("TEST PASSED: " + testContext.getTestMethod().getName());
        }
    }

    @Override
    public void afterTestClass(TestContext testContext) {
        System.out.println("Finished Test Suite for: " + testContext.getTestClass().getName());
    }
}