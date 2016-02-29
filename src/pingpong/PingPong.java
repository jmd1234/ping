package jaa;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Ping extends JComponent implements KeyListener
{
    JFrame school;
    int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    int ballX = 100;
    int ballY = 100;
    int ballDiamiter = 80;
    int ballSpeedX = 5;
    int ballSpeedY = 5;
    int paddleYPos = 200;
    int paddleXPos = 2;
    Ellipse2D.Double jack;
    Rectangle2D.Double bob;
    public static void main(String[] args)
    {
        new Ping().getGoing();
    }
    public void getGoing()
    {
        school = new JFrame("Let's Play Ping Pong");
        school.setVisible(true);
        school.setSize(width, height);
        school.add(this);
        school.addKeyListener(this);
        school.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while (true)
        {
            repaint();
            if (ballX > width - ballDiamiter)
            {
                if (ballSpeedX > 0)
                {
                    ballSpeedX *= -1;
                }
            }

            if (ballY > height - ballDiamiter - 100)
            {
                if (ballSpeedY > 0)
                {
                    ballSpeedY *= -1;
                }
            }
            if (ballY < 0)
            {
                if (ballSpeedY < 0)
                {
                    ballSpeedY *= -1;
                }
            }
        }
    }

    @Override
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        jack = new Ellipse2D.Double(ballX, ballY, ballDiamiter, ballDiamiter);
        bob = new Rectangle2D.Double(paddleXPos, paddleYPos, 20, 300);
        g2.setStroke(new BasicStroke(5f));
        g2.setColor(Color.RED);
        g2.setColor(Color.magenta);
        g2.setColor(Color.cyan);
        g2.fill(jack);
        g2.setColor(Color.RED);
        g2.fill(bob);
        ballX = ballX + ballSpeedX;
        ballY = ballY + ballSpeedY;
        if (jack.intersects(bob))
        {
            if (ballSpeedX < 0)
            {
                ballSpeedX *= -1;
            }
        }
    }
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch( keyCode ) { 
        case KeyEvent.VK_UP:
        	paddleYPos-=20;
            break;
        case KeyEvent.VK_DOWN:
        	paddleYPos+=20;
            break;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e1) {
		
     }
	
		

	@Override
	public void keyTyped(KeyEvent e3) {
	
		
	}
    
}
