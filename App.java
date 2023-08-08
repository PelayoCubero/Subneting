public class App {

    public static void main(String[] args) {

        IP i = new IP("192.168.1.1", 24);

        new Subred(i, 3);

        // Subneting s = new Subneting(i);

    //    System.out.println(s.toString());
        
    }

}
