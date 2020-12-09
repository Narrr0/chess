package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
//import GUI.MyFrame;

public class Message extends MyFrame {
   public static void EndMessage() {
      ImageIcon draftIcon = new ImageIcon("C:\\Users\\ss\\Desktop\\javaProject\\Checkmate.png");
      Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

      JFrame message = new JFrame("Message");
      message.setSize(700, 500);
      message.setLocationRelativeTo(null);

      JButton mainbtn = new JButton(new ImageIcon("C:\\Users\\ss\\Desktop\\javaProject\\main.png"));
      JButton exitbtn = new JButton(new ImageIcon("C:\\Users\\ss\\Desktop\\javaProject\\finish.png"));
      mainbtn.setBorderPainted(false);
      mainbtn.setContentAreaFilled(false);
      mainbtn.setFocusPainted(false);
      mainbtn.setOpaque(false);
      exitbtn.setBorderPainted(false);
      exitbtn.setContentAreaFilled(false);
      exitbtn.setFocusPainted(false);
      exitbtn.setOpaque(false);

      ActionListener goMain = new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            message.dispose();
         }
      };
      mainbtn.addActionListener(goMain);

      ActionListener exit = new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            System.exit(0);
         }
      };
      exitbtn.addActionListener(exit);

      Image tempImg = draftIcon.getImage();
      Image setsizeImg = tempImg.getScaledInstance(700, 500, java.awt.Image.SCALE_SMOOTH);
      ImageIcon icon = new ImageIcon(setsizeImg);

      JPanel messagep = new JPanel() {
         public void paintComponent(Graphics g) {
            g.drawImage(icon.getImage(), 0, 0, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };

      message.add(messagep);
      messagep.setLocation((dim.width / 2) - 350, (dim.height / 2) - 250);
      messagep.setLayout(new BorderLayout(10, 20));
      messagep.add(mainbtn, BorderLayout.EAST);
      messagep.add(exitbtn, BorderLayout.EAST);

      message.setVisible(true);
   }
}
