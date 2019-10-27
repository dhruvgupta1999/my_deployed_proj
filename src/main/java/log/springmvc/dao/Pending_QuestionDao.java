package log.springmvc.dao;

import java.util.List;

import log.springmvc.model.Pending_question;

public interface Pending_QuestionDao {
    List<Pending_question> showPending_questions();
    public void  addPending_question(String question);
    void delPending_question(int Q_id);
    Pending_question q_details(int Q_id);
}
