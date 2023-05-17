import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Notepad implements ActionListener{

    JFrame frame = new JFrame("Notepad");
    JTextArea t1 = new JTextArea("");

    JMenuBar mb = new JMenuBar();  
    JMenu openBtn = new JMenu("Open");
    JMenu newBtn = new JMenu("New");
    JMenu saveBtn = new JMenu("Save");

    Notepad(){
        prepareGUI();
        textProperties();
        buttonProperties();
    }

    public void prepareGUI(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,700);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void textProperties(){
        t1.setBounds(0,0, 20,30);  
        t1.setSize(500, 700);
        frame.add(t1);
    }

    public void buttonProperties(){
        frame.setJMenuBar(mb);
        mb.add(openBtn);
        mb.add(newBtn);
        mb.add(saveBtn);
        saveBtn.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        
    }

    static void save(){
        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
            }else {
            System.out.println("File already exists.");
            }
        } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
        }
    }
        
}
