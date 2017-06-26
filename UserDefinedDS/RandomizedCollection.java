/*
Design a data structure that supports all following operations in average O(1) 
time.

Note: Duplicate elements are allowed.
insert(val): Inserts an item val to the collection.
remove(val): Removes an item val from the collection if present.
getRandom: Returns a random element from current collection of elements. 
The probability of each element being returned is linearly related to the 
number of same value the collection contains.
*/


public class RandomizedCollection {
    HashMap<Integer, HashMap<Integer, Integer>> map;   
	//key ->val value->value HashMap
    ArrayList<Integer> arr;
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<Integer, HashMap<Integer, Integer>>();
        arr = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did 
	not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            HashMap<Integer, Integer> value =  map.get(val);    
			// key -> #times value-> arr.size()
            value.put(value.size() + 1, arr.size());
            arr.add(val);
            return false;
        }
        HashMap<Integer, Integer> value =  new HashMap <Integer,  Integer>();
        value.put(1,arr.size());
        map.put(val, value);
        arr.add(val);
        return true;
    }
    
    /** Removes a value from the collection. Returns true if the collection 
	contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)) {
            HashMap<Integer, Integer> value = map.get(val);
            removeArr(value.get(value.size()));
            if (map.get(val).size() == 1) {
                map.remove(val);
                return true;
            }
            value.remove(map.get(val).size());
            return true;
        }
        return false;
    }
    private void removeArr(int idx) {
        arr.set(idx, arr.get(arr.size() - 1));
        arr.remove(arr.size() - 1);
        arr.trimToSize();
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        if (arr.size() == 0) {
            return 0;
        }
        Random randomIdx = new Random();
        int n = randomIdx.nextInt(arr.size());
        return (int)arr.get(n);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */