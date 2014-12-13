package com.stardust.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class DialogLoader 
{
    public String[] text = new String[12];
    private String fileName;
    
    DialogLoader(String fileName)
    {
        this.fileName = fileName;
    }
    
    public void fileReader() throws IOException
    {
        try (BufferedReader in = new BufferedReader(new FileReader(fileName)))
        {
            String line;
            
            while((line = in.readLine()) != null)
            {
                String[] values = line.split(",");
                
                for(int i = 0; i < values.length; i++)
                {
                    text[i] = values[i];
                }
            }}
    }
}
