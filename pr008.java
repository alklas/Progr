//Рекурсия
class Factorial {
	int factR(int n) {
		int result;

		if(n==1) return 1;
		result = factR(n-1) * n;
		return result;
	}

	int factI(int n) {
		int t, result;
		result = 1;
		for(t=1; t<=n; t++) 
			result *= t;
		return result;
	}
}
//Статические переменные
class StaticDemo {
	int x;
	static int y;

	int sum() {
		return x + y;
	}
}

class StaticBlock {
	static double rootOf2;
	static double rootOf3;
	static {
		System.out.println("Внутри статического блока");
		rootOf2 = Math.sqrt(2.0);
		rootOf3 = Math.sqrt(3.0);
	}
	StaticBlock(String msg) {
		System.out.println(msg);
	}
}
class Outer {
	int[] nums;
	Outer(int[] n) {
		nums = n;
	}

	void analyze() {
		Inner inOb = new Inner();
		System.out.println("Минимальное значение: " + inOb.min());
		System.out.println("Максимальное значение: " + inOb.max());
		System.out.println("Среднее значение: " + inOb.avg());
	}

	//Внутренний класс
	class Inner {
		int min() {
			int m = nums[0];
			for(int i=1; i<nums.length; i++)
				if(nums[i] < m) m = nums[i];
			return m;
		}
		int max() {
                        int m = nums[0];
                        for(int i=1; i<nums.length; i++)
                                if(nums[i] > m) m = nums[i];
                        return m;
                }
		int avg() {
                        int a = 0;
                        for(int i=0; i<nums.length; i++)
                                a += nums[i];
                        return a/nums.length;
                }
	}
}
class VarArgs {
	static void vaTest(int ... v) {
		System.out.println("Количество аргументов: " + v.length);
		System.out.println("Содержимое массива аргументов: ");
		for(int i=0; i<v.length; i++)
			System.out.println(" аргумент " + i + ": " + v[i]);
		System.out.println();
	}
	static void vaTest2(String msg, int ... v) {
		System.out.println(msg + v.length);
		System.out.println("Содержимое массива аргументов: ");
                for(int i=0; i<v.length; i++)
                        System.out.println(" аргумент " + i + ": " + v[i]);
                System.out.println();
	}
	static void vaTest3( int ... v) {
                System.out.println("vaTest3(int ...)" + " Количество аргументов: " + v.length);
                System.out.println("Содержимое массива аргументов: ");
                for(int i=0; i<v.length; i++)
                        System.out.println(" аргумент " + i + ": " + v[i]);
                System.out.println();
        }
	static void vaTest3(boolean ... v) {
                System.out.println("vaTest3(boolean ...)" +  " Количество аргументов: " + v.length);
                System.out.println("Содержимое массива аргументов: ");
                for(int i=0; i<v.length; i++)
                        System.out.println(" аргумент " + i + ": " + v[i]);
                System.out.println();
        }
	static void vaTest3(String msg, int ... v) {
                System.out.println("vaTest3(String, int ...) " + msg + v.length);
                System.out.println("Содержимое массива аргументов: ");
                for(int i=0; i<v.length; i++)
                        System.out.println(" аргумент " + i + ": " + v[i]);
                System.out.println();
        }
}
class pr008 {
	public static void main(String[] args) {

		Factorial f = new Factorial();

		System.out.println("Вычисление факториала рекурсивным методом");
		System.out.println("Факториал 3 равен " + f.factR(3));
		System.out.println("Факториал 4 равен " + f.factR(4));
		System.out.println("Факториал 5 равен " + f.factR(5));
		
		System.out.println();

		System.out.println("Вычисление факториала итеративным методом");
                System.out.println("Факториал 3 равен " + f.factI(3));
                System.out.println("Факториал 4 равен " + f.factI(4));
                System.out.println("Факториал 5 равен " + f.factI(5));

		//Демонстрация использования статической переменной
		StaticDemo ob1 = new StaticDemo();
		StaticDemo ob2 = new StaticDemo();

		ob1.x = 10;
		ob2.x = 20;

		System.out.println("ob1.x и ob2.x независимы друг от друга");
		System.out.println("ob1.x: " + ob1.x + "\nob2.x " + ob2.x);

		System.out.println();
		
		System.out.println("Статическая переменная y является общей");
		StaticDemo.y = 19;
		System.out.println("Для y = 19");

		System.out.println("ob1.sum(): " + ob1.sum());
		System.out.println("ob2.sum(): " + ob2.sum());

		StaticDemo.y = 100;
                System.out.println("Для y = 100");
		
		System.out.println("ob1.sum(): " + ob1.sum());
                System.out.println("ob2.sum(): " + ob2.sum());

		//Демонстрация работы статического блока
		System.out.println();
		StaticBlock ob = new StaticBlock("Внутри конструктора");

		System.out.println("Квадратный корень из 2: " + StaticBlock.rootOf2);
		System.out.println("Квадратный корень из 3: " + StaticBlock.rootOf3);
		
		System.out.println();
		//Демонстрация работы внутреннего класса
		int[] x = {3, 2, 1, 5, 6, 9, 7, 2};
		Outer outOb = new Outer(x);

		outOb.analyze();

		class ShowBt {
		        int numbits;
		        ShowBt(int n) {
                		numbits = n;
		        }
		        void show(long val) {
                		long mask = 1;
                //Сдвиг влево значения 1
                		mask <<= numbits-1;

                		int spacer = 0;
                		for(;mask!=0;mask>>>=1) {
                        		if((val & mask) != 0)
                                		System.out.print("1");
	                        	else 
						System.out.print("0");
        	                	spacer++;
                	        	if((spacer%8) == 0) {
                        	        	System.out.print(" ");
                                		spacer = 0;
                        		}
                		}
                	System.out.println();
        		}
		}
		System.out.println();
		for(byte b=0; b<10; b++) {
			ShowBt byteval = new ShowBt(8);
			System.out.print(b + " в двоичном виде: ");
			byteval.show(b);
		}

		System.out.println();
		//Демонстрация вызова метода с переменным количеством аргументов

		VarArgs.vaTest(10);
		VarArgs.vaTest(1, 2, 3);
		VarArgs.vaTest();


		System.out.println();
		VarArgs.vaTest2("Один аргумент переменной длины: ", 10);
                VarArgs.vaTest2("Два аргумента переменной длины: ", 1, 2, 3);
                VarArgs.vaTest2("Без аргументов переменной длины ");

		System.out.println();
                VarArgs.vaTest3(10, 20);
                VarArgs.vaTest3("Два аргумента переменной длины: ", 1, 2, 3);
                VarArgs.vaTest3(true, false, false);
	}
}
