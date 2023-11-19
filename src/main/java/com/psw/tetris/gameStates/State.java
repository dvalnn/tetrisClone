package com.psw.tetris.gameStates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.psw.tetris.gameStates.GameStateHandler.GameStatesEnum;

public class State implements StateMethods {

  protected GameStatesEnum stateID;

  public State(final GameStatesEnum stateID) {
    this.stateID = stateID;
  }

  public GameStatesEnum getStateID() {
    return stateID;
  }

  @Override
  public void update() {
  }

  @Override
  public void render(final Graphics g) {
  }

  @Override
  public void mouseClicked(final MouseEvent e) {
  }

  @Override
  public void mousePressed(final MouseEvent e) {
  }

  @Override
  public void mouseReleased(final MouseEvent e) {
  }

  @Override
  public void mouseMoved(final MouseEvent e) {
  }

  @Override
  public void mouseDragged(final MouseEvent e) {
  }

  @Override
  public void keyPressed(final KeyEvent e) {
  }

  @Override
  public void keyReleased(final KeyEvent e) {
  }

  @Override
  public void windowLostFocus() {
  }

  @Override
  public void mouseEntered(final MouseEvent e) {
  }

  @Override
  public void mouseExited(final MouseEvent e) {
  }
}
