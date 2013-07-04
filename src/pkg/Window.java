package pkg;
import javax.swing.*;
import java.awt.event.*;
public class Window extends JFrame
{
	private static final long serialVersionUID = 5566322968333965313L;
	final public static JFrame frame = new JFrame("Game");
	public static void createWindow()
	{
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		frame.add(new Game());
		frame.pack();
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	public static void main(String[] args)
	{
		createWindow();
	}
}
