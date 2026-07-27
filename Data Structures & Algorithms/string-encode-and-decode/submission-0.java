
class Solution {
public static String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    for (String str : strs) {
        sb.append(str.length()).append("#").append(str);
    }
    return sb.toString();
}

public static List<String> decode(String str) {
    List<String> result = new ArrayList<>();
    int i = 0;

    while (i < str.length()) {
        int j = i;
        while (str.charAt(j) != '#') {
            j++;
        }

        int length = Integer.parseInt(str.substring(i, j));
        j++;

        result.add(str.substring(j, j + length));
        i = j + length;
    }

    return result;
}

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = Integer.parseInt(sc.nextLine());

    List<String> input = new ArrayList<>();

    for (int i = 0; i < n; i++) {
        input.add(sc.nextLine());
    }

    String encoded = encode(input);
    System.out.println("Encoded String:");
    System.out.println(encoded);

    List<String> decoded = decode(encoded);

    System.out.println("Decoded Strings:");
    for (String s : decoded) {
        System.out.println(s);
    }

    sc.close();
}
}