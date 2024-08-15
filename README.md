# Minesweeper a la Java

Java Console Minesweeper Game

## Table of Contents

- [Description](#description)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Roadmap](#roadmap)
- [Changelog](#changelog)

## Description

A simplified version of the game Minesweeper built with pure Java. The game randomly generates 10 mines in a 10x10 grid and the user is asked to provide two number inputs to select the coordinate of a cell. A number will be displayed in a revealed cell that indicates the number of mines that surround that particular cell. If the user selects a mine, the game will be lost. If every non-mine cell has been revealed, the game is won. 
The whole game is rendered in the Java console. 

## Features

Key features of the project.

## Installation

Step-by-step guide on how to set up the project.

## Usage

Instructions and examples on how to use the project.

## Roadmap

Planned future features and improvements: 
- Implement cascading when a cell with value zero is revealed

## Changelog

- 2024-08-10: Fully working basic game, no cascading when a cell with value zero is revealed
- 2024-08-13: Double-checked on code and it was not working as intended. I think I had accidentally pushed changes from my 'cascade' branch into the main branch. Had to revert it back to a point where I knew it was still working and make some minor fixes. Woops.
- 2024-08-15: Added error handling for wrong input type.