package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindSecondLargestWordLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "I love you akash";
		int len = Arrays.stream(str.split("\\s+"))		// split by white space and from array and use stream
				.map(m -> m.length()) 					// convert the words into its length
				.sorted(Comparator.reverseOrder())		// sort by descending order
				.skip(1)								// skip the largest length
				.findFirst()							// get the second largest length
				.orElse(0);								// or save 0
		System.out.println("second largest length is " + len);
				

	}

}
