package org.fogbeam.example.opennlp;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @file Main.java
 * @brief Main class for tokenizing text files using OpenNLP.
 *
 * This program provides functionality for tokenizing text files using the
 * OpenNLP Tokenizer module. It supports interactive input and command-line arguments
 * to tokenize single or multiple files.
 */
public class TokenizerMain {

    /**
     * Main entry point for the application.
     *
     * @param args Command-line arguments. If no arguments are provided, the program
     *             starts in interactive mode.
     * @throws IOException If an error occurs while reading files or tokenizing text.
     */
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            interactiveMenu();
        } else {
            for (String arg : args) {
                File file = new File(arg);
                List<String> tokens = tokenize(file);
                tokens.forEach(System.out::println);
            }
        }
    }

    /**
     * Interactive menu for tokenizing files.
     *
     * This method allows the user to tokenize files interactively,
     * add tokens from multiple files, and optionally save the tokens to an output file.
     *
     * @throws IOException If an error occurs while reading files or writing output.
     */
    public static void interactiveMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<String> tokens = new ArrayList<>();

        while (true) {
            System.out.println("Introduce path to file: ");
            String path = scanner.nextLine();
            File file = new File(path);
            tokens.addAll(tokenize(file));
            System.out.println("¿Another file? (y/n)");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (answer.equals("n")) {
                break;
            }
        }

        System.out.println("Save tokens to file? (y/n)");
        String answer = scanner.nextLine().trim().toLowerCase();
        if (answer.equals("y")) {
            System.out.println("Introduce path to save tokens: ");
            String path = scanner.nextLine();
            Files.write(Paths.get(path), tokens);
        } else {
            tokens.forEach(System.out::println);
        }
    }

    /**
     * Tokenizes a file or all files within a directory.
     *
     * If the input is a directory, all files within the directory are processed.
     *
     * @param file The file or directory to tokenize.
     * @return A list of tokens extracted from the file(s).
     * @throws IOException If an error occurs while reading files or tokenizing text.
     */
    public static List<String> tokenize(File file) throws IOException {
        List<String> tokens = new ArrayList<>();

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (!f.isDirectory()) tokens.addAll(tokenize(f));
                }
            }
        } else {
            tokens.addAll(tokenizeFile(file));
        }
        return tokens;
    }

    /**
     * Tokenizes the content of a single file.
     *
     * Reads the content of the file, tokenizes it using OpenNLP, and returns a list of tokens.
     *
     * @param inputFile The file to tokenize.
     * @return A list of tokens extracted from the file.
     * @throws IOException If an error occurs while reading the file or tokenizing its content.
     */
    public static List<String> tokenizeFile(File inputFile) throws IOException {
        InputStream modelIn = Files.newInputStream(Paths.get("models/en-token.model"));

        TokenizerModel model = new TokenizerModel(modelIn);
        Tokenizer tokenizer = new TokenizerME(model);

        String content = new String(Files.readAllBytes(inputFile.toPath()));
        String[] tokens = tokenizer.tokenize(content);

        try {
            modelIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Arrays.asList(tokens);
    }

}
