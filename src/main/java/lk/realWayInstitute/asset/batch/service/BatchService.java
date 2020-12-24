package lk.realWayInstitute.asset.batch.service;


import lk.realWayInstitute.asset.batch.dao.BatchDao;
import lk.realWayInstitute.asset.batch.entity.Batch;
import lk.realWayInstitute.util.interfaces.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchService implements AbstractService< Batch, Integer> {
    private final BatchDao batchDao;

    public BatchService(BatchDao batchDao) {
        this.batchDao = batchDao;
    }

    public List<Batch> findAll() {
        return batchDao.findAll();
    }

    public Batch findById(Integer id) {
        return batchDao.getOne(id);
    }

    public Batch persist(Batch batch) {
        return batchDao.save(batch);
    }

    public boolean delete(Integer id) {
        batchDao.deleteById(id);
        return false;
    }

    public List<Batch> search(Batch batch) {
        return null;
    }



}
