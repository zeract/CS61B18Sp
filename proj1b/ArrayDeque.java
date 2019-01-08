public class ArrayDeque<michigan> {
	private int size;
	private int nextFirst;
	private michigan[] item;
	private int nextLast;

	public ArrayDeque(){
		size = 0;
		nextFirst = 3;
		item = (michigan[])new Object[8];
		nextLast = 4;
	}
	public ArrayDeque(michigan x){
		size = 1;
		item[nextFirst] = x;
		nextFirst = 2;
		nextLast = 4;
	}

	public void addFirst(michigan x){
		if(size == item.length){
			michigan[] a = (michigan[])new Object[size*2];
			System.arraycopy(item, 0, a, 0, nextLast);
			System.arraycopy(item, nextLast, a, size+nextLast, size-nextLast);
			item = a;
			nextFirst = size+nextLast-1;
		}
		item[nextFirst] = x;
		size += 1;
		nextFirst -= 1;
		if(nextFirst == -1){
			nextFirst += item.length;
		}
	}

	public void addLast(michigan x){
		if(size == item.length){
			michigan[] a = (michigan[])new Object[size*2];
			System.arraycopy(item, 0, a, 0, nextLast);
			System.arraycopy(item, nextLast, a, size+nextLast, size-nextLast);
			item = a;
			nextFirst = size+nextLast-1;
		}
		item[nextLast] = x;
		size += 1;
		nextLast += 1;
		if(nextLast == item.length){
			nextLast = 0;
		}
	}

	public boolean isEmpty(){
		if(size == 0){
			return true;
		}
		return false;
	}

	public int size(){
		return size;
	}

	public void printDeque(){
		for(int i=nextFirst+1; i<=nextFirst+size; i++){
			if(i >= item.length){
				System.out.print(item[i-item.length]+" ");
			}else{
				System.out.print(item[i]+" ");
			}
		}
	}

	public michigan removeFirst(){
		michigan a = null;
		if(size != 0){
			if(nextFirst+1 == item.length){
				nextFirst -= item.length;
			}
			a = item[nextFirst+1];
			item[nextFirst+1] = null;
			size -= 1;
			nextFirst += 1;
		}
		if((item.length > 8) && (size * 1.0 / item.length < 0.25)){
			michigan[] b = (michigan[])new Object[item.length/2];
			for(int i=0; i<size; i++){
				b[i] = this.get(i);
			}
			item = b;
			nextFirst = item.length-1;
			nextLast = size;
		}
		return a;
	}

	public michigan removeLast(){
		michigan a = null;
		if(size != 0){
			if(nextLast == 0){
				nextLast += item.length;
			}
			a = item[nextLast-1];
			item[nextLast-1] = null;
			size -= 1;
			nextLast -= 1;
		}
		if((item.length > 8) && (size * 1.0 / item.length < 0.25)){
			michigan[] b = (michigan[])new Object[item.length/2];
			for(int i=0; i<size; i++){
				b[i] = this.get(i);
			}
			item = b;
			nextFirst = item.length-1;
			nextLast = size;
		}
		return a;
	}

	public michigan get(int index){
		michigan a = null;
		int i = nextFirst+1+index;
		if(i >= item.length){
			i -= item.length;
		}
		if(i < nextLast){
			a = item[i];
		}
		return a;
	}

	public static void main(String[] args){
		ArrayDeque<Integer> ad1 = new ArrayDeque<>();
		for(int i = 0; i < 20; i++){
			if(i % 2 == 0){
				ad1.addFirst(i);
			} else {
				ad1.addLast(i);
			}
		}
		for(int i = 0; i < 19; i++){
			ad1.removeFirst();
		}
		ad1.printDeque();
		System.out.println(ad1.size());
	}

}
