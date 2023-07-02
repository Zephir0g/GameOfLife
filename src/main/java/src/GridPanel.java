package src;

import javax.swing.*;
import java.awt.*;

public class GridPanel extends JPanel {
    private static int gridSize = 50;
    private static int cellSize = 20;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(GameOfLife.bgColor);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(GameOfLife.gridColor);

        for (int j = 0; j < gridSize; j++) {
            for (int i = 0; i < gridSize; i++) {
                if (GameOfLife.gridState[i][j]) {
                    g.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
                } else {
                    g.drawRect(i * cellSize, j * cellSize, cellSize, cellSize);
                }
            }
        }
    }
}
