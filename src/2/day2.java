package aoc21;

import java.io.*;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day2 {
    static Kattio io = new Kattio(System.in, System.out);

    public static void main(String[] args) {
        int count = 0;
        io.println(count);

//        Part 1
//        try {
//            File f = new File("C:\\Users\\lamch\\Repo\\aoc21\\src\\2\\2.txt");
//            Scanner myReader = new Scanner(f);
//            int[] res = new int[]{0, 0};
//            while (myReader.hasNextLine()) {
//                String i  = myReader.nextLine();
//                String[] s = i.split("\\s+");
//                String d = s[0];
//                int c = Integer.parseInt(s[1]);
//                if (d.equals("forward")) {
//                    res[0] += c;
//                }
//                if (d.equals("down")) {
//                    res[1] += c;
//                }
//                if (d.equals("up")) {
//                    res[1] -= c;
//                }
////                io.println(s[0]);
//            }
//            io.println("result is: " + String.valueOf(res[0] * res[1]));
//            myReader.close();
//        } catch (FileNotFoundException e) {
//            io.println("error");
//        }

//        Part 2
        try {
            File f = new File("C:\\Users\\lamch\\Repo\\aoc21\\src\\2\\2.txt");
            Scanner myReader = new Scanner(f);
            int[] res = new int[]{0, 0, 0};
            while (myReader.hasNextLine()) {
                String i  = myReader.nextLine();
                String[] s = i.split("\\s+");
                String d = s[0];
                int c = Integer.parseInt(s[1]);
                if (d.equals("forward")) {
                    res[0] += c;
                    res[1] += res[2] * c;
                }
                if (d.equals("down")) {
                    res[2] += c;
                }
                if (d.equals("up")) {
                    res[2] -= c;
                }
//                io.println(s[0]);
            }
            io.println("part 2 result is: " + String.valueOf(res[0] * res[1]));
            myReader.close();
        } catch (FileNotFoundException e) {
            io.println("error");
        }


        io.flush();
    }

    static class Kattio extends PrintWriter {
        public Kattio(InputStream i) {
            super(new BufferedOutputStream(System.out));
            r = new BufferedReader(new InputStreamReader(i));
        }

        public Kattio(InputStream i, OutputStream o) {
            super(new BufferedOutputStream(o));
            r = new BufferedReader(new InputStreamReader(i));
        }

        public boolean hasMoreTokens() {
            return peekToken() != null;
        }

        public int getInt() {
            return Integer.parseInt(nextToken());
        }

        public double getDouble() {
            return Double.parseDouble(nextToken());
        }

        public long getLong() {
            return Long.parseLong(nextToken());
        }

        public String getWord() {
            return nextToken();
        }


        private BufferedReader r;
        private String line;
        private StringTokenizer st;
        private String token;

        private String peekToken() {
            if (token == null)
                try {
                    while (st == null || !st.hasMoreTokens()) {
                        line = r.readLine();
                        if (line == null) return null;
                        st = new StringTokenizer(line);
                    }
                    token = st.nextToken();
                } catch (IOException e) {
                }
            return token;
        }

        private String nextToken() {
            String ans = peekToken();
            token = null;
            return ans;
        }
    }
}
