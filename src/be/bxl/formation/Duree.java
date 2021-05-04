package be.bxl.formation;

import java.time.DateTimeException;

public class Duree {

    private int jours;
    private int heures;
    private int minutes;
    private int secondes;

    public Duree(int secondes) {
        if (secondes < 0) {
            throw new IllegalArgumentException();
        }

        Duree duree = convertSecondsToDuree(secondes);

        this.secondes = duree.secondes;
        this.minutes = duree.minutes;
        this.heures = duree.heures;
        this.jours = duree.jours;

    }

    public Duree(int jours, int heures, int minutes, int secondes) {

        boolean joursIncorrect = jours < 0;
        boolean heuresIncorrect = heures >= 24 || heures < 0;
        boolean minutesIncorrect = minutes >= 60 || minutes < 0;
        boolean secondesIncorrect = secondes >= 60 || secondes < 0;

        if (joursIncorrect || heuresIncorrect || minutesIncorrect || secondesIncorrect) {
            throw new IllegalArgumentException();
        }

        this.jours = jours;
        this.heures = heures;
        this.minutes = minutes;
        this.secondes = secondes;

    }

    public String getDuree() {
        return jours + " jours, " + heures + " : " + minutes + " : " + secondes;
    }

    public String getTotalSeconds() {

        int totalSecondes = secondes;
        totalSecondes += minutes*60;
        totalSecondes += heures*60*60;
        totalSecondes += jours*24*60*60;

        return "La durée total en seconde est de : " + totalSecondes;
    }

    public void subDuree(Duree aSoustraire) {
        int totalSeconds = convertDureeToSeconds(this);
        int totalSecondsASoustraire = convertDureeToSeconds(aSoustraire);

        int results = totalSeconds - totalSecondsASoustraire;

        Duree newDuree = convertSecondsToDuree(results);

        if (results >= 0){
            this.secondes = newDuree.secondes;
            this.minutes = newDuree.minutes;
            this.heures = newDuree.heures;
            this.jours = newDuree.jours;
        } else {
            throw new ArithmeticException();
        }
    }

    public void addDuree(Duree aAjouter) {
        int totalSeconds = convertDureeToSeconds(this);
        int totalSecondsASoustraire = convertDureeToSeconds(aAjouter);

        int results = totalSeconds + totalSecondsASoustraire;

        Duree newDuree = convertSecondsToDuree(results);

        this.secondes = newDuree.secondes;
        this.minutes = newDuree.minutes;
        this.heures = newDuree.heures;
        this.jours = newDuree.jours;
    }

    private int convertDureeToSeconds(Duree duree) {

        int totalSeconds = duree.secondes;
        totalSeconds += duree.minutes*60;
        totalSeconds += duree.heures*60*60;
        totalSeconds += duree.jours*60*60*24;

        return totalSeconds;

    }

    private Duree convertSecondsToDuree(int secondes) {
        int newSeconds = 0;
        int newMinutes = 0;
        int newHeures = 0;
        int newJours = 0;

        if (secondes >= 60) {
            newMinutes += secondes/60;
            newSeconds = secondes%60;
        }

        if (newMinutes >= 60) {
            newHeures += newMinutes/60;
            newMinutes = newMinutes%60;
        }

        if (newHeures >= 24) {
            newJours += newHeures/24;
            newHeures = newHeures%24;
        }

        return new Duree(newJours, newHeures, newMinutes, newSeconds);
    }
}
