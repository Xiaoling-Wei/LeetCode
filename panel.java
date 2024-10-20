public class panel {
    public static void main(String[] args) {
        String panel = "2311453915";
        String[] codes={"0211","639"};
        String[] s =(panelPattern(panel,codes));
        for (String a : s){
            System.out.println(a);
        }
    }

    public static String[] panelPattern(String panel,String[] code) {
        int n=0;
        for (int i = 0; i < code.length; i++) {
            n = n+code[i].length()-1;
        }
        int k=0;
        String[] s = new String[n];
        String index = "";
        String pattern = "";
        for (int i = 0; i < code.length; i++) {
            for (int j = 0; j < code[i].length(); j++) {
                index = code[i].substring(j,j+1);
                pattern = code[i].substring(j+1);
                int ind = Integer.parseInt(index);
                int end = ind+pattern.length();
                if (ind == end){
                    continue;
                }
                String res = panel.substring(ind,end);
                if (ind < panel.length() && ind+pattern.length() < panel.length() && res.equals(pattern)) {
                    s[k++] = pattern;
                }else {
                    s[k++]="not found";
                }
            }
        }
        return s;
    }
}
