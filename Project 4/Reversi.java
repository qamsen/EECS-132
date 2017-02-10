import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * A game called Reversi
 * 
 * @author Kameron Damaska
 */
public class Reversi {
  
  /* The board Reversi will be played on*/
  private final JPanel board;
  
  /* The frame the board will be placed on*/
  private final JFrame frame;
  
  /* A two-dimensional array of buttons that will go on the board*/
  private final JButton[][] buttonGrid;
  
  /* The frame the skip turn dialogue will be placed on*/
  private JFrame turnSkippedFrame;
  
  /* The main panel of the skip turn frame*/
  private JPanel mainSkipTurn;
  
  /* The bottom panel of the skip turn frame*/
  private JPanel bottomSkipTurn;
  
  /* The top panel of the skip turn frame*/
  private JPanel topSkipTurn;
  
  /* The main panel of the end of game frame*/
  private JPanel mainEndOfGame;
  
  /* The bottom panel of the end of game frame*/
  private JPanel bottomEndOfGame;
  
  /* The top panel of the end of game frame*/
  private JPanel topEndOfGame;
  
  /* The button that skips the turn*/
  private final JButton turnSkippedButton;
  
  /* The label that explains whose turn is skipped*/
  private JLabel turnSkippedDialogue;
  
  /* The frame the end of game dialogue will be placed on*/
  private JFrame endOfGame;
  
  /* The label that explains who won the game*/
  private JLabel endOfGameDialogue;
  
  /* The button that closes the window following a game*/
  private JButton quit;
  
  /* The button that creates a new game following a game*/
  private JButton newGame;
  
  /* Records whose turn it is*/
  private boolean whiteTurn;
  
  /* Stores if there is a legal play available*/
  private boolean legalPlay;
  
  /* Stores the row coordinate of a button*/
  private int row;
  
  /* Stores the column coordinate of a button*/
  private int column;
  
  /* Stores an index row value*/
  private int indexRow;
  
  /* Stores an index column value*/
  private int indexColumn;
  
  /* White player's score*/
  private int whiteScore;
  
  /* Black player's score*/
  private int blackScore;
  
  /* Blank spaces at the end of the game*/
  private int blankSquare;
  
