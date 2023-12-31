# Game of Life

The Game of Life is a cellular automaton devised by the British mathematician John Conway. It is a zero-player game, meaning that its evolution is determined by its initial state, requiring no further input. It is Turing complete and can simulate a universal constructor or any other Turing machine.

![Game of Life](src/main/resources/game_of_life_demo.gif)

## Rules

The universe of the Game of Life is an infinite two-dimensional grid of square cells, each of which is in one of two possible states: alive or dead. Every cell interacts with its eight neighbors, which are the cells that are horizontally, vertically, or diagonally adjacent. At each step in time, the following transitions occur:

1. Any live cell with fewer than two live neighbors dies, as if by underpopulation.
2. Any live cell with two or three live neighbors lives on to the next generation.
3. Any live cell with more than three live neighbors dies, as if by overpopulation.
4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

## How to Run

To run the Game of Life, make sure you have Java installed on your system.

1. Clone this repository: `git clone https://github.com/Zephir0g/game-of-life.git`
2. Navigate to the project directory: `cd game-of-life`
3. Compile the Java files: `javac src/GameOfLife.java`
4. Run the application: `java src.GameOfLife`

## Controls

- Click the "Start" button to begin the simulation.
- Click the "Pause" button to pause the simulation.
- Click the "Regenerate" button to regenerate the initial position of live cells.

## License

This project has no licence

## Contributing
Contributions are welcome! If you have any suggestions or improvements, please open an issue or submit a pull request.

## Acknowledgements
The Game of Life was invented by John Horton Conway.
This project is inspired by the fascinating world of cellular automata.
