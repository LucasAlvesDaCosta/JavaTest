package com.lucasdev.sigabem.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
	public String readFile() throws IOException {
		
        String response = "";
        FileReader arq = new FileReader("src/main/resources/index.html");
        BufferedReader lerArq = new BufferedReader(arq);
        String linha = lerArq.readLine();

        while (linha != null) {
            linha = lerArq.readLine();
            response += linha;
        }
        arq.close();
        return response.trim().replaceFirst("null", "");
    }

}
