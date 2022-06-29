/**
 * Created by sushantshambharkar on 29/06/22.
 */
public class Utils {
    public static String rotateJson(String json) {
        String[] numbers = parseJson(json);
        int n = (int) Math.sqrt(numbers.length);
        for (int i = 0; i < n/2; i++){
            String temp = numbers[i*n + i];
            for (int j = i; j < n - i - 1; j++)
                numbers[j*n + i] = numbers[(j + 1)*n + i];
            for (int j = i; j < n - i - 1; j++)
                numbers[n * (n - 1 - i) + j] = numbers[n * (n - 1 - i) + j + 1];
            for (int j = n - i - 1; j > i ; j--)
                numbers[n * j + (n - 1 - i)] = numbers[n * (j - 1) + (n - 1 - i)];
            for (int j = n - i - 1; j > i ; j--)
                numbers[n * i + j] = numbers[n * i + j - 1];
            numbers[i*n + i + 1] = temp;
        }
        String joinedString = String.join(",", numbers).trim();
        return "\"[" + joinedString + "]\"";
    }

    private static String[] parseJson(String json) {
        return json.replaceAll("\\[", " ")
                .replaceAll("]", "")
                .split(",");
    }

    public static boolean validateJson(String json) {
        if(json == null) return false;
        String[] numbers = parseJson(json);
        return checkPerfectSquare(numbers.length);
    }

    private static boolean checkPerfectSquare(double number) {
        // calculating the square root of the given number
        double sqrt = Math.sqrt(number);
        // finds the floor value of the square root and comparing it with zero
        return ((sqrt - Math.floor(sqrt)) == 0);
    }
}
