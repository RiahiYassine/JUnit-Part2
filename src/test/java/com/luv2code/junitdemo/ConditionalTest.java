package com.luv2code.junitdemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

/*
  Specify that test methods in this class use a DisplayNameGeneration strategy to automatically generate display names.
    - DisplayNameGenerator.Simple: removes parentheses in method names
    - DisplayNameGenerator.ReplaceUnderscores: Replaces underscores in method names with spaces
    - DisplayNameGenerator.IndicativeSentences: Combine class with method name
*/
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestMethodOrder(MethodOrderer.Random.class)
class ConditionalTest {

    @Test
    @DisplayName("Test disabled until Bug JIRA #123 is fixed")
    @Disabled("Disabled until Bug JIRA #123 is fixed")
    void test_disabled_due_to_bug_jira_123() {
        // Test logic is omitted.
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void test_runs_only_on_windows() {
        // Test logic specific for Windows is executed here.
    }

    @Test
    @EnabledOnOs({OS.MAC, OS.LINUX})
    void test_runs_only_on_mac_and_linux() {
        // Test logic specific for macOS and Linux is executed here.
    }

    @Test
    @EnabledOnJre(JRE.JAVA_17)
    void test_runs_only_on_java_17() {
        // Test logic specific to Java version 17 is executed here.
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_11)
    void test_runs_on_java_11_and_above() {
        // Test logic for Java versions 11 and above is executed here.
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_13, max = JRE.JAVA_18)
    void test_runs_on_java_between_13_and_18() {
        // Test logic for Java versions 13 through 18 is executed here.
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "APP_ENV", matches = "prod")
    void test_runs_only_in_production_environment() {
        // Test logic is executed only when the environment variable APP_ENV is set to "prod".
    }

    @Test
    @EnabledIfSystemProperty(named = "deployment.mode", matches = "ci-cd")
    void test_runs_only_when_deployment_is_ci_cd() {
        // Test logic is executed only when the system property "deployment.mode" is set to "ci-cd".
    }
}