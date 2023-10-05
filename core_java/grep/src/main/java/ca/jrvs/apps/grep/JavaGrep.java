package ca.jrvs.apps.grep;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface JavaGrep {

    /**
     *
     * @throws IOException if an I/O error occurs while writing to the file.
     */
    void process() throws IOException;

    /**
     * Traverse a given directory and return all files
     * @param rootDir input dir
     * @return files under the rootDir
     */
    List<File> listFiles(String rootDir);

    /**
     * Reads a file and returns all the lines
     *
     * @param inputFile input file to read.
     * @return lines
     * @throws IllegalArgumentException if an inputFile is not a file
     */
    List<String> readLines(File inputFile) throws IOException;

    /**
     * Checks if a line contains a regex pattern match.
     *
     * @param line input line to check for regex pattern match.
     * @return true if there's a match
     */
    boolean containsPattern(String line);

    /**
     * Writes the lines to a file.
     *
     * @param lines matched lines
     * @throws IOException if an I/O error occurs while writing to the file.
     */
    void writeToFile(List<String> lines) throws IOException;

}