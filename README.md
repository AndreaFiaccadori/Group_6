<h1 align="center">MyShelfie</h1>

This project is inspired by the tabletop game "MyShelfie". In this game, the main goal is to fill your personal library by strategically choosing the right tiles at the right moment to complete as many objectives as possible. It emphasizes strategy over speed, as finishing your library first doesn't give many points.

1. Introduction

   - Instead of developing a graphical interface for this project, we focused on perfecting the console experience by adding colors, row and column numbers, and a legend to make it elegant and easier for players to understand

2. Start of the game

   - Initial inputs: The game starts by asking how many players want to play (2-4). It proceeds to ask each player for their nickname (the nickname cannot be empty)

   - Automatic preparation (based on the number of players): The order of the players is shuffled. Common objective cards (always 2) are extracted. The plank is filled based on the number of players

3. Turn

   - Picking the object tiles: The game checks if the plank needs to be filled
   
   - The following output is shown to the current player:

   i. The description and image of the common objectives

   ii. The library with all its tiles and column numbers

   iii. The personal objective of the current player

   iv. The current status of the plank with row and column numbers, along with a legend listing all the tile types (every object tile in the plank is identified as a single character)
   
   - Picking time: The player needs to decide which tile they want to take first. To do so, they need to specify the row number and then the column number of the tile they want to pick, separeted by a space. If a mistake occurs, the game recognizes it and informs the player that they need to pick the tile again. The game also asks if the player wants to pick another tile ('y' -> yes, 'n' -> no) or undo their choice and start by choosing the first tile
   
   - Common objective check: Every time a player finishes filling their library, the game checks if they have completed one of the common objectives. If they have, the game notifies the player, and the points are added. Players need to be fast, because if another player completes the objective faster than them, the current player will receive less points
   
   - Library filling: The player needs to choose one of the available columns (0-4) and put all the tiles in that same column. Then, they need to choose the correct order for the tiles. If only one tile is left, the game automatically puts the tile above the last one. The game includes many checks to prevent invalid moves, such as trying to place three tiles where there is only one space left in the library
   
   - At the end of the turn, the game checks if the library is completed. If it is, the player is awarded a bonus point, and the other players after the current one need to finish their turns
   
4. Endgame

   - Score calculation: After the last turn is finished, the game calculates the score for each player, based the number of completed common objective, how many tiles are positioned according to the personal objective, and the number of adjacent tiles of the same type. Currently, the game only determines one winner, even if two players have the same score
   
   - The user can then decide to play another match as well
