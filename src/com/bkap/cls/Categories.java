package com.bkap.cls;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bkap.ExceptionCustom.ExceptionCustom;
import com.bkap.itf.ICategories;
import com.bkap.run.Manager;

public class Categories implements ICategories, Serializable {
	static final long serialVersionUID=1L;
	private int catalogId;
	private String catalogName;
	private String descriptions;
	private boolean catalogStatus;
	private int parentId;

	public Categories() {

	}

	public Categories(int catalogId, String catalogName, String descriptions, boolean catalogStatus, int parentId) {
		super();
		this.catalogId = catalogId;
		this.catalogName = catalogName;
		this.descriptions = descriptions;
		this.catalogStatus = catalogStatus;
		this.parentId = parentId;
	}

	public int getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}

	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public boolean isCatalogStatus() {
		return catalogStatus;
	}

	public void setCatalogStatus(boolean catalogStatus) {
		this.catalogStatus = catalogStatus;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	@Override
	public void inputData() {
		Scanner sc = new Scanner(System.in);

		boolean check = false; // checkId

		do {
			try {
				System.out.println("Moi ban nhap id cua danh muc:");
				catalogId = Integer.parseInt(sc.nextLine());
				if (catalogId < 0) {
					throw new Exception();
				}
				for (Categories s : Manager.Cate) {
					if (s.getCatalogId() == catalogId) {
						throw new ExceptionCustom("Danh muc da ton tai");
					}
				}

				check = true;
			} catch (NumberFormatException e) {
				System.err.println("Id ban phai nhap la so");
			} catch (ExceptionCustom e) {
				System.err.println(e.getMessage());
			} catch (Exception e) {
				System.err.println("Id phai nhap so lon hon 0");

			}

		} while (!check);
		boolean checkName = false; // checkName
		do {
			try {
				System.out.println("Moi ban nhap ten danh muc:");
				catalogName = sc.nextLine();
				if (catalogName.length() < 6 || catalogName.length() > 30) {
					throw new Exception();
				}
				checkName = true;
			} catch (Exception e) {
				System.err.println("Ten cua danh muc phai nhap tu 6-30 ky tu");
			}
		} while (!checkName);
		boolean checkDescription = false; // checkDescription
		do {
			try {
				System.out.println("Moi ban nhap mo ta:");
				descriptions = sc.nextLine();
				if (descriptions == "") {
					throw new Exception();
				}
				checkDescription = true;
			} catch (Exception e) {
				System.err.println("Mo ta ban khong duoc de trong");
			}
		} while (!checkDescription);
		
		boolean checkCatalogStatus = false; // checkStatus
		do {
			System.out.println("Trang thai: ");
			System.out.println("\t1. Hoat dong");
			System.out.println("\t2. Khong hoat dong");
			System.out.println("Moi ban nhap trang thai:");
			int status = Integer.parseInt(sc.nextLine());

			if (status == 1 || status == 2) {
				if (status == 1)
					catalogStatus = true;
				else
					catalogStatus = false;

				checkCatalogStatus = true;
			} else {
				System.err.println("Nhap sai! Moi nhap lai");
			}

		} while (!checkCatalogStatus);
		
		boolean checkParentId = false;
		do {
			try {
				System.out.println("Moi ban nhap parentId");
				parentId = Integer.parseInt(sc.nextLine());
				System.out.println("Level cua danh muc la:"+Manager.checkLevel(parentId));
				if (Manager.checkLevel(parentId) > 3) {
					throw new Exception();
				}
				checkParentId = true;
			} catch (Exception e) {
				System.out.println("Moi ban nhap lai parentId");
			}
		} while (!checkParentId);
	}
	@Override
	public String toString() {
		String status = catalogStatus == true ? "Hoat dong" : "Khong hoat dong";
		return "\nMa danh muc la:"+catalogId+"\nTen danh muc:" + catalogName+"\nMo ta :" 
		+ descriptions+"\nTrang thai:" + status+"\nDanh muc cha:" + parentId;
	}
	
	@Override
	public void displayData() {
		
		String status = catalogStatus == true ? "Hoat dong" : "Khong hoat dong";
		System.out.println("Thong tin cua danh muc la:");
		System.out.println("Ma danh muc:" + catalogId);
		System.out.println("Ten danh muc:" + catalogName);
		System.out.println("Mo ta :" + descriptions);
		System.out.println("Trang thai:" + status);
		System.out.println("Danh muc cha:" + parentId);

	}

}
