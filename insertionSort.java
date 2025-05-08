import java.util.Arrays;

public class insertionSort {
    public void sort(int list[]){
        //get list length
        int n = list.length;

        //iterate through the list, compare key to current value and swap when needed
        for (int  i = 1; i< n; i++){
            //start with second value in list as the key
            int key = list[i];
            System.out.println("Current key: " + key);

            //need to keep track of the current element, the element to the left of the key
            int j = i-1;

            //compare and swap current element if greater than the key
            //while the current elements index is within the list, and the value of the current element is greater than the key
            while (j >= 0 && list[j] > key){
                System.out.println("Swapping " + list[j] + " and " + list[j+1]);
                //swap the key and the current element
                list[j+1] = list[j];
                
                //put greater value in next spot, and follow moved key
                j = j-1;

                System.out.println("Current list: "  + Arrays.toString(list));
            }
            //once loop is broken put key in the next spot in list
            list[j+1] = key;
        }
    }

    public void run(){
        System.out.println("----Insertion Sort----");
        //start by printing the list we will be using
        int[] list = {3, 4, 6, 9, 7, 2, 5};
        System.out.println(" Our list: " + Arrays.toString(list));
        
        //create object to run functions
        insertionSort object = new insertionSort();

        //use recursive sort function
        object.sort(list);

        //print final list
        System.out.println("Final List: ");
        for (int i = 0; i < list.length; i++){
            System.out.print(list[i] + " ");
        }
    }
}