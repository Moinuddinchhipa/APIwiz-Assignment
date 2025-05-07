package com.example.ScriptRunnerApplication;

public class ScriptRunnerTest {
    public static void main(String[] args) {
        ScriptRunner runner = new ScriptRunner();

        // Test JavaScript
        String jsScript = "var greeting = 'Hello from JavaScript'; greeting;";
        Object jsResult = runner.runScript("js", jsScript);
        System.out.println("JavaScript Result: " + jsResult);

        // Test Python
        String pyScript = "greeting = 'Hello from Python'\ngreeting";
        Object pyResult = runner.runScript("python", pyScript);
        System.out.println("Python Result: " + pyResult);
    }
}
