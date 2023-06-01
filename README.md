						                                MyShelfie

This project is inpired by the table game "MyShelfie".
In this game your main goal is filling your personal library trying to complete as many objectives as possible choosing carefully the right tiles at the right moment.
Not so many points are given to the one that finish his library first so this game is based
more on strategy than speed.
──────────────────────────────────────
1. Introduction
 -For this project we decided to don't develop the graphic interface but instead we   perfected the output by console by adding colors, rows and columns numbers,   boards 
  and a legend to make it elegant and easier to understand to the players.
 -There aren't some classes like Chair, ScoreTile and Bag because we preferred instead to
  implement this functions in the remaining classes.

──────────────────────────────────────
2. Start of the game
  2.1 Initial inputs
   -The game starts by asking how many players want to play (2-4)
   -It proceeds by asking the nickname to each one (the nickname cannot be empty)
  2.2 Automatic preparation (based on the number of players)
   -The order of the players is shuffled
   -Common objective cards (always 2) are extracted
   -The plank is filled based on the number of players

──────────────────────────────────────
3. Turn
  3.1 Picking the object tiles
   -It checks if the plank needs to be filled
   3.1.1 Initial output
    This output is showed to the current player:
     1)The common objectives description and image
     2)The library with all its boards and the numbers of the columns
     3)The personal objective for the current player
     4)The current status of the plank with the numbers of rows and columns
       and a legend where are listed all the tile types (every object tile in the
       plank is identified as a single word)
   3.1.2 Picking time
    -The player needs to decide which tile he wants to take first, in order to do so
     he needs to specify the number of the row first and then the column of the tile he           wants to pick separeted by a space (in case that doesn't happen      the game reconizes the       mistake specifing the error and the player need to pick the tile again)
    -Then the game asks if the player wants to pick another tile ('y'->yes | 'n'->no) 
     or undo his choice and starting by choosing the first tile (in this part of the game
     the player could be facing a bug: when he decided to pick another tile but there
     aren't any good choices the game will keep asking to type a proper choice, since
     there is no choice the player has to undo his previous decision and start by the first       tile)
  3.2 Common objective check
   -Every time the player has finished to fill his library the game controls if he completed
    some common objective; if he does the game will warn you and then points are going to be     added in the end (you need to be fast because if other players       has completed the         objective faster the current player will receive less points)
  3.3 Library filling
   -The player now has to choose between all the columns(0-4) and put all the tiles in there
    (same checks as the tile picking)
   -Then he needs to choose the right order for the tiles, if only one tile is left the game
    automatically puts the tile above the last one 
    (the game has been provided with many checks, so for the example the player can't choose      to put 3 tiles where there is only one space left on the         	library)
  3.3 Endgame 
   -At the end of the turn the game checks if the library is completed, if that happens the      palyer is being awarded with a bonus point and then the other      	players after the current player needs to finish their turn.

──────────────────────────────────────
4. Score calculation
 After the last turn is being finished the game must determine the score for each player
 based on how many common objective has completed, how many tiles are positioned following
 the personal objective and how many tiles of the same type are adjacent(for now the game 
 decide only one winner either if two players have the same points).
5. Another match?
 The user can then decide also to play another match.
