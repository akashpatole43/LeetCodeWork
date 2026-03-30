package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Given a list of integers, find out all the numbers starting with 1 using Stream functions?
public class StartingWith1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
		
//		List<Integer> ans = myList.stream()
//				.map(m -> m.toString())
//				.filter(f -> f.startsWith("1"))
//				.map(m -> Integer.parseInt(m))
//				.collect(Collectors.toList());
//		ye mera solution 
		List<Integer> ans = myList.stream().filter(f -> String.valueOf(f).startsWith("1")).collect(Collectors.toList());
		
		System.out.println(ans);
	}

}
