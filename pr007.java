// Управление доступом к членам класса
class Mod {
	private int alpha; //закрытая переменная
                public int beta; // открытая переменная
                int gamma; // переменная с доступом по умолчанию
                void setAlpha(int a) {
                        alpha = a;
                }
                int getAlpha() {
                        return alpha;
                }

}
//Пример передачи объектов методам
class Block {
	int a, b, c;
	int V;

	Block(int i, int j, int k) {
		a = i;
		b = j;
		c = k;
		V = a * b * c;
	}

	//Проверка эквивалентности двух параллелипипедов
	boolean sameBlock(Block ob) {
		if((ob.a == a) & (ob.b == b) & (ob.c == c)) return true;
		else return false;
	}

	//Проверка равенства объёмов
	boolean sameV(Block ob) {
		if(ob.V == V) return true;
		else return false;
	}
}
//Класс отказоустойчивого массива
class FailSoftArray {
	private int[] a;
	private int errval;
	public int length;

	public FailSoftArray(int size, int errv) {
		a = new int[size];
		errval = errv;
		length = size;
	}

	public int get(int index) {
		if(indexOK(index)) 
			return a[index];
		return errval;
	}
	public boolean put(int index, int val) {
		if(indexOK(index)) {
			a[index] = val;
			return true;
		}
		return false;
	}

	private boolean indexOK(int index) {
		if(index >=0 & index < length) 
			return true;
		return false;
	}
}
//Класс для вызова метода с передачей параметров по значению
class CallByValue {
	void noChange(int i11, int j11) {
		i11 = i11 + j11;
		j11 = -j11;
	}
}
//Класс для вызова метода с передачей параметров по ссылке
class CallByRef {
	int a12, b12;
	CallByRef (int i12, int j12){
		a12 = i12;
		b12 = j12;
	}

	void change(CallByRef ob5) {
                ob5.a12 = ob5.a12 + ob5.b12;
                ob5.b12 = -ob5.b12;
        }
}
//Класс для возвращения объекта в виде строки при возврате из метода
class ErrorMsg {
	String[] msgs = {
		"Ошибка вывода",
		"Ошибка ввода", 
		"Переполнение диска",
		"Выход индекса за границы диапазона"
	};
	//Возврат сообщения об ошибке
	String getErrorMsg(int i13) {
		if(i13>=0 & i13<msgs.length) return msgs[i13];
		else return "Отсутствует код для ошибки";
	}
}

//Возврат объекта, определённого в программе
class Err {
	String msg; //сообщение об ошибке
	int severity; //уровень серьёзности ошибки
	Err(String m, int s) {
		msg = m; 
		severity = s;
	}
}
class ErrorInfo {
	String[] msgs2 = {
                "Ошибка вывода",
                "Ошибка ввода",
                "Переполнение диска",
                "Выход индекса за границы диапазона"
        };
	int[] howBad = {3, 3, 2, 4};
	Err getErrorInfo(int i14) {
		if(i14 >= 0 & i14 < msgs2.length)
			return new Err(msgs2[i14], howBad[i14]);
		else 
			return new Err("Отсутствует код для ошибки", 0);
	}
}

class pr007 {
	public static void main(String[] args) {
		Mod ob = new Mod();
		//Изменение и просмотр значения закрытой переменной осуществляется через методы, заданные внутри класса Mod
		ob.setAlpha(77);
		System.out.println("Значение ob.alpha: " + ob.getAlpha());

		//Прямой доступ к переменной запрещён: ob.alpha = 100;
		ob.beta = 242;
		ob.gamma = 34;

		//Пример использования класса отказоустойчивого поведения массива
		System.out.println();
		FailSoftArray fs = new FailSoftArray(5, -999);
		int x;

		// Пример работы класса без вывода сообщений о неправильных индексах

		System.out.println("Скрытая от пользователя обработка ошибок:");
		for(int i=0; i<(fs.length * 2); i++)
			fs.put(i, i*10);

		for(int i=0; i < (fs.length * 2); i++) {
			x = fs.get(i);
			if(x != -999) System.out.print(x + " ");
		}
		System.out.println();

		// Пример работы класса с выводом сообщений об ошибках
		
		for(int i=0; i<(fs.length * 2); i++)
			if(!fs.put(i, i*10))
				System.out.println("Индекс " + i + " выходит за границы массива");

		for(int i=0; i < (fs.length * 2); i++) {
                        x = fs.get(i);
                        if(x != -999) System.out.print(x + " ");
			else 
				System.out.println("Индекс " + i + " выходит за границы массива");
                }

		System.out.println();

		//Пример использования методов класса с параметрами в виде объектов (Класс Block)
		System.out.println();
		Block ob1 = new Block(10, 2, 5);
		Block ob2 = new Block(10, 2, 5);
		Block ob3 = new Block(4, 5, 5);
		System.out.println("ob1 эквивалентен по размерам ob2: " + ob1.sameBlock(ob2));
		System.out.println("ob1 эквивалентен по размерам ob3: " + ob1.sameBlock(ob3));
		System.out.println("ob1 эквивалентен по объёму ob3: " + ob1.sameV(ob3));

		//Пример передачи параметров объекту по значению
		System.out.println();
		CallByValue ob4 = new CallByValue();
		int a11 = 15, b11 = 20;

		System.out.println("a11 и b11 перед вызовом: " + a11 + " " + b11);

		ob4.noChange(a11, b11);
		System.out.println("a11 и b11 после вызова метода ob4.noChange: " + a11 + " " + b11);
		//При передаче параметров методу объекта по значению, значение аргументов не изменяются
		
		//Пример передачи параметров по ссылке
		System.out.println();
		CallByRef ob6 = new CallByRef(15, 20);

		System.out.println("ob6.a12 и ob6.b12 перед вызовом: " + ob6.a12 + " " + ob6.b12);
		ob6.change(ob6);
		System.out.println("ob6.a12 и ob6.b12 после вызова метода ob6.Change: " + ob6.a12 + " " + ob6.b12);

		System.out.println();
		//Пример возврата строки при выполнении метода
		ErrorMsg err = new ErrorMsg();

		System.out.println(err.getErrorMsg(2));
		System.out.println(err.getErrorMsg(20));

		System.out.println();
		//Пример возврата произвольного объекта, определённого в программе
		ErrorInfo err2 = new ErrorInfo();
	       	Err e;
		e = err2.getErrorInfo(2);
		System.out.println(e.msg + ", уровень серьёзности: " + e.severity);
		e = err2.getErrorInfo(20);
                System.out.println(e.msg + ", уровень серьёзности: " + e.severity);

	}
}
