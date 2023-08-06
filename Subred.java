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

        //int mascaraOriginal = IP.getMascara();
        int potencia = 0;
        String apoyo = "";
        String host;

        while (Math.pow(2, potencia) < this.cantidadDeSubredes) {

            potencia++;

        }

        this.cantidadDeSubredes = (int) Math.pow(2, potencia);

        IP.setMascara(IP.getMascara() + potencia);

        String masc = IP.getMascaraEnBytes();
        int mascaraConPotecia = IP.getMascara();
        String[] direccion = IP.getBytes();

        
        IP.setMascara(IP.getMascara() - potencia);

        int[] bytes = llenarBytes(masc);
        String[] IPEnBits = new String[direccion.length];
        String[] bitsMascara = new String[direccion.length];

        for (int i = 0; i < direccion.length; i++) {

            IPEnBits[i] = Integer.toBinaryString(Integer.parseInt(direccion[i]));
            bitsMascara[i] = Integer.toBinaryString(bytes[i]);

        }

        for (int i = 0; i < bitsMascara.length; i++) {

            if (bitsMascara[i] == "0") {

                apoyo += "00000000";

            } else {

                apoyo += bitsMascara[i];

            }

        }

        host = bitsDeHost(apoyo, IP.getMascara());

        for (int i = 0; i < bitsMascara.length; i++) {
            System.out.println(bytes[i]);
        }

        for (int i = 0; i < cantidadDeSubredes; i++) {
            
            // String s = (Integer.toBinaryString(i) + host +"\n"+ masc);

            //String laIP = convertir(bitsMascara, );

            // System.out.println(Integer.parseInt(s,2) + " : " + s);

        }

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


        //    for (int j = 0; j < host.length(); j++) {
                
        //         if(host.charAt(j) == '0'){

        //             System.out.print(host.charAt(j));
                    
        //         }

        //     }
        //     System.out.println();
        // }