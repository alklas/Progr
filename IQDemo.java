class IQDemo {
	public static void main(String[] args) {
		FixedQueue q1 = new FixedQueue(10);
		CircularQueue q2 = new CircularQueue(10);
		ICharQ iQ;
		char ch;
		int i;
		iQ = q1;
		for (i=0; i<10; i++)
			iQ.put((char)('A' + i));
		System.out.print("Содержимое фиксированной очереди: ");
		for (i=0; i < 10; i++) {
			ch = iQ.get();
			System.out.print(ch);
		}
		System.out.println();

		iQ = q2;
		for (i=0; i<10; i++)
                        iQ.put((char)('A' + i));
                System.out.print("Содержимое кольцевой очереди: ");
                for (i=0; i < 10; i++) {
                        ch = iQ.get();
                        System.out.print(ch);
                }
                System.out.println();
	}
}
