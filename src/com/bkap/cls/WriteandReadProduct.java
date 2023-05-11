package com.bkap.cls;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.bkap.cls.Categories;
import com.bkap.run.Manager;

public class WriteandReadProduct {
	public static void writeProduct(String path,List<Product> data) {
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
	public static void readProduct(String path) {
		File file=new File(path);
		try {
			FileInputStream fis=new FileInputStream(file);
			ObjectInputStream ois=new ObjectInputStream(fis);
			List<Product> data = (List<Product>)ois.readObject();
			Manager.Pro=data;
			fis.close();
			ois.close();
		} catch (Exception e) {
			
		}
		
	}
}
