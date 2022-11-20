package org.dgp;

/**
 * demonstrate the use of dynamic object composition
 * as used by the Decorator design pattern.
 * where an object can by composed of a dynamic set of decorator objects
 * and which set can be determined at run-time.
 * 
 * @author dgpeters
 *
 */
public class DemoObjectComposition {
	private int count = 0;
	/**
	 * AlphaSetAPI for each set of alphabetic letters
	 * 
	 * @author dgpeters
	 *
	 */
	public interface AlphaSetAPI {
		/**
		 * get a String description of the Alpha Set
		 * 
		 * @return	String description of Alpha Set
		 */
		String getAlphaSet();
	}
	/**
	 * class AtoZAlphaSet is an example set of alphabetic characters.
	 * 
	 * @author dgpeters
	 *
	 */
	public class AtoZAlphaSet implements AlphaSetAPI {
		public static final String AtoZ_ALPHASET_DESCRIPTION = "A to Z (26)";

		@Override
		public String getAlphaSet() {
			return AtoZ_ALPHASET_DESCRIPTION;
		}
	}
	/**
	 * AlphaSetDecoratorAPI IS-A AlphaSetAPI and is used by each Alpha decorator
	 * which is added to make an Alpha Set dynamically through object composition
	 * by use of the Decorator design pattern.
	 * 
	 * @author dgpeters
	 *
	 */
	public abstract class AlphaSetDecoratorAPI implements AlphaSetAPI {
		@Override
		public String getAlphaSet() {
			return "AlphaSet";
		}

		@Override
		public String toString() {
			return this.getAlphaSet();
		}
	}
	
	/**
	 * class A IS-A AlphaSetDecoratorAPI used to make an Alpha Set dynamically through object composition
	 * by use of the Decorator design pattern.
	 * @author dgpeters
	 *
	 */
	public class A extends AlphaSetDecoratorAPI {
		public static final String A_DESCRIPTION = ", A";
		/**
		 * AlphaSet object to be decorated with dynamic extensions
		 */
		private final AlphaSetAPI alphaSet;
		
		public A(AlphaSetAPI obj) {
			this.alphaSet = obj;
		}
		
		/**
		 * Add to the existing AlphaSet getAlphaSet method.
		 * 
		 * This decorator will override this AlphaSet getAlphaSet method,
		 * extending the functionality by
		 * adding it's own custom version which will append this specific alpha char
		 * description to the existing AlphaSet getAlphaSet.
		 */
		@Override
		public String getAlphaSet() {
			return alphaSet.getAlphaSet() + A_DESCRIPTION;
		}
	}

	/**
	 * class B IS-A AlphaSetDecoratorAPI used to make an Alpha Set dynamically through object composition
	 * by use of the Decorator design pattern.
	 * @author dgpeters
	 *
	 */
	public class B extends AlphaSetDecoratorAPI {
		public static final String B_DESCRIPTION = ", B";
		/**
		 * AlphaSet object to be decorated with dynamic extensions
		 */
		private final AlphaSetAPI alphaSet;

		public B(AlphaSetAPI obj) {
			this.alphaSet = obj;
		}

		/**
		 * Add to the existing AlphaSet getAlphaSet method.
		 * 
		 * This decorator will override this AlphaSet getAlphaSet method,
		 * extending the functionality by
		 * adding it's own custom version which will append this specific alpha char
		 * description to the existing AlphaSet getAlphaSet.
		 */
		@Override
		public String getAlphaSet() {
			return alphaSet.getAlphaSet() + B_DESCRIPTION;
		}
	}
	
	/**
	 * class C IS-A AlphaSetDecoratorAPI used to make an Alpha Set dynamically through object composition
	 * by use of the Decorator design pattern.
	 * @author dgpeters
	 *
	 */
	public class C extends AlphaSetDecoratorAPI {
		public static final String C_DESCRIPTION = ", C";
		/**
		 * AlphaSet object to be decorated with dynamic extensions
		 */
		private final AlphaSetAPI alphaSet;
		
		public C(AlphaSetAPI obj) {
			this.alphaSet = obj;
		}
		
		/**
		 * Add to the existing AlphaSet getAlphaSet method.
		 * 
		 * This decorator will override this AlphaSet getAlphaSet method,
		 * extending the functionality by
		 * adding it's own custom version which will append this specific alpha char
		 * description to the existing AlphaSet getAlphaSet.
		 */
		@Override
		public String getAlphaSet() {
			return alphaSet.getAlphaSet() + C_DESCRIPTION;
		}
	}
	
	/**
	 * getCount() is a simple recursive method.
	 * @param myCount
	 * @return
	 */
	public int getCount(int myCount) {
		return myCount +1;
	}
	
	/**
	 * showRecursiveCounting is a simple method demonstrating recursion
	 * in comparison with looping
	 */
	public void showRecursiveCounting() {
		/*
		 * Loop implementation: 
		 * 1. saves stack memory
		 * 2. easier to debug
		 */
		{
			int n = 0;
			for (int i=0; i<3; i++) {
				n = getCount(n);
			}
			System.out.println(n);
		}
		/**
		 * Recursive implementation:
		 * 1. uses more stack memory for recursive calls
		 * 2. less code, very dense compact.
		 */
		{
			int n = 0;
			n = getCount( getCount( getCount(this.count)));
			System.out.println(n);
		}
	}
	
	/**
	 * Dynamically compose a NEW object by using object composition
	 * through repeated application of a Decorator object to 
	 * Modify the original object to have new behavior
	 * ALL DONE AT RUN-TIME without writing new classes.
	 */
	public void showAlphaSet() {
		/**
		 * Start with object from class AtoZAlphaSet,
		 * then apply in order the following decorators:
		 * 1. A
		 * 2. B
		 * 3. C
		 */
		System.out.println(new C(new B(new A(new AtoZAlphaSet()))));
		
		/**
		 * Start with object from class AtoZAlphaSet,
		 * then apply in order the following decorators:
		 * 1. A
		 * 2. B
		 * 3. C
		 */
		AlphaSetAPI objectAlphaSet = new AtoZAlphaSet(); // orig object
		objectAlphaSet  = new A(objectAlphaSet); 		 // decorate with A
		objectAlphaSet  = new B(objectAlphaSet); 		 // decorate with B
//		objectAlphaSet  = new C(objectAlphaSet); 		 // decorate with C
		System.out.println(objectAlphaSet);	// show object composition
		
		/**
		 * Start with object from class AtoZAlphaSet,
		 * then apply in order the following decorators:
		 * 1. C
		 * 2. B
		 * 3. A
		 */
		System.out.println(new A(new B(new C(new AtoZAlphaSet()))));
	}
	
	public static void demo() {
		System.out.println(DemoObjectComposition.class.getName() + ".demo()...");
		
		DemoObjectComposition obj = new DemoObjectComposition();
		obj.showRecursiveCounting();

		obj.showAlphaSet();
		System.out.println(DemoObjectComposition.class.getName() + ".demo()... done!");
	}
}
