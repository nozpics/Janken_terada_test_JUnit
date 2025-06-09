import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;

public class Execute {
	
	public static int enemyCount;
	public static int checkHand;
	
	public int execute(String[] inputValues) {
		if(!isInputCheck(inputValues)) {
			return 9;
		}
		int[] enemyHand = enemyHandSerch(inputValues[1]);
		String message = result(inputValues[0],enemyHand);
		logMessage(message);
		return 0;
	}
	
	/**
	 * 実行時の入力引数をチェックするメソッド。
	 * @param inputValues 入力引数
	 * @return チェック結果
	 */
	public boolean isInputCheck(String[] inputValues) {
		if(!(inputValues.length==2)) {
			logMessage("処理失敗：引数の数2個ではありません。確認してください。");
			return false;
		}
		if(!(inputValues[0].matches("[1-3]")) || !(inputValues[1].matches("[2-9]"))) {
			logMessage("処理失敗：引数を確認してください。" + inputValues[0] + "_" + inputValues[1]);
			return false;
		}
		checkHand = Integer.parseInt(inputValues[0]);
		enemyCount = Integer.parseInt(inputValues[1]);
		return true;
	}
	/**
	 * 相手の手の作成をするメソッド。
	 * @param numberOfBattelPlayer じゃんけん参加人数
	 * @return 相手の手
	 */
	protected int[] enemyHandSerch(String numberOfBattelPlayer) {
		int numberOfEnemyPlayer = Integer.parseInt(numberOfBattelPlayer) - 1;
		int[] hand = new int[numberOfEnemyPlayer];
		for(int i = 0; i < hand.length;i++) {
			hand[i] = new java.util.Random().nextInt(3)+1;
		}
		return hand;
	}
	
	private void logMessage(String message) {
		System.out.println(message);
		//ログファイルへの出力
		try {
			File file = new File("/Applications/Eclipse_2023-12.app/Contents/workspace/test.txt");
			
			if(!file.canWrite()) {
				file.setWritable(true);
			}
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime date = LocalDateTime.now();
			String formatted = date.format(dtf);
			FileWriter filewriter = new FileWriter(file,true);
			filewriter.write(formatted);
			filewriter.write(System.lineSeparator());
			filewriter.write(message);
			filewriter.close();
		}catch(IOException e) {
			System.out.println("ログファイルへの書き込み権限がありません");
			e.printStackTrace();
		}
	}
	
	/**
	 * 勝敗判定をするメソッド
	 * @param myHand 自分の手
	 * @param enemyHand 相手の手
	 * @return 勝敗メッセージ
	 */
	private String result(String myHand,int[] enemyHand) {
		HashSet<String> checkHand = new HashSet<>();
		checkHand.add(myHand);
		for(int i=0;i<enemyHand.length;i++) {
			String enemy = String.valueOf(enemyHand[i]);
			checkHand.add(enemy);
		}
		StringBuffer handResult = new StringBuffer();
		if(checkHand.size()==1 || checkHand.size()==3) {
			handResult.append("あいこです");
		}else if((myHand.equals("1") && checkHand.contains("2")) || (myHand.equals("2") && checkHand.contains("3")) || (myHand.equals("3") && checkHand.contains("1")) ) {
			handResult.append("あなたの勝ちです");
		}else {
			handResult.append("あなたの負けです");
		}
		HashMap<String,String> createMessage = new HashMap<>();
		createMessage.put("1", "グー");
		createMessage.put("2", "チョキ");
		createMessage.put("3", "パー");
		
		handResult.append(System.lineSeparator());
		handResult.append("自分の手は");
		handResult.append(createMessage.get(myHand));
		handResult.append("です");
		handResult.append(System.lineSeparator());
		handResult.append("相手の手は");
		for(int i=0;i<enemyHand.length;i++) {
			handResult.append(createMessage.get(String.valueOf(enemyHand[i])));
			if(i<enemyHand.length-1) {
				handResult.append("と");
			}else {
				handResult.append("です");
			}
		}
		String message = handResult.toString();
		return message;
	}	
}
