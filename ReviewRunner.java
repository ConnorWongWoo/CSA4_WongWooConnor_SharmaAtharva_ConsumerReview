/*
 * Requirements:
 * Write a program with a main method. (Complete)
 * Create at least one new method called from main that takes at least one parameter. (Complete)
 * Call at least two distinct methods in the String class. (Complete)
 * Use conditional statements or compound Boolean expressions. (Complete)
 * Use iteration. (Complete)
 */

class ReviewRunner {
  
  public static float getSum(String data) {
    float sum = 0.0f;
    String[] words = data.split(" ");
    for ( String w: words) {
      sum += Review.sentimentVal(w);
    }
    return (float) (Math.round(sum * 100f) / 100f);
  }

  public static void main(String[] args) {
    // Used chatgpt to properly split the reviews after the date
    String[] data = Review.textToString("data.txt").split("(?<=\\b\\d{4}\\b)"); 
    int i = 0;
    for (String review: data) {

      System.out.println("Review " + i + "| Sentiment Score: " + getSum(review) + " | " + review);
      i++;
    }
  }
}