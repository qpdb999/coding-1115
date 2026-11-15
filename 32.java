
/*
예외 처리 (Exception Handling)

    오늘 배운 내용

이번에는 자바에서 프로그램 실행 중 발생하는 예외를
처리하는 방법에 대해 배웠다.

try와 catch를 사용하여 오류가 발생했을 때 대응하는 방법과
finally를 이용해 예외 발생 여부와 관계없이 실행되는 코드를 작성하는 방법을 학습했다.

또한 throw와 throws의 차이점도 알아보았다.

    정의

1) 예외 (Exception)

예외란 프로그램 실행 중 발생하여
정상적인 프로그램의 흐름을 방해하는 상황이다.

예를 들어 숫자를 0으로 나누거나,
배열의 범위를 벗어난 위치에 접근하는 경우가 있다.

2) try

예외가 발생할 가능성이 있는 코드를 작성하는 영역이다.

3) catch

try 영역에서 예외가 발생했을 때
해당 예외를 처리하는 영역이다.

4) finally

예외 발생 여부와 관계없이 실행되는 영역이다.
주로 파일이나 자원 정리 등에 사용한다.

5) throw

개발자가 직접 예외를 발생시키는 데 사용하는 키워드이다.

6) throws

메서드에서 발생할 수 있는 예외를
호출한 곳으로 전달한다고 선언하는 키워드이다.

    사용 방법

1) 기본적인 예외 처리

public class Code {
    public static void main(String[] args) {

        try {
            int result = 10 / 0;
            System.out.println(result);

        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
        }

    }
}

실행 결과
0으로 나눌 수 없습니다.

2) 여러 종류의 예외 처리

public class Code {
    public static void main(String[] args) {

        try {
            int[] numbers = {10, 20, 30};

            System.out.println(numbers[5]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열의 범위를 벗어났습니다.");

        } catch (Exception e) {
            System.out.println("예외가 발생했습니다.");
        }

    }
}

실행 결과
배열의 범위를 벗어났습니다.

3) finally 사용하기

public class Code {
    public static void main(String[] args) {

        try {
            int result = 10 / 2;
            System.out.println(result);

        } catch (ArithmeticException e) {
            System.out.println("계산 오류가 발생했습니다.");

        } finally {
            System.out.println("프로그램을 종료합니다.");
        }

    }
}

실행 결과
5
프로그램을 종료합니다.

4) throw 사용하기

public class Code {

    static void checkAge(int age) {

        if (age < 0) {
            throw new IllegalArgumentException("나이는 음수일 수 없습니다.");
        }

        System.out.println("입력된 나이: " + age);
    }

    public static void main(String[] args) {

        try {
            checkAge(-1);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}

실행 결과
나이는 음수일 수 없습니다.

5) throws 사용하기

public class Code {

    static void readData() throws Exception {
        throw new Exception("데이터 처리 중 오류가 발생했습니다.");
    }

    public static void main(String[] args) {

        try {
            readData();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

실행 결과
데이터 처리 중 오류가 발생했습니다.

    코드 분석

1) try와 catch

try 내부에서 10 / 0을 계산하면
ArithmeticException 예외가 발생한다.

이때 catch가 예외를 감지하고
오류 메시지를 출력한다.

2) 여러 catch 사용

하나의 try 뒤에 여러 catch를 작성할 수 있다.
발생한 예외의 종류에 맞는 catch가 실행된다.

Exception은 다양한 예외의 상위 클래스이므로
일반적으로 구체적인 예외를 먼저 작성해야 한다.

3) finally

예외가 발생하지 않아도 finally는 실행된다.
예외가 발생해 catch가 실행된 경우에도 실행된다.

4) throw

throw는 예외를 직접 발생시키는 역할을 한다.
위 코드에서는 나이가 음수일 경우
IllegalArgumentException을 발생시킨다.

5) throws

throws는 메서드에서 발생할 수 있는 예외를
호출하는 쪽에서 처리하도록 전달한다고 선언한다.

    복습하면서 알게 된 점

예외 처리는 프로그램에서 오류가 발생했을 때
프로그램이 갑자기 종료되는 상황을 줄이고,
문제에 맞게 대응할 수 있도록 도와준다는 것을 알게 되었다.

특히 try와 catch는 예외를 처리하는 역할이고,
throw와 throws는 예외를 발생시키거나 전달하는 역할이라는
차이점을 이해했다.

📌 AI 활용 복습 문제

1) 예외가 발생할 가능성이 있는 코드를 작성하는 영역은?

정답: try

2) 예외가 발생했을 때 처리하는 영역은?

정답: catch

3) 예외 발생 여부와 관계없이 실행되는 영역은?

정답: finally

4) 0으로 숫자를 나누었을 때 발생하는 대표적인 예외는?

정답: ArithmeticException

5) 개발자가 직접 예외를 발생시키는 키워드는?

정답: throw

6) 메서드에서 발생할 수 있는 예외를 선언하는 키워드는?

정답: throws

7) 다음 코드의 실행 결과는?

try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("계산 오류");
} finally {
    System.out.println("종료");
}

정답:
계산 오류
종료

8) 여러 catch를 사용할 때 Exception을 마지막에 작성하는 이유는?

정답: Exception은 대부분의 예외를 포함하는 상위 클래스이기 때문에
구체적인 예외보다 먼저 작성하면 뒤에 있는 catch가 실행될 수 없기 때문이다.
*/
