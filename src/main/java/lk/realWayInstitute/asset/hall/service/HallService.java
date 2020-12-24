package lk.realWayInstitute.asset.hall.service;


import lk.realWayInstitute.asset.hall.dao.HallDao;
import lk.realWayInstitute.asset.hall.entity.Hall;
import lk.realWayInstitute.util.interfaces.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallService implements AbstractService< Hall, Integer> {
    private final HallDao hallDao;

    public HallService(HallDao hallDao) {
        this.hallDao = hallDao;
    }

    public List<Hall> findAll() {
        return hallDao.findAll();
    }

    public Hall findById(Integer id) {
        return hallDao.getOne(id);
    }

    public Hall persist(Hall hall) {
        return hallDao.save(hall);
    }

    public boolean delete(Integer id) {
        hallDao.deleteById(id);
        return false;
    }

    public List<Hall> search(Hall hall) {
        return null;
    }



}
