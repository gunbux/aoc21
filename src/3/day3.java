import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day3 {
    static Kattio io = new Kattio(System.in, System.out);

    public static void main(String[] args) {
        int count = 0;
        String res = "";
//        io.println(count);

// part 1
//        try {
//            File f = new File("C:\\Users\\lamch\\Repo\\aoc21\\src\\3\\3.txt");
//            Scanner myReader = new Scanner(f);
//            int len = myReader.nextLine().length();
//            io.println(len);
//            for (int l = 0; l < len; l++) {
//                int zc = 0;
//                int oc = 0;
//                Scanner read = new Scanner(f);
//                while (read.hasNextLine()) {
//                    String i  = read.nextLine();
////                    io.println(i.charAt(l));
//                    if (i.charAt(l) == '0') {
//                        zc += 1;
//                    }
//                    if (i.charAt(l) == '1') {
//                        oc += 1;
//                    }
//                }
////                io.println(oc);
////                io.println(zc);
////                io.println(l);
//                if (oc > zc) {
////                    io.println("test 1");
//                    res += "1";
//                }
//                if (zc > oc) {
////                    io.println("test2");
//                    res += "0";
//                }
//            }
//            io.println(res);
//            String res2 = "";
//            for (int i = 0; i < res.length(); i++ ) {
//                if (res.charAt(i) == '0') {
//                    res2 += '1';
//                }
//                if (res.charAt(i) == '1') {
//                    res2 += '0';
//                }
//            }
//            io.println(res2);
//            int gamma = Integer.parseInt(res, 2);
//            int eps = Integer.parseInt(res2, 2);
//            io.println(gamma);
//            io.println(eps);
//            io.println(eps * gamma);
//            myReader.close();
//        } catch (FileNotFoundException e) {
//            io.println("error");
//        }

//        part 2
        try {
            File f = new File("C:\\Users\\lamch\\Repo\\aoc21\\src\\3\\3.txt");
            Scanner myReader = new Scanner(f);
            int len = myReader.nextLine().length();
            ArrayList<String> list = new ArrayList<String>();
            Scanner initial = new Scanner(f);
            while (initial.hasNextLine()) {
                list.add(initial.nextLine());
            }
            io.println(len  );
            for (int l = 0; l < len; l++) {
                int zc = 0;
                int oc = 0;
                Scanner read = new Scanner(f);
                while (read.hasNextLine()) {
                    String i  = read.nextLine();
//                    io.println(i.charAt(l));
                    if (i.charAt(l) == '0') {
                        zc += 1;
                    }
                    if (i.charAt(l) == '1') {
                        oc += 1;
                    }
                }
                if (oc > zc) {
                    res += "1";
                }
                if (zc > oc) {
                    res += "0";
                }
                if (zc == oc) {
                    res += "1";
                }
            }
            io.println(res);
//            io.println(list.get(0));

//            public static ArrayList<String> filter(ArrayList<String> arr) {
//
//            }
            ArrayList<String> copy = new ArrayList<String>(list);
            io.println(copy);
            int i = 0;
            while (copy.size() > 1 && i < len) {
                String finalRes = res;
                int finalI = i;
//                io.println(finalI);
//                io.println(finalRes);
                char param = 0;
                int ooc = 0;
                int zzc = 0;
                for (int c = 0; c < copy.size(); c++) {
                    if (copy.get(c).charAt(finalI) == '0') {
                        zzc++;
                    }
                    if (copy.get(c).charAt(finalI) == '1') {
                        ooc++;
                    }
                }
                if (ooc >= zzc) {
                    param = '1';
                }
                if (ooc < zzc) {
                    param = '0';
                }
                char finalParam = param;
                copy.removeIf(s -> s.charAt(finalI) != finalParam);
//                io.println(copy);
                i++;
            }

            int oxy = Integer.parseInt(copy.get(0), 2);
//            io.println(copy);

            ArrayList<String> copy2 = new ArrayList<String>(list);
            int j = 0;
            while (copy2.size() > 1 && j < len) {
                String finalRes = res;
                int finalJ = j;
//                io.println(finalI);
//                io.println(finalRes);
                char param = 0;
                int ooc = 0;
                int zzc = 0;
                for (int c = 0; c < copy2.size(); c++) {
                    if (copy2.get(c).charAt(finalJ) == '0') {
                        zzc++;
                    }
                    if (copy2.get(c).charAt(finalJ) == '1') {
                        ooc++;
                    }
                }
                if (ooc < zzc) {
                    param = '1';
                }
                if (ooc >=   zzc) {
                    param = '0';
                }
                char finalParam = param;
                copy2.removeIf(s -> s.charAt(finalJ) != finalParam);
//                io.println(copy2);
                j++;
            }

            int co = Integer.parseInt(copy2.get(0), 2);
            io.println(copy2);
            io.println(oxy);
            io.println(co);
            io.println(co * oxy);

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
