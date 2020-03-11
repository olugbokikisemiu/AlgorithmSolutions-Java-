import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import java.util.Stack;
import javax.lang.model.element.Element;

public class Test {
    public static void main(String[] args) {
        // int[][] points = { { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 }, {
        // 0, 1, 1, 1, 1 } };
        int[][] points = { { -1, -2 }, { 1, 3 }, { 0, -1 }, { 2, 4 } };
        int[] data = { 2, 7, 11, 15 };
        //System.out.println("Result: " + Arrays.toString(addTwoNumbers(data, 9)));
    }

    public static int No_ways(int n) {
        if (n == 0 || n == 1)
            return 1;

        int moves[] = new int[n + 1];
        moves[0] = 1;
        moves[1] = 1;
        for (int i = 2; i <= n; i++) {
            moves[i] = moves[i - 1] + moves[i - 2];
        }
        System.out.println("Moves: " + Arrays.toString(moves));
        return moves[n];
    }

    public static int No_Ways_X(int n, int[] x) {
        if (n == 0)
            return 1;
        int moves[] = new int[n + 1];
        moves[0] = 1;
        for (int i = 1; i <= n; i++) {
            int total = 0;
            for (int j = 0; j < x.length; j++) {
                if (i - x[j] >= 0) {
                    total += moves[i - x[j]];
                }
            }
            moves[i] = total;
        }
        System.out.println("Moves: " + Arrays.toString(moves));
        return moves[n];
    }

    public static int areaOfOverlap() {
        int y = lenghtY(1, 2, 5, 7);
        int x = lenghtX(2, 3, 5, 5);
        if (x <= 0 || y <= 0) {
            return 0;
        }
        return x * y;
    }

    public static int lenghtY(int bottom1Y, int bottom2Y, int top1Y, int top2Y) {
        return differValue(bottom1Y, bottom2Y, top1Y, top2Y);
    }

    public static int lenghtX(int bottom1X, int bottom2X, int top1X, int top2X) {
        return differValue(bottom1X, bottom2X, top1X, top2X);
    }

    public static int differValue(int R1BXY, int R2BXY, int R1TXY, int R2TXY) {
        int bottom = Math.min(R1TXY, R2TXY);
        int top = Math.max(R1BXY, R2BXY);
        return bottom - top;
    }