  /**
   * Creates a game board
   * 
   * @param x  The number of rows on the board
   * @param y  The number of columns on the board
   */
  public Reversi(int x, int y) {
    
    /* Initializes the board with x number of rows and y number of columns*/
    board = new JPanel(new GridLayout(x, y));
    
    /* Initializes the grid of buttons*/
    buttonGrid = new JButton[x][y];
    
    /* Initializes each button from the array and add it to the grid*/
    for (int i = 0; i < buttonGrid.length; i++) {
      for (int j = 0; j < buttonGrid[0].length; j++) {
        buttonGrid[i][j] = new JButton(); 
        board.add(buttonGrid[i][j]);
        buttonGrid[i][j].addActionListener(new GameMove());
      }
    }
    
    /* Initializes the frame and adds the board to it*/
    frame = new JFrame("ReversiPractice");
    frame.add(board, "Center");
    
    /* Starts the game on white's turn*/
    whiteTurn = true;
    
    /* Creates the initial board state*/
    buttonGrid[x / 2 - 1][y / 2 - 1].setBackground(Color.WHITE);
    buttonGrid[x / 2][y / 2 - 1].setBackground(Color.BLACK);
    buttonGrid[x / 2 - 1][y / 2].setBackground(Color.BLACK);
    buttonGrid[x / 2][y / 2].setBackground(Color.WHITE);
    
    /* Sets each button size and sets the frame visible*/
    frame.setSize(60 * x, 60 * y);
    frame.setVisible(true);
    frame.toFront();
    
    /* Initializes the frame that holds the skip turn dialogue*/
    turnSkippedFrame = new JFrame("Turn Skipped");
    
    /* Initializes the three panels that will go on skip turn frame*/
    mainSkipTurn = new JPanel(new BorderLayout());
    topSkipTurn = new JPanel();
    bottomSkipTurn = new JPanel(new FlowLayout(FlowLayout.CENTER));
    
    /* Initializes the button that closes the skip turn frame*/
    turnSkippedButton = new JButton("Continue");
    turnSkippedButton.addActionListener(new ActionListener() {
      
      /* Gets rid of the skip turn frame*/
      public void actionPerformed(ActionEvent e) {
        turnSkippedFrame.dispose();
        frame.toFront();
      }
    });
    bottomSkipTurn.add(turnSkippedButton);
    
    /* Initializes the dialogue that will go on the turn skipped frame*/
    turnSkippedDialogue = new JLabel();
    topSkipTurn.add(turnSkippedDialogue);
    
    /* Adds the panels to the skip turn frame*/
    mainSkipTurn.add(topSkipTurn, BorderLayout.NORTH);
    mainSkipTurn.add(bottomSkipTurn, BorderLayout.SOUTH);
    turnSkippedFrame.add(mainSkipTurn);
    
    /* Initializes the frame that holds the end of game dialogue*/
    endOfGame = new JFrame();
    
    /* Initializes the three panels that will go on skip turn frame*/
    mainEndOfGame = new JPanel(new BorderLayout());
    topEndOfGame = new JPanel();
    bottomEndOfGame = new JPanel(new FlowLayout(FlowLayout.CENTER));
    
    /* Initializes the quit button at the end of the game*/
    quit = new JButton("Quit Reversi");
    quit.addActionListener(new ActionListener() {
      
      /* Closes the game over frame and the game*/
      public void actionPerformed(ActionEvent e) {
        endOfGame.dispose();
        frame.dispose();
      }
    });
    
    /* Initializes the new game button at the end of the game*/
    newGame = new JButton("New Game");
    newGame.addActionListener(new ActionListener() {
      
      /* Gets rid of the game over frame and launches a new game*/
      public void actionPerformed(ActionEvent e) {
        endOfGame.dispose();
        frame.dispose();
        Reversi reversi = new Reversi(x, y);
        frame.toFront();
      }
    });
    
    /* Add the buttons to the frame*/
    bottomEndOfGame.add(newGame);
    bottomEndOfGame.add(quit);
    
    /* Initializes the end of game dialogue*/
    endOfGameDialogue = new JLabel();
    topEndOfGame.add(endOfGameDialogue);
    
    /* Adds the panels to the end of game frame*/
    mainEndOfGame.add(topEndOfGame, BorderLayout.NORTH);
    mainEndOfGame.add(bottomEndOfGame, BorderLayout.SOUTH);
    endOfGame.add(mainEndOfGame);
  }
  
  /**
   * Creates a game board
   * 
   * @param dimension  the number of rows and the number of columns
   */
  public Reversi(int dimension) {
    this(dimension, dimension);
  }
  
  /**
   * Creates a game board with 8 rows and 8 columns
   */
  public Reversi() {
    this(8, 8);
  }
  
  /**
   * An inner method that handles when a button is pressed
   */
  public class GameMove implements ActionListener {
    
    /**
     * Makes the appropriate game move for an input
     *
     * @param e  the button pressed
     */
    public void actionPerformed(ActionEvent e) {
      
      /* The button pressed*/
      JButton thisButton = (JButton)e.getSource();
      
      /* Makes appropriate game move*/
      gameMove(thisButton);
      
      /* Checks if the opponent has any plays*/
      if(isSkipTurn()) {
        /* If the opponent has no plays, change turns*/
        setWhiteTurn(!getWhiteTurn());
        /* If this player has no plays either, end of the game*/
        if(isSkipTurn()) {
          endOfGame();
        }
        /* Or else let the player know their turn was skipped*/
        else {
          skipTurn();
        }
      }
    }
  }
  
  /**
   * Sets whether a legal play is available
   * 
   * @param  whether there is a legal play
   */
  private void setLegalPlay(boolean legalPlay) {
    this.legalPlay = legalPlay;
  }
  
  /**
   * Returns whether there is a legal play
   * 
   * @return whether there is a legal play
   */
  public boolean getLegalPlay() {
    return legalPlay;
  }
  
  /**
   * Sets whether it is currently white's turn
   * 
   * @param whiteTurn  whether it is currently white's turn
   */
  private void setWhiteTurn(boolean whiteTurn) {
    this.whiteTurn = whiteTurn;
  }
  
  /**
   * Returns whether it is white's turn
   * 
   * @return  whether it is white's turn
   */
  public boolean getWhiteTurn() {
    return whiteTurn;
  }
  
