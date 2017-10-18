/* Question
Given an array A[], of 'n' elements. Your task is to complete the function 
minDist which returns  an integer denoting the minimum distance between two 
integers x and y in the array. If no such distance is possible then return -1.
*/

/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*Complete the function below*/
class GfG
{
    int minDist(int arr[], int n, int x, int y) 
    {
       if (arr.length == 0) {
           return -1;
       }
       //prev used to keep track of the last encounted x OR y
       int prev = -1;
       int min = Integer.MAX_VALUE;
       //find either x or y and break.
       for (int i = 0; i < arr.length; ++i) {
           if (arr[i] == x || arr[i] == y) {
               prev = i;
               break;
           }
       }
       //enter the loop only if prev != -1
       /*start from prev and iterate over the entire array, updating prev value 
       as when requied, calc min and update the prev to the current idx*/
       for (int i = prev + 1; i < arr.length && prev != -1; ++i) {
           if (arr[i] == arr[prev]) {
               prev = i;
           } else if ((arr[i] == x || arr[i] == y) && arr[i] != prev) {
               min = Math.min (Math.abs(i - prev), min);
               prev = i;
           }
       }
       if (min == Integer.MAX_VALUE) {
           return -1;
       }
       return min;
    }
}