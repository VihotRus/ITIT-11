package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class Main {

    private static Gson gson = new GsonBuilder().create();
    private static String FILE = "G:\\навчання\\5 курс\\Інженерія даних та знань\\lab1\\lab1\\testData.json";

    public static void main(String[] args) throws Exception {
        addMatrix();
        writeToFile(FILE, gson.toJson(generateMatrix()));
        String json = readFile(new File(FILE));
        int[][] matrix = gson.fromJson(json, int[][].class);
        printArray(matrix);
        accessMatrix(matrix);
    }

    private static void addMatrix() {
        long t1 = System.currentTimeMillis();
        int [][] m1 = {{1, 1}, {2, 2}};
        int [][] m2 = {{3, 3}, {4, 4}};
        int [][] m3 = new int[2][2];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                m3[i][j] = m1[i][j] + m2[i][j];
            }
        }
        System.out.println("Matrix1:");
        printArray(m1);
        System.out.println("Matrix2:");
        printArray(m2);
        System.out.println("Matrix1 + Matrix2:");
        printArray(m3);
        System.out.println("addMatrix Time: " + String.valueOf(System.currentTimeMillis() - t1));
    }

    private static void accessMatrix(int[][] matrix) throws IOException {
        BufferedReader d = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println(String.format("rows number", matrix.length));
            System.out.println("Input row");
            int row = Integer.parseInt(d.readLine());
            if (matrix.length <= row) {
                System.out.println("Wrong row");
                return;
            }

            System.out.println("Input column");
            System.out.println(String.format("columns number", matrix[row].length));
            int column = Integer.parseInt(d.readLine());
            if (matrix[row].length <= column) {
                System.out.println("Wrong column");
                return;
            }
            System.out.println("Rquested element: " + String.valueOf(matrix[row][column]));
            System.out.println("Do you want to change it? [y/n]");
            String answer = d.readLine();
            if ("y".equals(answer)) {
                System.out.println("Input new value");
                int value = Integer.parseInt(d.readLine());
                matrix[row][column] = value;
                String json = gson.toJson(matrix);
                System.out.println("New Matrix: ");
                printArray(matrix);
                writeToFile(FILE, json);
            } else {
                break;
            }
        }
        d.close();
    }

    private static void printArray(int [][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(String.format("%2d", array[i][j]));
            }
            System.out.println();
        }
    }

    private static int[][] generateMatrix() throws IOException{
        long t1 = System.currentTimeMillis();
        BufferedReader d = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input row numbers");
        int row = Integer.parseInt(d.readLine());
        System.out.println("Input column numbers");
        int column = Integer.parseInt(d.readLine());
        int [][] matrix = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = i % 2 != 0 ? (j % 2 == 0 ? 0 : 1) : (j % 2 != 0 ? 0 : 1) ;
            }
        }
        System.out.println("generateMatrix Time: " + String.valueOf(System.currentTimeMillis() - t1));
        return matrix;
    }

    private static void writeToFile(String fileName, String content) {
        long t1 = System.currentTimeMillis();
        try {
            // Writing to a file
            File file=new File(fileName);
            FileWriter fileWriter = new FileWriter(file, false);
            System.out.println("Writing JSON object to file");
            System.out.println("-----------------------");
            System.out.println(content);
            fileWriter.write(content);
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("writeToFile Time: " + String.valueOf(System.currentTimeMillis() - t1));
    }

    private static String readFile(File file) throws FileNotFoundException, IOException {
        long t1 = System.currentTimeMillis();
        InputStream in = new FileInputStream(file);
        byte[] b  = new byte[(int) file.length()];
        int len = b.length;
        int total = 0;

        while (total < len) {
            int result = in.read(b, total, len - total);
            if (result == -1) {
                break;
            }
            total += result;
        }

        System.out.println("readFile Time: " + String.valueOf(System.currentTimeMillis() - t1));
        return new String(b, "UTF-8");
    }
}
