public class Subred {

    private IP IP;
    private int cantidadDeSubredes;
    private IP[][] subredes = new IP[4][cantidadDeSubredes];

    // constructores
    Subred(IP p, int c) {

        this.IP = p;
        this.cantidadDeSubredes = c;

        crearSubrredes();

    }

    // getters
    public IP[][] getSubredes() {
        return subredes;
    }

    // metodo principal
    private void crearSubrredes() {

        int mascaraOriginal = IP.getMascara();
        int potencia = 0;
        String apoyo = "";
        String host;

        while (Math.pow(2, potencia) < this.cantidadDeSubredes) {

            potencia++;

        }

        this.cantidadDeSubredes = (int) Math.pow(2, potencia);

        IP.setMascara(IP.getMascara() + potencia);

        String masc = IP.getMascaraEnBytes();
        String[] direccion = IP.getBytes();

        int[] bytes = llenarBytes(masc);
        int[] IPEnBits = new int[direccion.length];
        int[] bitsMascara = new int[direccion.length];

        for (int j = 0; j < direccion.length; j++) {

            IPEnBits[j] = Integer.parseInt(Integer.toBinaryString(Integer.parseInt(direccion[j])));
            bitsMascara[j] = Integer.parseInt(Integer.toBinaryString(bytes[j]));

        }

        for (int i = 0; i < bitsMascara.length; i++) {

            if (bitsMascara[i] == 0) {

                apoyo += "00000000";

            } else {

                apoyo += Integer.toString(bitsMascara[i]);

            }

        }

        host = bitsDeHost(apoyo, mascaraOriginal);

        // tenemos todos los bits de host separados

    }

    // metodos de apoyo
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

    public String bitsDeHost(String s, int ss) {

        String ret = "";

        for (int i = 0; i < s.length(); i++) {

            if (i >= ss) {

                ret += s.charAt(i);

            }

        }
        return ret;

    }

}
