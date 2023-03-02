package dao;

import domain.Campeonato;
import persistence.JpaPersistence;

public class CampeonatoDAO implements GenericDAO<Campeonato>{

    private JpaPersistence jpaPersistence;

    public CampeonatoDAO(){
        this.jpaPersistence = new JpaPersistence();
    }
    @Override
    public void saveOrUpdate(Campeonato campeonato) {
        this.jpaPersistence.getEm().getTransaction().begin();
        this.jpaPersistence.getEm().persist(campeonato);
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

    public JpaPersistence getJpaPersistence() {
        return jpaPersistence;
    }
}
