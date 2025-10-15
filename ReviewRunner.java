import java.util.ArrayList;
import java.lang.Math;
/*
 * Requirements:
 * Write a program with a main method. (Complete)
 * Create at least one new method called from main that takes at least one parameter. (Complete)
 * Call at least two distinct methods in the String class. (Complete)
 * Use conditional statements or compound Boolean expressions. (Complete)
 * Use iteration. (Complete)
 */

class ReviewRunner {
  public static ArrayList<Integer> wordIndexes(String word, String[] data) {
    ArrayList<Integer> wordIndexes = new ArrayList<>();
    for (int i = 0; i < data.length; i++) {
      if (data[i].contains(word)) {
        // System.out.println("Word: " + data[i] + "Index: " + i);
        wordIndexes.add(i);
      }
    }
    return wordIndexes;
  }
  
  public static float getSum(int index, int range, String[] data) {
    float sum = 0.0f;
    for (int i = Math.max(0, index - range); i < Math.min(index + range, data.length); i++) {
      sum += Review.sentimentVal(Review.removePunctuation(data[i]));
    }
    return sum;
  }

  public static void main(String[] args) {
    String[] data = Review.textToString("data.txt").split(" ");
    String[] marvel_words = {"Marvel", "MCU"};
    String[] dc_words = {"DC", "DCEU"};
    // ArrayList<ArrayList<Integer>> total_indexes = new ArrayList<>();
    for (String w: marvel_words) {
      ArrayList<Integer> w_l = wordIndexes(w, data);
      for (int num: w_l) {
        System.out.println("Word: "+ w + " Index: " + num + " Total Sentiment: " + getSum(num, 20, data));
      }
      // total_indexes.add(w_l);
    }
    // for (String w: dc_words) {
    //   ArrayList<Integer> w_l = wordIndexes(w, data);
    //   // total_indexes.add(w_l);
    // }

    // for (String w: data) {
    //   w = Review.removePunctuation(w);
    // }
  }
}