package dao;

import domain.Jogador;
import domain.Profissional;
import persistence.JpaPersistence;

import javax.persistence.Query;
import java.util.List;

public class JogadorDAO extends ProfissonalDAO{

    public void saveOrUpdate(Jogador jogador) {
        super.saveOrUpdate(jogador);
    }
    public Jogador findById(Class clazz, Long id) {
        return (Jogador) super.findById(clazz, id);
    }

    public void remove(Jogador object) {
        super.remove(object);
    }

    public List<Jogador> findAll(){
        Query query = super.getJpaPersistence().getEm().createNamedQuery("jogador.findAll");
        return query.getResultList();
    }
}