  /**
   * Sets the row coordinate of a button
   *
   * @param row  The row coordinate of a button
   */
  private void setRow(int row) {
    this.row = row;
  }
  
  /** 
   * Returns the row coordinate of a button
   * 
   * @return  The row coordinate of a button
   */
  public int getRow() {
    return row;
  }
  
  /**
   * Sets the column coordinate of a button
   * 
   * @param column  The column coordinate of a button
   */
  private void setColumn (int column) {
    this.column = column;
  }
  
  /**
   * Returns the column coordinate of a button
   * 
   * @return  The column coordinate of a button
   */
  public int getColumn() {
    return column;
  }
  
  /**
   * Sets the index row coordinate on the grid
   *
   * @param indexRow  The index row value
   */
  private void setIndexRow(int indexRow) {
    this.indexRow = indexRow;
  }
  
  /**
   * Gets the index row coordinate on the grid
   *
   * @return The index row value
   */
  public int getIndexRow() {
    return indexRow;
  }
  
  /**
   * Sets the index column coordinate on the grid
   *
   * @param indexColumn  The index column value
   */
  private void setIndexColumn(int indexColumn) {
    this.indexColumn = indexColumn;
  }
  
  /**
   * Gets the index column coordinate on the grid
   *
   * @return The index column value
   */
  public int getIndexColumn() {
    return indexColumn;
  }
  
  /**
   * Sets the total black pieces on the board
   * 
   * @param blackScore  The total black pieces on the board
   */
  private void setBlackScore(int blackScore) {
    this.blackScore = blackScore;
  }
  
  /**
   * Gets the total black pieces on the board
   *
   * @return  The total black pieces
   */
  public int getBlackScore() {
    return blackScore;
  }
  
  /**
   * Sets the total white pieces on the board
   * 
   * @param whiteScore  The total white pieces on the board
   */
  private void setWhiteScore(int whiteScore) {
    this.whiteScore = whiteScore;
  }
  
  /**
   * Gets the total white pieces on the board
   * 
   * @return  The total white pieces on the board
   */
  public int getWhiteScore() {
    return whiteScore;
  }
  
  /**
   * Sets the total blank pieces on the board
   * 
   * @param blackSquare  The total blank pieces on the board
   */
  private void setBlankSquares(int blankSquare) {
    this.blankSquare = blankSquare;
  }
  
  /**
   * Gets the total blank pieces on the board
   * 
   * @return  The total blank pieces on the board
   */
  public int getBlankSquares() {
    return blankSquare;
  }
  
  /**
   * Gets the frame this board is on
   *
   * @return  the frame this board is on
   */
  public JFrame getFrame() {
    return frame;
  }
  
  /**
   * Gets the frame the skip turn is on
   * 
   * @return  the frame skip turn is on
   */
  public JFrame getSkipTurnFrame() {
    return turnSkippedFrame;
  }
  
  /**
   * Gets the frame the end of game is on
   * 
   * @return  the frame end of game is on
   */
  public JFrame getEndOfGameFrame() {
    return endOfGame;
  }
  
  public JButton[][] getButtonGrid() {
    return buttonGrid;
  }
  /**
   * Gets the dialogue of the skip turn frame
   * 
   * @return  the dialogue from the skip turn frame
   */
  public JLabel getSkipTurnDialogue() {
    return turnSkippedDialogue;
  }
  
  /**
   * Gets the dialogue from the end of game frame
   *
   * @return  the dialogue form the end of game frame
   */
  public JLabel getEndOfGameDialogue() {
    return endOfGameDialogue;
  }
  
  /**
   * Determines whether a square is an enemy square
   * 
   * @param thisSquare  The square in question
   * @return            whether the square is an enemy.
   */
  public boolean isEnemySquare(JButton thisSquare) {
    
    /* When white's turn, black is enemy square and vice versa*/
    if (whiteTurn)
      return (Color.BLACK == thisSquare.getBackground());
    else
      return (Color.WHITE == thisSquare.getBackground());
  }
  
