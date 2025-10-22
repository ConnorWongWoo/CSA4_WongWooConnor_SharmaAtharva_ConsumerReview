/*
 * Requirements:
 * Write a program with a main method. (Complete)
 * Create at least one new method called from main that takes at least one parameter. (Complete)
 * Call at least two distinct methods in the String class. (Complete)
 * Use conditional statements or compound Boolean expressions. (Complete)
 * Use iteration. (Complete)
 */

class ReviewRunner {
  
  public static float getSentiment(String data) {
    float sum = 0.0f;
    String[] words = data.split(" ");
    for ( String w: words) {
      w = Review.removePunctuation(w);
      sum += Review.sentimentVal(w);
    }
    return sum;
  }

  public static void main(String[] args) {
    String[] data = Review.textToString("data.txt").split("(?=(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)[a-z]*\\s+\\d{1,2},\\s*\\d{4})");

    int i = 0;
    float avg_sentiment = 0.0f;
    for (i = 0; i < data.length-1; i++) {
      String full_review = Review.removePunctuation(data[i]);
      String review = full_review.split("score\\.")[1];
      float review_sentiment = getSentiment(review); 
      System.out.println("Review " + i + " |" + review + "\n");
      avg_sentiment += review_sentiment;
    }
    avg_sentiment = avg_sentiment / i;
    System.out.println("The average sentiment of the reviews of the movie Ironman (2008) is: " + avg_sentiment + ".");
    if (avg_sentiment > 4.0f) System.out.println("The reviews were mostly positive! People loved the movie!");
    else if (3.0f < avg_sentiment) System.out.println("The reviews were somewhat positive. People liked this movie.");
    else System.out.println("The reviews were pretty bad... People did not like this movie.");
  }
}