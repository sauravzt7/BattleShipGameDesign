### Machine Coding Assignment: BattleShip Game

### Objective

Design and implement a classic **BattleShip Game** where two players take turns firing missiles at each other’s fleet on a shared battlefield. The game continues until one player’s fleet is entirely destroyed.

---

### Functional Requirements

### Battlefield Setup

- The battlefield is a square grid of size N x N, where N is provided at runtime.
- It is divided equally:
    - Left half (N x N/2) → belongs to PlayerA
    - Right half (N x N/2) → belongs to PlayerB

---

### Ships

- Ships are **square in shape** (e.g., size 3 = 3x3 area).
- Each player is assigned **equal number of ships**.
- Each ship has:
    - Unique ID (e.g., SH1, SH2…)
    - Position (x, y) (top-left corner) and size
    - All positions occupied by the ship should be calculated accordingly.
- Ships **must not overlap** but may **touch boundaries**.
- Ships are **stationary**.

---

### Missile Fire (Turn-Based Logic)

- Players take turns firing **randomly** at opponent’s half of the grid.
- Each coordinate can be fired **only once** throughout the game.
- Turn result:
    - If hit → destroy the ship
    - If miss → continue the game
- The game ends when **all ships of a player are destroyed**.

---

### API Expectations

| Method | Description |
| --- | --- |
| `initGame(N)` | Initializes N x N battlefield and assigns halves to PlayerA and PlayerB |
| `addShip(id, size, Ax, Ay, Bx, By)` | Adds identical ships for both players at specified coordinates |
| `startGame()` | Begins the turn-based missile game, printing each move/result to console |
| `viewBattleField()` (Optional) | Visualizes current battlefield, marking ships per grid location |

---

### Sample Output

```
scss
CopyEdit
> initGame(8)
Battlefield of size 8x8 initialized.

> addShip("SH1", 2, 1, 1, 5, 1)
Ship SH1 added for PlayerA at (1,1), and for PlayerB at (5,1)

> addShip("SH2", 2, 3, 3, 6, 4)
Ship SH2 added for PlayerA at (3,3), and for PlayerB at (6,4)

> startGame()
PlayerA’s turn: Missile fired at (5,1) → HIT! PlayerB’s ship SH1 destroyed.
PlayerB’s turn: Missile fired at (1,1) → HIT! PlayerA’s ship SH1 destroyed.
PlayerA’s turn: Missile fired at (6,4) → HIT! PlayerB’s ship SH2 destroyed.
PlayerA wins the game!

```

---

### Class Design Suggestions

### Core Classes

| Class | Responsibility |
| --- | --- |
| GameEngine | Orchestrates the game flow |
| Battlefield | Represents N x N grid and manages ship placements |
| Player | Stores player ID, ships, and known coordinates |
| Ship | Holds ID, size, location, and calculated occupied coordinates |
| MissileService | Handles firing logic and results |
| Coordinate | Immutable (x, y) position representation |
| GameUtils | Utilities: random coordinate generation, hit detection |

---

### Constraints & Assumptions

- Ship placement validation:
    - Must not overlap with any existing ship
    - Must stay within bounds
- Each missile coordinate must be **unique**
- Ships are removed when hit once (i.e., 1 missile destroys the whole ship)
    - *(Extension: Track per-cell damage if required)*

---

### Bonus Features (Optional)

- `viewBattleField()`: Print an N x N grid with ships marked:
    - A-SH1, A-SH2 for PlayerA
    - B-SH1, B-SH2 for PlayerB
- Track number of hits/misses
- Add turn delay or visual indicators
- Allow manual (non-random) targeting for advanced mode

---

### Edge Cases to Handle

- Invalid ship placement (outside bounds or overlapping)
- Repeated missile coordinates
- Ship size larger than player’s grid area
- Game restart logic
- Handle odd N values correctly (use integer division for N/2)

---

### Deliverables

- Working Java implementation (no UI / API needed)
- Console-based input/output
- Readable and testable code
- Game can be run via a `main()` method or driver class

---

Let me know if you want a starter code structure based on this!