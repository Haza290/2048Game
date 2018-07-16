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
	
	public boolean canMakeMoveDown(){
		
		int startX = 0;
		int startY = 0;
		
		int movementX = 0;
		int movementY = -1;
		
		int leftToRight = 1;
		int downToUp = 1;
		
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
