package java8;

import java.util.Arrays;
import java.util.List;

public class FindFirstElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Given the list of integers, find the first element of the list using Stream functions?
		List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
		Integer firstE = myList.stream().findFirst().orElse(null);
		System.out.println(firstE);
		
		/* or can also try below single line code */
	      /* When numbers are given as Array int[] arr = {10,15,8,49,25,98,98,32,15}; */
		int[] arr = {10,15,8,49,25,98,98,32,15};
		Arrays.stream(arr).boxed().findFirst().ifPresent(System.out::println);

	}

}
