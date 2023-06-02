import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.Scanner;
public class Notepad implements ActionListener{

    JFrame frame = new JFrame("Notepad");
    static JTextArea t1 = new JTextArea("");

    JMenuBar mb = new JMenuBar();  
    JMenuItem openBtn = new JMenuItem("Open");
    JMenuItem newBtn = new JMenuItem("New");
    JMenuItem saveBtn = new JMenuItem("Save");

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
        openBtn.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
                open();
            }
        });
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == saveBtn) {
            save();
        }
    }

    private void open(){
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(frame);
        if (option == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        
        try {
            Scanner scanner = new Scanner(file);
            StringBuilder content = new StringBuilder();
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine()).append("\n");
            }
            scanner.close();
            t1.setText(content.toString());
            System.out.println("File opened: " + file.getName());
        } catch (IOException e) {
            System.out.println("An error occurred while opening the file.");
            e.printStackTrace();
        }
    }
    }

    private void save(){
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(frame);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String filePath = file.getAbsolutePath();
            
            try (FileWriter writer = new FileWriter(filePath + ".txt")) {
                writer.write(t1.getText());
                System.out.println("File saved: " + filePath);
            } catch (IOException e) {
                e.printStackTrace();
    
            }
    }   }
}


