class ByThrees implements Series {
	int start;
	int val;
//	int prev;

	ByThrees() {
		start = 0;
		val = 0;
//		prev = -2;
	}

	public int getNext() {
//		prev = val;
		val += 3;
		return val;
	}

	public void reset() {
		val = start;
//		prev = start - 2;
	}

	public void setStart(int x) {
		start = x;
		val = x;
//		prev = x - 2;
	}
/*
	int getPrevious() {
		return prev;
	}
*/
}
