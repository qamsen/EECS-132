import org.junit.*;
import static org.junit.Assert.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Tests Reversi
 * 
 * @author Kameron Damaska
 */
public class ReversiTester {
  
  /**
   * Tests whether the constructors produce the expected boards
   */
  @Test
  public void testGameBoards() {
    Reversi noParameter = new Reversi();
    noParameter.getFrame().setVisible(false);
    Reversi oneParameter = new Reversi(3);
    oneParameter.getFrame().setVisible(false);
    Reversi twoParameters = new Reversi(5, 8);
    twoParameters.getFrame().setVisible(false);
    
    /* Checks if the lengths are correct*/
    assertTrue(noParameter.getButtonGrid().length == 8);
    assertTrue(noParameter.getButtonGrid()[0].length == 8);
    assertTrue(oneParameter.getButtonGrid().length == 3);
    assertTrue(oneParameter.getButtonGrid()[0].length == 3);
    assertTrue(twoParameters.getButtonGrid().length == 5);
    assertTrue(twoParameters.getButtonGrid()[0].length == 8);
   /* Checks if the colors are correct*/
    assertTrue(noParameter.getButtonGrid()[3][3].getBackground() == Color.WHITE);
    assertTrue(noParameter.getButtonGrid()[4][4].getBackground() == Color.WHITE);
    assertTrue(noParameter.getButtonGrid()[3][4].getBackground() == Color.BLACK);
    assertTrue(noParameter.getButtonGrid()[4][3].getBackground() == Color.BLACK);

    /* Ignores remainder in division e.g. (3 / 2 - 1) would be the first row*/
    assertTrue(oneParameter.getButtonGrid()[0][0].getBackground() == Color.WHITE);
    assertTrue(oneParameter.getButtonGrid()[1][1].getBackground() == Color.WHITE);
    assertTrue(oneParameter.getButtonGrid()[0][1].getBackground() == Color.BLACK);
    assertTrue(oneParameter.getButtonGrid()[1][0].getBackground() == Color.BLACK);
    
    assertTrue(twoParameters.getButtonGrid()[1][3].getBackground() == Color.WHITE);
    assertTrue(twoParameters.getButtonGrid()[2][4].getBackground() == Color.WHITE);
    assertTrue(twoParameters.getButtonGrid()[1][4].getBackground() == Color.BLACK);
    assertTrue(twoParameters.getButtonGrid()[2][3].getBackground() == Color.BLACK);
  }
  
