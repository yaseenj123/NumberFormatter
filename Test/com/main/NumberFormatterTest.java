package com.main;

import org.junit.*;

import java.util.Arrays;
import java.util.Collection;

public class NumberFormatterTest {

    private NumberFormatter numberFormatter;

    @Before
    public void setUp()
    {
        numberFormatter = new NumberFormatter();
    }

    @Test
    public void testCollect()
    {
        String input = "87,95,45,14";
        Collection<Integer> expectedOutput = Arrays.asList(14, 45, 87, 95);
        Collection<Integer> actualOutput = numberFormatter.collect(input);
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testCollectNegativeOutcome()
    {
        String input = "79,115,88,3,23";
        Collection<Integer> expectedOutput = Arrays.asList(3, 23, 88, 79, 115);
        Collection<Integer> actualOutput = numberFormatter.collect(input);
        Assert.assertNotEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testSummarizeCollection()
    {
        Collection<Integer> input = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        String expectedOutput = "1,3,6-8,12-15,21-24,31";
        String actualOutput = numberFormatter.summarizeCollection(input);
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testSummarizeCollectionNegativeOutcome()
    {
        Collection<Integer> input = Arrays.asList(1, 2, 3, 5, 6, 7, 9, 15, 16, 17);
        String expectedOutput = "1-3,5,6-7,9,15-16,17";
        String actualOutput = numberFormatter.summarizeCollection(input);
        Assert.assertNotEquals(expectedOutput, actualOutput);
    }

}
