class CircularQueue implements ICharQ {
	private char[] q;
        private int putloc, getloc; //указатели на элементы очереди

        //Конструктор, создающий очередь на базе массива с размером size
        public CircularQueue (int size) {
                q = new char[size+1];
                putloc = getloc = 0;
        }
	//Метод для помещения символа в очередь
        public void put(char ch) {
                if((putloc+1==getloc) | ((putloc == q.length-1) & (getloc == 0))) {
                        System.out.println(" - невозможно вставить символ, так как очередь переполнена.");
                        return;
                }
                q[putloc++] = ch;
		if(putloc == q.length) //Организация "кольца"
			putloc = 0; 
        }

        //Метод для извлечения символа из очереди
        public char get() {
                if(getloc == putloc) {
                        System.out.println(" - невозможно извлечь символ, так как очередь пуста");
                        return (char) 0;
                }
		char ch = q[getloc++];
		if(getloc == q.length) //Организация "кольца"
                        getloc = 0;

                return ch;
        }
}