    public static int[][] distance(int[][] points, int k) {
        HashMap<Double, int[]> distObject = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            System.out.println(Arrays.toString(points[i]));
            double firstValue = Math.pow(points[i][0], 2);
            double secondValue = Math.pow(points[i][1], 2);
            distObject.put(firstValue + secondValue, points[i]);

            System.out.println(distObject.toString());
        }
        int[][] kPoints = maxKItem(distObject, k);
        return kPoints;
    }

    public static int[][] maxKItem(HashMap<Double, int[]> distObject, int k) {
        int i = 1;
        ArrayList<Double> maxHeap = new ArrayList<>();
        for (double key : distObject.keySet()) {
            if (i <= k) {
                maxHeap.add(key);
            } else {
                break;
            }
            i++;

        }
        int result[][] = new int[k][];
        for (int b = 0; b < maxHeap.size(); b++) {
            double minKey = maxHeap.get(b);
            int[] minElement = distObject.get(minKey);
            result[b] = minElement;
        }
        return result;
    }

    public static int countPair(int[] data, int x) {
        int count = 0;
        int shift = 1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] + data[data.length - shift] > x) {
                shift++;
            } else {
                count += (data.length - (i + 1));
            }
        }
        return count;
    }

    public static int countSameDigit(int startDigit, int endDigit) {
        int count = 0;
        startDigit += 1;
        for (int i = startDigit; i < endDigit; i++) {
            String[] splitValue = Integer.toString(i).split("");
            if (splitValue.length == 1) {
                count++;
            } else {
                if (splitValue[0].equals(splitValue[splitValue.length - 1])) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int[] countMax(int[] data, int element) {
        int[] maxheap = new int[element + 1];
        int k = 1;
        for (int i = 0; i < data.length; i++) {
            if (k < element) {
                maxheap[i] = data[i];
            } else {
                break;
            }
            k++;
        }

        System.out.println("Max Heap: " + Arrays.toString(maxheap));

        for (int j = element; j <= data.length; j++) {
            HashMap<Integer, Integer> max = maxValue(maxheap);
            // max.

        }
        return null;
    }

    public static HashMap<Integer, Integer> maxValue(int[] data) {
        HashMap<Integer, Integer> result = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
                result.put(i, max);
            }
        }
        return result;
    }

    public static int chocolateCount(int[] data, int t) {
        int k = 1;
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (k <= t) {
                System.out.println("Here!!!");
                if (data[i] > max) {
                    max = data[i];
                    System.out.println("Max: " + max);
                    count += max;
                }
                k++;
            } else {
                break;
            }
        }
        return count;
    }

    public static String reverseWord(String word) {
        StringBuilder build = new StringBuilder();
        String[] splitWord = word.split(" ");
        for (int i = splitWord.length - 1; i >= 0; i--) {
            build.append(splitWord[i] + " ");
        }
        return build.toString();
    }

    public static String reverseWordUsingStack(String word) {
        Stack<String> stackJava = new Stack<String>();
        String tempWord = "";
        for (int i = 0; i < word.length(); ++i) {
            System.out.println(word.charAt(i));
            if (word.charAt(i) == ' ' || i == word.length() - 1) {
                stackJava.push(tempWord);
                tempWord = "";
            } else {
                tempWord += word.charAt(i);
            }
        }
        System.out.println("Stack: " + stackJava.toString());

        StringBuilder build = new StringBuilder();
        while (stackJava.size() != 0) {
            build.append(stackJava.pop() + " ");
        }
        return build.toString();
    }

    public static LinkedList<Integer> sumLinkedValue() {
        LinkedList<Integer> linkedOne = new LinkedList<>();
        LinkedList<Integer> linkedTwo = new LinkedList<>();
        return null;
    }

    public static int countNonUnique(String word) {
        int count = 0;
        HashMap<Character, Character> wordMap = new HashMap<>();
        word = word.toLowerCase();
        for (char i = 0; i < word.length(); i++) {
            if (wordMap.containsKey(word.charAt(i))) {
                count++;
            } else {
                wordMap.put(word.charAt(i), i);
            }
        }
        return count;
    }

    public static String removeDuplicateChar(String word) {
        HashMap<Character, Character> wordMap = new HashMap<>();
        StringBuffer buf = new StringBuffer();
        word = word.toLowerCase();
        for (char i = 0; i < word.length(); i++) {
            if (!wordMap.containsKey(word.charAt(i))) {
                buf.append(word.charAt(i));
                wordMap.put(word.charAt(i), i);
            }
        }
        return buf.toString();
    }

    public static int largestSquare(int[][] matrix) {
        int result = 0;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] > 0) {
                    matrix[i][j] = 1 + Math.min(matrix[i][j - 1], Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]));
                    if (matrix[i][j] > result) {
                        result = matrix[i][j];
                    }
                }
            }
        }
        return result;
    }

    public static int minCell(int a, int b, int c) {
        int min = Integer.MAX_VALUE;
        min = Math.min(a, b);
        return Math.min(min, c);
    }

    public static int oddOccurrence(int[] data) {
        HashMap<Integer, Integer> logCount = new HashMap<>();
        int result = 0;
        for (int i = 0; i < data.length; i++) {
            if (!logCount.containsKey(data[i])) {
                logCount.put(data[i], 1);
            } else {
                logCount.remove(data[i]);
            }
        }

        for (Map.Entry<Integer, Integer> entry : logCount.entrySet()) {
            result = entry.getKey();
        }
        return result;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode temp = null;
        ListNode result = null;
        ListNode prev = null;
        
         while(l1 != null || l2 != null){
             int sum = carry + (l1 == null ?0 :l1.val) + (l2 == null ? 0 : l2.val);
             carry = (sum >= 10)?1 : 0;
             sum = sum %10;
             temp = new ListNode(sum);
             if(result == null){
                 result = temp;
             }else{
                 prev.next = temp;
             }
             prev = temp;
             if(l1 != null) l1 = l1.next;
             if(l2 != null) l2 = l2.next;
             
         }
        if(carry == 1) temp.next = new ListNode(carry);
        return result;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

}