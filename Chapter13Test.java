import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.*;
import java.lang.*;
/**
 * JUnit Test class for Searching and Sorting
 */
public class Chapter13Test {
	/**
	 * Base lists
	 */
	static List<Integer> sorted, reverse, empty, single; 
	
	/**
	 * Reset the base lists just in case
	 */
	@BeforeEach 
	void reset(){
		sorted = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		reverse = new ArrayList<>(Arrays.asList(5,4,3,2,1));
		empty = new ArrayList<>();
		single = new ArrayList<>(Arrays.asList(3));
	}
	
	/**
	 * Tests iterative binary search using sorted list
	 */
	@Test 
	public void testItrBinary() throws IllegalArgumentException{
		assertTrue(itrBinary(sorted, 3));
		assertFalse(itrBinary(sorted, -1));
		assertThrows(IllegalArgumentException.class, ()->{itrBinary(null, 3);});
	}
	
	/**
	 * Tests descending bubble using the base lists
	 */
	@Test 
	public void testDescendBubble() throws IllegalArgumentException{
		assertEquals(empty, descendBubble(empty));
		assertEquals(single, descendBubble(single));
		assertEquals(reverse, descendBubble(reverse));
		assertEquals(reverse, descendBubble(sorted));
		assertThrows(IllegalArgumentException.class, ()->{descendBubble(null);});
	}
	
	/**
	 * Tests selectionHi using the base lists
	 */
	@Test 
	public void testSelectionHi() throws IllegalArgumentException{
		assertEquals(empty, selectionHi(empty));
		assertEquals(single, selectionHi(single));
		assertEquals(sorted, selectionHi(reverse));
		assertEquals(sorted, selectionHi(sorted));
		assertThrows(IllegalArgumentException.class, ()->{selectionHi(null);});
	}
	
	/**
	 * Tests randomQuick using the base lists
	 */
	@Test 
	public void testRandomQuick() throws IllegalArgumentException{
		assertEquals(empty, randomQuick(empty));
		assertEquals(single, randomQuick(single));
		assertEquals(sorted, randomQuick(reverse));
		assertEquals(sorted, randomQuick(sorted));
		assertThrows(IllegalArgumentException.class, ()->{randomQuick(null);});
	}
	
	/**
	 * An iterative implementation of binary search.
	 * 
	 * Precondition: list must be sorted.
	 * 
	 * @param sorted The list to be searched
	 * @param number The number to find
	 * @return True if the number exists in the list, false otherwise
	 * @throws IllegalArgumentException if the list is null
	 * We first set our min to zero then we have out max be the size of our list minus one
	 * when while our min is less than or equal to our max we calculate our mid point
	 * which our max and min values divided by two
	 * If our mid equals the number to find, then we get true 
	 * otherwise it starts the search for the number by recalibrating our min and max
	 * if the number does not exist we return false
	 */
	public static boolean itrBinary(List<Integer> sorted, int number) throws IllegalArgumentException{
		if(sorted == null){
			throw new IllegalArgumentException();
		}
	int min = 0;
		int max = sorted.size() - 1;
     while (min <= max) {
		 int mid = (max + min) / 2;
		 if (sorted.get(mid) == number) {
			 return true;
		 } else if (sorted.get(mid) < number) {
			 min = mid + 1;
		 } else {
			 max = mid - 1;
		 }
    }
    return false;
}
	
	/**
	 * Sorts a list using bubble sort in descending order rather than ascending order.
	 * 
	 * @param list The list that needs to be sorted.
	 * @return The sorted list
	 * @throws IllegalArgumentException if the list is null
	 * We go through the list with I, it represents our n, and our j represents n, n - 1, n - 2
	 * Then if i is less than j we sort the list so that j goes in front of I, then we return our new list
	 */
	public static List<Integer> descendBubble(List<Integer> list) throws IllegalArgumentException{
		if(list == null){
			throw new IllegalArgumentException();
		}
		for(int i = 0; i < list.size();i++){
			for(int j = i; j < list.size();j++){
				if(list.get(i) < list.get(j)){
					int temp = list.get(j); 
					list.remove(j); 
					list.add(j, list.get(i));  
					list.remove(i); 
					list.add(i, temp); 
				}
			}
		}
		return new ArrayList<Integer>(list);
	}
	
	/**
	 * Sorts a list by selecting for the highest value each iteration.
	 * 
	 * @param list The list that needs to be sorted.
	 * @return The sorted list
	 * @throws IllegalArgumentException if the list is null
	 * We create a new integer array list and add integer x to that list. 
	 * Then we start going through the list from the top down, from there we get our maximum i
	 * then we do another for loop with h compared to I starting from the top down, if we find that J is greater than our max value
	 * j becomes our new max value.
	 * Then int x becomes out max, we remove our max and add our lowest value at max.
	 * Then we set our list equal to our temp list and we return our list.
	 */
public static List<Integer> selectionHi(List<Integer> list) throws IllegalArgumentException{
	if(list == null){
			throw new IllegalArgumentException();
		}
		
		List<Integer> hand = new ArrayList<Integer>();
		for(int x:list){
			hand.add(x);
		}
		for(int i = list.size()-1; i >= 0;i--){ 
			int max = hand.get(i);
			for(int j = i; j >=0;j--){
				if(hand.get(j) > max){
					max = hand.get(j);
				}
			}
			int x = hand.indexOf(max);
			hand.remove(x);
			hand.add(i, max);
		}
		list = hand;
		return new ArrayList<Integer>(list);
	}
	
	
	/**
	 * Sorts a list using quicksort with a random pivot.
	 * 
	 * @param list The list that needs to be sorted.
	 * @return The sorted list
	 * @throws IllegalArgumentException if the list is null
	 * First we check if our list size is less than or equal to one, then we just return the list
	 * Then we create a new array list, random, and we set out random point, and we set our pivot equal to the removal of the randomepoint
	 * Then we create two new array lists, on ethat will go left and the other right. From there we create a new iterator and while our iterator goes through the list
	 * we create a new int temp equal to the next iterator if our iterator is less than our pivot point then we add the temp to the left list, otherwise we add it
	 * to our right list
	 * Then we create a new array list and recursivly call our left and right lists and it to the lists, then we return our temp arraylist
	 */
	public static List<Integer> randomQuick(List<Integer> list) throws IllegalArgumentException{
		if(list == null){
			throw new IllegalArgumentException();
		}
		if(list.size() <= 1){
			return list;
		}
		list = new ArrayList <Integer> (list);
		Random rand = new Random();
		int randpoint = rand.nextInt(list.size());
		int pivot = list.remove(randpoint);
		List<Integer> left = new ArrayList<>();
		List<Integer> right= new ArrayList<>();
		
		Iterator itr = list.iterator();
		while(itr.hasNext()){
			int temp = (int)itr.next();
			if(temp <= pivot){
				left.add(temp);
			}else{
				right.add(temp);
			}
		}
		List<Integer> temp = new ArrayList<>();
		left = randomQuick(left);
		right = randomQuick(right);
		temp.addAll(left);
		temp.add(pivot);
		temp.addAll(right);
		return new ArrayList <Integer> (temp);
	}
	}
	


