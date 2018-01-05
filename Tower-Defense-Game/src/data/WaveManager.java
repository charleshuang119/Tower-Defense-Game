package data;

public class WaveManager {
	
	private float timeSinceLastWave, timeBetweenEnemies;
	private int waveNumber, enemiesPerWave;
	private Enemy enemyType;
	private Wave currentWave;
	
	public WaveManager(Enemy enemyTpye,float timeBetweenEnemies, int enemiesPerWave) {
		
		this.enemyType = enemyTpye;
		this.timeBetweenEnemies = timeBetweenEnemies;
		this.enemiesPerWave = enemiesPerWave;
		this.timeSinceLastWave = 0;
		this.waveNumber = 0;
		
		this.currentWave = null;
		
		newWave();
	}

	public void update() {
		if(!currentWave.isCompleted()) {
			currentWave.Update();
		}
		else {
			newWave();
		}
	}
	
	public void newWave() {
		currentWave = new Wave(enemyType, timeBetweenEnemies,enemiesPerWave);
		waveNumber++;
	}
	
	public Wave getCurrentWave(){
		return currentWave;
	}
	

}
