package svc;

import java.sql.Connection;
import dao.BoardDAO;
import vo.BoardBean;
import static db.JdbcUtil.*;
import java.util.ArrayList;

public class BoardListService {
	public int getListCount() throws Exception{
		
		int listCount=0;
		Connection con=getConnection();
		BoardDAO boardDAO=BoardDAO.getInstance();
		boardDAO.setConnection(con);
		listCount=boardDAO.selectListCount();
		close(con);
		return listCount;
		
	}//getListCount()-----
	
	public ArrayList<BoardBean> getArticleList(int page, int limit) throws Exception{
		ArrayList<BoardBean> articleList=null;
		Connection con=getConnection();
		BoardDAO boardDAO=BoardDAO.getInstance();
		boardDAO.setConnection(con);
		articleList=boardDAO.selectArticleList(page,limit);
		close(con);
		return articleList;
	}
}//BoardListService()-----
