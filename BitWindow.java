
import java.util.*;

public class BitWindow {
	// A sliding window of bits

	private static final int MAX_NUM_BITS = 1<<10;

	private BitSet window = new BitSet(MAX_NUM_BITS);

	private int offset, size;

	public BitWindow() {
		offset = 0;
		size = 0;
	}

	public void append(BitSet end, int nbits) {
		if (nbits>MAX_NUM_BITS-size) {
			nbits = MAX_NUM_BITS-size;
		}
		if (offset+size+nbits>MAX_NUM_BITS) {
			window = window.get(offset, MAX_NUM_BITS);
			offset = 0;
			if (window.size()<MAX_NUM_BITS) {
				window.set(MAX_NUM_BITS-1); // to get the desired capacity
			}
		}
		for (int i =0;i<nbits;i++) {
			window.set(offset+size, end.get(i));
			size++;
		}
	}

	// consumes and returns the first bit of the window
	// returns null if there is nothing left to consume
	public Boolean consume() {
		if (size==0) {
			return null;
		}
		size --;
		return window.get(offset++);
	}
	
}

