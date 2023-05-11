package com.bkap.cls;

import java.io.Serializable;
import java.util.Scanner;

import com.bkap.ExceptionCustom.ExceptionCustom;
import com.bkap.itf.IProduct;
import com.bkap.run.Manager;

public class Product implements IProduct,Serializable{
	static final long serialVersionUID=1L;
	private String producId;
	private String productName;
	private String title;
	private float importPrice;
	private float exportPrice;
	private float profit;
	private String descriptions;
	private boolean productStatus;
	private Categories catalog;
	public Product() {
		super();
	}
	public Product(String producId, String productName, String title, float importPrice, float exportPrice,
			String descriptions, boolean productStatus, Categories catalog) {
		super();
		this.producId = producId;
		this.productName = productName;
		this.title = title;
		this.importPrice = importPrice;
		this.exportPrice = exportPrice;
		this.descriptions = descriptions;
		this.productStatus = productStatus;
		this.catalog = catalog;
	}
	public String getProducId() {
		return producId;
	}
	public void setProducId(String producId) {
		this.producId = producId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getImportPrice() {
		return importPrice;
	}
	public void setImportPrice(float importPrice) {
		this.importPrice = importPrice;
	}
	public float getExportPrice() {
		return exportPrice;
	}
	public void setExportPrice(float exportPrice) {
		this.exportPrice = exportPrice;
	}
	public float getProfit() {
		return this.profit;
	}
	public void setProfit(float profit) {
		this.profit = profit;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public boolean isProductStatus() {
		return productStatus;
	}
	public void setProductStatus(boolean productStatus) {
		this.productStatus = productStatus;
	}
	public Categories getCatalog() {
		return catalog;
	}
	public void setCatalog(Categories catalog) {
		this.catalog = catalog;
	}
	@Override
	public void inputData() {
		Scanner sc=new Scanner(System.in);
		boolean checkProductId=false;
		do {
			try {
				System.out.println("Moi ban nhap Id cua san pham:");
				producId=sc.nextLine();
				if(producId.length()==4 && producId.charAt(0)=='C') {}
				else {throw new Exception();}
				for(Product s: Manager.Pro) {
					if(s.getProducId().compareTo(producId)==0) {
						throw new ExceptionCustom("San pham da ton tai");
					}
				}
				checkProductId=true;
			}catch(ExceptionCustom e) {
				System.out.println(e.getMessage());
			}catch(Exception e) {
				System.err.println("Ma san pham bao gom 4 ky tu va bat dau bang chu 'C'");
			}
		}while(!checkProductId);
		boolean checkNameProduct=false;
		do {
			try {
				System.out.println("Moi ban nhap ten san pham:");
				productName=sc.nextLine();
				if(productName.length()>50 || productName.length()<6) {
					throw new Exception();
				}
				for(Product s: Manager.Pro) {
					if(s.getProductName().compareTo(productName)==0) {
						throw new ExceptionCustom("San pham da ton tai");
					}
				}
				checkNameProduct=true;
			}catch(ExceptionCustom e) {
				System.err.println(e.getMessage());
			}catch(Exception e) {
				System.err.println("Ten san pham phai tu 6 den 50 ky tu");
			}
		}while(!checkNameProduct);
		boolean checktitle=false;
		do {
			try {
				System.out.println("Moi ban nhap tieu de san pham");
				title=sc.nextLine();
				if(title.length()>30 || title.length()<6) {
					throw new Exception();		
				}
				checktitle = true;
			} catch (Exception e) {
				System.out.println("Tieu de san pham phai tu 6 den 30 ky tu");
			}
		} while (!checktitle);
		boolean checkimportPrice=false;
		do {
			try {
				System.out.println("Moi ban nhap gia nhap san pham");
				importPrice=Float.parseFloat(sc.nextLine());
				if(importPrice<0) {
					throw new Exception();
				}
				checkimportPrice=true;
			} catch (NumberFormatException e) {
				System.err.println("Gia nhap cua san pham phai la so thuc");
			} catch (Exception e) {
				System.err.println("Gia nhap phai lon hon 0 ");
			}
		} while (!checkimportPrice);	
		boolean checkexportPrice=false;
		do {
			try {
				System.out.println("Moi ban nhap gia ban san pham");
				exportPrice=Float.parseFloat(sc.nextLine());
				if(exportPrice < MIN_INTEREST_RATE*importPrice+importPrice) {
					throw new Exception();
				}
				checkexportPrice=true;
			} catch (NumberFormatException e) {
				System.err.println("Gia ban cua san pham phai la so thuc");
			} catch (Exception e) {
				System.err.println("Gia ban phai lon hon gia nhap la MIN_INTEREST_RATE lan ");
			}
		} while (!checkexportPrice);
		boolean checkdescription=false;
		do {
			try {
				System.out.println("Moi ban nhap mo ta san pham");
				descriptions=sc.nextLine();
				if(descriptions=="") {
					throw new Exception();
				}
				checkdescription=true;
			}catch (Exception e) {
				System.err.println("Mo ta khong duoc de trong");
			}
		} while (!checkdescription);
		boolean checkProductStatus = false; // checkStatus
		do {
			System.out.println("Trang thai: ");
			System.out.println("\t1. Hoat dong");
			System.out.println("\t2. Khong hoat dong");
			System.out.println("Moi ban nhap trang thai:");
			int status = Integer.parseInt(sc.nextLine());
			
			if(status == 1 || status == 2) {
				if(status == 1) productStatus = true;
				else productStatus = false;
				
				checkProductStatus = true;
			} else {
				System.out.println("Nhap sai! Moi nhap lai");
			}
			
		} while (!checkProductStatus);
		boolean checkCatalog=false;
		do {
			try {
				System.out.println("Moi ban nhap id catalog:");
				 int catalogId=Integer.parseInt(sc.nextLine());
				if(Manager.findCategories(catalogId)!=null) {
					catalog=Manager.findCategories(catalogId);
				}else {
					throw new Exception();
				}
				checkCatalog=true;
			} catch (Exception e) {
				System.err.println("Id nay khong ton tai:");
			}
		} while (!checkCatalog);
	}
	
	@Override
	public void displayData() {
		String status = productStatus== true ? "Hoat dong" : "Khong hoat dong";

		System.out.println("Thong tin cua san pham la:");
		System.out.println("Ma san pham:" + producId);
		System.out.println("Ten san pham:" + productName);
		System.out.println("Mo ta :" + descriptions);
		System.out.println("Trang thai:" + status);
		System.out.println("Tieu de san pham:" + title);
		System.out.println("Gia nhap san pham:" + importPrice);
		System.out.println("Gia ban san pham:" + exportPrice);
		System.out.println("Loi nhuan cua san pham:" + profit);
		System.out.println("Catalog cua san pham:" + catalog);
	}
	
	
	@Override
	public void calProfit() {
		profit=exportPrice-importPrice;
	}
}
