/*
* https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
* */

public class FirstLastPositionOfElement {

    public static void main(String[] args) {
        LeetCode obj = new LeetCode();
        System.out.println(obj.binarySearchRight(new int[]{-1,0,3,4,5,5,5,9,12}, 5));
    }

    public int binarySearchLeft(int[] arr, int num){
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while(low <= high){
            mid = low + (high - low)/2;
            if(num < arr[mid]){
                high = mid - 1;
            }
            else if(num > arr[mid]){
                low = mid + 1;
            }
            else{
                if(mid > 0 && arr[mid - 1] == arr[mid]){
                    high = mid - 1;
                }
                else{
                    return mid;
                }
            }
        }
        return -1;
    }

    public int binarySearchRight(int[] arr, int num){
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while(low <= high){
            mid = low + (high - low)/2;
            if(num < arr[mid]){
                high = mid - 1;
            }
            else if(num > arr[mid]){
                low = mid + 1;
            }
            else{
                if(mid < arr.length - 1 && arr[mid + 1] == arr[mid]){
                    low = mid + 1;
                }
                else{
                    return mid;
                }
            }
        }
        return -1;
    }

}