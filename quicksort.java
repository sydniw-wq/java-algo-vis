import java.util.Arrays;

public class quicksort {
    public int parition(int[] list, int l, int high){
        //pivot and low value
        int pivot = list[high];
        int low = l-1; //start 1 before

        //for every element in the list
        for (int i =l; i < high; i++){
            //if the current element is less than or equal to the pivot, need to make sure its in the left subarray
            if (list[i] <= pivot){
                //increase k, will take the next lowest spot in the list
                low++;

                //create temp variable to be able to swap elements easily
                System.out.println("Swapping " + list[i] + " and " + list[low]);
                int temp = list[i];
                list[i] = list[low];
                list[low] = temp;

                System.out.println("Current List: " + Arrays.toString(list));
            }

        }
            
        //values greater than pivot go to the end of the list (right subarray)
        //start temp where first subarray leaves off
        System.out.println("Swapping " + list[low+1] + " and " + list[high]);
        int temp = list[low + 1];
        list[low + 1] = list[high];
        list[high] = temp;

        System.out.println("Current List: " + Arrays.toString(list));

        //low + 1 = next pivot
        return low + 1;

    } 

    public void sort(int[] list, int low, int high){
        //create a new pivot with each low and high
        if (low < high){
            int pivot = parition(list, low, high);

            System.out.println("Current Pivot: " + pivot);

            //sort all elements before partition
            sort(list, low, pivot - 1); //put a limit on the high to divide the full list

            //sort all elements after the partition
            sort(list, pivot + 1, high);
        }

    }

    public void run(){
        System.out.println("----Quick Sort----");
        //start by printing the list we will be using
        int[] list = {3, 4, 6, 9, 7, 2, 5};
        System.out.println(" Our list: " + Arrays.toString(list));

        //get high value
        int n = list.length;
        
        //create object to run functions
        quicksort object = new quicksort();

        //use recursive sort function
        object.sort(list,0, n-1);

        //print final list
        System.out.println("Final List: ");
        for (int i = 0; i < n; i++){
            System.out.print(list[i] + " ");
        }
    }
}