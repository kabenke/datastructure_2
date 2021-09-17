/**
 * Ein Objekt dieser Klasse ist ein Knoten eines binären Suchbaums. Der Knoten
 * besitzt einen long-Wert als Inhalt.
 */
public class Baumknoten {

    /**
     * Inhalt dieses Knotens.
     */
    private final long inhalt;

    /**
     * Linker Teilbaum dieses Knotens.
     */
    private Baumknoten linkerTeilbaum;

    /**
     * Rechter Teilbaum dieses Knotens.
     */
    private Baumknoten rechterTeilbaum;

    /**
     * Erzeugt einen Baumknoten mit dem übergebenen Wert.
     * @param wert Wert des neuen Baumknotens
     */
    public Baumknoten(long wert) {

        inhalt = wert;
        linkerTeilbaum = null;
        rechterTeilbaum = null;
    }

    /**
     * Fügt dem Suchbaum mit diesem Knoten als Wurzel einen neuen Knoten für den
     * übergebenen Wert hinzu. Der Knoten wird so hinzugefügt, dass der Baum ein
     * Suchbaum bleibt.
     * @param wert Wert, der dem Baum hinzugefügt wird
     */
    public void fuegeHinzu(long wert) {

        if (wert <= inhalt) {
            if (this.linkerTeilbaum == null) {
                this.linkerTeilbaum = new Baumknoten(wert);
            } else {
                this.linkerTeilbaum.fuegeHinzu(wert);
            }
        } else {
            if (this.rechterTeilbaum == null) {
                this.rechterTeilbaum = new Baumknoten(wert);
            } else {
                this.rechterTeilbaum.fuegeHinzu(wert);
            }
        }

    }


}
