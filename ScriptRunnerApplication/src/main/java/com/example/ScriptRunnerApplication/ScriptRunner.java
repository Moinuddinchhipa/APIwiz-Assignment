package com.example.ScriptRunnerApplication;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

public class ScriptRunner {

    public Object runScript(String language, String script) {
        try (Context context = Context.newBuilder(language)
                .allowAllAccess(true)
                .build()) {
            Value result = context.eval(language, script);
            return result.as(Object.class);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
