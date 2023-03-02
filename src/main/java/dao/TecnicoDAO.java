package dao;

import domain.Profissional;
import domain.Tecnico;

import javax.persistence.Query;
import java.util.List;

public class TecnicoDAO extends ProfissonalDAO{

    public void saveOrUpdate(Tecnico tecnico) {
        super.saveOrUpdate(tecnico);
    }
    public Tecnico findById(Class clazz, Long id) {
        return (Tecnico) super.findById(clazz, id);
    }

    public void remove(Tecnico tecnico) {
        super.remove(tecnico);
    }

    public List<Tecnico> findAll(){
        Query query = super.getJpaPersistence().getEm().createNamedQuery("tecnico.findAll");
        return query.getResultList();
    }
}
