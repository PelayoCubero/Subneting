public class Subred {

    private IP IP;
    private int cantidadDeSubredes;
    private IP[] subredes = new IP[cantidadDeSubredes];

    // constructores
    Subred(IP p, int c) {

        this.IP = p;
        this.cantidadDeSubredes = c;

        crearSubrredes();

    }

    // getters
    public IP[] getSubredes() {
        return subredes;
    }

    // metodo principal
    private void crearSubrredes() {

        int mascaraOriginal = IP.getMascara();
        int i = 0;
        String manejo = "";

        while (Math.pow(2, i) < this.cantidadDeSubredes) {

            i++;

        }

        this.cantidadDeSubredes = (int) Math.pow(2, i);

        IP.setMascara(IP.getMascara() + i);

        String masc = IP.getMascaraEnBytes();
        String[] direccion = IP.getBytes();

        int[] bytes = llenarBytes(masc);
        int[] IPEnBits = new int[direccion.length];
        int[] bitsMascara = new int[direccion.length];

        for (int j = 0; j < direccion.length; j++) {

            IPEnBits[j] = Integer.parseInt(Integer.toBinaryString(Integer.parseInt(direccion[j])));
            bitsMascara[j] = Integer.parseInt(Integer.toBinaryString(bytes[j]));

        }

        for (int j = 0; j < bitsMascara.length; j++) {

            if (bitsMascara[j] == 0) {

                manejo += "00000000";

            } else {

                manejo += Integer.toString(bitsMascara[j]);

            }

        }

        for (int j = 0; j < manejo.length(); j++) {

            if (j > mascaraOriginal - 1) {

                

            }

        }

    }

    // metodo de apoyo
    private int[] llenarBytes(String s) {

        String[] bytes = new String[4];
        int[] bit = new int[4];

        s += '.';
        int contador = 0;
        String apoyo = "";

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '.') {

                bytes[contador] = apoyo;
                contador++;
                apoyo = "";

            } else {

                apoyo += s.charAt(i);

            }
        }

        for (int i = 0; i < bit.length; i++) {

            bit[i] = Integer.parseInt(bytes[i]);

        }

        return bit;

    }

}
