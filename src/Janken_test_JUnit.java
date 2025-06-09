import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Janken_test_JUnit {
	Execute execute;
	
	@BeforeEach
	void beforeEach() {
		execute = new Execute();
	}
	@Test
	void executeTest1() {
		String[] inputValues = {"1","2"};
		assertEquals(0,execute.execute(inputValues));
	}
	@Test
	void executeTest2() {
		String[] inputValues = {"1"};
		assertEquals(9,execute.execute(inputValues));
	}
	
	@Test
	void isInputCheckTest3() {
		String[] inputValues = {"1","2"};
		assertTrue(execute.isInputCheck(inputValues));
	}
	
	@Test
	void isInputCheckTest4() {
		String[] inputValues = {"1","9"};
		assertTrue(execute.isInputCheck(inputValues));
	}
	
	@Test
	void isInputCheckTest5() {
		String[] inputValues = {"1","9","3"};
		assertFalse(execute.isInputCheck(inputValues));
	}
	
	@Test
	void isInputCheckTest6() {
		String[] inputValues = {"0","4"};
		assertFalse(execute.isInputCheck(inputValues));
	}
	
	@Test
	void isInputCheckTest6_1() {
		String[] inputValues = {"4","4"};
		assertFalse(execute.isInputCheck(inputValues));
	}

	@Test
	void isInputCheckTest7() {
		String[] inputValues = {"1","1"};
		assertFalse(execute.isInputCheck(inputValues));
	}

	@Test
	void isInputCheckTest8() {
		String[] inputValues = {"1","0"};
		assertFalse(execute.isInputCheck(inputValues));
	}

	/**
	 * Test4との違いは？
	 */
	@Test
	void isInputCheckTest9() {
		String[] inputValues = {"1","9"};
		assertTrue(execute.isInputCheck(inputValues));
	}
	
	@Test
	void isInputCheckTest10() {
		String[] inputValues = {"1","10"};
		assertFalse(execute.isInputCheck(inputValues));
	}
	
	@Test
	void isInputCheckTest11() {
		String[] inputValues = {"あ","5"};
		assertFalse(execute.isInputCheck(inputValues));
	}

	@Test
	void isInputCheckTest12() {
		String[] inputValues = {"2","い"};
		assertFalse(execute.isInputCheck(inputValues));
	}

	@Test
	void enemyHandSerchTest13() {
		String inputValues = "5";
		int[] values = execute.enemyHandSerch(inputValues);
		assertEquals(4,values.length);
	}

	@Test
	void logMessageTest14() {
	
	}

	@Test
	void logMessageTest15() {
		
	}

	@Test
	void resultTest16() {
		try {
			Class<Execute> executeClass = Execute.class;
			
			Object object = executeClass.getDeclaredConstructor().newInstance();
			Method method = Execute.class.getDeclaredMethod("result", String.class,int[].class);
			
			method.setAccessible(true);

			String myHand = "1";
			int[] enemyHand = {2};
			StringBuffer handResult = new StringBuffer();
			handResult.append("あなたの勝ちです");
			handResult.append(System.lineSeparator());
			handResult.append("自分の手はグーです");
			handResult.append(System.lineSeparator());
			handResult.append("相手の手はチョキです");
			String resultMessage = handResult.toString();
			
			String message = (String)method.invoke(object, myHand,enemyHand);
			
			assertEquals(resultMessage,message);
		} catch (Exception e ) {
			System.out.println(e);
			fail();
		}	
	}

	@Test
	void resultTest17() {
		try {
			Class<Execute> executeClass = Execute.class;
			
			Object object = executeClass.getDeclaredConstructor().newInstance();
			Method method = Execute.class.getDeclaredMethod("result", String.class,int[].class);
			
			method.setAccessible(true);

			String myHand = "2";
			int[] enemyHand = {3};
			StringBuffer handResult = new StringBuffer();
			handResult.append("あなたの勝ちです");
			handResult.append(System.lineSeparator());
			handResult.append("自分の手はチョキです");
			handResult.append(System.lineSeparator());
			handResult.append("相手の手はパーです");
			String resultMessage = handResult.toString();
			
			String message = (String)method.invoke(object, myHand,enemyHand);
			
			assertEquals(resultMessage,message);
		} catch (Exception e ) {
			System.out.println(e);
			fail();
		}	
	}
	

	@Test
	void resultTest18() {
		try {
			Class<Execute> executeClass = Execute.class;
			
			Object object = executeClass.getDeclaredConstructor().newInstance();
			Method method = Execute.class.getDeclaredMethod("result", String.class,int[].class);
			
			method.setAccessible(true);

			String myHand = "3";
			int[] enemyHand = {1};
			StringBuffer handResult = new StringBuffer();
			handResult.append("あなたの勝ちです");
			handResult.append(System.lineSeparator());
			handResult.append("自分の手はパーです");
			handResult.append(System.lineSeparator());
			handResult.append("相手の手はグーです");
			String resultMessage = handResult.toString();
			
			String message = (String)method.invoke(object, myHand,enemyHand);
			
			assertEquals(resultMessage,message);
		} catch (Exception e ) {
			System.out.println(e);
			fail();
		}	
	}

	@Test
	void resultTest19() {
		try {
			Class<Execute> executeClass = Execute.class;
			
			Object object = executeClass.getDeclaredConstructor().newInstance();
			Method method = Execute.class.getDeclaredMethod("result", String.class,int[].class);
			
			method.setAccessible(true);

			String myHand = "1";
			int[] enemyHand = {3,3};
			StringBuffer handResult = new StringBuffer();
			handResult.append("あなたの負けです");
			handResult.append(System.lineSeparator());
			handResult.append("自分の手はグーです");
			handResult.append(System.lineSeparator());
			handResult.append("相手の手はパーとパーです");
			String resultMessage = handResult.toString();
			
			String message = (String)method.invoke(object, myHand,enemyHand);
			
			assertEquals(resultMessage,message);
		} catch (Exception e ) {
			System.out.println(e);
			fail();
		}	
	}
	
	@Test
	void resultTest20() {
		try {
			Class<Execute> executeClass = Execute.class;
			
			Object object = executeClass.getDeclaredConstructor().newInstance();
			Method method = Execute.class.getDeclaredMethod("result", String.class,int[].class);
			
			method.setAccessible(true);

			String myHand = "1";
			int[] enemyHand = {1,1,1,1,1,1,1,1,1};
			StringBuffer handResult = new StringBuffer();
			handResult.append("あいこです");
			handResult.append(System.lineSeparator());
			handResult.append("自分の手はグーです");
			handResult.append(System.lineSeparator());
			handResult.append("相手の手はグーとグーとグーとグーとグーとグーとグーとグーとグーです");
			String resultMessage = handResult.toString();
			
			String message = (String)method.invoke(object, myHand,enemyHand);
			
			assertEquals(resultMessage,message);
		} catch (Exception e ) {
			System.out.println(e);
			fail();
		}	
	}
	
	@Test
	void resultTest21() {
		try {
			Class<Execute> executeClass = Execute.class;
			
			Object object = executeClass.getDeclaredConstructor().newInstance();
			Method method = Execute.class.getDeclaredMethod("result", String.class,int[].class);
			
			method.setAccessible(true);

			String myHand = "1";
			int[] enemyHand = {1,2,3,1,1,1,1,1,1};
			StringBuffer handResult = new StringBuffer();
			handResult.append("あいこです");
			handResult.append(System.lineSeparator());
			handResult.append("自分の手はグーです");
			handResult.append(System.lineSeparator());
			handResult.append("相手の手はグーとチョキとパーとグーとグーとグーとグーとグーとグーです");
			String resultMessage = handResult.toString();
			
			String message = (String)method.invoke(object, myHand,enemyHand);
			
			assertEquals(resultMessage,message);
		} catch (Exception e ) {
			System.out.println(e);
			fail();
		}	
	}
}
