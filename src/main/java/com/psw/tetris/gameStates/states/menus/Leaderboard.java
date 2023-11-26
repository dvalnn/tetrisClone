package com.psw.tetris.gameStates.states.menus;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.event.MouseEvent;

import static com.psw.tetris.utils.Constants.GameConstants.GAME_HEIGHT;
import static com.psw.tetris.utils.Constants.GameConstants.GAME_WIDTH;
import static com.psw.tetris.utils.Constants.UI.Buttons.RETURN_BUTTON;

import com.psw.tetris.gameStates.GameState;
import com.psw.tetris.gameStates.GameStateHandler.GameStatesEnum;
import com.psw.tetris.ui.Button;
import com.psw.tetris.ui.SwitchStateAction;
import com.psw.tetris.utils.LoadSave;

public class Leaderboard extends GameState {

  private final Button returnButton;

  private final BufferedImage returnButtonImage = LoadSave.loadImage(RETURN_BUTTON);
  private final BufferedImage leaderBoardBackground;

  private final double RETURN_BUTTON_SCALE = 0.35;

  private final int returnButtonX = 40;
  private final int returnButtonY = 620;

  private final SwitchStateAction switchGameStateAction = new SwitchStateAction();

  public Leaderboard() {
    super(GameStatesEnum.LEADERBOARD);

    leaderBoardBackground = LoadSave.loadBackground("mainMenu.png");

    returnButton = new Button(returnButtonX, returnButtonY, returnButtonImage, RETURN_BUTTON_SCALE);
  }

  @Override
  public void render(final Graphics g) {
    g.drawImage(leaderBoardBackground, 0, 0, GAME_WIDTH, GAME_HEIGHT, null);
    returnButton.render(g);
  }

  @Override
  public void mouseClicked(final MouseEvent e) {
    returnButton.execIfClicked(
        e.getPoint(),
        switchGameStateAction,
        GameStatesEnum.MAIN_MENU);
  }

}
