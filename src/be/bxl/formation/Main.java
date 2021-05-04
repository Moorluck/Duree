package be.bxl.formation;

public class Main {

    public static void main(String[] args) {

	    Duree duree = new Duree(1000);
        System.out.println("Durée 1 : " + duree.getDuree());

	    Duree duree2 = new Duree(5, 21, 45, 12);
        System.out.println("Durée 2 : " + duree2.getDuree());

        duree.addDuree(duree2);
        System.out.println("Durée 1 après ajout : " + duree.getDuree());

        duree.subDuree(duree2);
        System.out.println("Durée 1 après retrait : " + duree.getDuree());

        System.out.println(duree.getJours());

    }
}
