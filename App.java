public class App {

    public static void main(String[] args) {

        IP i = new IP("192.168.1.1", 20);

        new Subred(i, 2);
        
    }

}
