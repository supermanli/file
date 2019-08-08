package com.szkingdom;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            FileUtile fileUtile = new FileUtile();
            fileUtile.File();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
