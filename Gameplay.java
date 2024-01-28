import java.awt.*;
import java.awt.RenderingHints.Key;

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
    private int[] snakexlength = new int[750];
    private int[] snakeYlength = new int[750];

    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;
    private boolean end = false;

    private int moves = 0; 

    private Timer timer;
    private int score = 0;
    private int lengthofSnake=3;
    private int delay = 100;
    private int [] enemyxpos={25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475
    ,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
    private int [] enemyypos={75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475
    ,500,525,550,575,600,625};
    
    private Random random= new Random();
    private int xpos= random.nextInt(34);
    private int ypos= random.nextInt(23);

    public Gameplay(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay,this);
        timer.start();
    }
    public void paint(Graphics g){
        if(moves==0){
            snakexlength[2]=50;
            snakexlength[1]=75;
            snakexlength[0]=100;

            snakeYlength[2]=100;
            snakeYlength[1]=100;
            snakeYlength[0]=100;
        }
        g.setColor(Color.WHITE);
        g.drawRect(23,10,851,55);
        g.setColor(Color.black);
        g.fillRect(24,11,850,53);
        g.setColor(Color.WHITE);
        g.setFont(new Font("arial",Font.PLAIN,50));
        g.drawString("SNAKE GAME",35,55);
        g.setColor(Color.WHITE);
        g.drawRect(24,74,851,577);     
        g.setColor(Color.black);
        g.fillRect(25,75,850,575);
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("arial",Font.PLAIN,25));
        g.drawString("SCORE: "+score,700,45);
        
        g.setColor(Color.YELLOW);
        g.fillOval(snakexlength[0],snakeYlength[0],25,25);

        for(int a=0;a<lengthofSnake;a++){
            if(a==0 && right){
                g.setColor(Color.YELLOW);
                g.fillOval(snakexlength[a],snakeYlength[a],25,25);
            }

            if(a==0 && left){
                g.setColor(Color.YELLOW);
                g.fillOval(snakexlength[a],snakeYlength[a],25,25);
            }

            if(a==0 && down)
            {
                g.setColor(Color.YELLOW);
                g.fillOval(snakexlength[a],snakeYlength[a],25,25);
            }

            if(a==0 && up){
                g.setColor(Color.YELLOW);
                g.fillOval(snakexlength[a],snakeYlength[a],25,25);
            }

            if(a!=0){
                g.setColor(Color.blue);
                g.fillOval(snakexlength[a],snakeYlength[a],25,25);
            }
        }
        if(enemyxpos[xpos]==snakexlength[0] && enemyypos[ypos]==snakeYlength[0]){
        	lengthofSnake++;
        	score++;
        	xpos=0;
        	ypos=0;
        	while(xpos==0 && ypos==0) {
        		xpos = random.nextInt(34);
            	ypos = random.nextInt(23);
            	for(int i=1;i<lengthofSnake;i++) {
            		if(snakexlength[i]==enemyxpos[xpos] && snakeYlength[i]==enemyypos[ypos]) {
            			xpos=0;
            			ypos=0;
            			break;
            		}
            	}
        	}
        }
        g.setColor(Color.RED);
		g.fillOval(enemyxpos[xpos], enemyypos[ypos],25,25);

        for(int i=1;i<lengthofSnake;i++){
            if(snakexlength[i]==snakexlength[0] && snakeYlength[i]==snakeYlength[0]){
                right=false;
                left=false;
                up=false;
                down=false;
                end = true;
                g.setColor(Color.WHITE);
                g.setFont(new Font("arial",Font.BOLD,50));
                g.drawString("Game Over",300,300);
                g.setFont(new Font("arial",Font.BOLD,50));
                g.drawString("Press space to Restart",150,340);
            }
        }
        g.dispose();
    }
    public void actionPerformed(ActionEvent arg0) {
        timer.start();
        if(right && !end){
            for(int r=lengthofSnake-1;r>=0;r--){
                snakeYlength[r+1]=snakeYlength[r];
            }
            for(int r=lengthofSnake;r>=0;r--){
                if(r==0) snakexlength[r]=snakexlength[r]+25;
                else snakexlength[r]=snakexlength[r-1];
                if(snakexlength[r]>850) snakexlength[r]=25;
            }
            repaint();
        }
        if(left && !end){
            for(int r=lengthofSnake-1;r>=0;r--){
                snakeYlength[r+1]=snakeYlength[r];
            }
            for(int r=lengthofSnake;r>=0;r--){
                if(r==0) snakexlength[r]=snakexlength[r]-25;
                else snakexlength[r]=snakexlength[r-1];
                if(snakexlength[r]<25) snakexlength[r]=850;
            }
            repaint();
        }
        if(down && !end){
            for(int r=lengthofSnake-1;r>=0;r--){
                snakexlength[r+1]=snakexlength[r];
            }
            for(int r=lengthofSnake;r>=0;r--){
                if(r==0) snakeYlength[r]=snakeYlength[r]+25;
                else snakeYlength[r]=snakeYlength[r-1];
                if(snakeYlength[r]>625) snakeYlength[r]=75;
            }
            repaint();
        }
        if(up && !end){
            for(int r=lengthofSnake-1;r>=0;r--){
                snakexlength[r+1]=snakexlength[r];
            }
            for(int r=lengthofSnake;r>=0;r--){
                if(r==0) snakeYlength[r]=snakeYlength[r]-25;
                else snakeYlength[r]=snakeYlength[r-1];
                if(snakeYlength[r]<75) snakeYlength[r]=625;
            }
            repaint();
        }
    }
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            moves=0;
            score=0;
            lengthofSnake = 3;
            left=false;
            right=false;
            up=false;
            down=false;
            end=false;
            repaint();
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            moves++;
            right=true;
            if(left==true) {
                right=false;
                left=true;
            }
            else left=false;
            down=false;
            up=false;
        } 
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            moves++;
            left=true;
            if(right==true) {
                left=false;
                right=true;
            }
            else right=false;
            down=false;
            up=false;
        } 
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            moves++;
            down=true;
            if(up==true) {
                down=false;
                up=true;
            }
            else up=false;
            left=false;
            right=false;
        } 
        if(e.getKeyCode() == KeyEvent.VK_UP){
            moves++;
            up=true;
            if(down==true) {
                up=false;
                down=true;
            }
            else down=false;
            left=false;
            right=false;
        } 
    }
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }
}

