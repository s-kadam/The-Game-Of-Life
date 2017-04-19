import java.util.Random;

public class Life {

	public static void main(String[] args) {
		
		Random r = new Random();
		int gridSize = 200;
		int cellSize = 3;
		Grid grid = new Grid(gridSize, cellSize, "The Game of Life");
		grid.setDelay(0);
		int aliveColor = 7;
		int deadColor = 9;
		
		for(int x = 0; x < gridSize-1; x++)
		{	
			for (int y = 0; y < gridSize-1; y++)
			{
				if( r.nextInt(100) > 49 ){
					grid.setPos(x, y, aliveColor);
					grid.update();
				}else{
					grid.setPos(x, y, deadColor);
					grid.update();
				}
			}
		}
		
		grid.initialize();
		grid.setDelay(10);
		while (true){

			for(int x = 0; x < gridSize-1; x++)
			{
				for(int y = 0; y < gridSize-1; y++)
				{
					if( grid.getPos(x, y) == aliveColor) {
						if(grid.matchingNeighbors(x, y, aliveColor) == 2 || grid.matchingNeighbors(x, y, aliveColor) == 3){
							grid.setPos(x, y, aliveColor);
						}
						else {
							grid.setPos(x, y, deadColor);
						}
					} else {
						if (grid.matchingNeighbors(x, y, aliveColor) == 3) {
							grid.setPos(x, y, aliveColor);
						} else {
							grid.setPos(x, y, deadColor);
						}
					}
				}
			}
			grid.update();
		}
	}	
}




