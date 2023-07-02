package src;

import src.counter.GameCounter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOfLife extends JFrame {

    public static boolean[][] gridState;
    private static int gridSize = 60;
    private static int cellSize = 20;
    public static Color bgColor = Color.WHITE;
    public static Color gridColor = Color.BLACK;

    private GridPanel gridPanel;
    private Timer timer;
    private GameCounter gameCounter;

    public GameOfLife() {
        setTitle("Game of Life");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
//        int windowWidth = gridSize * cellSize;
//        int gridHeight = gridSize * cellSize;
//        int windowHeight = gridHeight + getInsets().top + getInsets().bottom;
        // fullscreen
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

        gridPanel = new GridPanel();
        add(gridPanel);

        initializeGridState();

        gameCounter = new GameCounter();

        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
        add(startButton, BorderLayout.NORTH);

        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateGridState();
                repaint();
                gameCounter.updateGeneration();
                gameCounter.updatePopulation(countPopulation());
            }
        });

        setVisible(true);
    }

    private void initializeGridState() {
        gridState = new boolean[gridSize][gridSize];
        // Here we can initialize the grid state with some pattern
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                gridState[i][j] = Math.random() < 0.5;
            }
        }
    }

    private void startGame() {
        timer.start();
    }

    private void updateGridState() {
        boolean[][] newGridState = new boolean[gridSize][gridSize];

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                int liveNeighbors = countLiveNeighbors(i, j);

                // Rules of the game
                if (gridState[i][j]) {
                    // Alive cell
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        // Dies if it has less than 2 or more than 3 live neighbors
                        newGridState[i][j] = false;
                    } else {
                        // Continues to live otherwise
                        newGridState[i][j] = true;
                    }
                } else {
                    // Dead cell
                    if (liveNeighbors == 3) {
                        // Gets alive if it has exactly 3 live neighbors
                        newGridState[i][j] = true;
                    } else {
                        // Stays dead otherwise
                        newGridState[i][j] = false;
                    }
                }
            }
        }

        gridState = newGridState;
    }

    private int countLiveNeighbors(int x, int y) {
        int count = 0;

        // Check all 8 neighbors
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    // Skip the cell itself
                    continue;
                }

                int neighborX = x + i;
                int neighborY = y + j;

                // Check if the neighbor is within the grid
                if (neighborX >= 0 && neighborX < gridSize && neighborY >= 0 && neighborY < gridSize) {
                    if (gridState[neighborX][neighborY]) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private int countPopulation() {
        int count = 0;

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (gridState[i][j]) {
                    count++;
                }
            }
        }
        System.out.println("Generation: " + gameCounter.getGeneration() + " Population: " + gameCounter.getPopulation());
        return count;
    }

    public class GridPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(bgColor);
            g.fillRect(0, 0, getWidth(), getHeight());

            g.setColor(gridColor);

            for (int j = 0; j < gridSize; j++) {
                for (int i = 0; i < gridSize; i++) {
                    if (gridState[i][j]) {
                        g.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
                    } else {
                        g.drawRect(i * cellSize, j * cellSize, cellSize, cellSize);
                    }
                }
            }

            // Draw the generation and population
            g.setColor(Color.RED);
            g.drawString("Generation: " + gameCounter.getGeneration(), 10, getHeight() - 20);
            g.drawString("Population: " + gameCounter.getPopulation(), 10, getHeight() - 5);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameOfLife::new);
    }
}
