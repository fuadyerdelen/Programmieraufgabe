public class GladStat extends Arena {

    private String name;
    private int gesamteKampf;
    private int gesamteSiege;
    private int gesamteNiederlagen;
    private double siegquote;
    private boolean isTot;


    static Wuerfel w20 = new Wuerfel(20);
    static int w20Ergebnis = w20.wuerfle();
    static Gladiator gladiator = new Gladiator(gladiatorenNamen[w20Ergebnis - 1]);


    private double rechnerSiegquote() {
        if (gesamteNiederlagen == 0) {
            return gesamteSiege;
        }
        return ((double) gesamteSiege) / gesamteNiederlagen;
    }

    public GladStat(String name, int gesamteKampf, int gesamteSiege, int gesamteNiederlagen, double siegquote, boolean isTot) {
        this.name = name;
        this.gesamteKampf = gesamteKampf;
        this.gesamteSiege = gesamteSiege;
        this.gesamteNiederlagen = gesamteNiederlagen;
        this.siegquote = rechnerSiegquote();
        this.isTot = isTot;

    }


    public int compareTo(GladStat gl) {
        if (this.gesamteSiege != gl.gesamteSiege) {
            return this.gesamteSiege - gl.gesamteSiege;
        } else if (this.siegquote != gl.siegquote) {
            return Double.compare(gl.siegquote, this.siegquote);
        } else if (this.isTot != gl.isTot) {
            return Boolean.compare(this.isTot, gl.isTot);
        } else {
            return this.name.compareTo(gl.name);
        }

    }

    public static void main(String[] args) {

        System.out.println(gladiator);
    }
}
