class PeekingIterator implements Iterator<Integer> 
{

	Iterator<Integer> it;
	Integer next_e = null;
	boolean peeked = false;
	public PeekingIterator(Iterator<Integer> it) {
	    // initialize any member here.
		
		this.it = it;
	    if(it.hasNext())
	    	next_e = it.next();
	    this.peeked = true;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
	    
	    if(!this.peeked)
	    {
	        if(this.it.hasNext())
	            this.next_e = this.it.next();
	    }
	    
		this.peeked = true;
		
		return this.next_e; 
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.

	@Override
	public Integer next() {

		if(!this.peeked && this.it.hasNext())
		{
			this.next_e = this.it.next();
		}
		
		
		this.peeked = false;

	    return this.next_e;
	}

	@Override
	public boolean hasNext() {
	    
	    if(!this.peeked && !this.it.hasNext())
	        this.next_e = null;
	        
	    return this.next_e != null;
	}
}
