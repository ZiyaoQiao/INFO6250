package com.shopping.service;

import com.shopping.dao.EvaluationDao;
import com.shopping.entity.Evaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service(value = "evaluationService")
public class EvaluationService {
    @Autowired
    private EvaluationDao evaluationDao;

    public Evaluation getEvaluation(int userId, int productId, String time) {
        return evaluationDao.getEvaluation(userId,productId,time);
    }

    public void addEvaluation(Evaluation evaluation) {
        evaluationDao.addEvaluation(evaluation);
    }

    public boolean deleteEvaluation(int userId, int productId, String time) {
        return evaluationDao.deleteEvaluation(userId,productId,time);
    }

    public boolean updateEvaluation(Evaluation evaluation) {
        return evaluationDao.updateEvaluation(evaluation);
    }

    public List<Evaluation> getProductEvaluation(int productId) {
        return evaluationDao.getProductEvaluation(productId);
    }
}
