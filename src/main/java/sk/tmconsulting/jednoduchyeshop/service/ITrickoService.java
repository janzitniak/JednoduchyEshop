package sk.tmconsulting.jednoduchyeshop.service;

import sk.tmconsulting.jednoduchyeshop.model.Tricko;

import java.util.List;

public interface ITrickoService {
    void ulozTricko(Tricko trickoObjekt);
    void aktualizujTricko(Tricko trickoObjekt);
    List<Tricko> ziskajVsetkyTricka();
    Tricko ziskajTrickoPodlaId(long id);
    void odstranTricko(long id);
}
