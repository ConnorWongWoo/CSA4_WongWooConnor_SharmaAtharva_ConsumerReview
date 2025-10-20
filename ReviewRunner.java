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
      sum += Review.sentimentVal(w);
    }
    return (float) (Math.round(sum * 100f) / 100f);
  }

  public static void main(String[] args) {
    // Used chatgpt to properly split the reviews after the date
    String[] data = Review.textToString("data.txt").split("(?<=\\b\\d{4}\\b)"); 
    int i = 0;
    float avg_sentiment = 0.0f;
    for (String review: data) {
      float review_sentiment = getSentiment(review); 
      System.out.println("Review " + i + "| Sentiment Score: " + review_sentiment + " | " + review);
      avg_sentiment += review_sentiment;
      i++;
    }
    avg_sentiment = avg_sentiment / i;
    System.out.println("The average sentiment of the reviews of the movie Ironman (2008) is: " + avg_sentiment + ".");
    if (avg_sentiment > 7.0f) System.out.println("The reviews were mostly positive! People loved the movie!");
    else if (4.0f < avg_sentiment) System.out.println("The reviews were somewhat positive. People liked this movie.");
    else System.out.println("The reviews were pretty bad... People did not like this movie.");
  }
}