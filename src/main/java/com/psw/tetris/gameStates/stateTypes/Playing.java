package com.psw.tetris.gameStates.stateTypes;

import static com.psw.tetris.utils.Constants.Directions.LEFT;
import static com.psw.tetris.utils.Constants.Directions.RIGHT;
import static com.psw.tetris.utils.Constants.GameConstants.BOARD_HEIGHT;
import static com.psw.tetris.utils.Constants.GameConstants.BOARD_SQUARE;
import static com.psw.tetris.utils.Constants.GameConstants.BOARD_WIDTH;
import static com.psw.tetris.utils.Constants.GameConstants.GAME_HEIGHT;
import static com.psw.tetris.utils.Constants.GameConstants.GAME_WIDTH;
import static com.psw.tetris.utils.Constants.TetrominoIDs.I;
import static com.psw.tetris.utils.Constants.TetrominoIDs.J;
import static com.psw.tetris.utils.Constants.TetrominoIDs.L;
import static com.psw.tetris.utils.Constants.TetrominoIDs.O;
import static com.psw.tetris.utils.Constants.TetrominoIDs.S;
import static com.psw.tetris.utils.Constants.TetrominoIDs.T;
import static com.psw.tetris.utils.Constants.TetrominoIDs.Z;

import com.psw.tetris.gameElements.boardTypes.PlayerBoard;
import com.psw.tetris.gameStates.GameStateHandler.GameStatesEnum;
import com.psw.tetris.gameStates.State;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Playing extends State {

  private PlayerBoard board;
  private Color boardColor = new Color(20, 20, 20);

  private final int X_OFFSET = GAME_WIDTH / 2 - BOARD_WIDTH * BOARD_SQUARE / 2;
  private final int Y_OFFSET = GAME_HEIGHT / 2 - BOARD_HEIGHT * BOARD_SQUARE / 2;

  private boolean mouseButton1Pressed = false;
  private boolean mouseButton3Pressed = false;

  public Playing() {
    super(GameStatesEnum.PLAYING);
    board = new PlayerBoard(BOARD_SQUARE, X_OFFSET, Y_OFFSET, boardColor);
  }

  @Override
  public void update() {
    board.update();
  }

  @Override
  public void render(Graphics g) {
    board.render(g);
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    if (e.getButton() == MouseEvent.BUTTON1) board.addBlockOnMousePosition(e.getX(), e.getY());
    else if (e.getButton() == MouseEvent.BUTTON3)
      board.removeBlockOnMousePosition(e.getX(), e.getY());
  }

  @Override
  public void mousePressed(MouseEvent e) {
    if (e.getButton() == MouseEvent.BUTTON1) mouseButton1Pressed = true;
    else if (e.getButton() == MouseEvent.BUTTON3) mouseButton3Pressed = true;
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    if (e.getButton() == MouseEvent.BUTTON1) mouseButton1Pressed = false;
    else if (e.getButton() == MouseEvent.BUTTON3) mouseButton3Pressed = false;
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    if (mouseButton1Pressed && !mouseButton3Pressed)
      board.addBlockOnMousePosition(e.getX(), e.getY());
    else if (!mouseButton1Pressed && mouseButton3Pressed)
      board.removeBlockOnMousePosition(e.getX(), e.getY());
  }

  @Override
  public void keyPressed(KeyEvent e) {
    switch (e.getKeyCode()) {
      case (KeyEvent.VK_Z):
        board.getTetromino().rotate(LEFT);
        break;

      case (KeyEvent.VK_X):
        board.getTetromino().rotate(RIGHT);
        break;

      case (KeyEvent.VK_LEFT):
        board.getTetromino().setLeft(true);
        break;

      case (KeyEvent.VK_DOWN):
        board.getTetromino().setDown(true);
        break;

      case (KeyEvent.VK_RIGHT):
        board.getTetromino().setRight(true);
        break;

      case (KeyEvent.VK_SPACE):
        board.getTetromino().setDrop(true);
        break;

      case (KeyEvent.VK_E):
        board.holdTetromino();
        break;
        
      case (KeyEvent.VK_G):
        // board.toggleGrid();
        break;

      case (KeyEvent.VK_D):
        board.toggleDebugMode();
        break;

      case (KeyEvent.VK_R):
        board.reset();
        break;

      case (KeyEvent.VK_P):
        board.togglePause();
        break;

        // NOTE: these keybinds are only for debugging purposes
        // TODO: remove these keybinds
      case (KeyEvent.VK_1):
        board.setTetromino(I);
        break;

      case (KeyEvent.VK_2):
        board.setTetromino(T);
        break;

      case (KeyEvent.VK_3):
        board.setTetromino(O);
        break;

      case (KeyEvent.VK_4):
        board.setTetromino(J);
        break;

      case (KeyEvent.VK_5):
        board.setTetromino(L);
        break;

      case (KeyEvent.VK_6):
        board.setTetromino(S);
        break;

      case (KeyEvent.VK_7):
        board.setTetromino(Z);
        break;

      default:
        break;
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    switch (e.getKeyCode()) {
      case (KeyEvent.VK_LEFT):
        board.getTetromino().setLeft(false);
        break;

      case (KeyEvent.VK_DOWN):
        board.getTetromino().setDown(false);
        break;

      case (KeyEvent.VK_RIGHT):
        board.getTetromino().setRight(false);
        break;

      case (KeyEvent.VK_SPACE):
        board.getTetromino().setDrop(false);
        break;

      default:
        break;
    }
  }

  @Override
  public void windowLostFocus() {}
}
