# IQPuzzlerPro
This is an efficient solver of the IQ Puzzler Pro game that is extensible for any 2D pieces and boards.


## To Run
run ```Game.java```

Game.java is currently initialized for a particular challenge with the 5x11 rectangular board and 12 pieces of the SmartGames IQ Puzzler Pro game. ```Test.java``` contains a few other initialization functions for different boards, pieces, and problems.

![IQ Puzzler Pro Board and Pieces](https://www.hamleys.com/images/_lib/image-150827-0.jpg)

## To Tailor to a Particular Problem
The recursive algorithm of this solver can support any 2D pieces and board layout. To apply its problem-solving utility for a particular problem, change the initialization functions in ```Game.java```'s main method.
