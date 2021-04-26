import java.awt.Color;
import java.awt.Graphics;

public class Player {
	public boolean rigth,lefth;
	public int x,y;
	public int w,h;
	public Player(int x, int y) {
		this.x=x;
		this.y=y;
		this.w = 40;
		this.h= 5;
	}
	public void tick() {
		if(rigth) {
			x++;
		}
		else if (lefth) {
			x--;
		}
		if(x+w>Game.WIDTH) {
			x = Game.WIDTH - w;
		}
		
		else if(x<0) {
			x=0;
		}
	}
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x,y,w,h);
	}
}
