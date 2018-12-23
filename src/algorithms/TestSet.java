package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestSet {

	public static void main(String[] args) {
		List<String> inputList = new ArrayList<String>(Arrays.asList("abc", "abc", "abc", "dd", "dd"));
		
		Set<String> outputSet = new HashSet<String>();
		for(int i=0; i<inputList.size(); i++) {
			outputSet.add(inputList.get(i));
		}
		
		System.out.println(outputSet.size());
		System.out.println(outputSet.toArray(new String[outputSet.size()]).length);
	}

}
