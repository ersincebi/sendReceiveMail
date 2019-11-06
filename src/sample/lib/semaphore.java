package sample.lib;

public class semaphore {
	private static boolean trigger = true;

	public static void start() { trigger = true; }

	public static void stop() { trigger = false; }

	public static boolean get(){ return trigger; }
}
