package sk.tmconsulting.jednoduchyeshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.tmconsulting.jednoduchyeshop.model.Tricko;
import sk.tmconsulting.jednoduchyeshop.repository.TrickoRepository;

import java.util.List;

@Service
public class TrickoService implements ITrickoService {
    @Autowired // TrickoRepository trickoRepository = new TrickoRepository();
    private TrickoRepository trickoRepository;

    @Override
    public void ulozTricko(Tricko trickoObjekt) {
        trickoRepository.save(trickoObjekt);
    }

    @Override
    public void aktualizujTricko(Tricko trickoObjekt) {
        trickoRepository.save(trickoObjekt);
    }

    @Override
    public List<Tricko> ziskajVsetkyTricka() {
        return trickoRepository.findAll();
    }

    @Override
    public Tricko ziskajTrickoPodlaId(long id) {
        return trickoRepository.findById(id).get();
    }

    @Override
    public void odstranTricko(long id) {
        trickoRepository.deleteById(id);
    }
}
