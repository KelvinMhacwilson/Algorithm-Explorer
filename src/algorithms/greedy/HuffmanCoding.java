package algorithms.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCoding {

  public Map<Character, String> buildHuffmanTree(Map<Character, Integer> frequencies) {
    PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();

    for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
      pq.offer(new HuffmanNode(entry.getKey(), entry.getValue()));
    }

    while (pq.size() > 1) {
      HuffmanNode left = pq.poll();
      HuffmanNode right = pq.poll();
      HuffmanNode newNode = new HuffmanNode('\0', left.frequency + right.frequency);
      newNode.left = left;
      newNode.right = right;
      pq.offer(newNode);
    }

    HuffmanNode root = pq.poll();
    Map<Character, String> huffmanCodes = new HashMap<>();
    buildCode(root, "", huffmanCodes);

    return huffmanCodes;
  }

  private void buildCode(HuffmanNode root, String code, Map<Character, String> huffmanCodes) {
    if (root != null) {
      if (root.left == null && root.right == null) {
        huffmanCodes.put(root.character, code);
      }
      buildCode(root.left, code + "0", huffmanCodes);
      buildCode(root.right, code + "1", huffmanCodes);
    }
  }

  private static class HuffmanNode implements Comparable<HuffmanNode> {
    char character;
    int frequency;
    HuffmanNode left;
    HuffmanNode right;

    HuffmanNode(char character, int frequency) {
      this.character = character;
      this.frequency = frequency;
    }

    @Override
    public int compareTo(HuffmanNode other) {
      return this.frequency - other.frequency;
    }
  }
}
