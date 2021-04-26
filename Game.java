import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Scanner;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable,KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static boolean isRun = true;
	public final static int WIDTH = 340;
	public final static int HEIGTH = 220;
	public final int S = 3;
	
	public BufferedImage layer = new BufferedImage(WIDTH,HEIGTH,BufferedImage.TYPE_INT_RGB);
	
	public static Player player;
	public static Enemy enemy;
	public static Ball ball;
	public static Placar placar;
	
	public Game() {
		setPreferredSize(new Dimension(WIDTH*S,HEIGTH*S));
		this.addKeyListener(this);
		player = new Player(100,HEIGTH-5);
		enemy = new Enemy(100,0);
		ball =  new Ball(100,HEIGTH/2-1);
	}
	public static void main(String args[]) {
		Game game = new Game();
		JFrame frame = new JFrame();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.add(game);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		new Thread(game).start(); 
	}
	public void tick() {
		player.tick();
		enemy.tick();
		ball.tick();
	}
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = layer.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0,0,WIDTH,HEIGTH);
		g.setColor(Color.white);
		g.fillRect(00,HEIGTH/2,WIDTH,2);
		player.render(g);
		enemy.render(g);
		ball.render(g);
		g = bs.getDrawGraphics();
		g.drawImage(layer,0,0,WIDTH*S,HEIGTH*S,null);
		g.setFont(new Font("arial",Font.BOLD,20));
		g.setColor(Color.white);
		g.drawString(" "+ball.pe,10,400);
		g.setFont(new Font("arial",Font.BOLD,20));
		g.setColor(Color.white);
		g.drawString(" "+ball.pj,10,250);
		bs.show();
	}
	public void run() {
		Scanner in = new Scanner(System.in);
		System.out.println("Bem vindo ao Jogo!");
		//enemy.mult = false;
		/*
		System.out.println("Digite M para mulijogador ou S para jorgar vs a maquina!");
		Object op = in.nextLine();
		if(op!="M") {
			enemy.mult = true;
		}
		else if(op=="S") {
			enemy.mult = false;
		}
		System.out.println(op);
		System.out.println(enemy.mult);
		*/
		while(isRun) {
			requestFocus();
			tick();
			render();
			try {
				Thread.sleep(1000/60);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			player.rigth = true;
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.lefth = true;
		}
		else if (e.getKeyCode() == KeyEvent.VK_A) {
			enemy.a = true;
		}
		else if (e.getKeyCode() == KeyEvent.VK_D) {
			enemy.d = true;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			player.rigth = false;
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.lefth = false;
		}
		else if (e.getKeyCode() == KeyEvent.VK_A) {
			enemy.a = false;
		}
		else if (e.getKeyCode() == KeyEvent.VK_D) {
			enemy.d = false;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
