package main.java.dao;

import main.java.model.RezerveOda;

import java.util.List;

public interface RezerveOdaDAO{

    String rezerveOdaKayit (RezerveOda rezervasyon);

    List<RezerveOda> rezerveOdaListele(RezerveOda rezervasyon);

    RezerveOda rezerveOdaBul(int id);

    String rezerveOdaSil(int id);

    String rezerveOdaGuncelle(RezerveOda rezerveOda);




}
