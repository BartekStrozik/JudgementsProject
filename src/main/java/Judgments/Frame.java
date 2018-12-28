package Judgments;

import Judgments.Application.UserCommands.LineToCommand;
import Judgments.Commands.Result;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class Frame extends JFrame implements KeyListener {
    public JTextField commandLine;
    private JTextArea answerArea = new JTextArea();

    public Frame() throws IOException {
        setCommandLineParameters();
        setTextAreaParameters();

        setVisible(true);
        setSize(new Dimension(1100, 600));
        setLocation(100,40);
        //setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Judgments Project");

        add(commandLine, BorderLayout.SOUTH);
        answerArea.append(Initializing.initialMessage());
    }

    private void setCommandLineParameters() {
        commandLine = new JTextField();
        commandLine.setVisible(true);
        commandLine.setSize(1100,100);
        commandLine.setForeground(Color.WHITE);
        commandLine.setBackground(Color.BLACK);
        commandLine.setFont(new Font("Consolas",Font.PLAIN,16));
        commandLine.addKeyListener(this);
    }

    private void setTextAreaParameters() {
        JScrollPane scrollPane = new JScrollPane(answerArea);
        scrollPane.setSize(1100,500);
        scrollPane.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.WHITE));

        answerArea.setBackground(Color.BLACK);
        answerArea.setForeground(Color.WHITE);
        answerArea.setFont(new Font("Consolas",Font.PLAIN,14));
        answerArea.setLineWrap(true);
        answerArea.setEditable(false);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void printMessage(String message) {
        answerArea.append(message + '\n');
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            String line = commandLine.getText();
            LineToCommand lineToCommand = new LineToCommand();
            Result result = lineToCommand.answer(line);
            String toDisplay = result.toString();
            printMessage(toDisplay);
        }
    }
}
