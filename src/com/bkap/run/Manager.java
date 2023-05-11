package com.bkap.run;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.bkap.cls.Categories;
import com.bkap.cls.Product;
import com.bkap.cls.WriteandReadCategories;
import com.bkap.cls.WriteandReadProduct;

public class Manager {
	public static List<Categories> Cate = new ArrayList<>();
	public static List<Product> Pro = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	public Manager() {

	}

	public void Case1() {
		boolean check1 = true;
		while (check1) {
			System.out.println("=================Quan ly danh muc cua ban============");
			System.out.println("1.Danh sach danh muc");
			System.out.println("2.Them danh muc");
			System.out.println("3.Xoa danh muc");
			System.out.println("4.Tim kiem danh muc");
			System.out.println("5.Quay lai");
			System.out.println("6.Hien thi chi tiet danh muc");
			System.out.println("Moi ban nhap lua chon cua ban:");
			int LuaChon1_ = Integer.parseInt(sc.nextLine());

			switch (LuaChon1_) {
			case 1: { // case 1.1:Danh sach danh muc
				System.out.println("=============Danh sach danh muc==================");
				System.out.println("1.Danh sach cay danh muc");
				System.out.println("2.Thong tin chi tiet danh muc");
				System.out.println("3.Quay lai");
				System.out.println("Moi ban nhap lua chon cua ban:");
				int LuaChon1_1 = Integer.parseInt(sc.nextLine());
				switch (LuaChon1_1) {
				case 1: // case 1.1.1:Danh sach cay danh muc
					displayCategoriesByParentId(0, Cate, "");
					break;
				case 2: // case 1.1.2:Thong tin chi tiet danh muc
					System.out.println("Moi ban nhap ten danh muc muon hien thi theo ten");
					String Name = sc.nextLine();
					boolean checkName = false;
					for (Categories s : Cate) {
						if (s.getCatalogName().contains(Name)) {
							s.displayData();
							checkName = true;
						}

					}
					if (!checkName) {
						System.err.println("Khong tim thay danh muc co ten tren");
					}
					break;

				case 3: // case 1.1.3 Quay lai
					break;

				default:
					System.err.println("Lua chon cua ban khong hop le");
				}
			}
				break;
			case 2: // case 1.2:Them danh muc
				System.out.println("Moi ban nhap so luong danh muc muon them theo ma danh muc");
				int n = Integer.parseInt(sc.nextLine());
				for (int i = 0; i < n; i++) {
					Categories Ca = new Categories();
					Ca.inputData();
					Cate.add(Ca);
				}
				break;
			case 3: // case 1.3:Xoa danh muc
				System.out.println("Moi ban nhap ma danh muc can xoa theo ma danh muc:");
				int deleteId = Integer.parseInt(sc.nextLine());
				boolean checkdeleteId = false;
				for (Categories s : Cate) {
					if (s.getCatalogId() == deleteId) {
						Cate.remove(s);
						checkdeleteId = true;
						break;
					}
				}
				if (!checkdeleteId) {
					System.out.println("Khong tim thay danh muc ban muon xoa");
				}
				break;

			case 4: // case 1.4:Tim kiem danh muc
				System.out.println("Moi ban nhap ten danh muc muon tim kiem theo ten danh muc");
				String findName = sc.nextLine();
				boolean checkFindName = false;
				for (Categories s : Cate) {
					if (s.getCatalogName().equals(findName)) {
						s.displayData();
						checkFindName = true;
						break;
					}
				}
				if (!checkFindName) {
					System.err.println("Khong tim thay danh muc co ten tren");
				}
				break;
			case 5: // case 1.5:Quay lai
				check1 = false;
				break;
			case 6:
				WriteandReadCategories.readCategories("D:\\BTJava\\BaiTapLon\\Categories.txt");
				for (Categories s : Cate) {
					s.displayData();

				}
				break;
			default:
				System.err.println("Lua chon cua ban khong hop le");
			}
		}

	}

