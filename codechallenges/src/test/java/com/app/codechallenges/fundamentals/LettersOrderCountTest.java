package com.app.codechallenges.fundamentals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LettersOrderCountTest {
	
	private String text;
	@BeforeEach
	public void before() {
		  text = "WCWMCWWMWWMC";
	}

	@Disabled
	@Test
	public void testLetters() {
		TreeMap<Character, Integer> sortedMap = LettersOrderCount.orderLettersWithTreeM(text);

        for (Map.Entry<Character, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
	}

	@Disabled
	@Test
	public void testLettersHashMap() {
		Map<Character, Integer> map = LettersOrderCount.orderLettersWithHashM(text);
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}

	}
	
	@ParameterizedTest
	@CsvSource({ "WCWMCWWMWWMMC, W:6;M:4;C:3", "AAABBBCCC, C:3;B:3;A:3", "XYZXYZXY, Y:3;X:3;Z:2" })
	public void testLettersWithParameterized(String text, String expected) {
		TreeMap<Character, Integer> sortedMap = LettersOrderCount.orderLettersWithTreeM(text);
		String result = sortedMap.entrySet().stream().map(e -> e.getKey() + ":" + e.getValue())
				.reduce((a, b) -> a + ";" + b).orElse("");
//		System.out.println("result "+result);
//		System.out.println("expected "+expected);
//		for (Map.Entry<Character, Integer> entry : sortedMap.entrySet()) {
//			System.out.println(entry.getKey() + "," + entry.getValue()+";");
//		}
		assertEquals(expected, result);
	}
}
