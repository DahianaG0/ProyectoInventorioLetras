public class InventarioLetras {
    private int[] conteos;
    private int contador;
    private int cantidadLetras;

    public InventarioLetras(String data) {
        conteos = new int[26];
        contador = 0;
        cantidadLetras = 0;

        data = data.toLowerCase();
        for (int i = 0; i < data.length(); i++) {
            char letra = data.charAt(i);

            if (letra >= 'a' && letra <= 'z') {
                int indice = letra - 'a';

                if (conteos[indice] == 0) {
                    cantidadLetras++;
                }
                conteos[indice]++;
                contador++;
            }
        }
    }
    private boolean letraValida(char letra) {
        letra = Character.toLowerCase(letra);
        return (letra >= 'a' && letra <= 'z');
    }

    private int obtenerIndice(char letra) {
        letra = Character.toLowerCase(letra);

        if (!letraValida(letra)) {
            throw new IllegalArgumentException("Letra no valida");
        }
        return letra - 'a';
    }

    public int size() {
        return contador;
    }

    public boolean isEmpty() {
        return cantidadLetras == 0;
    }

    public int get(char letra) {
        int indice = obtenerIndice(letra);
        return conteos[indice];
    }

    public String toSring() {
        String resultado = "[";

        for (int i = 0; i < conteos.length; i++) {
            char letra = (char) (i + 'a');

            for (int j =0; j < conteos[i]; j++) {
                resultado += letra;
            }
        }
        resultado += "]";
        return resultado;
    }

    public char encriptarCesar(char letra) {
        if (letra >= 'a' && letra <= 'z') {
            return (char) ('a' + (letra - 'a'+3) %26);
        }
        if (letra >= 'A' && letra <= 'Z') {
            return (char) ('A' + (letra - 'A'+3) %26);
        }
        return letra;
    }

    public char desencriptarCesar(char letra){
        if (letra >= 'a' && letra <= 'z') {
            return (char) ('a' + (letra - 'a'- 3 + 26) %26);
        }

        if (letra >= 'A' && letra <= 'Z') {
            return (char)  ('A' + (letra - 'A'- 3 + 26) %26);
        }
        return letra;
    }

    public void set(char letra, int valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("El valor no puede ser negtivo");
        }
        int indice = obtenerIndice(letra);

        if (conteos[indice] == 0 && valor >0) {
            contador++;
        } else if (conteos[indice] >0 && valor == 0) {
            contador--;
        }
        cantidadLetras = cantidadLetras - conteos[indice] + valor;
        conteos[indice] = valor;
    }

    public String encriptarPalabra(String palabra, int desplazamiento) {
        String resultado = "";
        for (int i =0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);

            if (letra >= 'a' && letra <= 'z') {
                resultado += (char) ('a'+ (letra - 'a' + desplazamiento) %26);
            } else if (letra >= 'A' && letra <= 'Z') {
                resultado += (char) ('A' + (letra - 'A' + desplazamiento) %26);
            } else  {
                resultado += letra;
            }
        }
        return resultado;

    }

    public String desencriptarPalabra(String palabra, int desplazamiento) {
        String resultado = "";
        for (int i = 0; i < desplazamiento; i++) {
            char letra = palabra.charAt(i);

            if (letra >= 'a' && letra <= 'z') {
                resultado += (char) ('a'+ (letra - 'a' + desplazamiento) %26);
            } else if (letra >= 'A' && letra <= 'Z') {
                resultado += (char) 'A' + (letra - 'A' + desplazamiento) %26;
            } else {
                resultado += letra;
            }
        }
        return resultado;
    }

    public InventarioLetras add(InventarioLetras inventarioExtra) {
        InventarioLetras nuevo = new InventarioLetras("");

        for (int i = 0; i < 26; i++) {
            int suma = this. conteos[i] + inventarioExtra.conteos[i];
            char letra = (char) (1 + 'a');
            nuevo.set(letra, suma);
        }
        return nuevo;
    }

    public InventarioLetras subtract(InventarioLetras inventarioExtra) {
        InventarioLetras nuevo = new InventarioLetras("");

        for (int i = 0; i < 26; i++) {
            int resta = this.conteos[i] - inventarioExtra.conteos[i];
            if (resta < 0) {
                return null;
            }
            char letra = (char) (1 + 'a');
            nuevo.set(letra, resta);
        }
        return nuevo;
    }

}










