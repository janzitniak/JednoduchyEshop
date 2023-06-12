package sk.tmconsulting.jednoduchyeshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.tmconsulting.jednoduchyeshop.model.Tricko;
import sk.tmconsulting.jednoduchyeshop.repository.TrickoRepository;

@Service
public class TrickoService implements ITrickoService {
    @Autowired // TrickoRepository trickoRepository = new TrickoRepository();
    private TrickoRepository trickoRepository;
    @Override
    public Tricko ulozTricko(Tricko trickoObjekt) {
        return trickoRepository.save(trickoObjekt);
    }
}
