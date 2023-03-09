package dao;

import domain.Campeonato;
import persistence.JpaPersistence;

import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.util.List;
import java.util.Stack;

public class CampeonatoDAO implements GenericDAO<Campeonato>{

    private JpaPersistence jpaPersistence;

    public CampeonatoDAO(){
        this.jpaPersistence = new JpaPersistence();
    }
    @Override
    public void saveOrUpdate(Campeonato campeonato) {
        this.jpaPersistence.getEm().getTransaction().begin();
        this.jpaPersistence.getEm().merge(campeonato);
        this.jpaPersistence.getEm().getTransaction().commit();
    }

    @Override
    public Campeonato findById(Class clazz, Long id) {

        return (Campeonato) this.jpaPersistence.getEm().find(clazz,id);
    }

    @Override
    public void remove(Campeonato campeonato) {
        this.jpaPersistence.getEm().remove(campeonato);
        this.jpaPersistence.getEm().getTransaction().commit();
    }

    public List<Campeonato> findAll(){
        Query query = jpaPersistence.getEm().createNamedQuery("campeonatos.findAll");
        return query.getResultList();
    }

    public Campeonato findByNome(String nome){
        Query query = jpaPersistence.getEm().createNamedQuery("campeonato.byname");
        query.setParameter("nomeCampeonato", nome);
        return (Campeonato) query.getSingleResult();
    }

    public JpaPersistence getJpaPersistence() {
        return jpaPersistence;
    }
}
