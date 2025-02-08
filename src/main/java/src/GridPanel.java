package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

import static src.GameOfLife.gridState;

public class GridPanel extends JPanel {
    // private static int gridSize = 20;
    // private static int cellSize = 20;
    // private static int gridSize = 30;
    // private static int cellSize = 18;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(GameOfLife.bgColor);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(GameOfLife.gridColor);

        for (int j = 0; j < gridSize; j++) {
            for (int i = 0; i < gridSize; i++) {
                if (gridState[i][j]) {
                    g.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
                } else {
                    g.drawRect(i * cellSize, j * cellSize, cellSize, cellSize);
                }
            }
        }
    }

    public GridPanel() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                super.mouseClicked(e);
                int x = e.getX();
                int y = e.getY();
                int i = x / cellSize;
                int j = y / cellSize;
                gridState[i][j] = !gridState[i][j];
                repaint();
            }
        });
    }
}
