public class Subred {

    private IP IP;
    private int cantidadDeSubredes;
    private Subneting[] subredes;

    // constructores
    Subred(IP p, int c) {

        this.IP = p;
        this.cantidadDeSubredes = c;


        crearSubrredes();

    }

    // getters
    public Subneting[] getSubredes() {
        return subredes;
    }

    private void crearSubrredes() {

        int potencia = obtenerBits();
        int mascaraNueva = IP.getMascara() + potencia;
        String host = obtenerHost(mascaraNueva);
        subredes = new Subneting[cantidadDeSubredes];

        for (int i = 0; i < subredes.length; i++) {
            
            subredes[i] = obtenerRed(IP.getMascara(), i ,host, mascaraNueva, potencia);
            System.out.println(subredes[i].toString());

        }

    }
  
    private Subneting obtenerRed(int mascara, int n, String host, int mascaraNueva, int p) {

        int[] ipOriginal = IP.getDireccionEnArray();
        String comodin = Integer.toBinaryString(n);
        String s = "";
        String apoyo = "";
        String redEnBits = "";
        String laIPEnBits = "";
        String referencias = "";
        String redDefinitiva = "";
        int contador = 0;

        for (int i = 0; i < ipOriginal.length; i++) {

            String r = Integer.toBinaryString(ipOriginal[i]);

            while(r.length() < 8){

                r = "0" + r;

            }

            referencias += r;
            
        }

        for (int i = 0; i < mascara; i++) {

            s += "1";

        }

        while(comodin.length() < p){

            comodin = "0" + comodin;

        }

        String ss = comodin + host;
        s += ss + " ";

        for (int i = 0; i < s.length(); i++) {

            if(contador == 8){

                laIPEnBits += apoyo;
                contador = 0;
                apoyo = "";

                if(i != 32){

                    laIPEnBits += ".";

                }

                i--;

            }else{

                apoyo += s.charAt(i);
                contador++;

            }
                 
        }

        comodin = "";
        contador = 0;

         for (int i = 0; i < referencias.length(); i++) {

            if(!(i < mascara)){

                comodin += ss.charAt(contador);
                contador++;

            }else{

                comodin += referencias.charAt(i);

            }
        }

        
        referencias = comodin + " ";
        comodin = "";
        apoyo = "";
        contador = 0;
        
        
        for (int i = 0; i < referencias.length(); i++) {
            
            if(contador == 8){

                comodin += apoyo;
                contador = 0;
                apoyo = "";

                if(i != referencias.length() - 1){
                    
                    comodin += ".";
                    
                }
                
                i--;
                
            }else{

                apoyo += referencias.charAt(i);
                contador++;
                
            }
            
        }
        
        referencias = comodin;

        for (int i = 0; i < referencias.length(); i++) {

            if(laIPEnBits.charAt(i) == '1' && referencias.charAt(i) == '1'){

                redEnBits += "1";

            }else if(laIPEnBits.charAt(i) == '.'){

                redEnBits += ".";

            }else{

                redEnBits += "0";

            }
            
        }

        apoyo = "";
        redEnBits += ".";

        for (int i = 0; i < redEnBits.length(); i++) {
            
            if(redEnBits.charAt(i) == '.'){

                redDefinitiva += Integer.toString(Integer.parseInt(apoyo, 2));

                if(i != redEnBits.length() - 1 ){

                    redDefinitiva += ".";

                }
                apoyo = "";

            }else{

                apoyo += redEnBits.charAt(i);

            }

        }

        
        
        return new Subneting(new IP(redDefinitiva, mascaraNueva));
    }

























































     private String obtenerHost(int m) {

        String s = "";
        int ref = 32 - m;

        for (int i = 0; i < ref; i++) {

            s += "0";

        }

        return s;
    }

    private int obtenerBits() {

        int n = 0;

        while(Math.pow(2, n) < cantidadDeSubredes){

            n++;

        }

        cantidadDeSubredes = (int) Math.pow(2,n);

        return n;
    }
    
}