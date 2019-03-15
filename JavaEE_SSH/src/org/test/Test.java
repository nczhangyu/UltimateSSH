package org.test;

import java.awt.event.FocusAdapter;
import java.io.*;

import org.dao.SearchDao;
import org.vo.Warrior;

public class Test {
	public static void main(String[] args) {
		String pathName = "E://temp//DB01.jpg";
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(pathName);
			SearchDao wd = new SearchDao();
			Warrior war = wd.searchWar(2);
			byte[] ph = war.getPhoto();
			fos.write(ph);
			System.out.println("结果如何啊？");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
