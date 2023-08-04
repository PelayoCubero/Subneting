import javax.swing.JOptionPane;

public class IP {

    private String dir;
    private String[] bytes = new String[4];
    private String mascaraEnBytes;
    private int mascara;
    private int apoyo = 0;

    // contructores
    IP(String direccionIP, int mascara) {

        if (!IPValida(direccionIP)) {

            System.out.println("Direccion no valida");
            return;

        }

        setMascara(mascara);
        this.dir = direccionIP;

        llenarBytes(direccionIP);

    }

    IP(String direccionIP, int mascara, int t) {

        this.apoyo = 1;

        if (!IPValida(direccionIP)) {

            JOptionPane.showMessageDialog(null, "Direccion no valida");
            return;

        }

        setMascara(mascara);
        this.dir = direccionIP;

        llenarBytes(direccionIP);

    }

    // getters
    public int getApoyo() {
        return apoyo;
    }

    public String getDir() {
        return dir;
    }

    public String[] getBytes() {
        return bytes;
    }

    public int getMascara() {
        return mascara;
    }

    public String getMascaraEnBytes() {
        return mascaraEnBytes;
    }

    // setters
    public void setBytes(String[] bytes) {

        String s = "";

        for (int i = 0; i < bytes.length; i++) {

            if (i != 3) {

                s += bytes[i];
                s += ".";

            } else {

                s += bytes[i];

            }
        }

        if (!IPValida(s) && apoyo == 1) {

            JOptionPane.showMessageDialog(null, "Direccion no valida");
            return;

        }
        if (!IPValida(s) && apoyo == 0) {

            System.out.println("Direccion no valida");
            return;

        } else {

            this.bytes = bytes;
            this.dir = s;
        }

    }

    public void setMascara(int m) {

        if ((m > 32 || m < 0) && apoyo == 1) {

            JOptionPane.showMessageDialog(null, "Mascara de red no valida, la mascara no se ha actualizado");
            return;

        }
        if ((m > 32 || m < 0) && apoyo == 0) {

            System.out.println("Mascara de red no valida, la mascara no se ha actualizado");
            return;

        } else {

            this.mascara = m;
            actualizarMascaraDeBits();

        }

    }

    private void actualizarMascaraDeBits() {

        int ref = 0;
        String s = "";
        String ss = "";
        String[] arr = new String[4];

        for (int i = 1; i <= 32; i++) {

            if (ref < mascara) {

                s += 1;
                ref++;

            } else {

                s += 0;

            }

        }

        ref = 0;

        for (int i = 0; i < arr.length; i++) {

            String masc = "";

            for (int j = i * 8; j < (i + 1) * 8; j++) {

                masc += s.charAt(j);

            }

            arr[i] = masc;

        }

        for (int i = 0; i < arr.length; i++) {

            int numero;

            numero = Integer.parseInt(arr[i], 2);
            ss += Integer.toString(numero);

            if (i != 3) {

                ss += ".";

            }

        }

        mascaraEnBytes = ss;

    }

    // metodo que aisla cada byte de la direccion IP en un espacio del array
    private void llenarBytes(String s) {

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

    }

    // metodo que garantiza la validez de la direccion IP
    private boolean IPValida(String s) {

        s += '.';
        int contador = 0;
        String[] test = new String[4];
        String apoyo = "";

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '.') {
                try {

                    test[contador] = apoyo;

                } catch (Exception e) {
                    return false;

                }

                contador++;
                apoyo = "";

            } else {

                apoyo += s.charAt(i);

            }
        }

        for (int i = 0; i < test.length; i++) {

            int n = 0;

            if (test[i] == null) {

                return false;
            }

            try {

                n = Integer.parseInt(test[i]);

            } catch (Exception e) {

                return false;

            }

            if ((n < 0) || (n > 255)) {

                return false;

            }
        }

        return true;

    }

}
