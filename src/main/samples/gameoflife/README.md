# Conway's Game of Life
### Built with TVWZ Engine, based on LWJGL's OpenGL Implementation

## Rules of the Game
1. Cells that are blank are unoccupied, and cells that are filled in are occupied.
2. Any occupied cell must have either 2 or 3 occupied neighbors to be occupied in the next iteration, else it will become unoccupied.
3. An unoccupied cell will become occupied in the next generation if and only if it has exactly three neighbors that are occupied.


## How to Play
- The game starts in a "paused" mode. To play, click on squares to give them "life" or "kill" them while paused.
- Press space to play/pause, and, while paused, the right arrow key will increment by one update without unpausing, allowing for a closer look at what is happening.
