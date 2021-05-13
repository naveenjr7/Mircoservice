package com.learn.mircroservice.product.controller;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;


@EnabledOnJre(JRE.JAVA_11)
@EnabledOnOs(OS.MAC)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class calculatorTest {
    calculator calculator;

    @BeforeEach
    void setUp(TestInfo testInfo, TestReporter testReporter) {
        System.out.println("beforeEach " + testInfo.getTestMethod());
    }

    @BeforeAll
    void beforeAll() {
        calculator = new calculator();
        System.out.println("beforeAll ");
    }

    @Disabled
    @Test
    void testAdd() {
        //calculator calculator = new calculator();
        System.out.println("inside test " + calculator.hashCode());
        int sum = calculator.add(2, 7);
        assertEquals(9, sum, "this is basic you should get message");
        //assertAll();assumeTrue();assertArrayEquals();assertIterableEquals();assertThrows();
    }

    @RepeatedTest(3)
    @Test
    @DisplayName("Subtract numbers")
    @Tag("Math")
    void testSubtract(RepetitionInfo repetitionInfo) {
        //calculator calculator = new calculator();
        System.out.println("inside test1 " + calculator.hashCode());
        int subtract = calculator.subtract(2, 7 + repetitionInfo.getCurrentRepetition());
        assertEquals(-5 - repetitionInfo.getCurrentRepetition(), subtract, "this is basic you should get message");
    }


    @AfterAll
    void afterAll() {
        System.out.println("afterAll");
    }

    @AfterEach
    void tearDown() {
        System.out.println("afterEach");
    }
}