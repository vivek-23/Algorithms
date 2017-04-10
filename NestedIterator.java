/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

	List<Integer> flattened_list;
	int size;
	int curr;

    public NestedIterator(List<NestedInteger> nestedList) {
    	this.flattened_list = new ArrayList<Integer>();
    	this.flattenList(nestedList,this.flattened_list);
    	this.size = this.flattened_list.size();
    	this.curr = 0;
    }

    public void flattenList(List<NestedInteger> nestedList,List<Integer> flattened_list)
    {
    	List<NestedInteger> temp = nestedList;
    	int len = temp.size();
    	for(int i=0;i<len;++i)
    	{
    		if(temp.get(i).isInteger()) flattened_list.add(temp.get(i).getInteger());
    		else flattenList(temp.get(i).getList(),flattened_list);
    	}
    }

    @Override
    public Integer next() {
        return this.flattened_list.get(curr++);
    }

    @Override
    public boolean hasNext() {
        return this.curr != this.size;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