	public void case2() {
		boolean check2 = true;
		while (check2) {
			System.out.println("=============Quan ly san pham==================");
			System.out.println("1.Them san pham moi:");
			System.out.println("2.Tinh loi nhuan sam pham:");
			System.out.println("3.Hien thi thong tin san pham:");
			System.out.println("4.Sap xep san pham:");
			System.out.println("5.Cap nhap thong tin san pham:");
			System.out.println("6.Cap nhap trang thai san pham:");
			System.out.println("7.Quay lai");
			System.out.println("8.Hien thi");
			System.out.println("Moi ban nhap lua chon cua ban:");
			int LuaChon2_ = Integer.parseInt(sc.nextLine());
			switch (LuaChon2_) {
			case 1: // case 2.1:Them san pham moi
				System.out.println("Moi ban nhap so luong san pham muon them");
				int n = Integer.parseInt(sc.nextLine());
				for (int i = 0; i < n; i++) {
					Product pr = new Product();
					pr.inputData();
					Pro.add(pr);
				}
				break;
			case 2: // case 2.2:Tinh loi nhuan san pham
				for (Product s : Pro) {
					s.calProfit();
					s.displayData();
				}
				break;
			case 3: // case 2.3:Hien thi thong tin san pham
				System.out.println("=============Thong tin danh muc==================");
				System.out.println("1.Hien thi san pham theo danh muc");
				System.out.println("2.Hien thi chi tiet san pham");
				System.out.println("3.Quay lai");
				System.out.println("Moi ban nhap lua chon cua ban:");
				int LuaChon2_3_ = Integer.parseInt(sc.nextLine());
				switch (LuaChon2_3_) {
				case 1: // case 2.3.1:Hien thi thong tin theo danh muc
					System.out.println("Moi ban nhap danh muc san pham ban muon tim kiem theo ma danh muc");
					int catelogId = Integer.parseInt(sc.nextLine());
					boolean checkCatelogIdErr=false;
					for (Product s : Pro) {
						if (s.getCatalog().getCatalogId() == catelogId) {
							s.displayData();
							checkCatelogIdErr=true;
							break;
							
						}
					}
					if(!checkCatelogIdErr) {
						System.err.println("Khong tim thay san pham");
					}
					break;
				case 2: // case 2.3.2:Hien thi chi tiet san pham
					System.out.println("Moi ban nhap ten san pham ban muon tim kiem theo ten danh muc");
					String checkProductName = sc.nextLine();
					boolean checkProductNameErr=false;
					for (Product s : Pro) {
						if (s.getProductName().equals(checkProductName)) {
							s.displayData();
							checkProductNameErr=true;
						}
					}
					if(!checkProductNameErr) {
						System.err.println("Khong tim thay san pham");
					}
					break;
				case 3: // case 2.3.3:Quay lai
					break;
				default:
					System.out.println("Lua chon cua ban khong hop le");
				}
				break;
			case 4: { // 2.4:Sap xep san pham
				System.out.println("=============Sap xep san pham==================");
				System.out.println("1.Sap xep san pham theo gia ban tang dan");
				System.out.println("2.Sap xep san pham theo loi nhuan giam dan");
				System.out.println("3.Quay lai");
				System.out.println("Moi ban nhap lua chon cua ban:");
				int LuaChon2_4_ = Integer.parseInt(sc.nextLine());
				switch (LuaChon2_4_) {
				case 1: // case 2.4.1:Sap xep san pham theo gia xuat tang dan
//					for (int i = 1; i < Pro.size()-1; i++) {
//						for (int j = i + 1; j < Pro.size(); j++) {
//							if (Pro.get(i).compareTo(Pro.get(j)) > 0) {
//								Product s = Pro.get(i);
//								Pro.set(i, Pro.get(j));
//								Pro.set(j, s);
//
//							}
//						}
//					}
					Collections.sort(Pro, new Comparator<Product>() {
						@Override
						public int compare(Product p1, Product p2) {
							if (p1.getExportPrice() > p2.getExportPrice()) {
								return 1;
							} else if (p1.getExportPrice() < p2.getExportPrice()) {
								return -1;
							}
							return 0;
						}
					});
					for (Product s : Pro) {
						s.displayData();
					}
					break;
				case 2: // case 2.4.2:Sap xep san pham theo loi nhuan giam dan
//					for (int i = 1; i < Pro.size(); i++) {
//						for (int j = i + 1; j < Pro.size(); j++) {
//							if (Pro.get(i).getProfit() < Pro.get(j).getProfit()) {
//								Product s = Pro.get(i);
//								Pro.set(i, Pro.get(j));
//								Pro.set(j, s);
//
//							}
//						}
//					}
					Collections.sort(Pro, new Comparator<Product>() {
						@Override
						public int compare(Product p1, Product p2) {
							if (p1.getProfit() > p2.getProfit()) {
								return -1;
							} else if (p1.getProfit() < p2.getProfit()) {
								return 1;
							}
							return 0;
						}
					});
					for (Product s : Pro) {
						s.displayData();
					}
					break;
				case 3: // case 2.4.3:Quay lai
					break;
				default:
					System.out.println("Lua chon cua ban khong hop le");
				}
			}
				break;
			case 5: // case 2.5:Cap nhap thong tin san pham theo ma san pham
				System.out.println("Moi ban nhap ma san pham cua san pham ban muon cap nhap");
				String checkProductId = sc.nextLine();
				boolean CheckProductIdErr = false;
				for (Product s : Pro) {
					if (s.getProducId().equals(checkProductId)) {
						System.out.println("Moi ban cap nhap lai ten san pham");
						s.setProductName(sc.nextLine());
						System.out.println("Moi ban cap nhap lai mo ta san pham");
						s.setTitle(sc.nextLine());
						System.out.println("Moi ban cap nhap lai gia nhap san pham");
						s.setImportPrice(Float.parseFloat(sc.nextLine()));
						System.out.println("Moi ban cap nhap lai gia xuat san pham");
						s.setExportPrice(Float.parseFloat(sc.nextLine()));
						System.out.println("Moi ban cap nhap lai trang thai san pham");
						s.setProductStatus(Boolean.parseBoolean(sc.nextLine()));
						System.out.println("Moi ban cap nhap lai mo ta san pham");
						s.setDescriptions(sc.nextLine());
						s.displayData();
						CheckProductIdErr = true;
						break;
					}
				}

				if (!CheckProductIdErr) {
					System.out.println("Khong tim san pham de cap nhap");
				}
				break;
			case 6: // case 2.6:Cap nhap trang thai san pham theo ma san pham
				System.out.println("Moi ban nhap ma san pham cua san pham ban muon cap nhap");
				String checkProductID = sc.nextLine();
				boolean CheckProductIDErr = false;
				for (Product s : Pro) {
					if (s.getProducId().equals(checkProductID)) {
						System.out.println("Moi ban cap nhap lai trang thai san pham");
						s.setProductStatus(Boolean.parseBoolean(sc.nextLine()));
						s.displayData();
						CheckProductIDErr = true;
						break;
					}
				}

				if (!CheckProductIDErr) {
					System.err.println("Khong tim san pham de cap nhap");
				}
				break;
			case 7: // case 2.7:Quay lai
				check2 = false;
				break;
			case 8:
				WriteandReadProduct.readProduct("D:\\BTJava\\BaiTapLon\\Product.txt");
				for (Product s : Pro) {
					s.displayData();
				}
				break;
			default:
				System.err.println("Lua chon cua ban khong hop le");
			}
		}

	}

	public static int checkLevel(int parentId1) {
		int level = 1;
		Categories Cate1 = Cate.stream().filter(x -> x.getCatalogId() == parentId1).findFirst().orElse(null);
		if (Cate1 != null) {
			level += checkLevel(Cate1.getParentId());
		}
		return level;
	}

	public static Categories findCategories(int categoriesId) {
		Categories categories = null;
		for (Categories s : Cate) {
			if (s.getCatalogId() == categoriesId) {
				categories = s;
			}
		}
		return categories;
	}

	public static void displayCategoriesByParentId(int parentId, List<Categories> categories, String prefix) {
		int count = 0;
		for (Categories category : categories) {
			if (category.getParentId() == parentId) {
				String index = prefix + (count + 1);
				System.out.println(index + "." + category.getCatalogName());
				count++;
				displayCategoriesByParentId(category.getCatalogId(), categories, index + ".");
			}
		}
	}
}
