public class IP{

    private int mascara;
    private String mascaraComoDireccion;
    private int[] mascaraEnArray;

    private String direccion;
    private int[] direccionEnArray;

    IP(String d, int m){

        if(IPValida(d) && mascaraValida(m)){

            this.direccion = d;
            this.mascara = m;

            this.mascaraComoDireccion = transformar(mascara);
            this.direccionEnArray = dirToArray(direccion);
            this.mascaraEnArray = dirToArray(mascaraComoDireccion);
            

        }else{

            return;

        }

    }

    // getters
    public String getDireccion() {
        return direccion;
    }
    public int getMascara() {
        return mascara;
    }
    public String getMascaraComoDireccion() {
        return mascaraComoDireccion;
    }
    public int[] getDireccionEnArray() {
        return direccionEnArray;
    }
    public int[] getMascaraEnArray() {
        return mascaraEnArray;
    }

    //setters
    public void setMascara(int mascara) {

        if(mascaraValida(mascara)){

            this.mascara = mascara;
            this.mascaraComoDireccion = transformar(mascara);
            this.mascaraEnArray = dirToArray(mascaraComoDireccion);

        }

    }

    private int[] dirToArray(String dir) {

        dir += '.';
        String s = "";
        int[] arr = new int[4];
        int ref = 0;

        for (int i = 0; i < dir.length(); i++) {

            if(dir.charAt(i) == '.'){

                arr[ref] = Integer.parseInt(s);
                ref++;
                s = "";

            }else{

                s+= dir.charAt(i);

            }
            
        }

        return arr;
    }

    private String transformar(int m) {

        int contador = 0;
        String s = "";
        String ss = "";
        String r = "";

        for (int i = 0; i < 32; i++) {

            if(i < m){

                s += "1";

            }else{

                s += "0";

            }
            
        }

        s += ".";

        for (int i = 0; i < 33; i++) {
            if (contador == 8){

                r += Integer.toString(Integer.parseInt(ss,2));
                ss = "";
                contador = 0;

                if(i != 32){

                    r+= ".";
                }

                i--;
                
            }else{

                ss += s.charAt(i);
                contador++;

            }
        }

        return r;
    }

    private boolean mascaraValida(int m) {

        if(m > 30 || m < 8){

            return false;


        }else{

            return true;

        }
    }

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