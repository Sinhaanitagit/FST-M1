import java.util.Arrays;
public class Activity4 {

	// public static void main(String[] args) {
    static void ascendingSort(int array[]) {
		// In this activity, we will be implementing the Insertion Sort algorithm
		// Insertion sort works in the similar way as we sort cards in our hand in a card game.
		// We assume that the first card is already sorted then, we select an unsorted card.
		// If the unsorted card is greater than the card in hand, it is placed on the right otherwise, to the left.
		// In the same way, other unsorted cards are taken and put at their right place.
		// Add a class named Activity4.
		// In the main() method: 
		// Initialize an array with numbers in random order
		// Use the insertion sort logic to sort the array in ascending order.
		// Display the array before and after sorting.
		
		int size = array.length, i;
        
        for (i = 1; i < size; i++) {
            int key = array[i];
            int j = i - 1;
            
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = key;
        }
    }
    
    public static void main(String args[]) {
        int[] data = { 9, 5, 1, 4, 3 };
        ascendingSort(data);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));


	}

}
