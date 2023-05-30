# Chess/3D Chess - BCIT 2510 Term Two

## Table of Contents
- [Project Description](#project-description)
- [Technologies Used](#technologies-used)
- [How to install or run the project](#how-to-run-project)
- [Contact Information](#contact-information)

## Project Description
This chess project was developed as part of BCIT's Object-Oriented course (2510), aiming to enhance our understanding of object-oriented languages and design patterns. The project primarily focuses on key concepts such as inheritance, polymorphism, and abstraction. However, it's important to note that the games included in this repository, Chess and 3D Chess, are not fully functional games. They lack features such as scoring, win conditions, and a appealing graphical user interface.

In the regular chess game, we have implemented several base classes that serve as the foundation for other components. The Game class manages the game board and player turns. The game board is represented as a matrix of tiles, each alternating between white and red. Each tile can either be empty or contain a single piece. The Piece class acts as the base class for all chess pieces, providing common functionality such as setting the team and type of the piece. Additionally, pieces can move from one tile to another and project their legal moves on the board.

Building upon these base objects, we have created custom objects specific to the game of chess, including the Chess game itself, the Chess board, and various chess pieces with their unique movement patterns.

To extend the functionality to 3D Chess, we simply extended the Chess game, board, and pieces to incorporate the features specific to 3D Chess.

While this project does not provide a complete gaming experience, it serves as an educational exercise to reinforce our understanding of object-oriented programming concepts and their application in game development.

## Technologies Used
- Java

## <a id="how-to-run-project">How to install or run the project</a>

### Prerequisites:

- Have a Git and GitHub account
- Have at least Java install (I am using Java 18)

### Cloning the repository:

- Open Command Prompt
- `cd` into the folder you want the repository stored in
- Type: `git clone [https://github.com/Rshokar/2510-Chess]`

### Running the project:

#### Running Chess
1. Open Command Prompt
2. `cd` into the folder where the code is stored
3. Type: `cd Chess`
4. Type: `javac Chess.java`
5. Type: `java Chess`

#### Running Chess 3D
1. Open Command Prompt
2. `cd` into the folder where the code is stored
3. Type: `cd Chess`
4. Type: `javac Chess3D.java`
5. Type: `java Chess3D`
<br>

## <a id="how-to-use-product">How to use the product (Features)</a>

### Features

#### Basic Analytics
- Selet a peice
- The board should be highlited to show available moves
<br>

## Contact Information <a id="contact-information">Contact Information</a>

### Ravinder Shokara
- ravindershokar@gmail.com
- https://www.linkedin.com/in/rshokar/
