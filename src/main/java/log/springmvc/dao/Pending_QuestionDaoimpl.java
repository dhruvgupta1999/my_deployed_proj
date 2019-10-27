package log.springmvc.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import log.springmvc.model.Pending_question;

public class Pending_QuestionDaoimpl implements Pending_QuestionDao{
	@Autowired
	  DataSource datasource;
	  @Autowired
	  JdbcTemplate jdbcTemplate;
	  public List<Pending_question> showPending_questions() {
		    String sql = "select * from Pending_question";
		    return jdbcTemplate.query(sql, new Pending_questionMapper());
	       }
	  public Pending_question q_details(int Q_id) {
		    String sql = "select * from Pending_question where Q_id=" + Q_id ;
		    List<Pending_question> pqlist = jdbcTemplate.query(sql, new Pending_questionMapper());
		    return pqlist.size()>0 ? pqlist.get(0) : null;
	       }
	  
	  public void delPending_question(int Q_id) {
		  String sql = "delete from Pending_question where Q_id=?";
			jdbcTemplate.update(sql, new Object[] {  Q_id });
		    }
	  
	  public void  addPending_question(String question) {
		  String sql = "insert into Pending_question(Question) values(?)";
		    jdbcTemplate.update(sql, new Object[] { question });
	  }
}


class Pending_questionMapper implements RowMapper<Pending_question> {
	  public Pending_question mapRow(ResultSet rs, int arg1) throws SQLException {
	    Pending_question user = new Pending_question();
	    user.setQuestion(rs.getString("Question"));
	    user.setQ_id(rs.getInt("Q_id"));
	    return user;
	  }
	}
