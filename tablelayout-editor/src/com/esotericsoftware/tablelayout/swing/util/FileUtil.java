package com.esotericsoftware.tablelayout.swing.util;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class FileUtil
{

    public static void writeData(String content, String fileName)
    {
	String base = "";
	String[] tmp = fileName.split("/");
	File dir = null;
	for (int i = 0; i < tmp.length - 1; i++)
	{
	    base += tmp[i] + "/";
	    dir = new File(base);
	    if (!dir.exists())
		dir.mkdir();
	}
	File outfile = new File(fileName);
	BufferedWriter output = null;
	try
	{
	    output = new BufferedWriter(new FileWriter(outfile));

	    output.write(content);
	    output.close();
	}
	catch (IOException e)
	{
	    e.printStackTrace();
	    throw new RuntimeException("write data to "+ fileName +" error",e);
	}
    }

    public static void readData(String fileName, LineProcessor lp)
    {

	BufferedReader br;
	try
	{
	    br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

	    String data = null;
	    String key = "";
	    while ((data = br.readLine()) != null)
	    {
		lp.readLine(data);
	    }
	}

	catch (Exception e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    throw new RuntimeException("read data from "+fileName +" error",e);
	}

    }
    
    public static void readData(InputStreamReader fileName, LineProcessor lp)
    {

	BufferedReader br;
	try
	{
	    br = new BufferedReader(fileName);

	    String data = null;
	    String key = "";
	    while ((data = br.readLine()) != null)
	    {
		lp.readLine(data);
	    }
	}

	catch (Exception e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    throw new RuntimeException("read data from inputstreamReader error",e);

	}

    }

    public static Properties readPropertiesFile( String fileName)
    {

	Properties p = null;
	try
	{
	    InputStream in = new BufferedInputStream(new FileInputStream(fileName));
	    p = new Properties();
	    p.load(in);

	}
	catch (IOException e)
	{
	    e.printStackTrace();
	    throw new RuntimeException("readPropertiesFile "+fileName +" error",e);
	}
	return p;
    }

    public static void main(String[] args)
    {
	//writeData("放大师傅说道", "c:/woaini/11Test.java");
	readData("c:/woaini/11Test.java",new LineProcessor()
	{
	    
	    @Override
	    public void readLine(String line)
	    {
		System.out.println(line);
		
	    }
	});
    }

    public static interface LineProcessor
    {
	void readLine(String line);
	

    }

}
