package wizards;



public class Monsters
{
	String monsterName;
	int monsterXp;
	String code;
	
	public Monsters(String name, int xp, String code) {
		this.monsterName = name;
		this.monsterXp = xp;
		this.code = code;
	}
	
	public Monsters(Monsters p) {
		this.monsterName = p.getName();
		this.monsterXp = p.getXp();
		this.code = p.getCode();
	}
	
	public void setName(String name) {
		monsterName = name;
	}
	public void setXp(int xp) {
		monsterXp = xp;
	}
	public void setCode(String shrCode) {
		code = shrCode;
	}
	public String getName() {
		return monsterName;
	}
	public int getXp() {
		return monsterXp;
	}
	public String getCode() {
		return code;
	}
	
	static Monsters Bandit = 		new Monsters("Bandit",25,"bdt");
	static Monsters BanditChief = 	new Monsters("Bandit Chief",450,"bdc");
	static Monsters Cultist = 		new Monsters("Cultist",25,"cul");
	static Monsters DireWolf = 		new Monsters("Dire Wolf", 200,"drw");
	static Monsters Default = 		new Monsters("Default",0,"nul");
	static Monsters Ghost = 		new Monsters("Ghost",1100,"gho");
	static Monsters Goblin = 		new Monsters("Goblin",50,"gob");
	static Monsters Knight =		new Monsters("Knight", 700,"kni");
	static Monsters Orc = 			new Monsters("Orc",100,"orc");
	static Monsters Wererat = 		new Monsters("Wererat", 450,"wrr");
	static Monsters Werewolf = 		new Monsters("Werewolf",700,"wrw");
	
	
	
}