  /**
   * Determines whether a square is an ally square
   * 
   * @param thisSquare  The square in question.
   * @return            whether the square in an ally
   */
  public boolean isAllySquare(JButton thisSquare) {
    
    /* When white's turn, black is enemy square and vice versa*/
    if (whiteTurn)
      return (Color.WHITE == thisSquare.getBackground());
    else
      return (Color.BLACK == thisSquare.getBackground());
  }
  
  /**
   * Determines whether the chosen square is available
   * 
   * @param thisSquare  The square that in question
   * @return            whether the square as no piece
   */
  public boolean isOpenSquare(JButton thisSquare) {
    /* If the square isn't colored, the space is open*/
    return thisSquare.getBackground() == new JButton().getBackground();
  }
  
  /**
   * Checks whether the index is out of the array's bounds
   * 
   * @return  whether the index is out of the array's bounds
   */
  private boolean isOutOfBounds() {
    
    if (getIndexRow() >= getButtonGrid().length)
      return true;
    if (getIndexColumn() >= getButtonGrid()[0].length)
      return true;
    if (getIndexRow() < 0)
      return true;
    if (getIndexColumn() < 0)
      return true;
    return false;
  }
  
  /**
   * Finds where in the array a button is
   * 
   * @param thisButton  The button in question
   */
  private void findButton(JButton thisButton) {      
    /* Loops through the multi-dimensional array to where the JButton is
     * in the array*/
    for (int i = 0; i < getButtonGrid().length; i++) {
      for (int j = 0; j < getButtonGrid()[0].length; j++) {
        
        /* When the JButton is found, record the row and column coordinate*/
        if (getButtonGrid()[i][j].equals(thisButton)) {
          setRow(i);
          setColumn(j);
        }
      }
    }
  }
  
  /**
   * Changes the color of the square to the current player's color
   * 
   * @param thisButton  the button in question
   */
  private void changeSquareColor(JButton thisButton) {
    
    /* Turns button white on white's turn, black on black's turn*/
    if(getWhiteTurn()) 
      thisButton.setBackground(Color.WHITE);
    else
      thisButton.setBackground(Color.BLACK);
  }
  
  /**
   * Flips the squares between the indeces and the actual row and column of
   * the square
   * 
   * @param dx  the amount the row index was incremented by
   * @param dy  the amount the column index was incremented by
   */
  private void flipSquares(int dx, int dy) {
    
    /* Flips the color of squares between the indeces and the original
     * square*/
    while(getIndexRow() != getRow() || getIndexColumn() != getColumn()) {
      /* The color of the current player*/
      changeSquareColor(getButtonGrid()[getIndexRow()][getIndexColumn()]);
      setIndexRow(getIndexRow() - dx);
      setIndexColumn(getIndexColumn() - dy);
    }
  }
  
  /**
   * Checks the a play is legal in a particular direction
   * 
   * @param dx  incremental change to the row index
   * @param dy  incremental change to the column index
   * @return    whether the direction is legal
   */
  private boolean isLegalDirection(int dx, int dy) {
    
    /* The row index is displaced one increment*/
    setIndexRow(dx + getRow());
    /* The column index is displaced one increment*/
    setIndexColumn(dy + getColumn());
    
    /* The direction is not legal if it is out of bounds*/
    if (isOutOfBounds())
      return false;
    
    /* If this move is not on an enemy square, return false*/
    if(!isEnemySquare(getButtonGrid()[getIndexRow()][getIndexColumn()]))
      return false;
    
    /* Checks whether the index is on the board*/
    while (!isOutOfBounds()) {
      
      /* Return true only if the enemy square is flanked by an ally square*/
      if(isOpenSquare(getButtonGrid()[getIndexRow()][getIndexColumn()]))
        return false;
      if(isAllySquare(getButtonGrid()[getIndexRow()][getIndexColumn()]))
        return true;
      
      /* Increment the index row and column*/
      setIndexRow(dx + getIndexRow());
      setIndexColumn(dy + getIndexColumn());
    }
    return false;
  }
  
  /**
   * Checks whether this square is a legal play
   * 
   * @return  whether there are any legal plays
   */
  private boolean checkLegalPlays() {
    /* Checks each square surrounding the pressed square*/
    for(int dx = -1; dx <= 1; dx++) {
      for(int dy = -1; dy <= 1; dy++) {
        if(isLegalDirection(dx, dy)) {
          return true;
        }
      }
    }
    return false;
  }
  
