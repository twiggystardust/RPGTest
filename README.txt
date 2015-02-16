This repository is for my RPGTest game. The game is a Final Fantasy type RPG. 
It is leaning more toward Final Fantasy 1 through 3. It's my first attempt at
and RPG.

1st change: Fixed tile map rendering and updated text files to position tiles 
	    correctly. Added NPC. Also made npc move a little, although the 
	    movement is jumpy. Will figure out a way to fix soon.

2nd change: Added World map. Can transition between that and town map(though 
            the code to do this is terrible and will be replaced as soon as 
            collision is added.) Also updated Tile class, not quite finished 
            with that part. Tried adding a method to detect what type of tile 
            the player is on. Added a 2nd layer to the world map(it has only 
            one town on it at the moment.) 

3rd change: Fixed NPC movement slightly. Made him move more often but less 
            distance. Added mountain tiles. Added transition class(although
            I'm not sure wether this is good practice or not.) Working on adding
            shop state.

4th change: Added animation to player (still need to fix left/right movment pngs.) 
	    Added shop state. Added dialog with shopkeep (still need to fix, button 
	    push is too quick.) Added player stats, painted them to the screen in 
	    the menu. 

5th change: Added dungeon tiles to tile sheet along with dungeon state and transistion
	    to and from the state/dungeon. Started building inventory (this is trial 
	    and error at this point.) Also fixed player animation. 