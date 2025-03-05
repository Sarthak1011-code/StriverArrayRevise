import java.util.*;
public class ArrayEasy {
    // QUESTION 1..
    // FIND THE LARGEST...
    public static int largest(int arr[]) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // QUESTION 2...
    // FIND THE SECOND LARGEST...
    public static int SecondLargest(int arr[]) {
        int Largest = Integer.MIN_VALUE;
        int SecondLargest = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > Largest) {
                SecondLargest = Largest;
                Largest = arr[i];
            }else if(arr[i] > SecondLargest && arr[i] < Largest) {
                SecondLargest = arr[i];
            }
        }
        if(SecondLargest == Integer.MIN_VALUE) {
            return -1;
        }

        return SecondLargest;
    }


    // QUESTION 3..
    // CHECK IF THE ARRAY IS SORTED AND ROTATED...
    public static boolean CheckSortedAndRotated(int arr[]) {
        int n = arr.length-1;

        int count = 0;

        for(int i = 1; i < arr.length; i++) {  
            if(arr[i-1] > arr[i]) {
                count++;
            }
        }
        if(arr[n] > arr[0]) {  //last element hmesa chota hona chahiye first element se tbhi rotated kehlayega
            count++;
        }

        return count <= 1;  //this returns true if the value of count is 1 and lesser than 1

    }

    // QUESTION 4..
    // REMOVE DUPLICATES FROM SORTED ARRAY...
    public static int RemoveDuplicates(int arr[]) {
        int count = 0;
        
        for(int i = 0; i < arr.length; i++) {
            if(i < arr.length-1 && arr[i] == arr[i+1]) {
                continue;
            }else {
                arr[count] = arr[i];  //shruwat me count ka value 0 hoga..phir whi se element add hoga 

                count++;
            }
        }
        return count;
    }

    // QUESTION 5..
    // ROTATE ARRAY BY K PLACES...
    public static void RotateArrayByKplaces(int arr[] , int k) {
        int temp[] = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            temp[(i+k)%arr.length] = arr[i];
        }

        System.arraycopy(temp, 0, arr, 0, arr.length);

    }

    // QUESTION 6...
    // MOVE ALL ZEROS TO END..
    public static void MoveZerosToEnd(int arr[]) {
        int i = 0;

        for(int j = 0; j < arr.length; j++) {
            if(arr[j] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
    }


    // QUESTION 7...
    // LINEAR SEARCH..
    public static boolean LinearSearch(int arr[] , int k) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == k) {
                return true;
            }
        }
        return false;
    }


    // QUESTION 8...
    // FIND THE UNION...
    public static ArrayList<Integer> FindUnion(int arr1[] , int arr2[]) {

        ArrayList<Integer> Union = new ArrayList<>();

        int i = 0 , j = 0;

        while(i < arr1.length && j < arr2.length) {
            if(i > 0 && arr1[i] == arr1[i-1]) {
                i++;
                continue;
            }

            if(j > 0 && arr2[j] == arr2[j-1]) {
                j++;
                continue;
            }

            if(arr1[i] < arr2[j]) {
                Union.add(arr1[i]);
                i++;
            }else if(arr1[i] > arr2[j]) {
                Union.add(arr2[j]);
                j++;
            }else {
                Union.add(arr1[i]);
                i++;
                j++;
            }


        }


        while(i < arr1.length) {
            if(arr1[i] > 0 && arr1[i] == arr1[i-1]) {
                i++;
                continue;
            }

            Union.add(arr1[i]);
            i++;
        }

        while(j < arr2.length) {
            if(arr2[j] > 0 && arr2[j] == arr2[j-1]) {
                j++;
                continue;
            }

            Union.add(arr2[j]);
            j++;
        }


        return Union;

    }


    // QUESTION 9...
    // FIND MISSING NUMBER IN AN ARRAY...
    public static int MissingNumber(int arr[]) {
        int sum = 0;

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        int ActualSum = (arr.length * (arr.length + 1)) / 2;

        int MissingNumber = ActualSum - sum;

        return MissingNumber;
    }


    // QUESTION 10...
    // MAXIMUM CONSICUTIVE ONES...
    public static int FindMaxConsecutiveOnes(int arr[]) {
        int Count = 0; 
        int MaxCount = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) {
                Count++;
                MaxCount = Math.max(MaxCount , Count);

            }else {
                Count = 0;
            }
        }
        return MaxCount;
    }

    // QUESTION 11...
    // FIND THE NUMBER THAT APPEAR ONLY ONCE AND OTHER NUMBER TWICE...
    public static int SingleNumber(int arr[]) {
        int xor = 0;

        for(int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
        }

        return xor;
    }

    // QUESTION 12...
    // FIND THE LENGTH OF LONGEST SUBARRAY SUM EQUALS K..

    public static int LengthOfLongestSubarrayWithSumK(int arr[] , int k) {

        // BASED ON SLIDING WINDOW APPROACH..
        int left = 0, right = 0;

        long Sum = arr[0];

        int MaxSum = 0;

        int n = arr.length;

        while(right < n) {
            // IF THE SUM EXCEEDS K , MOVE THE LEFT POINTER TO REDUCE THE WINDOW..
            while(left <= right && Sum > k) {
                Sum -= arr[left];
                left++;
            }

            // IF THE SUM EQUALS K UPDATE MAXLENGTH..
            if(Sum == k) {
                MaxSum = Math.max(MaxSum , right-left + 1);
            }


            // MOVE THE RIGHT POINTER TO EXPAND THE WINDOW..
            right++;
            if(right < n) {
                Sum += arr[right];
            }
        }

        return MaxSum;

    }

    public static void main(String args[]) {

    }
}