# tvwz-lwjgl-engine
Custom easy to use wrapper library and engine for LWJGL's OpenGL implementation, still generally light. Contains "Sample" implementations, small projects that use the engine. Current planning for projects:
- Simple Game Of Life implementation with interaction abilities and start/pause menus.
- Simple Falling Sand simulation, without complex physics engine.
- 2D redoing of previously done arcade/simple games, such as Minesweeper, Snake, Galaxian, etc.

## TODO
- (Possibly) Set up mapping with dependencies so other libraries are automatically added.
- Finish setting up sample/initial projects.
- Add UI library on top of current graphics libraries, as well as Texture/Sprite support.
- Add Text and Font (through TTF) support, most likely as a part of the Texture or Shape classes.
- Consider switch from inheritance to composition structure.

## Current update
Added new Input classes to the Input system to manage a callback style input, similar to java's own awt input framework. Inputs can now be detected on a need-base system instead of a frame-base system. Currently, callbacks are run synchronously, which is unnecessary - they can be called async, which will be implemented using `Thread` systems in the future. Input can be tested by running `Main` class and pressing keys. Current input has 3 systems: keys, mouse, and mouse positions. More support will be added as necessary in the future.

## Update 0.0.2 - Graphics work 2, General Setup
- Finished creation of more `simple` graphics classes, extension from Shape. 
- Polished setup of project, removed unnecessary bloat.
- Set up more classes and `samples` setup for the creation of the rest of the project.

## Update 0.0.1 - Graphics work 1
- Created more simple classes, worked on Lines, Polygons, Triangles, Points, etc. All work based on new `Vertex` class, taking in `Vector2` position and `Vector3` color data to paint to screen.
- Added update loop mechanics to window classes, as well as `Updateable` interface, can now be called on multiple classes.
- Extended example [`Main`](https://github.com/TheVizWiz/lwjgl-triangles/blob/main/src/main/Main.java) class that can be run using `TestClass`, creates floating-point grid. Space to rotate, click on screen to set rotate zone.
- Added multiple new methods, fleshed out `Vector2` and `Vector3` classes. Added new classes such as the `Line` class for future use. 
- Update peek:<br>
<img src = "https://github.com/TheVizWiz/lwjgl-triangles/blob/main/src/resources/rotating_points.png" width = "200" height = "200" alt = "rotating points 0.0.1">



## Update 0.0.0
Created the Input, Time, Window classes, as well as set up general framework for other parts (math, etc). Renderables can be rendered on screen per update of the window.
Objects can also be easily moved using deltaTime to be independent of the timestep.
Currently, simply quads have been set up using the `Renderable` abstract class. More will be added along with the next commit.


