package algorithms.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCoding {

    private HuffmanNode root;

    public Map<Character, String> compress(String input) {
        Map<Character, Integer> frequencies = calculateFrequencies(input);
        PriorityQueue<HuffmanNode> pq = buildPriorityQueue(frequencies);
        root = buildHuffmanTree(pq);
        Map<Character, String> huffmanCodes = new HashMap<>();
        buildHuffmanCodes(root, "", huffmanCodes);
        return huffmanCodes;
    }

    public String encode(String input) {
        StringBuilder encodedString = new StringBuilder();
        for (char c : input.toCharArray()) {
            encodedString.append(getCode(c));
        }
        return encodedString.toString();
    }

    public String decode(String encoded) {
        StringBuilder decodedString = new StringBuilder();
        HuffmanNode current = root;
        int i = 0;
        while (i < encoded.length()) {
            while (current.left != null && current.right != null) {
                if (encoded.charAt(i) == '0') {
                    current = current.left;
                } else {
                    current = current.right;
                }
                i++;
            }
            decodedString.append(current.character);
            current = root;
        }
        return decodedString.toString();
    }

    private Map<Character, Integer> calculateFrequencies(String input) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char c : input.toCharArray()) {
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }
        return frequencies;
    }

    private PriorityQueue<HuffmanNode> buildPriorityQueue(Map<Character, Integer> frequencies) {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            pq.offer(new HuffmanNode(entry.getKey(), entry.getValue()));
        }
        return pq;
    }

    private HuffmanNode buildHuffmanTree(PriorityQueue<HuffmanNode> pq) {
        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            HuffmanNode newNode = new HuffmanNode('\0', left.frequency + right.frequency);
            newNode.left = left;
            newNode.right = right;
            pq.offer(newNode);
        }
        return pq.poll();
    }

    private void buildHuffmanCodes(HuffmanNode root, String code, Map<Character, String> huffmanCodes) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                huffmanCodes.put(root.character, code);
            }
            buildHuffmanCodes(root.left, code + "0", huffmanCodes);
            buildHuffmanCodes(root.right, code + "1", huffmanCodes);
        }
    }

    private String getCode(char character) {
        Map<Character, String> codes = new HashMap<>();
        buildHuffmanCodes(root, "", codes);
        return codes.get(character);
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
