package org.academiadecodigo.bootcamp.defectpainter.utility_classes;


import java.io.*;

/**
 * Created by milena, filipe, joana, ita on 25/02/16.
 */
public class Streamer {

    /**
     * Saves in a txt path
     *
     * @param chars chars array that we want to save
     * @param path  path name of where to save
     * @throws IOException if buffered writer throws an exception while closing
     */
    public static void save(char[] chars, String path, String fileName) throws IOException {

        BufferedWriter bWriter = null;

        File dir = new File(path);
        if(!dir.exists()) {
            dir.mkdirs();
        }


        try {
            bWriter = new BufferedWriter(new FileWriter(path+fileName));
            bWriter.write(chars);
        } catch (IOException e) {
            e.getMessage();
        } finally {
            bWriter.close();
        }
    }

    /**
     * Loads chars from a file
     *
     * @param file file name of where we want to read
     * @return char array with all the chars in the file
     * @throws IOException if buffered reader throws an exception while closing
     */
    public static char[] load(String file) throws IOException {

        BufferedReader bReader = null;

        try {
            bReader = new BufferedReader(new FileReader(file));
        } catch (IOException e) {
            e.getMessage();
        }

        String line = "";
        String result = "";

        // reads each line at a time and adds it to a result string
        while ((line = bReader.readLine()) != null) {
            result += line + '\n';
        }

        // close the stream
        bReader.close();

        return result.toCharArray();
    }


}