  /**
   * Checks for all directions in which the play could be legal, and flips the
   * necessary squares for every legal method
   */
  private void flipLegalPlays() {
    
    /* Checks through each square surrounding this square flips necessary
     * squares*/
    for(int dx = -1; dx <= 1; dx++) {
      for(int dy = -1; dy <= 1; dy++) {
        /* If the direction is legal, the play is legal and flip the squares*/
        if(isLegalDirection(dx, dy)) {
          flipSquares(dx, dy);
          setLegalPlay(true);
        }
      }
    }
  }
  
  /**
   * Performs a game move
   * 
   * @param thisButton  The button pressed
   */
  private void gameMove(JButton thisButton) {
    
    /* Finds where on the array the button is*/
    findButton(thisButton);
    
    /* When the button is an square button, flip all legal directions*/
    if(isOpenSquare(thisButton))
      flipLegalPlays();
    
    /* Continue when a legal play*/
    if(getLegalPlay()) {
      /* Change the square color to this player's color*/
      changeSquareColor(thisButton);
      /* Change whose turn it is*/
      setWhiteTurn(!getWhiteTurn());
      setLegalPlay(!getLegalPlay());
    }
  }
  
  /**
   * Determines whether a turn needs to be skipped
   * 
   * @return Whether the turn needs to be skipped
   */
  private boolean isSkipTurn() {
    
    /* Loops through the multidimensional array*/
    for (int i = 0; i < getButtonGrid().length; i++) {
      for (int j = 0; j < getButtonGrid()[0].length; j++) {
        
        /* Continue when an open square is found*/
        if (isOpenSquare(getButtonGrid()[i][j])) {
          
          /* Set coordinates equal to this square's coordinates*/
          setRow(i);
          setColumn(j);
          
          /* If a legal play is found, the turn isn't skipped*/
          if (checkLegalPlays())
            return false;
        }
      }
    }
    return true;
  }
  
  /**
   * Determines the dialogue when a turn is skipped
   */
  private void skipTurnDialogue() {
    
    /* When it's white's turn, black's turn was skipped and vice versa*/
    if(getWhiteTurn())
      getSkipTurnDialogue().setText("Black has no moves, it's now white's turn");
    else
      getSkipTurnDialogue().setText("White has no moves, it's now black's turn");
  }
  
  /**
   * Sets the turn skip frame visible
   */
  private void setTurnSkipVisible() {
    /* The x coordinate of turn skip frame*/
    double xLocation = ((getFrame().getLocation()).getX() + 
                        (getFrame().getSize()).getWidth() / 2 - 
                        getEndOfGameFrame().getSize().getWidth() / 2);
    /* The y coordinate of turn skip frame*/
    double yLocation = ((getFrame().getLocation()).getY() + 
                        (getFrame().getSize()).getHeight() / 2 - 
                        getEndOfGameFrame().getSize().getHeight() / 2);
    /* Size of the frame is 4 buttons*/
    getSkipTurnFrame().setSize(300, 110);
    /* Makes the frame the center of the Reversi board*/
    getSkipTurnFrame().setLocation((int)xLocation, (int)yLocation);
    /* Sets frame visible and on top until clicked*/
    getSkipTurnFrame().setVisible(true);
    getSkipTurnFrame().toFront();
  }
  
  /**
   * Performs what is necessary when a turn is skipped
   */
  private void skipTurn() {
    /* Generate the dialogue*/
    skipTurnDialogue();
    /* Sets the skip turn frame visible*/
    setTurnSkipVisible();
  }
  
  /**
   * Determines the points score by black, white, and the undecided points
   */
  private void decideWinner() {
    
    /* Total of black, white, an blank scores*/
    setBlackScore(0);
    setWhiteScore(0);
    setBlankSquares(0);
    
    /* Loops through the multi-dimensional array of squares*/
    for(int i = 0; i < getButtonGrid().length; i++) {
      for( int j = 0; j < getButtonGrid()[0].length; j++) {
        
        /* Tallies the scores based on the color of the square*/
        if (getButtonGrid()[i][j].getBackground() == Color.WHITE)
          setWhiteScore(getWhiteScore() + 1);
        else if (getButtonGrid()[i][j].getBackground() == Color.BLACK)
          setBlackScore(getBlackScore() + 1);
        else
          setBlankSquares(getBlankSquares() + 1);
      }
    }
  }
  
