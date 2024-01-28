import java.awt.*;
import javax.swing.*;
class Main{
    public static void main(String[] args){
        JFrame obj = new JFrame();
        Gameplay game= new Gameplay();
        obj.setBounds(10,10,900,700);
        obj.setBackground(Color.DARK_GRAY);
        obj.setResizable(true);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(game);
    }
}