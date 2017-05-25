package org.glqdlt.okky;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamTest0001 {

	private List<PersonVO> setPersons() {

		PersonVO park = new PersonVO();
		park.setJob("백수");
		park.setName("박지요");
		park.setOld(30);
		PersonVO shin = new PersonVO();
		shin.setJob("개발자");
		shin.setName("신진수");
		shin.setOld(30);

		List<PersonVO> list = new ArrayList<>();
		list.add(shin);
		list.add(park);

		return list;
	}

	@Test
	public void test001() {

		List<PersonVO> list = setPersons();

		long count = list.stream().filter(x -> x.jobCheck("백수")).count();

		long count2 = list.stream().filter(x -> {
			return x.jobCheck("하하");
		}).count();

		/**
		 * filter에서 predicate 를 받기 떄문인듯.
		 */
		long count3 = list.stream().filter(x -> {
			boolean b = x.getName().equals("박지요");
			return b;
		}).count();

	}

	@Test
	public void test002() {
		List<String> col = Stream.of("a", "b").collect(Collectors.toList());

		assertEquals(Arrays.asList("a", "b"), col);
		List<String> collected = Stream.of("a", "b", "c").map(x -> x.toUpperCase()).collect(Collectors.toList());

		assertEquals(Arrays.asList("A", "B", "C"), collected);

		// Object[] collected02 = Stream.of(Arrays.asList("1","2")).toArray();
		// List<String> collected03 = (List<String>)
		// Stream.of(Arrays.asList("1","2"));

		// 재밌는건 list 와 object 가 다른 타입이라고 나온다.
		// assertEquals(Arrays.asList("1","2"), collected02 );
		// 웃긴건 아래에 형변환 cast가 안된다.
		// assertEquals(Arrays.asList("1","2"), collected03 );

	}

	@Test
	public void test003() {

		List<String> beginningNumbs = Stream.of("a", "b", "1a").filter(x -> Character.isDigit(x.charAt(0)))
				.collect(Collectors.toList());

		// assertEquals(Arrays.asList("1a"), beginningNumbs);
		// 1a갑이 들어가있는게 정답인데, 일부러 오탐을 내게 해보았다. 2a로 넣으면 1a != 2a 이므로 Junit 콘솔에서
		// 에러를 내뱉는다.
		assertEquals(Arrays.asList("2a"), beginningNumbs);

		List<String> beginningMy = Stream.of("seoul", "daegu", "ulsan").filter(x -> {

			if (x.equals("seoul")) {
				return true;
			}
			return false;
		}).collect(Collectors.toList());

		assertEquals(Arrays.asList("seoul"), beginningMy);
	}

	// assertEquals 는 Junit 에서 제공한다. 틀리면 Junit 콘솔창에서 잘못됬다는 것을 알려주고, 맞으면 그냥 아무일없이
	// ~ 그냥 통과됨.
	@Test
	public void test004() {

		List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4)).flatMap(x -> x.stream())
				.collect(Collectors.toList());

		assertEquals(Arrays.asList(1, 2, 3, 4), together);
	}

}