  /**
   * Determines the dialogue on the end of game frame
   */
  private void endOfGameDialogue() {
    /* Lists who won and the scores of both the players*/
    if (getWhiteScore() > getBlackScore())
      getEndOfGameDialogue().setText("White wins with a score of " + 
                                     (getWhiteScore() + getBlankSquares()) + " to " +
                                     getBlackScore());
    else if (getWhiteScore() < getBlackScore()) 
      getEndOfGameDialogue().setText("Black wins with a score of " +
                                     (getBlackScore() + getBlankSquares()) + " to " +
                                     getWhiteScore());
    else
      getEndOfGameDialogue().setText("The game ends in a tie!");
  }
  
  /**
   * Sets the end of game frame visible
   */
  private void setEndOfGameVisible() {
    
    /* The x coordinate of end of game frame*/
    double xLocation = ((getFrame().getLocation()).getX() + 
                        (getFrame().getSize()).getWidth() / 2 - 
                        (getEndOfGameFrame().getSize()).getWidth() / 2);
    /* The y coordinate of end of game frame*/
    double yLocation = ((getFrame().getLocation()).getY() +
                        (getFrame().getSize()).getHeight() / 2 -
                        getEndOfGameFrame().getSize().getHeight() / 2);
    
    /* The frame is 4x4 buttons in size*/
    getEndOfGameFrame().setSize(300, 110);
    /* Sets the frame in the center of the Reversi board*/
    getEndOfGameFrame().setLocation((int)xLocation, (int)yLocation);
    /* Sets the frame visible and places it on top until clicked*/
    getEndOfGameFrame().setVisible(true);
    getEndOfGameFrame().toFront();
  }
  
  /**
   * Performs the end of game functions
   */
  private void endOfGame() {
    /* Determines the winner of the game*/
    decideWinner();
    /* Generates the dialogue*/
    endOfGameDialogue();
    /* Sets the frame visible*/
    setEndOfGameVisible();
  }
  
  /**
   * The method initializes a game of Reversi
   * 
   * @param args  The arguments taken in by the method
   */
  public static void main(String[] args) {
    /* Initializes the panels, frame, and button to create an error pop-up*/
    JFrame errorFrame = new JFrame("Invalid Input");
    JPanel mainPanel = new JPanel(new BorderLayout());;
    JPanel btmPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel topPanel = new JPanel();
    JButton close = new JButton("Continue");
    JLabel errorMessage = new JLabel("Please enter 0 to 2 integers");
    /* Closes the error message when the button is pressed*/
    close.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        errorFrame.dispose();
      }
    });
    /* Adds the panels to the frame*/
    btmPanel.add(close);
    topPanel.add(errorMessage);
    mainPanel.add(btmPanel, BorderLayout.SOUTH);
    mainPanel.add(topPanel, BorderLayout.NORTH);
    errorFrame.add(mainPanel);
    
    /* With no inputs, launch a 8x8 Reversi*/
    if (args.length == 0) {
      new Reversi();
    }
    /* With one input, launch an input by input Reversi*/
    else if (args.length == 1) {
      /* Catch inputs that are not integers*/
      try {
        int input1 = Integer.parseInt(args[0]);
        new Reversi(input1);
      }
      catch (NumberFormatException e) {
        /* Error message if it's not an integer*/
        errorFrame.setSize(300, 110);
        errorFrame.setVisible(true);
        errorFrame.toFront();
      }
    }
    /* With two input, launch an input1 by input2 Reversi*/
    else if (args.length == 2) {
      /* Catch inputs that are not integers*/
      try {
        int input1 = Integer.parseInt(args[0]);
        int input2 = Integer.parseInt(args[1]);
        new Reversi(input1, input2);
      }
      /* Error message if it's not an integer*/
      catch (NumberFormatException e) {
        errorFrame.setSize(300, 110);
        errorFrame.setVisible(true);
        errorFrame.toFront();
      }
      new Reversi(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    }
    /* If more than 2 inputs, error message pop-up*/
    else {
      errorFrame.setSize(300, 110);
      errorFrame.setVisible(true);
      errorFrame.toFront();
    }
  }
  
}