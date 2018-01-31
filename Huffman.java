
import java.util.*;


public class Huffman {
  
  Node root;
  int n;
  
  public Huffman(int [] freqs) {
    n =freqs.length;
    Node [] leafs = new Node[n];
    for (int i =0;i<n;i++) {
      leafs[i] = new Node();
      leafs[i].wt = freqs[i];
      leafs[i].symbol = i;
    }
    buildTree(leafs);
  }
  
  public void buildTree(Node[] leafs) {
    PriorityQueue<Node> pq = new PriorityQueue<>(leafs);
    while (pq.size()>1) {
      Node left = pq.poll(), right = pq.poll();
      Node parent = new Node();
      parent.wt = left.wt + right.wt;
      parent.left = left;
      parent.right = right;
      pq.add(parent);
    }
    if (!pq.isEmpty()) {
      root = pq.poll();
    }
  }
  
}


class Node implements Comparable<Node>{
  int wt;
  int symbol;
  Node left, right;
  
  public Node() {
    wt =0;
    symbol =0;
    left = null;
    right = null;
  }
  
  public int compareTo(Node other) {
    return wt - other.wt;
  }
  
}



