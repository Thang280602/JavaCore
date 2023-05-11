package com.bkap.cls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.bkap.run.Manager;

public class WriteandReadCategories {
	public static void writeCategories(String path,List<Categories> data) {
		File fileCate=new File(path);
		try {
			FileOutputStream fos = new FileOutputStream(fileCate);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(data);
			fos.close();
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void readCategories(String path) {
		File file=new File(path);
		try {
			FileInputStream fis=new FileInputStream(file);
			ObjectInputStream ois=new ObjectInputStream(fis);
			List<Categories> data = (List<Categories>)ois.readObject();
			Manager.Cate=data;
			fis.close();
			ois.close();
		} catch (Exception e) {
			
		}
		
	}
}
