class FixedQueue implements ICharQ {
	private char[] q;
        private int putloc, getloc; //указатели на элементы очереди

        //Конструктор, создающий очередь на базе массива с размером size
        public FixedQueue (int size) {
                q = new char[size];
                putloc = getloc = 0;
        }
	//Метод для помещения символа в очередь
        public void put(char ch) {
                if(putloc==q.length) {
                        System.out.println(" - невозможно вставить символ, так как очередь переполнена.");
                        return;
                }
                q[putloc++] = ch;
        }

        //Метод для извлечения символа из очереди
        public char get() {
                if(getloc == putloc) {
                        System.out.println(" - невозможно извлечь символ, так как очередь пуста");
                        return (char) 0;
                }
                return q[getloc++];
        }
}
