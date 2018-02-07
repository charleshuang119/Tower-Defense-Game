package data;

public class WaveManager {
	
	private float timeSinceLastWave, timeBetweenEnemies;
	private int waveNumber, enemiesPerWave;
	private Enemy[] enemyTypes;
	private Wave currentWave;
	
	public WaveManager(Enemy[] enemyTpyes,float timeBetweenEnemies, int enemiesPerWave) {
		
		this.enemyTypes = enemyTpyes;
		this.timeBetweenEnemies = timeBetweenEnemies;
		this.enemiesPerWave = enemiesPerWave;
		this.timeSinceLastWave = 0;
		this.waveNumber = 0;
		
		this.currentWave = null;
		
		newWave();
	}

	public void update() {
		if(!currentWave.isCompleted()) {
			currentWave.update();
		}
		else {
			newWave();
		}
	}
	
	public void newWave() {
		currentWave = new Wave(enemyTypes, timeBetweenEnemies,enemiesPerWave);
		waveNumber++;
		System.out.println("Begining Wave" + waveNumber);
	}
	
	public Wave getCurrentWave(){
		return currentWave;
	}
	
	public int getWaveNumber() {
		return waveNumber;
	}

}
