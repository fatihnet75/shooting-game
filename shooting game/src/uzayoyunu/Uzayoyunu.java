
package uzayoyunu;

import java.awt.HeadlessException;
import java.io.IOException;
import javax.swing.JFrame;

public class Uzayoyunu extends JFrame {

    public Uzayoyunu(String title) throws HeadlessException {
        super(title);
    }

   
    public static void main(String[] args) throws IOException {
        Uzayoyunu ekran = new Uzayoyunu("Uzay oyunu");
        ekran.setResizable(false);
        ekran.setFocusable(false);
        ekran.setSize(800, 600);
        ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        oyun oyun = new oyun();
        oyun.requestFocus();//klavye
        oyun.addKeyListener(oyun);
        oyun.setFocusable(true);
        oyun.setFocusTraversalKeysEnabled(false);
        ekran.add(oyun);
        ekran.setVisible(true);
    }
    
}
