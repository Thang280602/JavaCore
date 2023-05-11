package com.bkap.run;


import java.util.Scanner;


import com.bkap.cls.WriteandReadCategories;
import com.bkap.cls.WriteandReadProduct;

public class main {
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Manager manager=new Manager();
		WriteandReadCategories.readCategories("D:\\BTJava\\BaiTapLon\\Categories.txt");
		WriteandReadProduct.readProduct("D:\\BTJava\\BaiTapLon\\Product.txt");
		do {
			System.out.println("================Menu===============");
			System.out.println("1.Quan ly danh muc");
			System.out.println("2.Quan ly san pham");
			System.out.println("3.Thoat");
			System.out.println("Moi ban nhap lua chon cua ban:");
			int LuaChon=Integer.parseInt(sc.nextLine());
			switch(LuaChon) {
			case 1:                                                       // case 1:Quan ly danh muc
				manager.Case1();
				break;
			case 2:                                                        // case 2:Quan ly san pham
				manager.case2();
				break;
			case 3:                                                        //case 3:Thoat
				WriteandReadCategories.writeCategories("D:\\BTJava\\BaiTapLon\\Categories.txt",Manager.Cate);
				WriteandReadProduct.writeProduct("D:\\BTJava\\BaiTapLon\\Product.txt", Manager.Pro);
				System.exit(0);
				break;
			default:
				System.err.println("Lua chon cua ban khong hop le");
			}
		}while(true);

	}
}
