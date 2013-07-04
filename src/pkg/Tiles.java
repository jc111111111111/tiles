package pkg;
import java.util.Random;
public class Tiles 
{
	static int scale = Game.scale;
	static int[][] tiles;
	static int[][] check;
	public Tiles()
	{
		check = new int[(scale*scale)][2];
		for(int y = 0; y < scale; y++)
		{
			for(int x = 0; x < scale; x++)
			{
				check[(y*scale)+x][0] = x;
				check[(y*scale)+x][1] = y;
			}
		}
		check[(scale*scale)-1][0] = -1;
		check[(scale*scale)-1][1] = -1;
		tiles = check.clone();
		scramble();
	}
	void scramble()
	{
		Random rand = new Random();
		int r;
		int[] e;
		for(int z = 0; z < (scale*100); z++)
		{
			r = ((Math.abs(rand.nextInt()))%(scale*scale));
			e = tiles[0].clone();
			tiles[0] = tiles[r].clone();
			tiles[r] = e;
		}
	}
	static boolean win()
	{
		for(int x = 0; x < scale*scale; x++)
		{
			//System.out.println(check[x][0] + " = " + tiles[x][0] + " " + check[x][1] + " = " + tiles[x][1]);
			if(check[x][0] != tiles[x][0] || check[x][1] != tiles[x][1]) return false;
		}
		tiles[(scale*scale)-1][0] = scale-1;
		tiles[(scale*scale)-1][1] = scale-1;
		return true;
	}
	static void clicked(int num)
	{
		int dir = -1;
		if(tiles[num][0] != -1)
		{
			if(num > (scale-1) && tiles[num-scale][0] == -1) dir = num-scale;
			if(num%scale != (scale-1) && tiles[num+1][0] == -1) dir = num+1;
			if(num < scale*(scale-1) && tiles[num+scale][0] == -1) dir = num+scale;
			if(num%scale != 0 && tiles[num-1][0] == -1) dir = num-1;
			if(dir != -1)
			{
				tiles[dir] = tiles[num].clone();
				tiles[num][0] = -1;
				tiles[num][1] = -1;
			}
		}
	}
}
