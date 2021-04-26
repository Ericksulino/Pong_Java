import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {
	
	public double x,y;
	public int w,h,p=0;
	public double dx,dy;
	public int pj=0,pe=0;
	public double speed = 1.9;
	public Ball(int x,int y) {
		this.x = x;
		this.y = y;
		this.w = 4;
		this.h= 4;
		int angle = new Random().nextInt(120-45)+46; 
		dx = Math.cos(Math.toRadians(angle));
		dy = Math.sin(Math.toRadians(angle));
	}
	public void tick() {
		if(x+(dx*speed)+w>= Game.WIDTH) {
			dx*=-1;
		}
		else if(x+(dx*speed)<0) {
			dx*=-1;
		}
		if(y>=Game.HEIGTH) {
			//Ponto do inimigo
			Placar(false);
		}
		else if(y<0) {
			//Ponto do jogador
			Placar(true);
		}
	
		Rectangle bounds = new Rectangle((int)(x+(dx*speed)),(int)(y+(dy*speed)),w,h);
		Rectangle boundsPlayer = new Rectangle(Game.player.x,Game.player.y,Game.player.w,Game.player.h);

		Rectangle boundsEnemy = new Rectangle((int)Game.enemy.x,(int)Game.enemy.y,Game.enemy.w,Game.enemy.h);
		if(bounds.intersects(boundsEnemy)) {
			int angle = new Random().nextInt(120-45)+46; 
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			if(dy<0)
				dy*=-1;
		}
		else if(bounds.intersects(boundsPlayer)) {
			int angle = new Random().nextInt(120-45)+46; 
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			if(dy>0)
				dy*=-1;
		}
		x+=dx*speed;
		y+=dy*speed;
	}
	private void Placar(boolean PJ) {
		//Ponto do jogador
		if(PJ) {
			pj+=1;
			//Enemy.agi=+0.01;
			
			System.out.println("Ponto do Jogador!");
			new Game();
		return;
		}
		else if (!PJ){
			//Ponto do inimigo
			pe+=1;
			System.out.println("Ponto do Inimigo!");
			new Game();
			return;
		}
		
	}
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect((int)x,(int) y, w, h);
	}
}
