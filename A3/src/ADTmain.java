public class ADTmain {

	public static void main(String[] args) {

		TestCases();

	}

	public static void TestCases() {

		ADTQueue<Integer, Integer> aDTQueue = new ADTQueue<>();

		int[] PQ_Key = { 2, 4, 6, 8, 5, 98, 45, 12, 78, 98, 35, 67, 22, 10, 20, 30, 40 };
		int[] PQ_Value = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17 };

		int length = PQ_Key.length;
		for (int index = 0; index < length; index++) {
			aDTQueue.insert(PQ_Key[index], PQ_Value[index]);
			aDTQueue.printArray();
		}

		System.out.println("isEmpty ==> " + aDTQueue.isEmpty());

		aDTQueue.printArray();

		System.out.println("removeTop ==>");

		aDTQueue.removeTop();

		System.out.println("State ==> " + aDTQueue.state());

		System.out.println("insert ==>");

		aDTQueue.insert(50, 18);

		System.out.println("TOP ==> " + aDTQueue.top());

		aDTQueue.printArray();

		System.out.println("isEmpty ==> " + aDTQueue.isEmpty());

		System.out.println("Size ==> " + aDTQueue.size());

		System.out.println("remove ==>");

		Entry<Integer, Integer> entryRemove = new PriorityQueueEntry<Integer, Integer>(12, 8, 3);

		aDTQueue.remove(entryRemove);
		aDTQueue.printArray();

		System.out.println("Size ==> " + aDTQueue.size());

		System.out.println("replaceKey ==>");

		Entry<Integer, Integer> entryReplaceKey = new PriorityQueueEntry<Integer, Integer>(8, 4, 1);
		aDTQueue.replaceKey(entryReplaceKey, 55);
		aDTQueue.printArray();

		System.out.println("replaceValue ==>");

		Entry<Integer, Integer> entryReplaceValue = new PriorityQueueEntry<Integer, Integer>(40, 17, 3);
		aDTQueue.replaceValue(entryReplaceValue, 555);
		aDTQueue.printArray();

		System.out.println("Size ==> " + aDTQueue.size());

		System.out.println("State ==> " + aDTQueue.state());

		System.out.println("toggle ==>");
		aDTQueue.toggle();
		aDTQueue.printArray();

		System.out.println("State ==> " + aDTQueue.state());

		System.out.println("toggle ==>");
		aDTQueue.toggle();
		aDTQueue.printArray();

		System.out.println("State ==> " + aDTQueue.state());

		System.out.println("isEmpty ==> " + aDTQueue.isEmpty());

		System.out.println("Size ==> " + aDTQueue.size());
		System.out.println("remove ==>");
		Entry<Integer, Integer> entryRemove1 = new PriorityQueueEntry<Integer, Integer>(4, 2, 0);

		aDTQueue.remove(entryRemove1);
		aDTQueue.printArray();

		System.out.println("Size ==> " + aDTQueue.size());

		System.out.println("replaceKey ==>");

		Entry<Integer, Integer> entryReplaceKey1 = new PriorityQueueEntry<Integer, Integer>(6, 3, 2);
		aDTQueue.replaceKey(entryReplaceKey1, 60);

		aDTQueue.printArray();

		System.out.println("replaceValue ==>");

		Entry<Integer, Integer> entryReplaceValue1 = new PriorityQueueEntry<Integer, Integer>(40, 555, 1);
		aDTQueue.replaceValue(entryReplaceValue1, 666);
		aDTQueue.printArray();

		System.out.println("Size ==> " + aDTQueue.size());

		System.out.println("State ==> " + aDTQueue.state());

		System.out.println("toggle ==>");
		aDTQueue.toggle();
		aDTQueue.printArray();

		System.out.println("State ==> " + aDTQueue.state());

		System.out.println("toggle ==>");
		aDTQueue.toggle();
		aDTQueue.printArray();

		System.out.println("isEmpty ==> " + aDTQueue.isEmpty());

		System.out.println("Size ==> " + aDTQueue.size());
	}
}