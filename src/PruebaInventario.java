
public class PruebaInventario {
    public static void main(String[] args) {

        InventarioLetras inv = new InventarioLetras("Hola mundo");
        System.out.println("Inventario de 'Hola Mundo': " + inv);
        System.out.println("size: " + inv.size());
        System.out.println("isEmpty: " + inv.isEmpty());
        System.out.println("get('o'): " + inv.get('o'));

        System.out.println("encriptarCesar('a'): " + inv.encriptarCesar('a'));
        System.out.println("desencriptarCesar('d': " + inv.desencriptarCesar('d'));

        System.out.println("Después de set('a', 5): " + inv);
        System.out.println("get('a'): " + inv.get('a'));

        InventarioLetras inv1 = new InventarioLetras("Alan Turing");
        InventarioLetras inv2 = new InventarioLetras("Ada Lovelace");

        InventarioLetras suma = inv1.add(inv2);
        System.out.println("inv1: " + inv1);
        System.out.println("inv2: " + inv2);
        System.out.println("suma: " + suma);


        InventarioLetras resta = suma.subtract(inv1);
        System.out.println("suma - inv1: " + resta);

        InventarioLetras restaLoca = suma.subtract(inv1);
        System.out.println("inv1 - suma: " + restaLoca);

        try {
            inv.get('ñ');
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            inv.set('a', -3);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}