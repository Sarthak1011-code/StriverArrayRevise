package Array1;


import java.util.ArrayList;

public class ArrayMedium {
    // QUESTION 1..
    // TWO SUM PROBLEM...
    public static ArrayList<Integer> TwoSum(int arr[] , int target) {

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {

            for(int j = i+1; j < arr.length; j++) {

                if(arr[i] + arr[j] == target) {
                    list.add(i);
                    list.add(j);
                }
            }
        }
        return list;
    }


    // QUESTION 2...
    // SORT THE ARRAY'S OF 0S 1S AND 2S..
    // ***  DUTCH NATIONAL FLAG ALGORITHM  ***....

    public static void SortTheArraysOf0s1sAnd2s(int arr[]) {
        int n = arr.length - 1;

        int low = 0 , mid = 0 , high = n;

        while(mid <= high) {
            if(arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            }else if(arr[mid] == 1) {
                mid++;
            }else {
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            }
        }
    }


    // QUESTION 3...
    // MAJORITY ELEMENT...
    //***   BOYER-MOORE VOTING ALGORITHM  ***

    public static int MajorityElement(int arr[]) {
        int Candidate = arr[0];

        int Count = 1;

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == Candidate) {
                Count++;
            }else {
                Count--;
                if(Count == 0) {
                    Candidate = arr[i];
                    Count = 1;
                }
            }
        }

        return Candidate;


        // ALGO STEPS


        // 1-> AFTER INITIALISING THE VARIABLES CANDIDATE AND COUNT,
        // TRAVERSE THE ARRAY STARTING FROM THE SECOND INDEX...

        // 2-> FOR EACH ELEMENT:
        // 1->IF THE ELEMENT IS EQUAL TO THE CURRENT CANDIDATE INCREMENT THE COUNT
        // 2->IF THE ELEMENT IS NOT EQUAL TO THE CURRENT ELEMENT DECREMENT THE COUNT
        // 3->IF THE COUNT BECOMES ZERO, UPDATE THE CANDIDATE TO THE CURRENT ELEMENT AND RESET THE COUNT TO 1

        // 3->AT THE END OF THE TRAVERSAL THE CANDIDATE WILL HOLD THE MAJORITY ELEMENT..

    }


    // QUESTION 4..
    // KADANES'S ALGORITHM..
    public static void MaxSubarraySum(int arr[]) {
        
        int CurrentSum = arr[0];

        int MaxSum = arr[0];

        for(int i = 1; i < arr.length; i++) {

            CurrentSum = Math.max(arr[i] , CurrentSum + arr[i]);

            MaxSum = Math.max(CurrentSum , MaxSum);
        }

        System.out.println("Our Max Subarray Sum is : " + MaxSum);
    }


    // QUESTION 5...
    // STOCK BUY AND SELL...
    public static int MaxProfit(int arr[]) {

        int MinPrice = Integer.MAX_VALUE;

        int MaxProfit = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < MinPrice) {
                MinPrice = arr[i];
            }else if(arr[i] - MinPrice > MaxProfit) {
                MaxProfit = arr[i] - MinPrice;
            }
        }
        return MaxProfit;
    }

    // QUESTION 6...
    // REARRANGE ARRAY ELEMENTS BY SIGN...
    public static ArrayList<Integer> RearrangeArray(int arr[]) {
        int n = arr.length;

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            ans.add(0);  //fill the arraylist with zeros..
        }

        int PosIndex = 0; //even index to store the positive numbers...

        int NegIndex = 1;

        for(int i = 0; i < n; i ++) {

            if(arr[i] < 0) {
                ans.set(NegIndex , arr[i]);
                NegIndex += 2;
            }else {
                ans.set(PosIndex , arr[i]);
                PosIndex += 2;
            }
        }
        return ans;
    }


    // QUESTION 7...
    // NEXT PERMUTATION...
    public static void NextPermutation(int arr[]) {
        int n = arr.length;
        int pivot = -1;

        for(int i = n-2; i >= 0; i--) {
            if(arr[i] < arr[i+1]) {
                pivot = i;
                break;
            }
        }

        if(pivot == -1) {
            reverse(arr , 0 , n-1);
            return;
        }

        // FIND THE NEXT LARGER ELEMENT TO SWAP WITH THE PIVOT...
        for(int i = n-1; i >= 0; i--) {
            if(arr[i] > arr[pivot]) {
                swap(arr , i , pivot);
                break;
            }
        }

        // REVERSE
        reverse(arr , pivot+1 , n-1);
    }

    // HELPER FUNCTION TO REVERSE THE ARRAY..
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }


    // Helper function to swap two elements in the array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    // QUESTION 8....
    // LEADERS IN AN ARRAY PROBLEM...
    public static ArrayList<Integer> Leaders(int arr[]) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i] < arr[j]) {
                    continue;
                }else {
                    list.add(arr[j]);
                }
            }
        }
        return list;
    }


//  QUESTION 9...
//  MAJORITY ELEMENT 2...
    public static ArrayList<Integer> Majorityelement(int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();

        int n = arr.length;

        int threshold = n / 3;

//        iterate through each element in the array...
        for(int i = 0; i < n; i++) {
            int Count = 0;

//            Count occurence of arr[i] in the array
            for(int j = 0; j < n; j++) {
                if(arr[j] == arr[i]) {
                    Count++;
                }
            }
//            if Count is greater than n/3 times and if arr[i] is not already in the result add it to ans list
            if(Count > threshold && !ans.contains(arr[i])) {
                ans.add(arr[i]);
            }
        }
        return ans;
    }





    

    public static void main(String args[]) {

    }
}


