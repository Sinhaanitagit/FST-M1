import java.util.*;
public class Activity2 {

	public static void main(String[] args) {
		//In this activity, we are writing a program to check if the sum of all the 10's in the array is exactly 30.
		//Add a Class named Activity2.
		//In the main() method: 
		//Initialize an array with 6 number: [10, 77, 10, 54, -11, 10]
		//Find the 10's in the array and add them
		//Check if value is equal to 30.
		
		//Initialize the array
        int[] numArr = {10, 77, 10, 54, -11, 10};
        System.out.println("Original Array: " + Arrays.toString(numArr));
        
        //Set constants
        int searchNum = 10;
        int fixedSum = 30;

        //Print result
        System.out.println("Result: " + result(numArr, searchNum, fixedSum));
    }

    public static boolean result(int[] numbers, int searchNum, int fixedSum) {
        int temp_sum = 0;
        //Loop through array
        for (int number : numbers) {
            //If value is 10
            if (number == searchNum) {
                //Add them
                temp_sum += searchNum;
            }

            //Sum should not be more than 30
            if (temp_sum > fixedSum) {
                break;
            }
        }

        //Return true if condition satisfies
        return temp_sum == fixedSum;
	}
}
