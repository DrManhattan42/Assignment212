import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class BingoController {

    private final String OPTION_EXIT = "1 - Exit";
    private final String OPTION_PLAY = "2 - Play Bingo";
    private final String OPTION_SEPARATOR = "3 - Separate numbers";
    private final String OPTION_CREATE_CARD = "4 - Create a bingo card";
    private final String OPTION_LIST_CARDS = "5 - List existing bingo cards";
    private final String OPTION_SIZE = "6 - Set the bingo card size";
    private final String OPTION_ENTERCHOICE = "\nPlease enter your choice ->> ";

    private final String[] mainMenuItems = {OPTION_EXIT,
                                            OPTION_PLAY,
                                            OPTION_SEPARATOR,
                                            OPTION_CREATE_CARD,
                                            OPTION_LIST_CARDS,
                                            OPTION_SIZE, OPTION_ENTERCHOICE};

    /* TODO
          complete constants attached to mainMenuItems //
     */



    /* TODO
          complete default size of rows / columns as specified in the Defaults class
          create an arraylist of BingoCard cards
          include getters and setters for row / column sizes //
     */

    private int currentRowSize;
    private int currentColumnSize;

    /* TODO create an ArrayList of BingoCard cards*/

    ArrayList <BingoCard> bingoCards = new ArrayList<BingoCard>();

    //implement code here

    /* TODO
          implement getters and setters for currentRowSize / currentColumnSize
     */
    public int getCurrentRowSize() {
        /* TODO
              change the return from 0 to the appropriate return
     */
        return currentRowSize;
    }

    public void setCurrentRowSize(int currentRowSize) {
       /* TODO
             implement code here
     */
        currentRowSize = currentRowSize;
    }


    public int getCurrentColumnSize() {
        /* TODO
              change the return from 0 to the appropriate return
     */
        return currentColumnSize;
    }

    public void setCurrentColumnSize(int currentColumnSize) {
       /* TODO
             implement code here
     */

        currentColumnSize = currentColumnSize;
    }

    /* TODO
          add a new BingoCard card
     */
    public void addNewCard(BingoCard card) {
        //implement code her
        bingoCards.add(card);
    }

    /* TODO
          include an appropriate message to the the number of rows as well as the number of columns
     */

    public void setSize() {
        setCurrentRowSize(parseInt(Toolkit.getInputForMessage(
            "")));
        setCurrentColumnSize(parseInt(Toolkit.getInputForMessage(
            "")));
        System.out.printf("The bingo card size is set to %d rows X %d columns%n",
                          getCurrentRowSize(),
                          getCurrentColumnSize());
    }

    /* TODO
           ensure that the correct amount of numbers are entered
           print a message that shows the numbers entered using Toolkit.printArray(numbers)
           create, setCardNumbers and add the card as a BingoCard
     */
    public void createCard() {

        /* TODO
              calculate how many numbers are required to be entered based on the number or rows / columns
         */

        int numbersRequired = 0;
        int numbersLen = Defaults.DEFAULT_NUMBER_OF_ROWS * Defaults.DEFAULT_NUMBER_OF_COLUMNS;
        String[] numbers = new String[numbersLen];

        numbers = Toolkit.getInputForMessage(
                             String.format(
                                 "Enter " + numbers.length +   " numbers " +
                                 "for your " +
                                 "card " +
                                 "(separated by " +
                                 "' ')",
                                 numbersRequired,
                                 Defaults.getNumberSeparator()))
                         .trim()
                         .split(Defaults.getNumberSeparator());

        /* TODO
              verify if the correctAmountOfNumbersEntered is true or false dependant on the numbersRequired calculation
            //changes according to calculation inserted here
        /* TODO
         	verify if the correctAmountOfNumbersEntered is true or false dependant on the numbersRequired calculation
        	verify whether the numbers entered is not correct by printing an appropriate message
        	verify against the expected output files
         */

        if(numbersLen == numbers.length){
            boolean found = false;
            for(int i=0; i<numbers.length; i++){
                for (int j=i+1; j<numbers.length; j++){
                    if (numbers[i] == numbers[j]){
                        found = true;
                    }
                    if(found) { break;}
                }
                if(found) { break;}
            }

            if (found == true){
                Toolkit.printArray(numbers);
                System.out.println("You have repeated the same number more than once\n");
                /* TODO  print an appropriate message using ToolKit.printArray() to show the numbers entered */
                System.out.println(Toolkit.printArray(numbers));


            }else {
                /* TODO create new BingoCard*/
                int col = Defaults.DEFAULT_NUMBER_OF_COLUMNS;
                int row = Defaults.DEFAULT_NUMBER_OF_ROWS;
                BingoCard card = new BingoCard(row, col);
                /* TODO setCardNumbers for the new card */
                card.setCardNumbers(numbers);
                /* TODO add the card to the ArrayList */
                bingoCards.add(card);
            }
        } else {
            System.out.println("You have entered wrong amount of numbers. " +
                               "Required ["+numbersLen+"] nummbers only\n");
        }

        //changes according to calculation inserted here




    }

    /* TODO
         this method goes with printCardAsGrid() seen below
         when option 4 is chosen to list existing cards it prints each card accordingly
         for example, it should show the following
         Card 0 numbers:
         1  2
         3  4 (check with expected output files)
    */



    public void listCards() {

        int i = 0;
        for(BingoCard myCard: bingoCards){
            System.out.println("Card " + (++i));
            String cardNumbers = myCard.getCardNumbers();
            System.out.println(cardNumbers);
        }


        /* TODO
              insert code here to find all cards to be printed accordingly
         */
        /* TODO
              call printCardAsGrid() method here, Hint: use getCardNumbers() when getting cards
         */
    }


    /* TODO
          this is for option 4, list existing cards where all the cards are printed as a grid
          of rows / columns, so numbers 3 4 5 6 will be printed as follows:
          3  4
          5  6
          it is a follow on method from listCards() and ensures that the grid structure is printed
     */
    public void printCardAsGrid(String numbers) {
        //insert code here to print numbers as a grid
    }

    /* TODO
          use Toolkit.getInputForMessage to enter a new separator
          print a message what the new separator is
     */
    public void setSeparator() {
        String sep = Toolkit.getInputForMessage("Enter the new separator");
        /* TODO
              make use of setNumberSeparator() and getNumberSeparator()
         */
    }

    /* TODO
         reset all BingoCards using resetMarked (to false)
     */
    public void resetAllCards() {
        //insert code here
    }

    /* TODO
          mark off a number that was called when it equals one of the numbers on the BingoCard
     */
    public void markNumbers(int number) {
        //insert code here
    }

    /* TODO
          make use of isWinner() to determine who the winner is
          the method should return the index of who the winner is
     */
    public int getWinnerId() {
        //insert code here
        return 0;
    }

    /* TODO
          please take note that the game will not end until there is a winning sequence
     */
    public void play() {
        System.out.println("Eyes down, look in!");
        resetAllCards();

        boolean weHaveAWinner;
        do {
            markNumbers(parseInt(
                Toolkit.getInputForMessage("Enter the next number")
                       .trim()));

            int winnerID = getWinnerId();
            weHaveAWinner = winnerID != Defaults.NO_WINNER;
            if (weHaveAWinner)
                System.out.printf("And the winner is card %d%n", winnerID);
        } while (!weHaveAWinner);
    }

    public String getMenu(String[] menuItems) {
    /* TODO
        change this method so it prints a proper numbered menu
        analyse the correct format from the ExpectedOutput files
        menuText is returned
     */
        StringBuilder menuText = new StringBuilder();

        for (int i=0; i<menuItems.length; i++){
            menuText.append(menuItems[i]);
            menuText.append("\n");
        }

        //insert code here
        return menuText.toString();
    }
    /* TODO
          complete the menu using switch to call the appropriate method calls
     */
    public void run() {
        boolean finished = false;

        do {
            //Toolkit.getInputForMessage(getMenu(mainMenuItems));
            int choice =
                Integer.valueOf(Toolkit.getInputForMessage(getMenu(mainMenuItems)));
            switch (choice) {
                //insert code here
                case 1: System.out.printf("Thanks for playing!"); break;
                case 2:
                    System.out.println("Welcome to Bingo");
                    int cols =
                        Integer.valueOf(Toolkit.getInputForMessage("Enter " +
                                                                   "column" +
                                                                   "numbers"));
                    int rows =
                        Integer.valueOf(Toolkit.getInputForMessage("Enter " +
                                                                   "row " +
                                                                   "numbers"));
                    BingoCard bingoCard = new BingoCard(rows, cols);
                    break;
                case 3: break;
                case 4:
                    int n = Integer.valueOf(Toolkit.getInputForMessage("Please enter " +
                                                                       "the " +
                                                                       "number of cards you " +
                                                                       "want to create"));
                    for(int i = 0; i<n; i++){
                        createCard();
                    }
                    break;
                case 5:

                    listCards();
                    break;

            }
            if(choice == 1){
                finished = true;
            }

        } while (!finished);

    }
}