  /**
   * Tests various plays to see if they produce the expectated outcome.
   */
  @Test
  public void testLegalPlays() {
    /* The grid we'll be comparing to the game*/
    JButton[][] testButtonGrid = new JButton[8][8];
    /* The game we're testing*/
    Reversi reversi = new Reversi();
    (reversi.getFrame()).setVisible(false);
    
    /* Initializes each button on the grid*/
    for (int i = 0; i < testButtonGrid.length; i++) {
      for (int j = 0; j < testButtonGrid[0].length; j++) {
        testButtonGrid[i][j] = new JButton(); 
      }
    }
    
    /* Mimicking the initial board state*/
    testButtonGrid[3][3].setBackground(Color.WHITE);
    testButtonGrid[4][4].setBackground(Color.WHITE);
    testButtonGrid[4][3].setBackground(Color.BLACK);
    testButtonGrid[3][4].setBackground(Color.BLACK);
    
    /* Clicking an ally square (white turn)*/
    (reversi.getButtonGrid()[3][3]).doClick();
    
    /* Testing if they are the same*/
    for (int i = 0; i < testButtonGrid.length; i++) {
      for (int j = 0; j < testButtonGrid[0].length; j++) {
        assertTrue(testButtonGrid[i][j].getBackground() ==
                   (reversi.getButtonGrid()[i][j]).getBackground());
      }
    }
    
    /* Clicking an enemy square (white turn)*/
    (reversi.getButtonGrid()[3][4]).doClick();
    
    /* Testing if they are the same*/
    for (int i = 0; i < testButtonGrid.length; i++) {
      for (int j = 0; j < testButtonGrid[0].length; j++) {
        assertTrue(testButtonGrid[i][j].getBackground() ==
                   (reversi.getButtonGrid()[i][j]).getBackground());
      }
    }
    
    /* Clicking a blank illegal move (white turn)*/
    (reversi.getButtonGrid()[0][0]).doClick();
    
    /* Testing if they are the same*/
    for (int i = 0; i < testButtonGrid.length; i++) {
      for (int j = 0; j < testButtonGrid[0].length; j++) {
        assertTrue(testButtonGrid[i][j].getBackground() ==
                   (reversi.getButtonGrid()[i][j]).getBackground());
      }
    }
    
    /* Clicking a blank legal move (white turn)*/
    (reversi.getButtonGrid()[3][5]).doClick();
    
    /* The expected change*/
    testButtonGrid[3][4].setBackground(Color.WHITE);
    testButtonGrid[3][5].setBackground(Color.WHITE);
    
    /* Testing if they are the same*/
    for (int i = 0; i < testButtonGrid.length; i++) {
      for (int j = 0; j < testButtonGrid[0].length; j++) {
        assertTrue(testButtonGrid[i][j].getBackground() ==
                   (reversi.getButtonGrid()[i][j]).getBackground());
      }
    }
    
    /* Clicking an ally square (black turn)*/
    (reversi.getButtonGrid()[4][3]).doClick();
    
    /* Testing if they are the same*/
    for (int i = 0; i < testButtonGrid.length; i++) {
      for (int j = 0; j < testButtonGrid[0].length; j++) {
        assertTrue(testButtonGrid[i][j].getBackground() ==
                   (reversi.getButtonGrid()[i][j]).getBackground());
      }
    }
    
    /* Clicking an enemy square (white turn)*/
    (reversi.getButtonGrid()[3][3]).doClick();
    
    /* Testing is they are the same*/
    for (int i = 0; i < testButtonGrid.length; i++) {
      for (int j = 0; j < testButtonGrid[0].length; j++) {
        assertTrue(testButtonGrid[i][j].getBackground() ==
                   (reversi.getButtonGrid()[i][j]).getBackground());
      }
    }
    
    /* Clicking a blank illegal move (white turn)*/
    (reversi.getButtonGrid()[0][0]).doClick();
    
    /* Testing if they are the same*/
    for (int i = 0; i < testButtonGrid.length; i++) {
      for (int j = 0; j < testButtonGrid[0].length; j++) {
        assertTrue(testButtonGrid[i][j].getBackground() ==
                   (reversi.getButtonGrid()[i][j]).getBackground());
      }
    }
    
    /* Clicking a blank legal move (white turn)*/
    (reversi.getButtonGrid()[2][3]).doClick();
    
    /* The expected change*/
    testButtonGrid[3][3].setBackground(Color.BLACK);
    testButtonGrid[2][3].setBackground(Color.BLACK);
    
    /* Testing is they are the same*/
    for (int i = 0; i < testButtonGrid.length; i++) {
      for (int j = 0; j < testButtonGrid[0].length; j++) {
        assertTrue(testButtonGrid[i][j].getBackground() ==
                   (reversi.getButtonGrid()[i][j]).getBackground());
      }
    }
    
    /* Setting up a multi-line flip*/
    (reversi.getButtonGrid()[3][2]).doClick();
    testButtonGrid[3][3].setBackground(Color.WHITE);
    testButtonGrid[3][2].setBackground(Color.WHITE);
    
    /* This play should flip two series of enemies*/
    (reversi.getButtonGrid()[4][5]).doClick();
    
    /* The play should flip these pieces*/
    testButtonGrid[4][5].setBackground(Color.BLACK);
    testButtonGrid[3][4].setBackground(Color.BLACK);
    testButtonGrid[4][4].setBackground(Color.BLACK);
    
    /* Testing if they are the same*/
    for (int i = 0; i < testButtonGrid.length; i++) {
      for (int j = 0; j < testButtonGrid[0].length; j++) {
        assertTrue(testButtonGrid[i][j].getBackground() ==
                   (reversi.getButtonGrid()[i][j]).getBackground());
      }
    }
  }
  
  /**
   * Testing situations where a players turn must be skipped
   */
  @Test
  public void testSkipTurnAndEndGame() {
    
    /* Board we're testing with*/
    Reversi reversi = new Reversi(3, 4);
    
    /* These moves will create a situation where white's turn is skipped*/
    (reversi.getButtonGrid()[1][0]).doClick();
    (reversi.getButtonGrid()[0][0]).doClick();
    
    /* The expected dialogue when white's turn is skipped*/
    String expectedDialogue = "White has no moves, it's now black's turn";
    assertTrue(expectedDialogue.equals((reversi.getSkipTurnDialogue()).getText()));
    
    /* These moves will create a situation where the game ends*/
    (reversi.getButtonGrid()[2][0]).doClick();
    (reversi.getButtonGrid()[2][2]).doClick();
    
    /* The expected dialogue when black wins*/
    expectedDialogue = "Black wins with a score of 12 to 0";
    assertTrue(expectedDialogue.equals((reversi.getEndOfGameDialogue()).getText()));
    
    /* Tests the new game function*/
    reversi = new Reversi(3, 4);
    

    /* These moves will create a situation where black's turn is skipped*/
    (reversi.getButtonGrid()[0][3]).doClick();
    (reversi.getButtonGrid()[1][3]).doClick();
    (reversi.getButtonGrid()[2][3]).doClick();
    
    /* The expected dialogue when white's turn is skipped*/
    expectedDialogue = "Black has no moves, it's now white's turn";
    assertTrue(expectedDialogue.equals((reversi.getSkipTurnDialogue()).getText()));
    
    /* These moves will create a situation where the game ends*/
    (reversi.getButtonGrid()[2][1]).doClick();
    
    /* The expected dialogue when black wins*/
    expectedDialogue = "White wins with a score of 12 to 0";
    assertTrue(expectedDialogue.equals((reversi.getEndOfGameDialogue()).getText()));
  }
}