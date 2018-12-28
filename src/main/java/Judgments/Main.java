package Judgments;

import Judgments.Application.UserCommands.Requests;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Requests requests = new Requests();
        requests.selectData();
    }
}