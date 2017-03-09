package org.syz;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(1);

		Predicate<Integer> p1 = i -> i == 2;
		boolean b1 = list.stream().anyMatch(p1);
		System.out.println(b1);

		System.out.println(list.stream().distinct().collect(Collectors.toList()));
		System.out.println(list.stream().findAny());

		Stream.of("AAA", "BBB", "CCC").parallel().forEach(s -> System.out.println("Output:" + s));
		Stream.of("AAA", "BBB", "CCC").parallel().forEachOrdered(s -> System.out.println("Output:" + s));//记住原始的顺序

		System.out.println(list.stream().isParallel());
		list.parallelStream().forEach(System.out::println);//并行打印

		list.stream().peek(System.out::println);
		System.out.println(list.stream().parallel().isParallel());
		list.stream().sequential();//并行流转化为顺序刘
		System.out.println(list.stream().isParallel());
		list.stream().sorted().forEach(System.out::println);
		list.stream().unordered().forEach(System.out::println);//回到原始的添加顺序
	}
}
