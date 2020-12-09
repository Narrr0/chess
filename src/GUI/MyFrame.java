package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame {
  public MyFrame() {
    JFrame frame = new JFrame("Chess");
    Color backc = new Color(100, 90, 126);
    frame.getContentPane().setBackground(backc); //배경색 
    frame.setSize(700, 600);
    
    JButton vs1 = new JButton(new ImageIcon("C:\\Users\\ss\\Desktop\\javaProject\\Button1.png"));
    JButton vs2 = new JButton(new ImageIcon("C:\\Users\\ss\\Desktop\\javaProject\\Button2.png"));
    JButton exit = new JButton(new ImageIcon("C:\\Users\\ss\\Desktop\\javaProject\\Exit.png"));
    JButton logo = new JButton(new ImageIcon("C:\\Users\\ss\\Desktop\\javaProject\\Logo.png"));
    
    vs1.setBorderPainted(false); vs2.setBorderPainted(false);
    exit.setBorderPainted(false); logo.setBorderPainted(false);
    vs1.setContentAreaFilled(false); vs2.setContentAreaFilled(false);
    exit.setContentAreaFilled(false); logo.setContentAreaFilled(false);
    vs1.setFocusPainted(false); vs2.setFocusPainted(false);
    exit.setFocusPainted(false); logo.setFocusPainted(false);
    vs1.setOpaque(false); vs2.setOpaque(false); exit.setOpaque(false); logo.setOpaque(false); 
    //버튼 배경 삭제
    
    ActionListener boardFirst = new ActionListener() {
       public void actionPerformed(ActionEvent e) {
    	   Board board=new Board();
   			board.Board1();
       }
    };
    vs1.addActionListener(boardFirst);
    
    ActionListener boardSecond = new ActionListener() {
       public void actionPerformed(ActionEvent e) {
    	   Board board=new Board();
   		   board.Board2();
       }
    };
    vs2.addActionListener(boardSecond);
    
    ActionListener exitlisten = new ActionListener() {
       public void actionPerformed(ActionEvent e) {
          System.exit(0);
       }
    };
    exit.addActionListener(exitlisten);
    
    frame.setLayout(new BorderLayout(10, 20));
    frame.add(logo, BorderLayout.NORTH);
    
    JPanel cp = new JPanel();
    cp.setLayout(new GridLayout(3, 1));
    cp.add(vs1);
    cp.add(vs2);
    cp.add(exit);
    frame.add(cp, BorderLayout.CENTER); //Layout
 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
  
  