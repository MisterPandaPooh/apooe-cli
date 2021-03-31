package com.company;

import com.lauriecs.imp.ContentTypeHttpCommand;
import com.lauriecs.imp.HttpCommand;
import com.lauriecs.imp.HttpCommandFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        System.out.println("Input Cmd svp");

        String cmd = s.nextLine();
        System.out.println("Your cmd is :" + cmd);
        if(cmd.charAt(0) == 'q'){
            System.exit(0);
        }
        boolean output = HttpCommandFactory.getCommand(cmd).exec();
        System.out.println("Everything is " +  output);
        int x =1;


    }
}
