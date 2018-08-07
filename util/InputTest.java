package util;

//import static util.Input.yesNo;

public class InputTest {
    public static void main(String[] args) {
        Input newInput = new Input();

        System.out.println(newInput.getString());
        System.out.println(newInput.getString("\nEnter a value: "));
        System.out.println(newInput.yesNo());
        System.out.println(newInput.getInt(5, 20));
        System.out.println(newInput.getInt());
        System.out.println(newInput.getInt("\nPick a numnber, any number... "));
        System.out.println(newInput.getDouble(11.11, 50.2));
        System.out.println(newInput.getDouble());
    }
}
