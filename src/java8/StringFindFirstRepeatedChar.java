package java8;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

//Given a String, find the first repeated character in it using Stream functions?
public class StringFindFirstRepeatedChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "Java Articles are Awesome";
		
		Character res = input.chars()
				.mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
				.collect(Collectors.groupingBy(
						Function.identity(),
						LinkedHashMap::new,
						Collectors.counting()))
				.entrySet()
				.stream()
				.filter(f -> f.getValue() > 1L)
				.map(m -> m.getKey())
				.findFirst()
				.get();
		System.out.println(res);

	}

}
