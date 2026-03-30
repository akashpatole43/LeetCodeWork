package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
		
		// accending order
		System.out.println(myList.stream().sorted().collect(Collectors.toList()));
		
		//descending order
		System.out.println(myList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()));

	}

}
