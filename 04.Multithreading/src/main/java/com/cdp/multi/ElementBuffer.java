package com.cdp.multi;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by dima on 27.10.14.
 */
public class ElementBuffer {
    private File file = new File("test.txt");
    private static final int MAX_FILE_SIZE = 1000;
    private static final int MIN_FILE_SIZE = 10;

    public synchronized void put(String newElem) throws InterruptedException {
        while (file.length() > MAX_FILE_SIZE) {
            this.wait();
        }
        writeToFile(newElem);
        this.notifyAll();
    }

    public synchronized List<String> get() throws InterruptedException {
        while (file.length() < MIN_FILE_SIZE) {
            this.wait();
        }
        List<String> result = null;
        try {
            result = readFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (file.length() >= MAX_FILE_SIZE)
            file.delete();
        this.notifyAll();
        return result;
    }

    private List<String> readFromFile() throws FileNotFoundException {
        List<String> results = new ArrayList<String>();
        BufferedReader fileReader = null;
        try {
            String line;
            fileReader = new BufferedReader(new FileReader(file));
            while ((line = fileReader.readLine()) != null) {
                results.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return results;
    }

    private void writeToFile(String newElem) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            bufferedWriter.append(newElem).append(": file size = " + file.length()).append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
