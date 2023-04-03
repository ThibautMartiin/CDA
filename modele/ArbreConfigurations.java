package modele;

import java.util.List;

public abstract class ArbreConfigurations implements Comparable<ArbreConfigurations> {
    private int score; //issu du calcul de minMax ou de la fonction d'evaluation
    private Plateau p;//configuration sur laquelle on reflechit (le coup donné est deja joué)
    private Coup c;//coup appliqué pour obtenir cette situation
    private String couleur;//couleur du coup joué en dernier
    private boolean isMax;//si on cherche à maximiser ou minimiser le score dans ce noeud (vis à vis de ses fils)

    public ArbreConfigurations(Plateau p, Coup c, String couleur, boolean isMax){
        this.c = c;
        this.p = p;
        this.isMax= isMax;
        this.couleur = couleur;

    }
//    private void calculerScore(int prof) {
//        ArrayList<Coup> coupsPossibles = this.p.listeCoupsPossibles(this.couleur);
//        if (coupsPossibles.size() == 0) { //si pas de coup possible
//            if (this.p.estFiniePartie()) { //si c'est une configuration finale
//                //cherher qui a gagné
//                int nbPionJoueur = this.p.score(this.couleur);
//                int nbPionAdv = this.p.score(Plateau.opposeCouleur(this.couleur));
//                if (nbPionAdv > nbPionJoueur) {
//                    this.score = -1000;
//                } else {
//                    this.score = 1000;
//                }
//            }else{
//                coupsPossibles.add(Coup.coupPasser());
//            }
//        }
//    }
    abstract void minMax( List<Coup> coupsPossibles, int prof);
//    public int fonctionEvaluation(){
//        int DIM = this.p.getDIM();
//        int score = 0;
//        String coulOpp = Plateau.opposeCouleur(this.couleur); //on évalue du point de vue de la prochaine personne à jouer (et qui ne joue pas)
//        for(int i=0; i<DIM; i++){
//            for(int j=0; j<DIM; j++){
//                if (coulOpp.equals(this.p.getGrille()[i][j])) {
//                    if (((i == 0) && (j == 0)) || ((i == 0) && (j == DIM - 1)) || ((i == DIM - 1) && (j == 0)) || ((i == DIM - 1) && (j == DIM - 1))) {
//                        score += 11;
//                    } else if ((i == 0) || (j == 0) || (i == DIM - 1) || (j == DIM - 1)) {
//                        score += 6;
//                    } else {
//                        score += 1;
//                    }
//                }
//            }
//        }
//        return score;
//    }

    public int getScore(){
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCouleur() {
        return couleur;
    }

    public Plateau getP() {
        return p;
    }

    public boolean isMax() {
        return isMax;
    }

    public Coup getC() {
        return c;
    }

    @Override
    public int compareTo(ArbreConfigurations arbreConfigurations) {
        return score - arbreConfigurations.getScore();
    }

}
