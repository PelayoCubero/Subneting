public class App {

    public static void main(String[] args) {

        if (args.length != 0) {

            try {

                Subred sub = new Subred(new IP(args[0], Integer.parseInt(args[1])),
                        Integer.parseInt(args[2]));

                for (int i = 0; i < sub.getSubredes().length; i++) {

                    System.out.println(sub.getSubredes()[i].toString());

                }

            } catch (Exception e) {

                System.out.println("Se ha producido un error");
                return;

            }

        }

        new Ventana();

    }

}
