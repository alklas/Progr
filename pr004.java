class Avtomobil {
	int pass; //количество пассажиров
	int v; //объём топливного бака в л.
	double rash; //расход топлива в л. на 100 км.
	
	void rasst() {
		System.out.println("Расстояние на полном баке: " + ((int)(v/rash *100)));
	}
}
class pr004 {
	public static void main(String args[]) {
		//Создание экземпляра класса
		Avtomobil lada = new Avtomobil();
		Avtomobil porshe = new Avtomobil();
		int rasst, rasst2;

		//Присваивание значений внутренним переменным экземпляра класса
		lada.pass = 4;
		lada.v = 40;
		lada.rash = 5.5;

		porshe.pass = 1;
	       	porshe.v = 100;
		porshe.rash = 14.0;

		/*
		Avtomobil mercedes;	

		mercedes = porshe;
		System.out.println("rash для Mercedes: " + mercedes.rash);
		mercedes.rash = 18.0;
		System.out.println("rash для Porshe: " + porshe.rash);
		*/
		
		//Расчёт расстояния, которое lada проедет на полном баке
		//rasst = (int) (lada.v/lada.rash * 100);
		//rasst2 = (int) (porshe.v/porshe.rash * 100);

		System.out.print("Для Lada: " );
		lada.rasst();

		System.out.print("Для Porshe: ");
		porshe.rasst();
	}
}
