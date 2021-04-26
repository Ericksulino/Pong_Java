import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy {
	public static boolean mult;
	public static boolean a;
	public static boolean d;
	public double x,y;
	public double agi = 0.09;
	public int w,h;
	public Enemy(int x,int y) {
		this.x = x;
		this.y = y;
		this.w = 40;
		this.h= 5;
		
	}
	public void tick() {
		Rectangle rect1 = new Rectangle((int)x,(int)y,w,h);
		if(mult) {
			if(a) {
				x--;
			}
			else if (d) {
				x++;
			}
			if(x+w>Game.WIDTH) {
				x = Game.WIDTH - w;
			}
			
			else if(x<0) {
				x=0;
			}
			}
		else if(!mult) {
			x+= (Game.ball.x-x-6)* agi;
		}
	}
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x,(int) y, w, h);
	}
}