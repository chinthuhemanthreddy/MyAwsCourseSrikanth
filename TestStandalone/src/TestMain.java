import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class TestMain {
	private static ExecutorService emailExecutor = Executors.newSingleThreadExecutor();

	public static void main(String[] args) throws ParseException {
		  // getData();
		//testMap();
		HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();

		//int i =0;

		//int j = hm.get(i);
		
		StreamProducts();
		    }
	private static void testMap() {

		Map<Integer,Integer> installmentSeqDetailseMap = new HashMap<Integer, Integer>();
		installmentSeqDetailseMap.put(1,1);
		
		System.out.println("before null...");
		Integer n = installmentSeqDetailseMap.get(null);
		System.out.println("hfskdjhsdaf "+n);
		Map<Integer,String> documentDetailseMap = new HashMap<Integer, String>();
		documentDetailseMap.put(1,"Srikanth");
		String s =documentDetailseMap.get(n);
		System.out.println("fsadfd ::: "+s);
	}
	private static void getData() {
	    List<Future<String>> futures = new ArrayList<>();
	    
	   
	    for (int i = 0; i < 5; i++) {
	        final Future<String> future = emailExecutor.submit(new MyInfoCallable(i));
	        futures.add(future);
	    }
	    for (Future<String> f : futures) {
	        try {
	            System.out.println(f.get());
	        } catch (Exception ex) {
	        }
	    }
	}

	public static String getMYInfo(int i) {
	    String somevav = "success";
	    if (i == 0) {
	        somevav = "success";
	    } else {
	        somevav = "fail";
	    }
	    return somevav;
	}

	private static class MyInfoCallable implements Callable<String> {

	    int i;

	    public MyInfoCallable(int i) {
	        this.i = i;
	    }

	    @Override
	    public String call() throws Exception {
	        return getMYInfo(i);
	    }

	}
	
	static void StreamProducts(){
		
		  List<Product> productsList = new ArrayList<Product>();  
	        //Adding Products  
	        productsList.add(new Product(1,"HP Laptop",25000f));  
	        productsList.add(new Product(2,"Dell Laptop",30000f));  
	        productsList.add(new Product(3,"Lenevo Laptop",28000f));  
	        productsList.add(new Product(4,"Sony Laptop",2800f));  
	        productsList.add(new Product(5,"Apple Laptop",90000f));  
	        List FilterList = productsList.stream().filter(i->i.getPrice()>3000).collect(Collectors.toList()); 
	       System.out.println(FilterList); 
	}
}