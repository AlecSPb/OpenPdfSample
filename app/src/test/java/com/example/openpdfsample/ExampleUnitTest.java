package com.example.openpdfsample;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }



    @Test
    public void text_replace_isCorrect() {

        String templateString = "The ${animal} jumped over the ${target}.";
        Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put("animal", "quick brown fox");
        valuesMap.put("target", "lazy dog");

        StringHelper helper = new StringHelper();
        String res = helper.ReplaceTemplateText(templateString, valuesMap);
        assertEquals("The quick brown fox jumped over the lazy dog.", res);
    }
}