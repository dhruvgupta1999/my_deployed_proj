package log.springmvc.dao;

import java.util.List;

import log.springmvc.model.Answered_question;

public interface Answered_questionDao {
    List<Answered_question> showAns();
    void addAns(Answered_question ans_ques);
}
