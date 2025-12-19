package caculator;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CaculatorFunction {
	private void parseExpression(String expression, List<Double> numbers, List<Character> operators) {
        // Loại bỏ khoảng trắng
        String cleanedExpression = expression.replaceAll("\\s+", "");

        // 1. Tách các số (bao gồm số thập phân)
        Pattern numPattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        Matcher numMatcher = numPattern.matcher(cleanedExpression);
        while (numMatcher.find()) {
            // Thêm các số tìm được vào danh sách numbers
            numbers.add(Double.parseDouble(numMatcher.group()));
        }

        // 2. Tách các toán tử (+, -, *, /)
        Pattern opPattern = Pattern.compile("[+\\-*/]");
        Matcher opMatcher = opPattern.matcher(cleanedExpression);
        while (opMatcher.find()) {
            // Bỏ qua toán tử dấu trừ (-) khi nó đứng đầu biểu thức (là dấu của số đầu tiên)
            // Ví dụ: Trong "-10+5", ta chỉ muốn lấy '+'
            if (opMatcher.start() == 0 && opMatcher.group().equals("-")) {
                 continue;
            }
            operators.add(opMatcher.group().charAt(0));
        }
    }

    /* Thực hiện các phép toán theo thứ tự ưu tiên (Nhân/Chia trước, Cộng/Trừ sau).*/
    public double calculate(String expression) {
        List<Double> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        // Bước 1: Phân tích cú pháp và tách Numbers/Operators
        parseExpression(expression, numbers, operators);

        // Kiểm tra cơ bản
        if (numbers.isEmpty()) {
            return 0.0;
        }

        // Giai đoạn 1: Xử lý Nhân (*) và Chia (/)
        for (int i = 0; i < operators.size(); i++) {
            char op = operators.get(i);

            if (op == '*' || op == '/') {
                double num1 = numbers.get(i);
                double num2 = numbers.get(i + 1);
                double result = 0;

                if (op == '*') {
                    result = num1 * num2;
                } else if (op == '/') {
                    if (num2 == 0) throw new ArithmeticException("Không thể chia cho 0.");
                    result = num1 / num2;
                }

                // Cập nhật danh sách:
                // 1. Thay thế số đầu tiên (num1) bằng kết quả
                numbers.set(i, result);
                // 2. Loại bỏ số thứ hai (num2)
                numbers.remove(i + 1);
                // 3. Loại bỏ toán tử đã dùng
                operators.remove(i);
                
                // Điều chỉnh chỉ số vòng lặp vì danh sách đã bị thay đổi
                i--; 
            }
        }

        // Giai đoạn 2: Xử lý Cộng (+) và Trừ (-) trên kết quả còn lại
        double finalResult = numbers.get(0);

        for (int i = 0; i < operators.size(); i++) {
            char op = operators.get(i);
            double nextNumber = numbers.get(i + 1);

            if (op == '+') {
                finalResult += nextNumber;
            } else if (op == '-') {
                finalResult -= nextNumber;
            }
        }

        return finalResult;
    }
}