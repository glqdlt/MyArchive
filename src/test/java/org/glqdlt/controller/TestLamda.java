package org.glqdlt.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

import org.junit.Test;

public class TestLamda {

	/**
	 * Predicate는 람다식이고, test(x) 에 들어오는 x의 값을 비교하여 값을 담는 식이다. boolean 타입이 떨어질 수
	 * 있는 식으로 사용가능한듯.
	 */
	@Test
	public void predicateTest() {

		Predicate<Integer> atLeast1 = x -> x > 5;
		System.out.println(atLeast1.test(6));
		System.out.println(atLeast1.test(3));

		Predicate<Integer> atLeast3 = x -> (x + x) > 5;
		System.out.println(atLeast3.test(3));

		Predicate<String> atStr1 = x -> x.equals("hello");

		System.out.println(atStr1.test("Oh"));
		System.out.println(atStr1.test("hello"));

		Predicate<Map<String, Object>> atMap = x -> x.get("key1").equals("hello");

		Map<String, Object> targetMap = new HashMap<>();
		// 여기서는 nullpoint 가 뜸. null 체크는 하지 않는 거 같다.
		// System.out.println(atMap.test(targetMap));
		targetMap.put("key1", "hi");
		System.out.println(atMap.test(targetMap));
		targetMap.put("key1", "hello");
		System.out.println(atMap.test(targetMap));

	}

}
