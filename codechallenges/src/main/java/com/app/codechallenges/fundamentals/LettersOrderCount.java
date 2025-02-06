package com.app.codechallenges.fundamentals;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Count the quantity of repeats letters in descending order Example: WWCWMCMMW
 * Output: W = 4, M = 3, C = 1
 */
public class LettersOrderCount {

	/**
	 * Order a TreeMap using comparing interface
	 * 
	 * @param sample text
	 * @return Descending order TreeMap
	 */
	public static TreeMap<Character, Integer> orderLettersWithTreeM(String text) {
		Map<Character, Integer> frequencyMap = new HashMap<>();
		for (char ch : text.toCharArray()) {
			frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
		}
		TreeMap<Character, Integer> sortedMap = new TreeMap<>((char1, char2) -> {
			int freqCompare = frequencyMap.get(char2).compareTo(frequencyMap.get(char1));
			if (freqCompare == 0) {
				return char2.compareTo(char1);
			}
			return freqCompare;
		});
		sortedMap.putAll(frequencyMap);
		return sortedMap;
	}

	/**
	 * Order a HashMap using algorithms
	 * 
	 * @param input
	 * @return
	 */
	public static Map<Character, Integer> orderLettersWithHashM(String input) {

		char[] characters = { 'W', 'M', 'C' };
		int[] frequencies = new int[characters.length];

		// insert frequencies values
		for (char ch : input.toCharArray()) {
			for (int i = 0; i < characters.length; i++) {
				if (ch == characters[i]) {
					frequencies[i]++;
					break;
				}
			}
		}

		// sort frequencies
		for (int i = 0; i < frequencies.length - 1; i++) {
			for (int j = 0; j < frequencies.length - i - 1; j++) {
				if (frequencies[j] < frequencies[j + 1]) {

					int tempFreq = frequencies[j];
					frequencies[j] = frequencies[j + 1];
					frequencies[j + 1] = tempFreq;

					char tempChar = characters[j];
					characters[j] = characters[j + 1];
					characters[j + 1] = tempChar;
				}
			}
		}

		Map<Character, Integer> freqCharacters = new HashMap<>();
		for (int i = 0; i < frequencies.length; i++) {
			freqCharacters.put((Character)characters[i], frequencies[i]);
		}

		return freqCharacters;
	}
}
