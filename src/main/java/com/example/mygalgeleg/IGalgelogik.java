package com.example.mygalgeleg;

import java.util.ArrayList;

public interface IGalgelogik {




        public ArrayList<String> getBrugteBogstaver();

        public String getSynligtOrd();

        public String getOrdet();
        public int getAntalForkerteBogstaver();

        public boolean erSidsteBogstavKorrekt();
        public boolean erSpilletVundet();
        public boolean erSpilletTabt();

        public boolean erSpilletSlut();

        public void nulstil() ;

        public void setWord(String word);

        public void gætBogstav(String bogstav);

        public void logStatus();

        public void hentOrdFraDr() throws Exception;

        public void hentOrdFraRegneark(String sværhedsgrader) throws Exception;
    }

