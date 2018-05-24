package hellotvxlet;

import java.awt.Font;
import java.util.Timer;
import javax.tv.xlet.*;
import org.dvb.event.*;
import org.dvb.ui.DVBColor;
import org.havi.ui.*;
import org.havi.ui.event.HRcEvent;

public class HelloTVXlet implements Xlet, UserEventListener {
  MijnComponent mc;
  Timer t;
  String word = "auto";
  private HSinglelineEntry veld;
    public HelloTVXlet() {
        
    }
    
    public void initXlet(XletContext context) {
        HScene scene = HSceneFactory.getInstance().getDefaultHScene();
        mc = new MijnComponent();
        System.out.println("hallo");
        scene.add(mc);
        scene.validate();
        scene.setVisible(true);
        
        /*veld = new HSinglelineEntry("", 100, 100, 100, 50, 1, null, new DVBColor(255,0,0,255));
        //veld.setBackground(new DVBColor(255,0,0,255));
        veld.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(veld);
        veld.setFocusTraversal(veld, veld, veld, veld);*/
        
        
        UserEventRepository uev = new UserEventRepository("mijn verzameling");
        uev.addAllArrowKeys();
        uev.addKey(27);
        
        for (int i=65;i<91;i++)
        {
            uev.addKey(i);
        }
        EventManager.getInstance().addUserEventListener(this, uev);
        
        //t = new Timer();
        
        
        //MijnTimerTask mtt = new MijnTimerTask();
        //mtt.setCallback(this);
        //t.scheduleAtFixedRate(mtt,0,100);
    }

    public void startXlet() {
    }

    public void pauseXlet() {
       
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    public void userEventReceived(UserEvent e) {
        if(e.getType() == HRcEvent.KEY_PRESSED){
            switch(e.getCode())
            {
               /* case HRcEvent.VK_LEFT:
                    System.out.println("LEFT");
                    mc.showA();
                    break;
                case HRcEvent.VK_RIGHT:
                    System.out.println("RIGHT");
                    mc.showO();
                    break;
                case HRcEvent.VK_UP:
                    System.out.println("UP");
                    mc.showU();
                    break;
                case HRcEvent.VK_DOWN:
                    System.out.println("DOWN");
                    mc.showT();
                    break;*/
                case HRcEvent.VK_ESCAPE:
                    System.out.println("escape");
                    mc.wrong();
                    break;
                case HRcEvent.VK_A:
                    System.out.println("A");
                    mc.showA();
                    break;
                case HRcEvent.VK_U:
                    System.out.println("U");
                    mc.showU();
                    break;
                case HRcEvent.VK_T:
                    System.out.println("T");
                    mc.showT();
                    break;
                case HRcEvent.VK_O:
                    System.out.println("O");
                    mc.showO();
                    break;
                default:
                    mc.wrong();
                    break;
            }
        }
    }
    
    public void callback(){
     //ystem.out.println("callback"); 
     mc.Move(0, 10);
    }
    
    public void validate (char letter) throws InterruptedException{
        int index = word.indexOf(letter);
        if (index<0)
        {
            mc.wrong();
        }
        else
        {
            switch(letter)
            {
                case 'a':
                    mc.showA();
                    break;
                case 'u':
                    mc.showU();
                    break;
                case 't':
                    mc.showT();
                    break;
                case 'o':
                    mc.showO();
                    break;
            }
        }
    }
}
