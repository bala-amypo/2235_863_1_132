package com.example.demo;

public class TestResultListener {
    
    public void logTestStart(String testName) {
        System.out.println("Test started: " + testName);
    }
    
    public void logTestSuccess(String testName) {
        System.out.println("Test passed: " + testName);
    }
    
    public void logTestFailure(String testName) {
        System.out.println("Test failed: " + testName);
    }
}