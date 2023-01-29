package DoHyung;

public class Solution133499DH {
    public int solution(String[] babbling) {
        int answer = 0;

        for (String babble:babbling) {
            String before = "";
            boolean invalid = false;
            while (babble.length() > 0 && !invalid) {
                if (babble.length() >= 3 && babble.substring(0,3).equals("aya")) {
                    if (before.equals("aya")) {
                        invalid = true;
                        break;
                    } else {
                        babble = babble.substring(3);
                        before = "aya";
                    }
                } else if (babble.length() >= 2 && babble.substring(0,2).equals("ye")) {
                    if (before.equals("ye")) {
                        invalid = true;
                        break;
                    } else {
                        babble = babble.substring(2);
                        before = "ye";
                    }
                } else if (babble.length() >= 3 && babble.substring(0,3).equals("woo")) {
                    if (before.equals("woo")) {
                        invalid = true;
                        break;
                    } else {
                        babble = babble.substring(3);
                        before = "woo";
                    }
                } else if (babble.length() >= 2 && babble.substring(0,2).equals("ma")) {
                    if (before.equals("ma")) {
                        invalid = true;
                        break;
                    } else {
                        babble = babble.substring(2);
                        before = "ma";
                    }
                } else {
                    invalid = true;
                    break;
                }
            }
            if (!invalid && babble.length() == 0) {
                answer++;
            }
        }

        return answer;
    }
}
