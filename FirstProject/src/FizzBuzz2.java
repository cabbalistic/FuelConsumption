public class FizzBuzz2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            int flag = (i%3 == 0 && i%5 == 0) ? 1: (i%3 == 0)? 2: (i%5 == 0)? 3: 4;

            switch(flag){
                case 1:
                    System.out.println("FizzBuzz");
                    break;
                case 2:
                    System.out.println("Fizz");
                    break;
                case 3:
                    System.out.println("Buzz");
                    break;
                case 4:
                     System.out.println(i);
                    break;
            }
        }
    }
}
