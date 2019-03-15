package org.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.dao.SearchDao;
import org.vo.Warrior;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport{
	private Warrior warrior;

	public Warrior getWarrior() {
		return warrior;
	}

	public void setWarrior(Warrior warrior) {
		this.warrior = warrior;
	}
	
	/*public String getImage() throws Exception{					//“≥√Êœ‘ æÕº∆¨
		HttpServletResponse response = ServletActionContext.getResponse();
		//int id = warrior.getId();
		String name = warrior.getName();
		WarriorDao wd = new WarriorDao();
		Warrior war = wd.searchWar(name);
		byte[] ph = war.getPhoto();
		response.setContentType("image/jpeg");
		ServletOutputStream outputStream = response.getOutputStream();
		if (ph != null && ph.length != 0) {
			for (int i = 0;i < ph.length; i++) {
				outputStream.write(ph[i]);
			}
			outputStream.flush();
		}
		return NONE;
	}*/
	public String execute() throws Exception{
		SearchDao sd = new SearchDao();
		List lists = sd.searchAll();
		if(lists != null) {
			Map request = (Map)ActionContext.getContext().get("request");	
			request.put("results", lists);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
}
