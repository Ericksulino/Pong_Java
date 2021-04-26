public class Placar {
    public int pj=0,pe=0;
    public boolean PJ;
    public Placar(int pj, int pe){
        this.pj=pj;
        this.pe=pe;
    }

    public void Placar() {
		//Ponto do jogador
		if(PJ) {
		pj+=1;
		//Enemy.agi=+0.01;
		
		System.out.println("Ponto do Jogador!");
		new Game();
		//new Ball();
		return;
		}
		else if (!PJ){
			//Ponto do inimigo
			pe+=1;
            System.out.println("Ponto do Inimigo!");
            //new Ball();
			new Game();
			return;
        }
    }
}