# lwjgl-triangles
Floating Triangles Simulation using Java's lwjgl library


## Current work
Created the Input, Time, Window classes, as well as set up general framework for other parts (math, etc). Renderables can be rendered on screen per update of the window.
Objects can also be easily moved using deltaTime to be independent of the timestep.
Currently, simply quads have been set up using the `Renderable` abstract class. More will be added along with the next commit.


## TODO
- Create more possible Renderable simple classes. Begin work on code for triangle simulation and movement.
