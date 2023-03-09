package dao;

import domain.Equipe;
import persistence.JpaPersistence;

import javax.persistence.EntityManager;

public class EquipeDAO implements GenericDAO<Equipe>{
    private JpaPersistence jpaPersistence;

    public EquipeDAO(){
        this.jpaPersistence = new JpaPersistence();
    }

    @Override
    public void saveOrUpdate(Equipe equipe) {
        this.jpaPersistence.getEm().getTransaction().begin();
        this.jpaPersistence.getEm().merge(equipe);
        this.jpaPersistence.getEm().getTransaction().commit();
    }

    @Override
    public Equipe findById(Class clazz, Long id) {
        return (Equipe) this.jpaPersistence.getEm().find(clazz,id);
    }

    @Override
    public void remove(Equipe equipe) {
        this.jpaPersistence.getEm().remove(equipe);
        this.jpaPersistence.getEm().getTransaction().commit();

    }

    public JpaPersistence getJpaPersistence() {
        return jpaPersistence;
    }
}
