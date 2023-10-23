package utils;

public class Constants {
    public static class GameConstants {
        public static final int FPS_SET = 60;
        public static final int UPS_SET = 100;
        public static final int BOARD_WIDTH = 10;
        public static final int BOARD_HEIGHT = 20;
    }

    public static class TetrominoConstants {
        public static final int[][] I_SHAPE = { { 1, 1, 1, 1 } };
        public static final int[][] J_SHAPE = { { 1, 0, 0 }, { 1, 1, 1 } };
        public static final int[][] L_SHAPE = { { 0, 0, 1 }, { 1, 1, 1 } };
        public static final int[][] O_SHAPE = { { 1, 1 }, { 1, 1 } };
        public static final int[][] S_SHAPE = { { 0, 1, 1 }, { 1, 1, 0 } };
        public static final int[][] T_SHAPE = { { 0, 1, 0 }, { 1, 1, 1 } };
        public static final int[][] Z_SHAPE = { { 1, 1, 0 }, { 0, 1, 1 } };

        public static final int[][][] SHAPES = { I_SHAPE, J_SHAPE, L_SHAPE, O_SHAPE, S_SHAPE, T_SHAPE, Z_SHAPE };

        public static final int[][] I_COLOR = { { 0, 255, 255 } };
        public static final int[][] J_COLOR = { { 0, 0, 255 } };
        public static final int[][] L_COLOR = { { 255, 165, 0 } };
        public static final int[][] O_COLOR = { { 255, 255, 0 } };
        public static final int[][] S_COLOR = { { 0, 255, 0 } };
        public static final int[][] T_COLOR = { { 128, 0, 128 } };
        public static final int[][] Z_COLOR = { { 255, 0, 0 } };

        public static final int[][][] COLORS = { I_COLOR, J_COLOR, L_COLOR, O_COLOR, S_COLOR, T_COLOR, Z_COLOR };
    }

    public static class Directions {
        public static final int NONE = -1;
        public static final int UP = 0;
        public static final int RIGHT = 1;
        public static final int DOWN = 2;
        public static final int LEFT = 3;
    }

    public static class GameStates {
        public static final int GAME_OVER = 0;
        public static final int PLAYING = 1;
        public static final int PAUSED = 2;

        public static int gameState = PLAYING;
    }
}