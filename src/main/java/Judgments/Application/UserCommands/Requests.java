package Judgments.Application.UserCommands;

import Judgments.Frame;

import java.io.IOException;

public class Requests {
    private LineToCommand lineToCommand = new LineToCommand();
    private Frame frame;

    public void selectData() throws IOException {
        this.frame = new Frame();
    }
}
