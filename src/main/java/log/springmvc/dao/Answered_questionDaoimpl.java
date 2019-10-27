package log.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import log.springmvc.model.Answered_question;
//import log.springmvc.model.Answered_question;

public class Answered_questionDaoimpl implements Answered_questionDao {

	 @Autowired
	  DataSource datasource;
	  @Autowired
	  JdbcTemplate jdbcTemplate;
	public void addAns(Answered_question ans_ques) {
		String sql = "insert into Answered_question values(?,?)";
	    jdbcTemplate.update(sql, new Object[] { ans_ques.getQuestion() , ans_ques.getAnswer()});
	
}
	
	public List<Answered_question> showAns() {
		String sql = "select * from Answered_question";
	    return jdbcTemplate.query(sql, new Answered_questionMapper());
	}
	
	
}

class Answered_questionMapper implements RowMapper<Answered_question> {
	  public Answered_question mapRow(ResultSet rs, int arg1) throws SQLException {
	    Answered_question user = new Answered_question();
	    user.setQuestion(rs.getString("Question"));
	    user.setAnswer(rs.getString("Answer"));
	    return user;
	  }
	}
