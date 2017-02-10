import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * A game called ReversiPractice
 */
public class ReversiPractice2 {
  
  /* The board Reversi will be played on*/
  private final JPanel board;
  
  /* The frame the board will be placed on*/
  private final JFrame frame;
  
  /* A two-dimensional array of buttons that will go on the board*/
  private final JButton[][] buttonGrid;
  
  /* The frame the skip turn dialogue will be placed on*/
  private JFrame turnSkippedFrame;
  
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
  public ReversiPractice2(int x, int y) {
    
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
    
    /* Initializes the frame that holds the skip turn dialogue*/
    turnSkippedFrame = new JFrame("Turn Skipped");
    
    /* Initializes the button that closes the skip turn frame*/
    turnSkippedButton = new JButton();
    turnSkippedButton.addActionListener(new ActionListener() {
      
      public void actionPerformed(ActionEvent e) {
        turnSkippedFrame.dispose();
        frame.setFocusable(true);
      }
    });
    
    /* Initializes the dialogue that will go on the turn skipped frame*/
    turnSkippedDialogue = new JLabel();
    
    turnSkippedFrame.add(turnSkippedDialogue, "North");
    turnSkippedFrame.add(turnSkippedButton, "South");
    
    /* Initializes the frame that holds the end of game dialogue*/
    endOfGame = new JFrame();
    
    /* Initializes the quit button at the end of the game*/
    quit = new JButton();
    quit.addActionListener(new ActionListener() {
      
      public void actionPerformed(ActionEvent e) {
        endOfGame.dispose();
        frame.dispose();
      }
    });
    
    /* Initializes the new game button at the end of the game*/
    newGame = new JButton();
    newGame.addActionListener(new ActionListener() {
      
      public void actionPerformed(ActionEvent e) {
        endOfGame.dispose();
        frame.dispose();
        new ReversiPractice2(x, y);
      }
    });
    
    /* Initializes the end of game dialogue*/
    endOfGameDialogue = new JLabel();
    
    endOfGame.add(quit, "East");
    endOfGame.add(newGame, "West");
    endOfGame.add(endOfGameDialogue, "North");
  }
  
  /**
   * Creates a game board
   * 
   * @param dimension  the number of rows and the number of columns
   */
  public ReversiPractice2(int dimension) {
    this(dimension, dimension);
  }
  
