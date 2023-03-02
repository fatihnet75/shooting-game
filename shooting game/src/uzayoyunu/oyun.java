
package uzayoyunu;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JOptionPane;

import javax.swing.JPanel;
import javax.swing.Timer;
class  Ates{
    private int x;
    private int y;

    public Ates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
public class oyun extends JPanel implements  KeyListener,ActionListener{
    private int gecensure=0;
    private int harcananats=0;
    private BufferedImage image;
    
    
    private ArrayList<Ates> atesler = new ArrayList<>();
    private int atesdiry =1;
    private int topx=0;
    private int topdirx=2;
    private int uzatgemisix=0;
    private int diruzayx=20;
    Timer timer = new Timer(-10000000, this);
    public boolean controlet (){
    for(Ates ates:atesler){
        if(new Rectangle(ates.getX(),ates.getY(),10,20).intersects((new Rectangle(topx,0,20,20)))){
            return true;
        }
        
    }
    return false;
}
    public oyun() throws IOException {
        image = ImageIO.read(new FileImageInputStream(new File("f.jpg")));
        setBackground(Color.white);
   timer.start();
    }

    @Override
    public void repaint() {
        super.repaint(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        gecensure+=5;
        g.setColor(Color.black);
        g.fillOval(topx, 0, 20, 20);
        g.drawImage(image,uzatgemisix,490,image.getWidth()/12,image.getHeight()/12,this);
         for(Ates ates :atesler){
             if(ates.getY()<0)
             {
                 atesler.remove(ates);
             }
         }
         g.setColor(Color.blue);
         for(Ates ates: atesler){
             g.fillRect(ates.getX(), ates.getY(), 5, 10);
         }
         if(controlet()){
             timer.stop();
             String mesage="kazandınız...\n"
                     +"harcanan ates = "+harcananats
                     +"\nharcanan zaman"+gecensure/1000.0;
             JOptionPane.showMessageDialog(this, mesage);
             System.exit(0);
         }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
      
    }

    @Override
    public void keyPressed(KeyEvent e) {
          int c= e.getKeyCode();
        if(c==KeyEvent.VK_LEFT){
            if (uzatgemisix<=0){
                uzatgemisix=0;
            }
            else{
                uzatgemisix-=diruzayx;
            }
        }
        else if(c ==KeyEvent.VK_RIGHT){
                if(uzatgemisix>=750){
                    uzatgemisix=750;
                }
                else {
                    uzatgemisix+=diruzayx;
                }
                }
        else if(c==KeyEvent.VK_SPACE ){
            atesler.add(new Ates(uzatgemisix+15, 480));
            harcananats++;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
   for(Ates ates:atesler){
       ates.setY(ates.getY()-atesdiry-10);
       
   }
        topx+=topdirx;
    if(topx>=750){
        topdirx = -topdirx;
    }
    if(topx<=0){
        topdirx=-topdirx;
        
    }
    repaint();
    }
    
}
