
/**
 * Ein Objekt dieser Klasse ist ein binärer Suchbaum mit Elementen des Typs
 * long.
 */
public class BinaererSuchbaum {

    /**
     * Wurzelknoten dieses Baums.
     */
    private Baumknoten wurzel;

    /**
     * Erzeugt leeren Suchbaum.
     */
    public BinaererSuchbaum() {

        this.wurzel = null;
    }

    /**
     * Fügt dem Suchbaum den übergebenen Wert hinzu.
     *
     * @param wert Wert, der dem Baum hinzugefügt wird
     */
    public void fuegeHinzu(long wert) {

        if (wurzel == null) {
            wurzel = new Baumknoten(wert);
        } else {
            wurzel.fuegeHinzu(wert);
        }
    }



    public static void main(String[] args) {

        /*
         * Binären Suchbaum mit verschiedenen Werten zw. -5 und 25 erzeugen.
         */
        BinaererSuchbaum b = new BinaererSuchbaum();
        long[] werte = new long[]{9, 3, 25, -2, -5, 3, 4, 3, 7, 10, 9, 20, 25, 25, 25};
        for (long l : werte) {
            b.fuegeHinzu(l);
        }
        System.out.println(b.anzahlKleiner(9));/*Soll true abbrechnen*/
    }
}
