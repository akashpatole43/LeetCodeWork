package java8;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringFindFirstNonRepeted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Given a String, find the first non-repeated character in it using Stream functions?
		String input = "Java articles are Awesome";
		
		Character res = input.chars() 	// stream of string
				.mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) 	// first convert to character obj and then to lowercase
				.collect(Collectors.groupingBy(
						Function.identity(), 
						LinkedHashMap::new, 
						Collectors.counting())) 	// store the chars in map with count
				.entrySet()
				.stream()
				.filter(f -> f.getValue() == 1L)
				.map(m -> m.getKey())
				.findFirst()
				.get();
		
	System.out.println(res);

	}

}
