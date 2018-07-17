public class Board
{
	private Tile[][] board;
	private int size;
	
	public Board(int size) {
		this.size = size;
		resetBoard();
	}
	
	private void resetBoard(){
		board = new Tile[size][size];
	}
	
	public boolean canMakeMove(){
		return(canMakeMove(0,0,0,-1,1,1) || 		// check move down
				canMakeMove(0,size-1,0,1,1,-1) || 	// check move up
				canMakeMove(size-1,0,1,0,-1,1) ||	// check move right
				canMakeMove(0,0,-1,0,1,1));			// check move left
	}
	
	private boolean canMakeMove(final int startX,
								final int startY,
								final int movementX,
								final int movementY,
								final int leftToRight,
								final int downToUp){
		
		for(int x = startX; 0 <= x && x < size; x += leftToRight){
			for(int y = startY; 0 <= y && y < size; y += downToUp){
				Tile currentTile = board[x][y];
				if(null == currentTile || !isInBoard(x + movementX, y + movementY)){
					continue;
				}
				Tile newTile = board[x + movementX][y + movementY];
				if(null == newTile || currentTile.value == newTile.value){
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isInBoard(int x, int y){
		return (x >= 0 && x < size && y >= 0 && y < size);
	}
}
