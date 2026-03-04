package java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicateElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
		
		Set<Integer> s = new HashSet<>();
		
		//How to find duplicate elements in a given integers list in java using Stream functions?
		Set<Integer> ans = myList.stream()
				.filter(f -> !s.add(f))
				.collect(Collectors.toSet());
		ans.forEach(System.out::println);
		
		/* Way 1 - Gives list of all distinct/unique values */
		List<Integer> d = myList.stream().distinct().collect(Collectors.toList());
		System.out.println(d);
		
		
		/* When numbers are given as Array int[] arr = {10,15,8,49,25,98,98,32,15}; */
		int[] arr = {10,15,8,49,25,98,98,32,15};
		List<Integer> list = Arrays.stream(arr).boxed()  //this code is needed to use stream on array
				.distinct()
				.collect(Collectors.toList());
		System.out.println(list);

	}

}
