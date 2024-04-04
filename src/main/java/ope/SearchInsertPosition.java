package ope;

public class SearchInsertPosition {
    /*
    Given a sorted array of distinct integers and a target value:

        return the index if the target is found.
        If not, return the index where it would be if it were inserted in order.

    You must write an algorithm with O(log n) runtime complexity.
    Given a sorted array of distinct integers and a target value,
    return the index if the target is found.

    If not, return the index where it would be if it were inserted in order.

    You must write an algorithm with O(log n) runtime complexity.
     */

    /*
        Find the middle index of the array.

        If target is equal to middle index, return index.
        else if target is less than middle index:
            set startIndex to 0.
            set endIndex to middleindex - 1.
            repeat search
        else if target is greater than middle index:
            set startIndex to middleIndex + 1
            set endIndex to length - 1 of array.
            repeat search.

     */
    public static void main(String[] args) {
        SearchIndex lol = new SearchIndex();
        int[] array1 = {1,3,5,6};
        int target = 5;
        int target2 = 2;
        int target3 = 7;
        System.out.println(lol.searchInsert(array1,target));
        System.out.println(lol.searchInsert(array1,target2));
        System.out.println(lol.searchInsert(array1,target3));
    }


}
class SearchIndex{
    public int searchInsert(int[] num,int target){
        int startIndex = 0;
        int endIndex = num.length - 1;

        while(startIndex <= endIndex){
            int middleIndex = startIndex + (endIndex - startIndex) / 2;

            if(num[middleIndex] == target){
                return middleIndex;
            }
            if(num[middleIndex] < target){
                startIndex = middleIndex + 1;
            }
            else{
                endIndex = middleIndex - 1;
            }
        }
        return startIndex;
    }
}

