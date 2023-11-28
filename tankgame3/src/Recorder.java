import java.io.*;
import java.util.Vector;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/28 19:11
 */
public class Recorder {
    private static int hitCount = 0;

    // 文件读写器
    private static FileWriter fw = null;
    private static BufferedWriter bw = null;

    private static FileReader fr = null;
    private static BufferedReader br = null;

    public static String getRecordFile() {
        return recordFile;
    }

    private static String recordFile = "./myRecord.txt";

    private static Vector<EnemyTank> enemyTanks = null;

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    public static void saveRecorder() {
        try {
            bw = new BufferedWriter(new FileWriter(recordFile));
            bw.write(hitCount + "\n");
            for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank enemyTank = enemyTanks.get(i);
                if (enemyTank.isLive) {
                    String record = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirect();
                    bw.write(record + "\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static Vector<EnemyTank> loadRecorder(Vector<EnemyTank> enemyTanks) {
        try {
            br = new BufferedReader(new FileReader(recordFile));
            String line;
            hitCount = Integer.parseInt(br.readLine());
            while ((line = br.readLine()) != null) {
                String[] xyd = line.split(" ");
//                System.out.println(Integer.parseInt(xyd[0]) + " " + Integer.parseInt(xyd[1]) + " " + Integer.parseInt(xyd[2]));
                EnemyTank enemyTank = new EnemyTank(Integer.parseInt(xyd[0]), Integer.parseInt(xyd[1]), Integer.parseInt(xyd[2]));
                enemyTanks.add(enemyTank);

            }
            return enemyTanks;

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static int getHitCount() {
        return hitCount;
    }

    public static void setHitCount(int hitCount) {
        Recorder.hitCount = hitCount;
    }

    public static void addHitCount() {
        Recorder.hitCount++;
    }
}