  /**
   * Creates a game board with 8 rows and 8 columns
   */
  public ReversiPractice2() {
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
      if(isSkipTurn(buttonGrid)) {
        if(isSkipTurn(buttonGrid)) {
        }
        else {
        }
      }
    }
  }
  
  /**
   * Sets if a legal play is available
   * 
   * @param  if there is a k play
   */
  private void setLegalPlay(boolean legalPlay) {
    this.legalPlay = legalPlay;
  }
  
  /**
   * Returns if there is a legal play
   * 
   * @return if there is a legal play
   */
  private boolean getLegalPlay() {
    return legalPlay;
  }
  
  /**
   * Sets if it is currently white's turn
   * 
   * @param whiteTurn  If it is currently white's turn
   */
  private void setWhiteTurn(boolean whiteTurn) {
    this.whiteTurn = whiteTurn;
  }
  
  /**
   * Returns if it is white's turn
   * 
   * @return  if it is white's turn
   */
  private boolean getWhiteTurn() {
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
  private int getRow() {
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
  private int getColumn() {
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
  private int getIndexRow() {
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
  private int getIndexColumn() {
    return indexColumn;
  }
  
  /**
   * Determines whether a square is an enemy square
   * 
   * @param thisSquare  The square in question
   * @return            If the square is an enemy.
   */
  private boolean isEnemySquare(JButton thisSquare) {
    
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
   * @return            If the square in an ally
   */
  private boolean isAllySquare(JButton thisSquare) {
    
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
   * @return            If the square as no piece
   */
  private boolean isOpenSquare(JButton thisSquare) {
    /* If the square isn't colored, the space is open*/
    return thisSquare.getBackground() == new JButton().getBackground();
  }
  
  /**
   * Checks if the index is out of the array's bounds
   * 
   * @return  If the index is out of the array's bounds
   */
  private boolean isOutOfBounds() {
    
    if (getIndexRow() >= buttonGrid.length)
      return true;
    if (getIndexColumn() >= buttonGrid[0].length)
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
    for (int i = 0; i < buttonGrid.length; i++) {
      for (int j = 0; j < buttonGrid[0].length; j++) {
        
        /* When the JButton is found, record the row and column coordinate*/
        if (buttonGrid[i][j].equals(thisButton)) {
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
  public void flipSquares(int dx, int dy) {
    
    /* Flips the color of squares between the indeces and the original
     * square*/
    while(getIndexRow() != getRow() || getIndexColumn() != getColumn()) {
      /* The color of the current player*/
      changeSquareColor(buttonGrid[getIndexRow()][getIndexColumn()]);
      setIndexRow(getIndexRow() - dx);
      setIndexColumn(getIndexColumn() - dy);
    }
  }
  
  /**
   * Checks the a play is legal in a particular direction
   * 
   * @param dx  incremental change to the row index
   * @param dy  incremental change to the column index
   * @return    If the direction is legal
   */
  public boolean isLegalDirection(int dx, int dy) {
    
    /* The row index is displaced one increment*/
    setIndexRow(dx + getRow());
    /* The column index is displaced one increment*/
    setIndexColumn(dy + getColumn());
    
    /* The direction is not legal if it is out of bounds*/
    if (isOutOfBounds())
      return false;
    
    /* If this move is not on an enemy square, return false*/
    if(!isEnemySquare(buttonGrid[getIndexRow()][getIndexColumn()]))
      return false;
    
    /* Checks if the index is on the board*/
    while (!isOutOfBounds()) {
      
      /* Return true only if the enemy square is flanked by an ally square*/
      if(isOpenSquare(buttonGrid[getIndexRow()][getIndexColumn()]))
        return false;
      if(isAllySquare(buttonGrid[getIndexRow()][getIndexColumn()]))
        return true;
      
      /* Increment the index row and column*/
      setIndexRow(dx + getIndexRow());
      setIndexColumn(dy + getIndexColumn());
    }
    return false;
  }
  
  /**
   * Checks if this square is a legal play
   * 
   * @param thisSquare
   */
  private boolean checkLegalPlays() {
    /* Checks each square surrounding the pressed square*/
    for(int dx = -1; dx <= -1; dx++) {
      for(int dy = -1; dy <= 1; dy++) {
        /* When a legal direction is found, there's a legal play*/
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
   * 
   * @param thisButton  the square in question*/
  private void flipLegalPlays() {
    
    /* Checks through each square surrounding this square flips necessary
     * squares*/
    for(int dx = -1; dx <= 1; dx++) {
      for(int dy = -1; dy <= 1; dy++) {
        /* Catches if the square in question is this square*/
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
   * Checks if there are any legal plays on the board
   * 
   * @param buttonGrid  The board in question
   * @return            If there are any legal plays
   */
  private boolean isSkipTurn(JButton[][] buttonGrid) {
    /* Checks each square for a legal play*/
    for(int i = 0; i < buttonGrid.length; i++) {
      for(int j = 0; j < buttonGrid[0].length; j++) {
        /* Sets the row and column of the button being checked*/
        setRow(i);
        setColumn(j);
        if(isOpenSquare(buttonGrid[i][j])) {
          /* When a legal play is found, the turn is not skipped*/
          if(checkLegalPlays()) {
            return false;
          }
        }
      }
    }
    return true;
  }
  
  private void skipTurnDialogue() {
    if(getWhiteTurn())
      turnSkippedDialogue.setText("Black has no open plays, \t" +
                                  "it's now white's turn");
    else
      turnSkippedDialogue.setText("White has no open plays, \t" +
                                  "it's now black's turn");
  }
  
  private void skipTurn() {
    skipTurnDialogue();
    turnSkippedFrame.setSize(400, 400);
    turnSkippedFrame.setVisible(true);
    frame.setFocusable(false);
  }
  
  private void decideWinner() {
    
    blackScore = 0;
    whiteScore = 0;
    blankSquare = 0;
    
    for(int i = 0; i < buttonGrid.length; i++) {
      for( int j = 0; j < buttonGrid[0].length; j++) {
        
        if (buttonGrid[i][j].getBackground() == Color.WHITE)
          whiteScore = whiteScore + 1;
        else if (buttonGrid[i][j].getBackground() == Color.BLACK)
          blackScore = blackScore + 1;
        else
          blankSquare = blankSquare + 1;
      }
    }
  }
  
  private void setEndOfGameDialogue() {
    if (whiteScore > blackScore)
      endOfGameDialogue.setText("White wins with a score of " + 
                                (whiteScore + blankSquare) + " to " +
                                blackScore);
    else if (whiteScore < blackScore) 
      endOfGameDialogue.setText("Black wins with a score of " +
                                (blackScore + blankSquare) + " to " +
                                whiteScore);
    else
      endOfGameDialogue.setText("The game ends in a tie!");
  }
  
  private void endOfGame() {
    decideWinner();
    setEndOfGameDialogue();
    endOfGame.setSize(200, 200);
    endOfGame.setVisible(true);
    frame.setFocusable(false);
  }
}