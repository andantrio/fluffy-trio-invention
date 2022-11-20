package DoHyung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main17479DH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nOfMenus = new int[3];
        for (int i=0;i<nOfMenus.length;i++) {
            nOfMenus[i] = Integer.parseInt(st.nextToken());
        }

        Map<String, String> menuTypes = new HashMap<>();
        Map<String, Long> standardMenu = new HashMap<>();
        Map<String, Long> specialMenu = new HashMap<>();

        for (int i=0;i<nOfMenus[0];i++) {
            String[] input = br.readLine().split(" ");
            standardMenu.put(input[0], Long.parseLong(input[1]));
            menuTypes.put(input[0], "standard");
        }

        for (int i=0;i<nOfMenus[1];i++) {
            String[] input = br.readLine().split(" ");
            specialMenu.put(input[0], Long.parseLong(input[1]));
            menuTypes.put(input[0], "special");
        }

        for (int i=0;i<nOfMenus[2];i++) {
            menuTypes.put(br.readLine(), "service");
        }

        int n = Integer.parseInt(br.readLine());

        long standardMenuSum = 0L;
        long specialMenuSum = 0L;
        int serviceMenuCount = 0;

        for (int i=0;i<n;i++) {
            String order = br.readLine();
            String menuType = menuTypes.get(order);
            if (menuType.equals("standard")) {
                standardMenuSum += standardMenu.get(order);
            } else if (menuType.equals("special")) {
                specialMenuSum += specialMenu.get(order);
            } else if (menuType.equals("service")) {
                serviceMenuCount++;
            }
        }

        if (standardMenuSum >= 20000 && standardMenuSum+specialMenuSum >= 50000 && serviceMenuCount < 2) {
            System.out.println("Okay");
        } else if (standardMenuSum >= 20000 && serviceMenuCount == 0) {
            System.out.println("Okay");
        } else if (standardMenuSum < 20000 && specialMenuSum == 0 && serviceMenuCount == 0) {
            System.out.println("Okay");
        } else {
            System.out.println("No");
        }
    }
}
