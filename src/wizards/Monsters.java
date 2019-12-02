package wizards;

public class Monsters
{
	String monsterName;
	int monsterXp;
	
	public Monsters(String name, int xp) {
		this.monsterName = name;
		this.monsterXp = xp;
	}
	
	public Monsters(Monsters p) {
		this.monsterName = p.getName();
		this.monsterXp = p.getXp();
	}
	
	public void setName(String name) {
		monsterName = name;
	}
	public void setXp(int xp) {
		monsterXp = xp;
	}
	public String getName() {
		return monsterName;
	}
	public int getXp() {
		return monsterXp;
	}
	
	static Monsters Bandit = 		new Monsters("Bandit",25);
	static Monsters BanditChief = 	new Monsters("Bandit Chief",450);
	static Monsters Cultist = 		new Monsters("Cultist",25);
	static Monsters Goblin = 		new Monsters("Goblin",50);
	static Monsters Orc = 			new Monsters("Orc",100);
	static Monsters Werewolf = 		new Monsters("Werewolf",700);
	static Monsters Default = 		new Monsters("Default",0);
	static Monsters Knight =		new Monsters("Knight", 700);
	static Monsters Wererat = 		new Monsters("Wererat", 450);
	
	
}
