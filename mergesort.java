import java.util.Arrays;

public class mergesort {
    public void divide(int[] list, int left, int right){
        //take in list, left, and right values to determine the middle and recursively split the list into equal sized sub arrays
        if (left < right){ //creates a loop since we are recursively calling the funtion, so while this condition is true we will call
            //find the midpoint, place to split into sub arrays
            int middle = (left + right) / 2;

            System.out.println("Mid point for arrays: " + middle);

            //split each sub array into a subarray

            int[] leftArr = Arrays.copyOfRange(list, left, middle); 
            int[] rightArr = Arrays.copyOfRange(list, middle + 1, right);

            System.out.println("Splittling left subarray: "+ Arrays.toString(leftArr));
            divide(list, left, middle);

            System.out.println("Splittling right subarray: "+ Arrays.toString(rightArr));
            divide(list, middle + 1, right);

            //will then need to merge the subarrays
            merge(list, left, middle, right);
            System.out.println("After merge: " + Arrays.toString(Arrays.copyOfRange(list, left, right + 1)));
        }
    }  
    
    public void merge(int[] list, int left, int middle, int right){
        //need to define the sub arrays
        //start by definig the size of each sub array
        int n1 = middle - left + 1;
        int n2 = right - middle;

        //then can create the subarrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        //fill the subarrays with the proper values from the original list
        for (int i =0; i<n1; i++){
            leftArray[i] = list[left+i];
        }

        for (int j =0; j<n2; j++){
            rightArray[j] = list[middle + 1 + j];
        }

        System.out.println("Merging:");
        System.out.println("  Left:  " + Arrays.toString(leftArray));
        System.out.println("  Right: " + Arrays.toString(rightArray));

        //now that we have the subarrays we have to merge them in the proper order, so we compare the values  in the arrays against each other
        int i =0, j=0, k=left;

        //while there are still values in each subarray we can compare them
        while ( i < n1 && j <n2){
            //if the value in the left is greater than the one in the right then we need to put it in the right place in the main array
            if (leftArray[i] <= rightArray[j]){
                list[k++] = leftArray[i++]; //put in arra then increase value
            } else{
                list[k++] = rightArray[j++];
            }
        }

        //in the case that either the left or right subaray is greater than the other we will need to fill the main array with rem. values
        while (i < n1){
            list[k++] = leftArray[i++];
        }

        while(j < n2){
            list[k++] = rightArray[j++];
        }
    }

    public void run(){
        System.out.println("----Merge Sort----");
        //start by printing the list we will be using
        int[] list = {3, 4, 6, 9, 7, 2, 5};
        System.out.println(" Our list: " + Arrays.toString(list));

        //divide calls the merge function for us and is recursive so just have to call divide to do the full sort
        mergesort object = new mergesort();

        object.divide(list, 0, list.length-1);

        //print out final list
        System.out.println("Final List: ");
        for (int i = 0; i < list.length; i++){
            System.out.print(list[i] + " ");
        }


    }
}