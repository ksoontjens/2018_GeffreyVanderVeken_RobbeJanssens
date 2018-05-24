/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.*;
import org.havi.ui.HComponent;
import org.dvb.ui.*;

/**
 *
 * @author student
 */



public class MijnComponent extends HComponent{
    
    private Image achter;
    private Image stars;
    private Image ship;
    public Image hangMan;
    public Image gameOver;
    int hangManx = 300;
    int hangMany = 150;
    int starsx = 0;
    int starsy = 0;
    int shipx = 340;
    int shipy = 500;
    int faultcounter = 0;
    MediaTracker mt;
    String A = ".";
    String U = ".";
    String T = ".";
    String O = ".";
    String gameOve = "";
    private int juist = 0;
    
    
    public MijnComponent () {
        
        achter = this.getToolkit().getImage("achter.png");
        stars = this.getToolkit().getImage("sterren.png");
        ship = this.getToolkit().getImage("spaceship.png");
        hangMan = this.getToolkit().getImage("hangMan0.PNG");
        gameOver = this.getToolkit().getImage("");
        mt = new MediaTracker(this);
        mt.addImage(achter, 0);
        mt.addImage(stars,0);
        mt.addImage(ship,0);
        mt.addImage(hangMan,0);
        mt.addImage(gameOver, 0);
        try {
            mt.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.setBounds(0,0,720,576);
    }
    
    public void paint(Graphics g) {
        g.setColor(new DVBColor(255,0,0,255));
        g.setFont(new Font("Times New Roman", Font.PLAIN, 100));
        //g.drawLine(0,0,200,200);
        //g.drawImage(stars,starsx,starsy,this);
        //g.drawImage(stars,starsx,starsy-570,this);
        //g.drawImage(ship, shipx, shipy,this);
        g.drawImage(achter, 0, 0, this);
        g.drawImage(gameOver, 200, 0, this);
        g.drawImage(hangMan, hangManx, hangMany, this);
        g.drawString(gameOve, 170, 100);
        g.drawString(A, 250, 400);
        g.drawString(U, 320, 400);
        g.drawString(T, 390, 400);
        g.drawString(O, 460, 400);
        
    }
    
    public void Move (int x, int y)
    {
        starsx += x;
        starsy += y;
        if(starsy > 570) { starsy -= 570;}
        this.repaint();
    }
    
    public void MoveShip (int x, int y)
    {
        shipx += x;
        shipy += y;
        this.repaint();
    }
    
    public void wrong ()
    {
        faultcounter++;
        if (faultcounter >= 10)
        {
            //GameOver
            //gameOver = this.getToolkit().getImage("gameOver.PNG");
            gameOve = "Game Over!";
            this.repaint();
            
            for (int i = 0 ; i<100 ; i++){
            hangMan = this.getToolkit().getImage("hangMan10.PNG");
            this.repaint();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            hangMan = this.getToolkit().getImage("hangMan11.PNG");
            this.repaint();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            }
            hangMan = this.getToolkit().getImage("gameOver.PNG");
        }
        else
        {
            hangMan = this.getToolkit().getImage("hangMan" + faultcounter + ".PNG");
        }
        
        this.repaint();
    }
    
    public void juist()
    {
        juist++;
        if (juist == 4) 
        {
            hangMan = this.getToolkit().getImage("gewonnen.PNG");
        }
    }
    
    public void showA()
    {
        this.juist();
        this.A = "A";
        this.repaint();
    }
    
    public void showU()
    {
        this.juist();
        this.U = "U";
        this.repaint();
    }
    
    public void showT()
    {
        this.juist();
        this.T = "T";
        this.repaint();
    }
    
    public void showO()
    {
        this.juist();
        this.O = "O";
        this.repaint();
    }
}
