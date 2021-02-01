# lwjgl-triangles
Floating Triangles Simulation using Java's lwjgl library


## TODO
- Create more possible Renderable simple classes. Begin work on code for triangle simulation and movement.

##Update 0.0.1 - Graphics work 1
- Created more simple classes, worked on Lines, Polygons, Triangles, Points, etc. All work based on new `Vertex` class, taking in `Vector2` position and `Vector3` color data to paint to screen.
- Added update loop mechanics to window classes, as well as `Updateable` interface, can now be called on multiple classes.
- Extended example main class to include 


## Update 0.0.0
Created the Input, Time, Window classes, as well as set up general framework for other parts (math, etc). Renderables can be rendered on screen per update of the window.
Objects can also be easily moved using deltaTime to be independent of the timestep.
Currently, simply quads have been set up using the `Renderable` abstract class. More will be added along with the next commit.


