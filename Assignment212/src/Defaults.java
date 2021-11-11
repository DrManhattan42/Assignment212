/**
 * This class is fully implemented and requires no further changes
 */
public class Defaults {

  public static final int DEFAULT_NUMBER_OF_ROWS    = 4;
  public static final int DEFAULT_NUMBER_OF_COLUMNS = 4;

  public static final int NO_WINNER = -1;

  private static String numberSeparator = " ";

  public static String getNumberSeparator() {
    return numberSeparator;
  }

  public static void setNumberSeparator(String separator) {
    numberSeparator = separator;
  }

}
