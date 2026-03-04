package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Given a list of integers, find out all the even numbers that exist in the list using Stream functions?

public class EvenNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);
		
		List<Integer> ans = list.stream()
				.filter(c -> c%2 ==0)
				.collect(Collectors.toList());
		
		System.out.println(ans);

	}

}
