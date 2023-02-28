package application;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;
public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> product = new ArrayList<>();
		System.out.print("Enter the number of products:");
		int p = sc.nextInt();
		
		
		for (int i = 1; i <=p; i++) {
			sc.nextLine();
			System.out.print("Common, used or imported (c/u/i)?");
			
			char c = sc.next().charAt(0);
			sc.nextLine();
			if(c == 'i') {
				System.out.print("Name: ");
				
				String name = sc.nextLine();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				System.out.print("Customs fee:");
				double customsFee = sc.nextDouble();
				
				product.add(new ImportedProduct(name,price,customsFee) );
				
			}
			
			else if (c == 'c') {
				System.out.print("Name: ");
				
				String name = sc.nextLine();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				product.add(new Product(name,price));
			}else {
				System.out.print("Name: ");
				
				String name = sc.nextLine();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufacture = sdf.parse(sc.next());
				product.add(new UsedProduct(name,price,manufacture));
				
			}
			
			
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		
		for(Product pd: product) {
			System.out.println(pd.priceTag());
		}

		
		sc.close();

	}

}
