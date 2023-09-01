package ca.jrvs.apps.grep;

import java.io.*;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JavaGrepImp is an implementation of the JavaGrep interface.
 */
public class StreamJavaGrepImp implements StreamJavaGrep {

    final static Logger logger = LoggerFactory.getLogger(StreamJavaGrepImp.class);

    private String regex;
    private String rootPath;
    private String outFile;

    /**
     * @param args command line arguments: regex, rootPath, outFile.
     */
    public static void main(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("USAGE: StreamGrep regex rootPath outFile");
        }

        BasicConfigurator.configure();

        StreamJavaGrepImp streamJavaGrepImp = new StreamJavaGrepImp();
        streamJavaGrepImp.setRegex(args[0]);
        streamJavaGrepImp.setRootPath(args[1]);
        streamJavaGrepImp.setOutFile(args[2]);

        try {
            streamJavaGrepImp.process();
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

        // Logging the rootPath before calling listFiles()
        logger.info("Root Path: " + this.getRootPath());

        try (PrintWriter writer = new PrintWriter(new FileWriter(this.getOutFile()))) {
            listFiles(this.getRootPath())
                    .flatMap(this::readLines)
                    .filter(this::containsPattern)
                    .forEach(line -> {
                        writer.println(line);
                        writer.flush();
                    });
        }

        // Logging the completion of the process
        logger.info("StreamJavaGrepImp process completed");
    }

    @Override
    public Stream<File> listFiles(String rootDir) {
        File directory = new File(rootDir);

        // Logging the directory being processed
        logger.debug("Processing directory: " + directory.getAbsolutePath());

        if (directory.isDirectory()) {
            return Stream.of(Objects.requireNonNull(directory.listFiles()))
                    .sorted()
                    .flatMap(file -> file.isFile() ? Stream.of(file) : listFiles(file.getAbsolutePath()));
        }

        return Stream.empty();
    }

    @Override
    public Stream<String> readLines(File inputFile) {
        if (inputFile == null) {
            logger.error("Input file cannot be null");
            return Stream.empty();
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            return reader.lines().onClose(() -> {
                try {
                    reader.close();
                } catch (IOException e) {
                    logger.error("Error closing file reader", e);
                }
            });
        } catch (IOException e) {
            logger.error("Error reading lines from file: " + inputFile.getAbsolutePath(), e);
            return Stream.empty();
        }
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
    public void writeToFile(Stream<String> lines) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(this.getOutFile()))) {
            lines.forEach(writer::println);
        }
    }
}
