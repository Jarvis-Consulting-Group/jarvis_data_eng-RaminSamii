package ca.jrvs.apps.grep;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JavaGrepImp is an implementation of the JavaGrep interface.
 */
public class JavaGrepImp implements JavaGrep {

    final static Logger logger = LoggerFactory.getLogger(JavaGrepImp.class);

    private String regex;
    private String rootPath;
    private String outFile;

    /**
     * @param args command line arguments: regex, rootPath, outFile.
     */
    public static void main(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("USAGE: Grep regex rootPath outFile");
        }

        BasicConfigurator.configure();

        JavaGrepImp javaGrepImp = new JavaGrepImp();
        javaGrepImp.setRegex(args[0]);
        javaGrepImp.setRootPath(args[1]);
        javaGrepImp.setOutFile(args[2]);

        try {
            javaGrepImp.process();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * Get the regex pattern
     */
    public String getRegex() {
        return this.regex;
    }

    /**
     * Set the regex pattern.
     */
    public void setRegex(String regex) {
        this.regex = regex;
    }

    /**
     * Get the outFile path.
     */
    public String getOutFile() {
        return this.outFile;
    }

    /**
     * Set the outFile path.
     */
    public void setOutFile(String outFile) {
        this.outFile = outFile;
    }

    /**
     * Get the root directory path.
     */
    public String getRootPath() {
        return this.rootPath;
    }

    /**
     * Set the root directory path.
     */
    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    @Override
    public void process() throws IOException {
        List<String> matchedLines = new ArrayList<>();

        // Logging the rootPath before calling listFiles()
        logger.info("Root Path: " + this.getRootPath());

        for (File file : this.listFiles(this.getRootPath())) {
            for (String string : this.readLines(file)) {
                if (this.containsPattern(string)) {
                    matchedLines.add(string);
                }
            }
        }

        // Logging the number of matched lines
        logger.info("Number of matched lines: " + matchedLines.size());

        this.writeToFile(matchedLines);
        // Logging the completion of the process
        logger.info("JavaGrepImp process completed");
    }

    @Override
    public List<File> listFiles(String rootDir) {
        List<File> files = new ArrayList<>();
        File directory = new File(rootDir);

        // Logging the directory being processed
        logger.debug("Processing directory: " + directory.getAbsolutePath());

        if (directory.isDirectory()) {
            File[] fileList = directory.listFiles();

            if (fileList != null) {
                // Sort files based on their names
                Arrays.sort(fileList);

                for (File file : fileList) {
                    if (file.isFile()) {
                        files.add(file);
                    } else {
                        // Recursive call to process subdirectories
                        files.addAll(listFiles(file.getAbsolutePath()));
                    }
                }
            }
        }

        // Logging the number of files found in the directory
        logger.debug("Number of files in directory: " + files.size());

        return files;
    }

    @Override
    public List<String> readLines(File inputFile) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String line;

        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }

        reader.close();
        return lines;
    }

    @Override
    public boolean containsPattern(String line) {
        if (line == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(this.getRegex(), Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(line);
        return matcher.find();
    }

    @Override
    public void writeToFile(List<String> lines) throws IOException {
        if (lines.isEmpty()) {
            // Exit early if the list is empty
            return;
        }

        try (FileWriter writer = new FileWriter(this.getOutFile())) {
            for (String line : lines) {
                writer.write(line + System.lineSeparator());
            }
        }
    }
}