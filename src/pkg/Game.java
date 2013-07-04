package pkg;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Game extends JPanel implements MouseListener
{
	private static final long serialVersionUID = 8038710370744306097L;
	int height = this.getHeight();
	int width = this.getWidth();
	int imgheight;
	int imgwidth;
	public Image img;
	public static int scale = 3;
	static boolean firstrun = true;
	public Game()
	{
		 new Tiles();
		 ImageIcon i = new ImageIcon(getClass().getResource("/imgs/image.jpg"));
		 img = i.getImage();
		 addMouseListener(this);
		 repaint();
	}
	public void paint(Graphics g)
	{
		height = this.getHeight();
		width = this.getWidth();
		imgheight = img.getHeight(null);
		imgwidth = img.getWidth(null);
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		if(Tiles.win()&&firstrun)
		{
			firstrun = false;
			JOptionPane.showMessageDialog(this, "You win");
		}
		int[][] z = Tiles.tiles;
		for(int x = 0; x < Math.pow(scale, 2); x++)
		{
			if(z[x][0] != -1 && z[x][1] != -1) g2d.drawImage(img, (x%scale)*(width/scale), (x/scale)*(height/scale), ((x%scale)+1)*(width/scale), ((x/scale)+1)*(height/scale), z[x][0]*(imgwidth/scale), z[x][1]*(imgheight/scale), (z[x][0]+1)*(imgwidth/scale), (z[x][1]+1)*(imgheight/scale), null);
		}
		for(int x = 1; x < scale; x++)
		{
			g2d.drawLine(0, x*(height/scale), width, x*(height/scale));
		}
		for(int x = 1; x < scale; x++)
		{
			g2d.drawLine(x*(width/scale), 0, x*(width/scale), height);
		}
	}
	public void mousePressed(MouseEvent e)
	{
		height = this.getHeight();
		width = this.getWidth();
		int x = (int)e.getX()/(width/scale);
		int y = (int)e.getY()/(height/scale);
		Tiles.clicked((y*scale)+x);
		repaint();
	}
	public void mouseClicked(MouseEvent e)
	{
		
	}
	public void mouseEntered(MouseEvent e)
	{
		
	}
	public void mouseExited(MouseEvent e)
	{
		
	}
	public void mouseReleased(MouseEvent e)
	{
		
	}
}
